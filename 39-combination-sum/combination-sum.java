import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        // Sort for pruning optimization
        Arrays.sort(candidates);
        
        backtrack(candidates, target, 0, current, result);
        return result;
    }
    
    private void backtrack(int[] candidates, int remaining, int start, 
                          List<Integer> current, List<List<Integer>> result) {
        // Base case: found a valid combination
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Try each candidate from start index
        for (int i = start; i < candidates.length; i++) {
            // Pruning: if current candidate exceeds remaining, break
            if (candidates[i] > remaining) {
                break;
            }
            
            // Choose candidate
            current.add(candidates[i]);
            
            // Recurse with same i (unlimited use)
            backtrack(candidates, remaining - candidates[i], i, current, result);
            
            // Backtrack: remove the candidate
            current.remove(current.size() - 1);
        }
    }
}