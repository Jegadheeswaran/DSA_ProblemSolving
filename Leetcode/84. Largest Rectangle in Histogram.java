/**
 * Approach 1
 * 
 * 1. approach is when we are poping the value from stack then we are calucating
 * the area for popued value.
 * 2. create a stack to store a pair of index(its maximum extensible left index
 * value) and height of index
 * 3. only pop the stack when (stack is not empty and stack.peek().getValue() is
 * greater than current hight)
 * then store index = poped index and then update maxarea by calculating area of
 * popped vale
 * 
 * 
 * 
 * Time complexity : O(n)
 * Space complexity : O(n)
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int currHt = heights[i];
            int index = i;
            while (!stack.isEmpty() && currHt < stack.peek().getValue()) {
                Pair<Integer, Integer> current = stack.pop();
                index = current.getKey();
                int h = current.getValue();
                int currArea = (i - index) * h;
                maxArea = Math.max(maxArea, currArea);

            }
            stack.push(new Pair(index, currHt));
        }

        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pair = stack.pop();
            int h = pair.getValue();
            int index = pair.getKey();
            maxArea = Math.max(maxArea, (heights.length - index) * h);
        }

        return maxArea;
    }
}

/**
 * Approach 2
 * 
 * 1. for calculating area for every height formulae is calculate index of left
 * side till
 * we can extend the length and calculated right index for the same them use
 * (h-l+1) * height[i]
 * 
 * 2. So create an stack to calculate left and right max extended value for
 * every index/heights.
 * 
 * 3. for calculating left[i] values if stack is empty left of i will be current
 * index.
 * else we need to check till stack is empty & currHeight is less than or equal
 * to
 * stacklastPushed index height then save left[i] is zero (if stack is empty)
 * else stack.peek()+1
 * 
 * 4. for calculating right[i] values if stack is empty right of i will be
 * arraysize - 1.
 * else we need to check till stack is empty & currHeight is less than or equal
 * to
 * stacklastPushed index height then save left[i] is array size - 1 (if stack is
 * empty)
 * else stack.peek()-1
 * 
 * Time complexity : O(n)
 * Space complexity : O(n)
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        int left[] = new int[n];
        int right[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int area = (right[i] - left[i] + 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}