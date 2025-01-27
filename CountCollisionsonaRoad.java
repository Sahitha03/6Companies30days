class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int ans=0;
        int k=0;
        while(k<n && directions.charAt(k)=='L'){
            k++;
        }
        while(n-1>=0 && directions.charAt(n-1)=='R'){
            n--;
        }

        for(int i=k; i<n ; i++){
            if(directions.charAt(i)!='S'){
                ans++;
            }
        }
        return ans;
    }
}
