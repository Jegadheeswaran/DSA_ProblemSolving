class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        double result = Integer.MIN_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            if (right - left + 1 == k) {
                result = Math.max(result, (double) sum / k);
                sum -= nums[left];
                left++;
            }

        }
        return result;
    }
}