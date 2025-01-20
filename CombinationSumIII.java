class Solution {
   
    List<List<Integer>> res = new ArrayList<>();
    public void dfs(int k, int n, int i, List<Integer> lst, int ans) {
        ans += i;
        lst.add(i);
        k--;
        if(k == 0 && ans == n) {
            res.add(lst);
        }
        for(int j = i+1; j < 10; j++) {
            dfs(k, n, j, new ArrayList<Integer>(lst), ans);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        
        for(int i = 1; i < 10; i++) {
            List<Integer> lst = new ArrayList<>();
            dfs(k, n, i, lst, 0);
        }
        return res;
    }
}
