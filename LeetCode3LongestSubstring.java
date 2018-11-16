
package leetcode3longestsubstring;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3LongestSubstring {

    public static void main(String[] args) {
        int length = lengthOfLongestSubstring("ppwabcdwwkew");
        System.out.println(length);
    }
    
    /** Returns length of longest substring with no repeated characters. */
    public static int lengthOfLongestSubstring(String s) {
        int start = 0;         // Starting index of current substring.
        int length = 0;        // Length of longest substring.
        Map<Character, Integer> map = new HashMap<>(); // Map to store where characters have been found.
        
        for( int current = 0; current < s.length(); current++ ) {
            char c = s.charAt(current);
            Integer j = map.get(c);
            
            if( j != null ) {
                length = Math.max( length, current - start );
                for(int k = start; k < j; k++)
                    map.remove(s.charAt(k));
                start = j + 1;
            } 
            map.put(c, current);
        }
        length = Math.max( length, s.length() - start );
        
        return length;
    }
}
