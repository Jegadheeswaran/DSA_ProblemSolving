/**
 * 
 */

/*

BRUTE FORCE 

class Solution {
    public int maxArea(int[] height) {
        int result = 0;

        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int width = j-i;
                int h = Math.min(height[i],height[j]);
                int temp = width * h;
                result = Math.max(temp,result);
            }
        }

        return result;
    }
}

 */


class Solution {
    public int maxArea(int[] height) {
        int max_area = 0;
        int left = 0;
        int right = height.length-1;

        while(left < right){
            max_area = Math.max(max_area, (right-left) * Math.min(height[left],height[right]));
            if(height[left]<height[right])  left++;
            else right--;
        }
        return max_area;
    }
}