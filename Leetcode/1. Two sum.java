/**
 * Brute force approach
 * Take one value from an array
 * and sum with all other value from an array 
 * then check sum is equal to target if it is equal return index of two values
 * 
 * code for brute force approach: 
 * 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int solutionArray [] = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    solutionArray[0] = i;
                    solutionArray[1] = j;
                    break;
                }
            }
        }
        return solutionArray;
    }
}

 */

/**
 * Optimal solution : 
 * 
 * Iterate through the input array nums.
 * For each element nums[i], check if its complement (target - nums[i]) exists in the HashMap.
 * If found, return the indices {i, hmap.get(nums[i])} representing the two numbers that sum up to the target. Otherwise, store the complement along with its index in the HashMap.
 * Return an empty array if no such pair is found.
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Create a Hashmap to store the value : index pair
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(hmap.containsKey(nums[i])){
                return new int [] {i, hmap.get(nums[i])};
            }
            hmap.put(target-nums[i],i);
        }
        return new int [] {};
    }
}