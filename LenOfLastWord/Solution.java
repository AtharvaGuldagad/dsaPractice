package LenOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length()-1;
        while(s.charAt(n)==' ') n--;
        int res=0;
        for(int i=n;i>=0;i--) {
            if(s.charAt(i)==' ') break;
            res++;
        }
        return res;
    }
}
