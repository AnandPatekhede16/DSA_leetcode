class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int numberOfSets(int n, int k) {
        // Answer = C(n + k - 1, 2k)
        return nCk(n + k - 1, 2 * k);
    }
    
    private int nCk(int n, int k) {
        if (k > n - k) k = n - k;
        
        long result = 1;
        for (int i = 0; i < k; i++) {
            result = result * (n - i) % MOD;
            result = result * modInverse(i + 1) % MOD;
        }
        return (int) result;
    }
    
    private long modInverse(long a) {
        return power(a, MOD - 2);
    }
    
    private long power(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}