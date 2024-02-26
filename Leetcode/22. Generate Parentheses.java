/**
 * Approach 
 * 
 * creare a array list to store result
 * use backtracking to get valid parentheses 
 * if current string length is equal to n*2 then add to list
 * if open < max add a open parentheses 
 * if close < opne add a close parentheses ( we can't add close parentheses before open parentheses)
 * 
 * Time complexity : O(2^N)
 * Space complexity : O(N)
 */

class Solution {    
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,"",0,0,n);
        return result;
    }

    public void backtrack(List<String> result, String str, int open, int close, int max){
        if(str.length() == max*2){
            result.add(str);
            return;
        }
          
        if(open < max)
            backtrack(result,str+"(",open+1,close,max);
        if(close < open)
            backtrack(result,str+")",open,close+1,max);

    }
}