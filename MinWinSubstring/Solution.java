package MinWinSubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";
        Map<Character, Integer> T=new HashMap<>();
        Map<Character, Integer> window=new HashMap<>();
        for(char c:t.toCharArray()){
            T.put(c,T.getOrDefault(c,0)+1);
        }
        int have=0, need=T.size();
        int[]res={-1,-1};
        int resLen=Integer.MAX_VALUE;
        int l=0;

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            window.put(c,window.getOrDefault(c,0)+1);
            if(T.containsKey(c) && window.get(c).equals(T.get(c))) have++;
            while(have==need){
                if((i-l+1)<resLen){
                    resLen=i-l+1;
                    res[0]=l;
                    res[1]=i;

                }
                char leftChar=s.charAt(l);
                window.put(leftChar,window.get(leftChar)-1);
                if(T.containsKey(leftChar) && window.get(leftChar)<T.get(leftChar)) have--;
                l++;
            }
        }
        return resLen==Integer.MAX_VALUE?"":s.substring(res[0],res[1]+1);
    }
}

