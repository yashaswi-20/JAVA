class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenPos = (n + 1) / 2;
        long oddPos = n / 2;

        long evenWays = power(5, evenPos);
        long oddWays = power(4, oddPos);

        return (int)((evenWays * oddWays) % MOD);
    }

    private long power(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if (exp %2==1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            exp=exp/2;
        }

        return result;
    }
}