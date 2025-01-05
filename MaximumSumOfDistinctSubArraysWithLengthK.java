class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int l = 0;
        long sum = 0;
        long mx = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            
           
            if (mp.containsKey(nums[r]) && mp.get(nums[r]) >= l) {
                int duplicateIndex = mp.get(nums[r]);
                
                
                for (int i = l; i <= duplicateIndex; i++) {
                    sum -= nums[i];
                }
                
              
                l = duplicateIndex + 1;
            }
            
         
            mp.put(nums[r], r);
            
           
            if (r - l + 1 == k) {
                mx = Math.max(mx, sum);
                
                
                sum -= nums[l];
                l++;
            }
        }
        
        return mx;
    }
}
