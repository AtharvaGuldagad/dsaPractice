package RevPolishNotation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();
        for(String c:tokens) {
            if(c.equals("+")){
                s.push(s.pop()+s.pop());
            }else if(c.equals("-")){
                int a=s.pop();
                int b=s.pop();
                s.push(b-a);
            }else if(c.equals("*")){
                s.push(s.pop()*s.pop());
            }else if(c.equals("/")){
                int a=s.pop();
                int b=s.pop();
                s.push(b/a);
            }else{
                s.push(Integer.parseInt(c));
            }
        }
        return s.pop();
    }
}