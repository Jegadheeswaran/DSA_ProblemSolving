/**
 * 
 *
 * initally compare the size of an string if its not equal return false
 * otherwise follow below steps
 * 
 * Conver string to char array
 * Sort char array 
 * compare every val if it is not equal return false
 * otherwise return true
 * 
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())    return false;
        char arr1 [] = s.toCharArray();
        char arr2 [] = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] != arr2[i])  
                return false;
        }
        return true;
    }
}


/**
 * Optimal solution 
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * 
 * check length if its not equal return false
 * create a hashmap store the char : count value for string 1
 * take string 2 check the char is present or not, if char count is zero return false 
 * if yes subtract 1, else return false 
 * 
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())    return false;

        HashMap <Character,Integer> charCount = new HashMap<Character,Integer>();

        for(char c : s.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c,0)+1);
        }

        for(char c : t.toCharArray()){
            if(!charCount.containsKey(c) || charCount.get(c) == 0 )   return false;
            charCount.put(c, charCount.get(c)-1);
        }
    return true;    
    }
}

//Solution 3 

/**
 * Time complexity : O(n)
 * Space complexity : ~O(n)
 * 
 * create an integer array, size of 26
 * in str1 increment array[char- 'a']
 * in str2 decrement array[char - 'a']
 * check array whether its contains only zero's 
 * if not zero return false
 * else return true
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())    return false;

        int arr [] = new int[26];  
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        } 
        for(int i : arr){
            if(i != 0)  
                return false;
        }
        return true;
    }
}