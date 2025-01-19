class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer>res=new ArrayList<>();
        int i=0,j=0;
        boolean foundA=false,foundB=false;
        while(i<=s.length()-a.length() && j<=s.length()-b.length()){
            if(!foundA){
                if(s.substring(i,i+a.length()).equals(a)) foundA=true;
            }
            if(!foundB){
                if(s.substring(j,j+b.length()).equals(b)) foundB=true;
            }
            if(foundA && foundB){
                if(Math.abs(i-j)<=k){
                    res.add(i);
                    i++;
                    foundA=false;
                }
                else{
                    if(j<=i){
                        foundB=false;
                        j++;
                    }
                    else{
                        foundA=false;
                        i++;
                    }
                }
            }
            else{
                if(!foundA) i++;
                if(!foundB) j++;
            }
        }
        return res;
    }
}
