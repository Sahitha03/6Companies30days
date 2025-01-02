class Solution {
    public int incremovableSubarrayCount(int[] nums) {

        int length = nums.length, result = 0;

        for (int i = 0, leftLimit = Integer.MIN_VALUE; i < length; i++) {


            for (int j = length - 1, rightLimit = Integer.MAX_VALUE; i <= j; j--) {
                result++;


                if (leftLimit >= nums[j] || nums[j] >= rightLimit) 
                    break;


                rightLimit = nums[j];
            }


            if (leftLimit >= nums[i]) 
                break;
            leftLimit = nums[i];


        }
        
        return result;
    }
}
