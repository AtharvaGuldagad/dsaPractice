package CourseScheduler;

import java.util.*;

public class Solution {
    Map<Integer,List<Integer>> preMap=new HashMap<>();
    Set<Integer> visiting= new HashSet<>();

    public boolean canFinish(int numCrs, int[][] prerequisites) {
        for(int i=0;i<numCrs;i++){
            preMap.put(i,new ArrayList<>());

        }   
        for(int[] preq: prerequisites){
            preMap.get(preq[0]).add(preq[1]);
        }
        for(int c=0;c<numCrs;c++){
            if(!dfs(c)){
                return false;
            }
        }
        return true;
    }
    boolean dfs(int crs){
        if(visiting.contains(crs)) return false;
        if(preMap.get(crs).isEmpty()) return true;
        visiting.add(crs);
        for(int pre:preMap.get(crs)){
            if(!dfs(pre)){
                return false;
            }
        }
        visiting.remove(crs);
        preMap.put(crs,new ArrayList<>());
        return true;
    }
}

