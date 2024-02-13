/**
 * Time complexity : O(m*n)
 * Approach : 
 * 
 * take every string from an array
 * create a arr of int contains 26 value
 * loop through an string and perform this arr[c-'a']++
 * convert the array to string 
 * and create a hashmap of string and array of strings
 * check the key is present or not if present add(str), else put key, new arraylist in hashmap
 * 
 * return hashmap.values in arrayof list.
 * 
 * Approach 2 : we can use string builder to convert array to string
 * Approach 3 : take every string conver to char array, sort it, convert to string use this as key
 */


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap <String,ArrayList<String>> map = new HashMap<>();

        for(String str : strs){

            int arr[]= new int[26];

            for(char c : str.toCharArray()){
                arr[c-'a']++;
            }

            String key = Arrays.toString(arr);

            if(!map.containsKey(key))
                 map.put(key, new ArrayList<>());

            map.get(key).add(str);
            
        }

        return new ArrayList<>(map.values());
    }
}