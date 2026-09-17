import java.util.*;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE / 2;
        
        // Step 1: Find all subarrays with sum = target using prefix sum
        // For each ending index, find the shortest subarray ending there
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, -1); // prefix sum 0 at index -1
        
        int[] minLenEnding = new int[n]; // min length of subarray ending at or before i
        Arrays.fill(minLenEnding, INF);
        
        int sum = 0;
        int minLen = INF;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            
            // Check if there's a subarray ending at i with sum = target
            if (prefixSum.containsKey(sum - target)) {
                int start = prefixSum.get(sum - target);
                int len = i - start;
                minLen = Math.min(minLen, len);
            }
            
            minLenEnding[i] = minLen;
            prefixSum.put(sum, i);
        }
        
        // Step 2: Find min length subarray starting at or after each index
        int[] minLenStarting = new int[n];
        Arrays.fill(minLenStarting, INF);
        
        prefixSum.clear();
        prefixSum.put(0, n); // suffix sum 0 at index n
        sum = 0;
        minLen = INF;
        
        for (int i = n - 1; i >= 0; i--) {
            sum += arr[i];
            
            // Check if there's a subarray starting at i with sum = target
            if (prefixSum.containsKey(sum - target)) {
                int end = prefixSum.get(sum - target);
                int len = end - i;
                minLen = Math.min(minLen, len);
            }
            
            minLenStarting[i] = minLen;
            prefixSum.put(sum, i);
        }
        
        // Step 3: Find minimum sum of two non-overlapping subarrays
        int result = INF;
        
        for (int i = 0; i < n - 1; i++) {
            if (minLenEnding[i] != INF && minLenStarting[i + 1] != INF) {
                result = Math.min(result, minLenEnding[i] + minLenStarting[i + 1]);
            }
        }
        
        return result == INF ? -1 : result;
    }
}