class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int res=0;
        Set<String> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for(int j = i;j<nums.length;j++){
                sb.append(nums[j]).append(",");
                if(nums[j] % p == 0) cnt++;
                if(cnt > k) break;
                set.add(sb.toString());
            }
        }
        return set.size();
    }
}
