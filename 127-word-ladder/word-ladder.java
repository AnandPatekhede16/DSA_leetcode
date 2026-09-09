import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        
        // If endWord is not in dictionary, no solution
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                
                // If we reached endWord, return level
                if (currentWord.equals(endWord)) {
                    return level;
                }
                
                // Try changing each character
                char[] wordArray = currentWord.toCharArray();
                for (int j = 0; j < wordArray.length; j++) {
                    char originalChar = wordArray[j];
                    
                    // Try all letters from 'a' to 'z'
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        
                        wordArray[j] = c;
                        String newWord = new String(wordArray);
                        
                        // Check if valid and not visited
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.offer(newWord);
                        }
                    }
                    
                    // Restore original character
                    wordArray[j] = originalChar;
                }
            }
            
            level++;
        }
        
        return 0;
    }
}