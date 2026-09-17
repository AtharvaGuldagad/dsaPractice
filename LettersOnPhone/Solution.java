package LettersOnPhone;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> res = new ArrayList<>();
    String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        bktk(0,"",digits);
        return res;
    }
    void bktk(int i,String curStr, String digits){
        if(curStr.length()==digits.length()){
            res.add(curStr);
            return;
        }
        String chars=digitToChar[digits.charAt(i)-'0'];
        for(char c: chars.toCharArray()) bktk(i+1,curStr+c,digits);
    }
}

