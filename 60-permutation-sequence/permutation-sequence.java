import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        // Create list of available numbers
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        // Precompute factorials
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        
        // Convert k to 0-indexed
        k = k - 1;
        
        StringBuilder result = new StringBuilder();
        
        // Build permutation digit by digit
        for (int i = n; i >= 1; i--) {
            int blockSize = factorial[i - 1];
            int index = k / blockSize;
            k = k % blockSize;
            
            result.append(numbers.get(index));
            numbers.remove(index);
        }
        
        return result.toString();
    }
}