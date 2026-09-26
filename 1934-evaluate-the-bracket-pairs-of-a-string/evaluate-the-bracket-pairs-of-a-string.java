import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Build HashMap for O(1) lookup
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        
        StringBuilder result = new StringBuilder();
        int i = 0;
        int n = s.length();
        
        while (i < n) {
            char c = s.charAt(i);
            
            if (c == '(') {
                // Find the closing bracket
                int j = i + 1;
                while (j < n && s.charAt(j) != ')') {
                    j++;
                }
                
                // Extract key
                String key = s.substring(i + 1, j);
                
                // Look up value
                result.append(map.getOrDefault(key, "?"));
                
                // Move past the closing bracket
                i = j + 1;
            } else {
                // Plain character
                result.append(c);
                i++;
            }
        }
        
        return result.toString();
    }
}