class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans=Helper(nums,0,0,0,0,k)-Helper(nums,0,0,0,0,k-1);
        return ans;
    }
    public static int Helper(int nums[],int l,int r,int cnt,int sum,int goal)
    {
        if(goal<0)
        {
            return 0;
        }
        while(r<nums.length)
        {
            sum+=(nums[r])%2;
            while(sum>goal)
            {
                sum=sum-(nums[l])%2;
                l++;
            }
            cnt+=(r-l+1);
            r++;
        }
    return cnt;
    }
 }