
class Solution
{
    static ArrayList <Integer> max_of_subarrays(int arr[], int k)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        int start=0;
        int end=0;
        int n=arr.length;
        while(end<n){
            if(arr[end]>max){
                max=arr[end];
            }
            if(end-start+1<k){
                end++;
            }
            else if(end-start+1==k){
                    ans.add(max);
                if(arr[start]==max){
                    max=Integer.MIN_VALUE;
                    for(int i=start+1;i<=end;i++){
                        max=Math.max(arr[i],max);
                    }
                }
                start++;
                end++;
            }
        }
        return ans;
    }
}
