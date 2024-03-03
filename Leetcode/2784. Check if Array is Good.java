/**
 * Approach 1 :
 * 
 * 1. Create a hashmap to store value, count
 * 2. check for value from 1 to n-1 count == 1 if not return false
 * 3. if yes decrement count
 * 4. for last value check count = 2 then return true
 * 5. else return false
 * 
 * Time complexity : O(n)
 * Space Complexity : O(n)
 */

class Solution {
    public boolean isGood(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (!map.containsKey(i))
                return false;
            if (map.get(i) == 1) {
                map.put(i, map.get(i) - 1);
            }
        }
        int last = nums.length - 1;

        if (map.containsKey(last) && map.get(last) == 2) {
            return true;
        }

        return false;
    }
}

/**
 * 
 * Appraoch 2 :
 * 
 * you can use interger array to store count
 */