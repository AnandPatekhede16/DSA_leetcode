import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            // If already in set, we found a duplicate
            if (!seen.add(num)) {
                return true;
            }
        }
        
        return false;
    }
}