package GenerateParenthesis;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder stk=new StringBuilder();
        bktk(res, n, 0,0, stk);
        return res;
    }
    void bktk(List<String> res, int n, int open, int closed, StringBuilder stk){
        if(closed==open&&open==n){
            res.add(stk.toString());
            return;
        }
        if(open<n) {
            stk.append('(');
            bktk(res, n, open+1, closed, stk);
            stk.deleteCharAt(stk.length()-1);
        }
        if(closed<open){
            stk.append(')');
            bktk(res,n,open,closed+1,stk);
            stk.deleteCharAt(stk.length()-1);
        }
        
        
    }
}

