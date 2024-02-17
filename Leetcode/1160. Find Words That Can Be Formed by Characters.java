/**
 * Approach 1 :
 * 
 * 1. Create a hashmap to store char and count of chars 
 * 2. Loop through an array take every string 
 * 3. create a hashmap to store char,count for string and create flag as true
 * 4. loop through every char from string
 * 5. check for this char do we have key in chars-Hashmap if it is null or 
 * counter of char-hashmap is less than string-hashmap then update flag as false and break from loop.
 * 6. if flag is true update length
 * 7. return length 
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */

class Solution {
    public int countCharacters(String[] words, String chars) {


        HashMap <Character,Integer> charCount = new HashMap<>();

        int length=0;

        for(char c : chars.toCharArray()){
            charCount.put(c,charCount.getOrDefault(c,0)+1);
        }

        for(String str : words){
            HashMap <Character, Integer> strCount = new HashMap<>();
            for(char c : str.toCharArray()){
                strCount.put(c, strCount.getOrDefault(c,0)+1);
            }
            boolean flag = true;
            for(char c : str.toCharArray()){
                if(charCount.get(c) == null || charCount.get(c)<strCount.get(c)){
                    flag = false;
                    break;
                }    
            }
            if(flag)
                length += str.length();
        }
        return length;
    }
}

/**
 * Appraoch : 2 
 * 
 * create a int array of 26 letter store count for chars 
 * 
 * loop through string
 * create temp array and store count values
 * for every string check for every character value is greater than zero and value is present 
 * if its present decrese the counter
 * compare total no of validated char count is equal to length of the string 
 * if yes sum length
 * 
 * 
 * Time Complexity: O(n + m + km) ==> O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int countCharacters(String[] words, String chars) {
        int array[] = new int[26];

        for(char c : chars.toCharArray()){
            array[c-'a']++;
        }
        int length=0;

        for(String str : words){

            int temp[] = Arrays.copyOf(array, 26);
            int no_validated_char = 0;

            for(char c : str.toCharArray()){
                if(temp[c-'a']>0){
                    temp[c-'a']--;
                    no_validated_char++;
                    continue;
                }
            }
            if(no_validated_char == str.length())
                length += no_validated_char;

        }

        return length;
    }
}