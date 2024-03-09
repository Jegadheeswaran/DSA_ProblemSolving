/**
 * Approach 1 :
 * 
 * 1. use sliding window technique
 * 2. create a have and need to update our start and minLen
 * 3. update minLen only current window lenght is less than minLen
 * 4. when we are updating have for decreasing it note that we need to only
 * decrease when currWindow have less than required count
 * 
 * Hint : use Hashmap, if u use array store size as 128 note when storing array
 * we dont have to use - 'a' or -'A"
 * if we use 52 then note
 * that we need to check curr index is uppercase or not
 * if uppercase c-'A' else c-'a'
 * 
 * Time complexity : O(m+n)
 * Space complexity : O(n)
 */

class Solution {
    public String minWindow(String s, String t) {
        int count[] = new int[128];
        int window[] = new int[128];

        for (char c : t.toCharArray()) {
            count[c]++;
        }

        // "ADOBECODEBANC"
        // "ABC"

        // System.out.println("Start count array "+Arrays.toString(count));

        int have = 0;
        int need = 0;

        int minLen = s.length() + 1;
        int start = 0;

        for (int i : count) {
            if (i != 0)
                need++;
        }

        // System.out.println("before loop need "+need+" have"+have);
        // System.out.println("before loop start "+start+" minlne"+minLen);

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            // System.out.println("loop starts left and right "+left+" "+right);

            char index = s.charAt(right);

            window[index]++;

            // System.out.println(" count array "+Arrays.toString(count)+"
            // winodw"+Arrays.toString(window));

            if (count[index] == window[index])
                have++;

            // System.out.println("have "+have+" need "+need);
            while (have == need) {

                if (right - left + 1 < minLen) {
                    start = left;
                    minLen = right - left + 1;

                }
                // System.out.println("updated start "+start+" end "+minLen );

                window[s.charAt(left)]--;

                if (count[s.charAt(left)] > window[s.charAt(left)])
                    have--;

                // System.out.println("have "+have+" need "+need);

                left++;
            }

            // System.out.println("loop ends");

        }

        return minLen > s.length() ? "" : s.substring(start, start + minLen);
    }
}

/**
 * using hashmap
 * 
 * 
 */

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        String result = "";
        int minLen = s.length() + 1;

        int have = 0;
        int need = count.size();

        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (count.containsKey(c) && count.get(c).equals(window.get(c)))
                have++;

            while (have == need) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }

                c = s.charAt(left);

                window.put(c, window.get(c) - 1);

                if (count.containsKey(c) && count.get(c) > window.get(c))
                    have--;

                left++;
            }
        }

        return result;
    }
}