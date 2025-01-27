class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int resultHBars = 0;
        int countHBars = 0;
        for (int i = 0; i < hBars.length; i++) {
            if (i + 1 < hBars.length && hBars[i] + 1 == hBars[i + 1]) {
                countHBars++;
            } else {
                resultHBars = Math.max(resultHBars, countHBars + 1);
                countHBars = 0;
            }
        }
        int resultVBars = 0;
        int countVBars = 0;
        for (int i = 0; i < vBars.length; i++) {
            if (i + 1 < vBars.length && vBars[i] + 1 == vBars[i + 1]) {
                countVBars++;
            } else {
                resultVBars = Math.max(resultVBars, countVBars + 1);
                countVBars = 0;
            }
        }
        int result = Math.min(resultHBars, resultVBars) + 1;
        return result * result;
    }
}
