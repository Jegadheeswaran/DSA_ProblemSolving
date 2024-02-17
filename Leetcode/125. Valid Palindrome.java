/**
 * Approach : 
 * 
 * 1. convert given string to lowercase,
 * then remove values excpet alphanumeric and remove extra space use `[^a-zA-Z0-9]`
 * 2. create two pointer i = firstElment and j  = lastElement 
 * 3. check ith value and jth value is equal or not 
 * 4 if its not equal return false
 * 5. increment i and decrement j, repeat from step 3 till i<j 
 * 
 * 
 * Time Complexity: O(n) 
 * Space Complexity: O(n)
 * 
 */

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase().trim();
        
        int i = 0;
        int j = s.length()-1;

        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true; 
    }
}

/**
 * Approach : 2 
 * 
 *  Logic --> instead of using regex method we can create a new string by checking Character.isDigit(c)
 * and Character.isLetter(c)
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public boolean isPalindrome(String str) {
        

        String s = "";

        for(char c : str.toCharArray()){
            if(Character.isDigit(c) || Character.isLetter(c))
                s += Character.toLowerCase(c);
        }
        System.out.println(s);
        int i = 0;
        int j = s.length()-1;

        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true; 
    }
}