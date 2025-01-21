class Solution {

    private int getBitHash(String s)
    {
        int bitHash = 0;
        for(char x: s.toCharArray())
        {
            int val = x-'a';
            bitHash += (1<<val);
        }
        return bitHash;
    }
    public int wordCount(String[] startWords, String[] targetWords) {
        
        Set<Integer> st = new HashSet<>();
        for(int i=0;i<startWords.length;i++)
        {
            st.add(getBitHash(startWords[i]));
        }
        int ans=0;
        for(int i=0;i<targetWords.length;i++)
        {
            int bitHash = getBitHash(targetWords[i]);
            for(int j=0;j<targetWords[i].length();j++)
            {
                int v = targetWords[i].charAt(j)-'a';
                if(st.contains(bitHash-(1<<v)))
                {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
