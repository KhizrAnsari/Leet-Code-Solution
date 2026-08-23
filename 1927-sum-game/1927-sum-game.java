class Solution {
    public boolean sumGame(String num) {
        int n= num.length();
        double res =0 ;
        for(int i =0; i <n; i++){
            double  sign = (i < n /2) ? 1 : -1;
            double value = (num.charAt(i) == '?') ? 4.5 : (num.charAt(i) - '0');
            res += sign * value;
        }
        return res != 0.0;
    }
}