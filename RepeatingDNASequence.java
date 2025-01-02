class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans=new ArrayList<>();
        Map<String,Integer> mp=new HashMap<>();
       
           for(int i=0;i<=s.length()-10;i++)
        {
          String res = s.substring(i, i + 10);
            if(mp.containsKey(res))
            {
               mp.put(res,mp.getOrDefault(res,0)+1);
            }
            else
            {
                mp.put(res,1);
            }
        }
        for(String x:mp.keySet())
        {
            if(mp.get(x)>1)
            {
                ans.add(x);
            }
        }
        
      return ans;
    }
}