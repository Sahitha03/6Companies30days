class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid=nums[nums.length/2];
        int cnt=0;
        for(int i=0;i<nums.length;i++)
        {
           cnt+=Math.abs(nums[i]-mid);
        }
        return cnt;
    }
}