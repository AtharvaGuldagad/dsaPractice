package ValidAnagram;

import java.util.HashMap;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> Smap = new HashMap<>();
        HashMap<Character,Integer> Tmap= new HashMap<>();
        int i=0;
        while (i<s.length()){
            Smap.merge(s.charAt(i), 1, Integer::sum);
            Tmap.merge(t.charAt(i), 1, Integer::sum);
            i++;
        }
        return Smap.equals(Tmap);
    }
}

