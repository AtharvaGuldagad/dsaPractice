package LngstRepeatingChar;

import java.util.HashMap;

public class Solution {
    public int characterReplacement(String s, int k) {
        int res=0;
        for(int i=0;i<s.length();i++){
            HashMap<Character, Integer> count=new HashMap<>();
            int maxfreq=0;
            for(int j=i;j<s.length();j++){
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j),0)+1);
                maxfreq=Math.max(maxfreq,count.get(s.charAt(j)));
                if((j-i+1)-maxfreq<=k) res=Math.max(res,j-i+1);
            }
        }
        return res;        
    }
}

