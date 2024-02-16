/**
 * Approach :
 * 
 * create a hashset and store array elements
 * 
 * initalise longest value to zero
 * now loop thorugh an array
 * initalise count value to zero
 * if element-1 value is presnt in set, go to next element in an array
 * for every element check next consecutive value is present in set or not 
 * if present increse count value
 * else store maximum value of longest and count to longest
 * return longest
 * 
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * 
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet <Integer> numSet = new HashSet<>();

        for(int n : nums)   
            numSet.add(n);

        int longest = 0;

        for(int i=0;i<nums.length;i++){
            int length = 0;
            if(numSet.contains(nums[i]-1))
                continue;
            while(numSet.contains(nums[i]+length))
                length++;
            longest = Math.max(longest,length);
        }

        return longest;    
    }
}