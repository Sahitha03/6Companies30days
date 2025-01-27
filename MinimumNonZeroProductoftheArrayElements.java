class Solution {
    public int minNonZeroProduct(int p) {
        long mod = 1000_000_000 + 7, divider = (1L << p) - 1;
        long powResult = myPow(divider - 1, (divider - 1) / 2, mod);
        int ret = (int) (((divider % mod) * powResult) % mod);
        return ret;
    }

    private long myPow(long x, long y, long mod) {
        if (y == 0) {
            return 1;
        }
        long temp = myPow(x, y / 2, mod);
        long p = (temp * temp) % mod;

        return y % 2 == 1 ? (p * (x % mod)) % mod : p;
    }
}
