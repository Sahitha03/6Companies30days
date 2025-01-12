class Solution {
public int longestString(int x, int y, int z) {
     if(Math.abs(x-y)<=1)
     {
      return 2*(x+y+z);
     }
     else{
     return ((Math.min(x,y)*2+1)+z)*2;
    }
}
}
