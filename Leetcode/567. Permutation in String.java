import java.util.HashMap;

/**
 * Approach 1 :
 * 
 * 1. Create a two hashmap need and have, have is for string 2 and need is for
 * string 1
 * 2. Store character, count for s1
 * 3. initialize left to zero
 * 4. start from right = 0 to s2.length
 * 5. put current character in have hashmap
 * 6. check currWindow lenght is equal to s1 length
 * 7. if yes check two hashmap or same
 * 8. if it is same return true
 * 9. else remove s2.charAt(left) value from have hashmap and increment left
 * 
 * 
 * 
 * Time complexity : O(26 * n + m)
 * Space complexity : O(K)
 * 
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> have = new HashMap<>();

        int left = 0;

        for (char c : s1.toCharArray()) {

            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        for (int right = 0; right < s2.length(); right++) {
            char c = s2.charAt(right);
            have.put(c, have.getOrDefault(c, 0) + 1);

            if (s1.length() == (right - left + 1)) {

                boolean flag = true;
                for (char ch : need.keySet()) {
                    if (!have.containsKey(ch) || !have.get(ch).equals(need.get(ch))) {
                        flag = false;
                        break;
                    }
                }

                if (flag)
                    return true;

                have.put(s2.charAt(left), have.get(s2.charAt(left)) - 1);
                left++;

            }

        }

        return false;
    }
}

/**
 * its same as approach 1
 * and here we used array of size 26 instead of hashmap
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] freq = new int[26];
        int m = s2.length();
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        int[] freq2 = new int[26];
        for (int i = 0; i < m; i++) {
            freq2[s2.charAt(i) - 'a']++;
            if (i >= n) {
                freq2[s2.charAt(i - n) - 'a']--;
            }
            if (Arrays.equals(freq, freq2))
                return true;
        }
        return false;
    }
}

/**
 * Approach 2
 * 
 * 1. follow approach 1 method
 * 2. we can initiate matches counter and matchesRequired to avoid checking
 * hashmap for every iteration
 * 3. we need to loop through hashmap only one time (first time curr window
 * length is equals to s1 lenght) to get matches.
 * 4. for every other time increment and decrement matches counter by checking
 * current character
 * 
 * Time complexity O(n+m)
 * Space complexity O(K)
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> have = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            need.put(s1.charAt(i), need.getOrDefault(s1.charAt(i), 0) + 1);
            have.put(s2.charAt(i), have.getOrDefault(s2.charAt(i), 0) + 1);
        }

        // System.out.println("\n have \t" + have);
        // System.out.println("\n need \t" + need);

        int left = 0;
        int matches = 0;
        int matchesRequired = need.size();

        for (char ch : need.keySet()) {
            if (have.containsKey(ch) && have.get(ch).equals(need.get(ch))) {
                matches++;
            }
        }

        // System.out.println("\n inital matches \t" + matches);
        // System.out.println("\n required matches \t" + matchesRequired);

        for (int right = s1.length(); right < s2.length(); right++) {

            if (matches == matchesRequired)
                return true;

            char c = s2.charAt(right);

            have.put(c, have.getOrDefault(c, 0) + 1);

            if (need.containsKey(c)) {
                if (have.get(c).equals(need.get(c)))
                    matches++;
                else if ((have.get(c)) == need.get(c) + 1)
                    matches--;
            }

            c = s2.charAt(left);

            have.put(c, have.get(c) - 1);

            if (need.containsKey(c)) {

                if (have.get(c).equals(need.get(c)))
                    matches++;
                else if (have.get(c) == need.get(c) - 1)
                    matches--;
            }
            // System.out.println("\n left \t" + left);

            // System.out.println("\n right \t" + right);

            // System.out.println("\n have \t" + have);
            // System.out.println("\n need \t" + need);

            // System.out.println("\n after loop matches \t" + matches);

            left++;

        }

        return matches == matchesRequired;
    }
}