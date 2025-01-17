class Solution {
    class Pair{
        String s;
        int index;
        Pair(String s, int index){
            this.s=s;
            this.index=index;
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        Map<Integer,List<Pair>> map=new HashMap<>();
        int ans[]=new int[queries.length];
        for(int i=0;i<nums.length;i++){
            String str=nums[i];
            int n=str.length();
            int len=n;
            for(int j=0;j<n;j++){
                map.putIfAbsent(len,new ArrayList<>());
                Pair pair=new Pair(str.substring(j),i);
                map.get(len--).add(pair);
            }
        }
        int idx=0;
        for(int query[]:queries){
            int k=query[0];
            int key=query[1];
            List<Pair> l=map.get(key);
            Collections.sort(l,(p1,p2)->{
                if(p1.s.equals(p2.s))
                  return p1.index-p2.index;
                return p1.s.compareTo(p2.s);
            });
            ans[idx++]=l.get(k-1).index;
        }
        return ans;
    }
}
