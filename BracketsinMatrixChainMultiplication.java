class Solution{
    static String matrixChainOrder(int p[]){
        int n=p.length;
        int[][] dp = new int[n][n], idx_store = new int[n][n];
        
        for(int i=n-1; i>0; i--){
           
            for(int j=i+1; j<n; j++){
                int mini = (int)1e9, idx = 0;
                for(int k=i; k<j; k++){
                    int steps = (p[i-1]*p[k]*p[j]) + dp[i][k] + dp[k+1][j];
                    if(steps<mini){
                        mini = steps;
                        idx=k;
                    }
                }
                dp[i][j] = mini;
                idx_store[i][j] = idx;
            }
        }
        
        return convertToString(1, n-1, idx_store);
        
    }
    
   
    static String convertToString(int i, int j, int[][] store){
        Stack<int[]> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        
        stack.push(new int[]{i,j});
        
        while(!stack.isEmpty()){
            int[] pair = stack.pop();
            i = pair[0];
            j = pair[1];
            if(i==j){
                result.append((char)(i+64));    
                int t = map.getOrDefault(j,0);    
                while(t-->0){
                    result.append(')');
                }
            }else{
                result.append('(');
                
                stack.push(new int[]{store[i][j]+1, j});
                stack.push(new int[]{i, store[i][j]});
                
                map.put(j, map.getOrDefault(j,0)+1);
            }
        }
        return result.toString();
    }
    
}
