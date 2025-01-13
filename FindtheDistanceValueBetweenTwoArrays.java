class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        boolean iscount=false;
        int c=0;
        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr2.length;j++)
            {
                int diff=Math.abs(arr1[i]-arr2[j]);
                if(diff<=d)
                {
                    iscount=false;
                    break;
                }
                else
                {
                    iscount=true;
                }
            }
            if(iscount)
            {
                c++;
            }
        }
        return c;
    }
}
