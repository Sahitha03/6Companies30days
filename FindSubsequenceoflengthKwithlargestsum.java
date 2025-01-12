class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
    int[] ans = new int[k];
    int sum = 0;

    for (int i = 0; i < k; i++) {
        ans[i] = nums[i];
        sum += nums[i];
    }

    for (int i = k; i< nums.length; i++) {
        int idx = 0;
        int small = ans[0];
        for (int j = 1; j < k; j++) {
            if (ans[j] < small) {
                small = ans[j];
                idx = j;
            }
        }
        if (small < nums[i]) {
            for (int m = idx + 1; m < k; m++) {
                ans[m - 1] = ans[m];
            }
            ans[k-1] = nums[i];
        }
    }
    return ans;
}
}
