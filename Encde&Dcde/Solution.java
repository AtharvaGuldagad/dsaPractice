import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public String encode(List<String> strs) {
        StringBuilder enc = new StringBuilder();
        for(String i : strs){
            enc.append(i.length()).append("#").append(i); //length of string + #(delimiter) + string itself
        }
        return enc.toString();
    }

    public List<String> decode(String str) {
        List<String> s = new ArrayList<>();
        int i=0;
        while (i<str.length()){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int len= Integer.parseInt(str.substring(i,j));
            i=j+1;
            s.add(str.substring(i,i+len));
            i= i+len;
        }
        return s;
    }
}
