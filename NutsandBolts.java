
class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        Map<Character, Integer> orderMap = ordering();
        int MAX = 9;
        char[] nutsBolts = new char[MAX];
        int i=0;
        for(Map.Entry<Character, Integer> entry: orderMap.entrySet()){
            if(i>=n)
                break;
            char key = nuts[i];
            int index = orderMap.get(key);
            nutsBolts[index] = key;
            i++;
        }
        int k=0; 
        for(int j=0; j<MAX; j++){
            if(nutsBolts[j]!='\u0000' && k<n){
                nuts[k] = nutsBolts[j];
                bolts[k]= nutsBolts[j];
                k++;
            }
        }
    }
    
    Map<Character, Integer> ordering(){
        char[] order = { '!','#','$','%','&','*','?','@','^' };
        
        Map<Character, Integer> orderMap = new LinkedHashMap<>();
        
        for(int i=0; i<order.length; i++)
            orderMap.put(order[i], i);
            
        return orderMap;
    }
}
