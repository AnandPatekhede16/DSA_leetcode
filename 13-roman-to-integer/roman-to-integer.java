class Solution {
    public int romanToInt(String s) {
        int total = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int currentVal = getValue(current);
            
            // Check if next character exists and is larger
            if (i < s.length() - 1) {
                char next = s.charAt(i + 1);
                int nextVal = getValue(next);
                
                // If current is smaller than next, subtract
                if (currentVal < nextVal) {
                    total -= currentVal;
                } else {
                    total += currentVal;
                }
            } else {
                total += currentVal;
            }
        }
        
        return total;
    }
    
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}