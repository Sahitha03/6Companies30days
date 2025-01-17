class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000000+7;
        int ans = 0;
        int count = 0;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++){
             if(i-delay>=1){
                count += dp[i-delay];
                count = count%mod;
            }
            if(i-forget>=1){
                count = (count - dp[i-forget] + mod)%mod;
            }
            dp[i] = count%mod;
        }

        for(int i=n-forget+1; i<=n;i++)
       { ans += dp[i]; ans = ans%mod;}

        return ans;
        
    }
}
