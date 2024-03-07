class Solution {
    public int divisorSubstrings(int num, int k) {

        String number = Integer.toString(num);
        int left = 0;
        int count = 0;

        for (int right = 0; right < number.length(); right++) {
            if (right - left + 1 == k) {
                int temp = Integer.parseInt(number.substring(left, right + 1));
                if (temp != 0 && num % temp == 0) {
                    count++;
                }
                left++;
            }

        }

        return count;
    }
}