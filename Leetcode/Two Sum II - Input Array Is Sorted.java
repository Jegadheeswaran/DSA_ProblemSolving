/**
 * Approach : 
 * 
 * 1. create two pointers 
 * 2. calculate sum = ith elemnt + jth element
 * 3. check sum == target then return i+1,j+1 array
 * 4. else check sum > target then j--
 * 5. else i++
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;

        while(i<j){
            int sum = numbers[i] + numbers[j];
            if(sum == target)
                return new int[] {i+1,j+1};
            if(sum > target)
                j--;
            else
                i++; 
        }
        return new int[]{};
    }
}