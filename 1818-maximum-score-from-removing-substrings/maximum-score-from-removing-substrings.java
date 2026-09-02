class Solution {
    public int maximumGain(String s, int x, int y) {
        // Strategy: Remove the substring that gives more points first
        // Because greedy works here - removing higher value pairs first
        // always gives optimal result
        
        // Determine which pair gives more points
        String highPair = (x > y) ? "ab" : "ba";
        String lowPair = (highPair.equals("ab")) ? "ba" : "ab";
        
        int highPoints = Math.max(x, y);
        int lowPoints = Math.min(x, y);
        
        int score = 0;
        StringBuilder sb = new StringBuilder(s);
        
        // First pass: Remove high value pairs
        score += removePairs(sb, highPair, highPoints);
        
        // Second pass: Remove low value pairs from remaining string
        score += removePairs(sb, lowPair, lowPoints);
        
        return score;
    }
    
    private int removePairs(StringBuilder sb, String pair, int points) {
        int score = 0;
        int i = 0;
        
        while (i < sb.length() - 1) {
            if (sb.charAt(i) == pair.charAt(0) && sb.charAt(i + 1) == pair.charAt(1)) {
                // Found the pair, remove it
                sb.delete(i, i + 2);
                score += points;
                // Move back one position to check for new pairs
                if (i > 0) i--;
            } else {
                i++;
            }
        }
        
        return score;
    }
}