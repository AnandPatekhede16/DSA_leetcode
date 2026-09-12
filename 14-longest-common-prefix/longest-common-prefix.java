class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        // Start with first string as prefix
        String prefix = strs[0];
        
        // Compare with each subsequent string
        for (int i = 1; i < strs.length; i++) {
            // Shrink prefix until it matches the beginning of strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        
        return prefix;
    }
}