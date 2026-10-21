import java.util.*;
class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] s1 = s.toCharArray();
        char[] s2 = s.toCharArray();

        Arrays.sort(s1,0,n-1);
        Arrays.sort(s2,1,n);
        if(isSorted(s.toCharArray()))return 0;
        if(isSorted(s1) || isSorted(s2)) return 1;
        if(s1[n-1] >= s1[0]) return 2;
        if(s2[0] <= s2[n-1]) return 2;

        if(n>2) return 3;
        return -1;
    }
    private boolean isSorted(char[] arr){
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }
}