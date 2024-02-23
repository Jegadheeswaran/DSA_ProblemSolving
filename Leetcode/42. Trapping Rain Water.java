/**
 * 
 * Appraoch : 1 
 * 
 * 1. we can calculate unit of water trapped in every index.
 * 2. For calculating this we can to take minimum of (max of left & max of right value) substract to height of current index
 * 3. we can't trap negative and zero units of rain.
 * 4. if its a positive value added to result and return it.
 * 5. for calculatin max of left and max of right create an array and store max of left and right values
 * 
 * Time complexity : O(n)
 * Space complexity : O(n)
 */


class Solution {
    public int trap(int[] height) {
        int maxLeft [] = new int [height.length];
        int maxRight [] = new int [height.length];
        
        int maxL = 0;
        int maxR = 0;
        int area = 0;
        for(int i=0;i<height.length;i++){
            maxLeft[i] = maxL; 
            maxL = Math.max(maxL, height[i]);
        }

        for(int i=height.length-1;i>=0;i--){
            maxRight[i] =  maxR;
            maxR = Math.max(height[i],maxR);
        }

        for(int i=0; i<height.length; i++){
            int temp = Math.min(maxLeft[i],maxRight[i]) - height[i];
            if(temp > 0)
                area += temp;
        }

    return area;
    }
}

/**
 * 
 * Approach 2 :
 * 
 * 1. for getting linear space complexity we can use two pointer 
 * 2. take left max and right max 
 * 3. you can take minimum from this maxOfleft and maxOfRight value, as we are having max of right value 
 * we don't require exact max of right value bacause we are taking minimum value for checking the area
 *
 * 
 * Time complexity : O(n)
 * Space complexity : O(1)
 */

class Solution {
    public int trap(int[] height) {
        int maxLeft = 0;
        int maxRight = 0;

        int left = 0;
        int right = height.length-1;
        int result = 0;
        while(left<right){
            if(height[left]<height[right]){
                maxLeft = Math.max(maxLeft, height[left]);
                result += maxLeft-height[left];
                left++;
            }
            else{
                maxRight = Math.max(maxRight, height[right]);
                result += maxRight - height[right];
                right--;
            }
        }

    return result;
    }
}