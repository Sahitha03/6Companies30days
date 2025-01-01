class Solution {
    public void wiggleSort(int[] nums) {
        int sortarr[]=nums.clone();
        Arrays.sort(sortarr);
        int mid=(nums.length+1)/2;
        int k=mid-1;
        int l=nums.length-1;
        for(int i=0;i<nums.length;i++)
        {
            if(i%2==0)
            {
                nums[i]=sortarr[k--];
            }
            else
            {
                nums[i]=sortarr[l--];
            }
        }
    }
}