class Solution {
    public int firstUniqChar(String s) {
        int idx=-1;
        Map<Character,Integer> mp=new LinkedHashMap<>();
        for(int i=0;i<s.length();i++)
        {
           if(mp.containsKey(s.charAt(i)))
           {
             mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
           }
           else
           {
             mp.put(s.charAt(i),1);
           }
        }
        for(char x:mp.keySet())
        {
            if(mp.get(x)==1)
            {
                idx=s.indexOf(x);
                break;
            }
        }
        return idx;
    }
}
