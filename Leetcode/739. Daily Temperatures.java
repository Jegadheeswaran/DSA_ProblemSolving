/**
 * Approach :
 * 
 * 1. create a result array stack
 * 2. we can add a index value in stack when current index temperature is
 * greater than
 * top of stack index temperature
 * 3. we need to pop the value till the condition fails and in result we need to
 * add result[stack.pop()] = i - stack.pop()
 * 4. return result
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * 
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int result[] = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {

                int j = stack.pop();
                result[j] = i - j;
            }

            stack.push(i);
        }
        return result;
    }
}