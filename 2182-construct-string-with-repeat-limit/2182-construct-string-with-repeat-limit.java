import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        
        // Count frequency
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Max heap (characters in descending order)
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.add((char)(i + 'a'));
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int count = Math.min(freq[ch - 'a'], repeatLimit);
            
            // Add up to repeatLimit times
            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
            
            freq[ch - 'a'] -= count;
            
            // If still remaining, need a break char
            if (freq[ch - 'a'] > 0) {
                if (maxHeap.isEmpty()) break; // no smaller char
                
                char next = maxHeap.poll();
                result.append(next);
                freq[next - 'a']--;
                
                // Put back next if still available
                if (freq[next - 'a'] > 0) {
                    maxHeap.add(next);
                }
                
                // Put back current char
                maxHeap.add(ch);
            }
        }
        
        return result.toString();
    }
}