package ValidSudoku;

import java.util.HashSet;
import java.util.Set;

class Solution {
    //a little tricky, just checkif num in row, col and box, if not add to set, if already exist return false.
    public boolean isValidSudoku(char[][] board) {
       Set<String> saw = new HashSet<>();
       for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            char num=board[i][j];
            if(num!='.'){
                if(!saw.add(num+"At row"+i) ||
                   !saw.add(num+"At col"+j) ||
                   !saw.add(num+"In Box"+i/3+"-"+j/3)){
                    return false;
                   }
            }
        }
       }
       return true;
    }
}
