/**
 * Approach : use length and # key to encode 
 * 
 * 
 */

class Solution {

    public String encode(List<String> strs) {
        String res= "";

        for(String str : strs){
            res += (int)str.length()+"#"+str; 
        }


        return res;
    }

    public List<String> decode(String str) {
        ArrayList<String> result = new ArrayList<String>();

        int i = 0;

        while(i<str.length()){
            int j = i;
            while(str.charAt(j) != '#')
                j++;

            int len = Integer.parseInt(str.substring(i, j));
            String word = str.substring(j+1,j+1+len);
            result.add(word);
            i = j+1+len; 
        }

        return result;

    }
}
