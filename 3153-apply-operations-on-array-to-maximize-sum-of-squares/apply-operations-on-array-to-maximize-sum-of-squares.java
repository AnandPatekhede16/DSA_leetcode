import java.util.*;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        
        int[] bitCount = new int[32];
        
        for (int num : nums) {
            for (int b = 0; b < 32; b++) {
                if ((num & (1 << b)) != 0) {
                    bitCount[b]++;
                }
            }
        }
        
        long[] result = new long[k];
        
        for (int b = 0; b < 32; b++) {
            int count = bitCount[b];
            long bitValue = 1L << b;
            
            for (int i = 0; i < count && i < k; i++) {
                result[i] += bitValue;
            }
        }
        
        long sum = 0;
        for (long num : result) {
            sum = (sum + (num % MOD) * (num % MOD)) % MOD;
        }
        
        return (int) sum;
    }
}