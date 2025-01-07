class Solution {
    public int longestMountain(int[] arr) {


        int arrLen = arr.length;


        int left = 0, max = 0;

        while (left < arrLen - 2) {
            int right = left + 1;


            if (arr[left] < arr[right]) {
                
                while (right < arrLen - 1 && arr[right] < arr[right + 1]) {


                    right++;
                }
              
                while (right < arrLen - 1 && arr[right] > arr[right + 1]) {


                    right++;

                    
                    max = Math.max(max, right - left + 1);
                }                        
            }
            left = right;          
        }
        return max;
    }
}
