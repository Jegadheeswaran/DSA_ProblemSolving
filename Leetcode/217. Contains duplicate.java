/**
 * Optimal solution: 
 * 
 * Time complexity : O(n)
 * Space complexity : O(n)
 * 
 * create a hashset
 * loop through an array if value is present in hashset return true
 * else return false
 */


class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashset = new HashSet<Integer>();
        for(int num : nums){
            if(hashset.contains(num))
                return true;
            hashset.add(num);
        }
        return false;
    }
}