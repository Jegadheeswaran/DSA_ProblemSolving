/**
 * Approach 1 :
 * 
 * 1. create a left and right pointer
 * 2. left = 0 and right = 1;
 * 3. while right < array length , do check if profit of right is greater than
 * profit of left
 * if its true calculate the profit and update maxprofit else assign right value
 * to left pointer.
 * 4. return maxprofit
 * 
 * 
 * Time complexity : O(n)
 * Space complexity : O(1)
 * 
 */

class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int left = 0;
        int right = 1;

        while (right < prices.length) {

            if (prices[right] > prices[left])
                maxP = Math.max(maxP, prices[right] - prices[left]);
            else
                left = right;
            right++;
        }

        return maxP;
    }
}

/**
 * Approach 2 :
 * 
 * 1. store min as prices[0]
 * 2. loop through an arry from 1 to n-1
 * 3. if min value is greater than currValue update min
 * 4. else if currProfit > maxP update Max Profit
 * 5. return maxProfit
 * 
 * 
 * Time complexity : O(n)
 * Space complexity : O(1)
 */

class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else if (prices[i] - min > maxP) {
                maxP = prices[i] - min;
            }
        }
        return maxP;
    }
}