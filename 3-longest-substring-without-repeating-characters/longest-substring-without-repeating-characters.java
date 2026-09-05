import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If character was seen before and is within current window
            if (lastSeen.containsKey(currentChar) && lastSeen.get(currentChar) >= left) {
                // Move left pointer to after the previous occurrence
                left = lastSeen.get(currentChar) + 1;
            }
            
            // Update last seen position
            lastSeen.put(currentChar, right);
            
            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}