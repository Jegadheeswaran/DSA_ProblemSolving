/**
 * Approach :
 * 
 * 1. create a hashmap and store position and distance
 * 2. create a stack to store carfleet
 * 3. sort a position array
 * 4. loop through an array
 * 5. push distance if stack.isEmpty() || map.get(position[i]) > stack.peek()
 * 6. return stack size
 * 
 * 
 * Time complexity : O(n log n)
 * Space Complexity : O(n)
 */

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Double> map = new HashMap<>();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < position.length; i++) {
            double time = (double) (target - position[i]) / speed[i];
            map.put(position[i], time);
        }

        Arrays.sort(position);

        for (int i = position.length - 1; i >= 0; i--) {

            if (stack.isEmpty() || map.get(position[i]) > stack.peek()) {
                stack.push(map.get(position[i]));
            }
        }

        return stack.size();
    }
}