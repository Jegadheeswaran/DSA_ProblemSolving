/**
 * Appraoch 1 : 
 * 
 * 
 *  Time complexity : O(n)
 * Space complexity : O(n)
 * 
 * 
 * create two arrays left and right and store prefix & postfix of the current element
 * then multiply the value store it in result array then return it
 * 
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        //Initialize arrays to store products from left and right

        int left [] = new int [nums.length];
        int right [] = new int [nums.length];

        int leftProduct = 1; 
        int rightProduct = 1;

        //Caluclate product of elements to the left
        for(int i=0;i<nums.length;i++){
            left[i] = leftProduct;
            leftProduct *= nums[i];
        }

        //Caluclate product of elements to the right
        for(int i=nums.length-1;i>=0;i--){
            right[i] = rightProduct;
            rightProduct *= nums[i];
        }

        //Calculate the final product
        for(int i=0;i<nums.length;i++){
            nums[i] = left[i] * right[i];
        }

        return nums;
    }
}










/**
 * Approach : 2 
 * 
 * Time complexity : O(n)
 * Space complexity : O(1) //as instructed in problem description 
 * 
 * 
 * create a result array 
 * initialise postfix and prefix value to 1. 
 * loop through an array store postfix value of element in output array for doing that ( result[i] = prefix ) 
 * update prefix value by multipling prefix value and current element 
 * 
 * now loop thorugh an array in reverse order 
 * take current result value multiply with postfix value
 * update postfix value 
 * 
 * return output array 
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int prefix = 1;
        int postfix = 1;
        int result [] = new int [nums.length];

        for(int i=0 ; i< nums.length;i++){
            result[i] = prefix;
            prefix *= nums[i];
        }

        for(int i=nums.length-1;i>=0;i--){
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}