package LargestEletoRight;

public class Solution {
    public int[] replaceElements(int[] arr) {
        int temp=0;
        for(int i=0;i<arr.length;i++){
            int max=-1;
            for(int j=i+1;j<arr.length;j++){
                max=Math.max(max,arr[j]);
            }
            arr[i]=max;
        }
        arr[arr.length-1]=-1;
        return arr;
    }
}