/**
 * Approach : 
 * 
 * create a hashSet of strings store 3 types of strings for Row Validation, Column Validation, Grid Validation
 * for box validation we are converting i and j value into i/3,j/3 
 * hashSet add method will return true if the value is added. 
 * 
 * Time and Space complexity : O(1) 
 */



class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<String>();

        for(int i=0; i<9 ; i++){
            for(int j=0;j<9;j++){
                char currValue = board[i][j];

                if(currValue == '.')    
                    continue;

                if( !seen.add(currValue+" found in row "+i) ||
                    !seen.add(currValue+" found in columen "+j)||
                    !seen.add(currValue+" found in box "+i/3+"-"+j/3) )
                    
                    return false;

            }
        }
        return true;
    }
}