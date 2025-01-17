class Solution {

    static long[][] a = new long[256][256];

    long cnt(long m, long n) {
        if(a[(int)m][(int)n] != 0) return a[(int)m][(int)n];
        if(m == n) return 1;
        if(n == 0) return 1;
        return a[(int)m][(int)n] = cnt(m - 1, n) + cnt(m - 1, n - 1);
    }

    public int waysToReachStair(int k) {
        if(k == 0) return 2;
        long x = 0;
        long n = 0;
        while(x + 1 < k) {
            x = (x << 1) | 1;
            n ++;
        }
        long res = 0;
        while(1 + x - k <= n + 1) {
            res += cnt(n + 1, 1 + x - k);
            x = (x << 1) | 1;
            n++;
        }
        return (int)res;
    }
}
