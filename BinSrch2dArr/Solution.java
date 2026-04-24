package BinSrch2dArr;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0,h=matrix[0].length-1;
        int m=(l+h)/2;
        int r=0;

        int lt=0,rt=matrix.length-1;
        int lstcol = matrix[0].length - 1;
        int colm=(lt+rt)/2;
        while(lt<=rt){
            if(target < matrix[colm][0]){
                rt=colm-1;
            }else if(target>matrix[colm][lstcol]){
                lt=colm+1;
            } else {
                r=colm;
                break;
            }
            colm=(lt+rt)/2;
        }
        m=(l+h)/2;
        while (l<=h){
            if(matrix[r][m]==target){
                return true;
            }else if(matrix[r][m]<target){
                l=m+1;
            }else if(matrix[r][m]>target){
                h=m-1;
            }
            m=(l+h)/2;   
        }
        return false;
    }
}

