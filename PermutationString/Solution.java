package PermutationString;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> c1=new HashMap<>();
        for (char c:s1.toCharArray()) {
            c1.put(c,c1.getOrDefault(c,0)+1);
        }
        int need = c1.size();
        for (int i=0;i<s2.length();i++) {
            Map<Character, Integer> c2=new HashMap<>();
            int cur=0;
            for (int j=i;j<s2.length();j++) {
                char c=s2.charAt(j);
                c2.put(c, c2.getOrDefault(c,0)+1);
                if (c1.getOrDefault(c,0)<c2.get(c)) break;
                if (c1.getOrDefault(c,0)==c2.get(c)) cur++;
                if (cur==need) return true;
            }
        }
        return false;
    }
}
