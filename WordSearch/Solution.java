package WordSearch;

import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    boolean res=false;
    int row,col;
    Set<Pair<Integer,Integer>> rasta=new HashSet<>();

    public boolean exist(char[][] board, String word) {
        row=board.length;
        col=board[0].length;
         for (int r=0; r<row; r++) {
            for (int c=0; c<col; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    
    boolean dfs(char[][] board, String word,int r,int c,int i){
        if(i==word.length()) return true;
        if( r>=row || c>=col || r<0 || c<0 ||
            board[r][c]!=word.charAt(i) ||
            rasta.contains(new Pair<>(r,c))){
                return false;
        }
        rasta.add(new Pair<>(r,c));
        res=dfs(board, word, r+1, c, i+1) ||
            dfs(board, word, r-1, c, i+1) ||
            dfs(board, word, r, c+1, i+1) ||
            dfs(board, word, r, c-1, i+1);
        rasta.remove(new Pair<>(r,c));
        return res;
    }
}



class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    // Crucial for HashSet lookups to work properly
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}