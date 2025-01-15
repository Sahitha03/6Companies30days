class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> l = new ArrayList<>();
        int n = arr.length;

        
        int[] f = new int[n + 1];

      
        for (int i = 0; i < n; i++) {
            f[arr[i]] += 1;
        }

        int rep = 0; 
        int missing = 0; 
       
        for (int i = 1; i <= n; i++) { 
            if (f[i] == 2) {
                rep = i; 
            } else if (f[i] == 0) {
                missing = i; 
            }
        }

      
        l.add(rep);
        l.add(missing);
        return l;
    }
}
