/**
 * Approach 1 :
 * 
 * 1. slinding window technique
 * 2. create left=0 and right = 0 pointer and create a set to store unique
 * values
 * 3. loop through right > length
 * 4. check the string.charAt(right) is in set or not
 * 5. if not add a value and update max
 * 6. if yes we need to remove the value till charAt(right) for that in set
 * remove charAt(left) value
 * 
 * 
 * Time complexity : O(N)
 * Space Complexity : O(N)
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                max = Math.max(max, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }

        }
        return max;
    }
}