package ValidParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack <Character>S=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='['||c=='{'){
                S.push(c);
            } else {
                if(S.isEmpty()) return false;
                char top=S.pop();
                if(c==')'&&top!='('||c==']'&&top!='['||c=='}'&&top!='{'){
                    return false;
                }
            }
        }
        return S.isEmpty();
    }
}
