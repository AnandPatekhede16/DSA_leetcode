import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        
        // Step 1: Find first and last occurrence of each character
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }
        
        // Step 2: For each starting position, find minimal valid substring
        // end[i] = rightmost index of minimal valid substring starting at i
        // If no valid substring starts at i, end[i] = -1
        int[] end = new int[n];
        Arrays.fill(end, -1);
        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            
            // Only consider starting positions that are the first occurrence of some character
            if (first[c] != i) continue;
            
            int right = last[c];
            int j = i;
            
            // Extend right until no more extensions needed
            while (j <= right) {
                int ch = s.charAt(j) - 'a';
                if (first[ch] < i) {
                    // This character has an occurrence before i, so invalid
                    right = -1;
                    break;
                }
                right = Math.max(right, last[ch]);
                j++;
            }
            
            end[i] = right;
        }
        
        // Step 3: Greedy interval scheduling
        // Sort intervals by end position
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (end[i] != -1) {
                intervals.add(new int[]{i, end[i]});
            }
        }
        
        // Sort by end position (ascending)
        intervals.sort((a, b) -> a[1] - b[1]);
        
        List<String> result = new ArrayList<>();
        int lastEnd = -1;
        
        for (int[] interval : intervals) {
            if (interval[0] > lastEnd) {
                result.add(s.substring(interval[0], interval[1] + 1));
                lastEnd = interval[1];
            }
        }
        
        return result;
    }
}