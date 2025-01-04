class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long arr[][] = new long[26][26];
        for(long a[] : arr)
        Arrays.fill(a,Integer.MAX_VALUE);
        for(int i=0;i<26;i++){
            arr[i][i] = 0L;
        }
        for(int i=0;i<cost.length;i++){
            arr[original[i]-'a'][changed[i]-'a'] = Math.min(cost[i],arr[original[i]-'a'][changed[i]-'a']);
        }
        for(int via = 0;via<26;via++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    arr[i][j] = Math.min(arr[i][j],arr[i][via]+arr[via][j]);
                }
            }
        }
        long ans = 0L;
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)!=target.charAt(i)){
                if(arr[source.charAt(i)-'a'][target.charAt(i)-'a']<Integer.MAX_VALUE){
                    ans+=arr[source.charAt(i)-'a'][target.charAt(i)-'a'];
                }
                else{
                    return -1L;
                }
            }
        }
        return ans;
    }
}
