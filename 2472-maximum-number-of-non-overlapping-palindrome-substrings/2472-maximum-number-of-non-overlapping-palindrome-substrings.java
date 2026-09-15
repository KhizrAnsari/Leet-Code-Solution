class Solution {
    public int maxPalindromes(String s, int k) {
        // non overlapping 
        // each has length atleast `k` & each string is a palindrome 
        // max no of substrings that can be formed
        // N2, N2LogN will work 

        // then can I generate non-overlapping one's out of it easily. Let me try
        int n = s.length(); 
        boolean[][] pal = new boolean[n][n]; 

        // 1 length is alsways a palindrom 
        for(int i = 0; i < n; i++) pal[i][i] = true; 

        for(int i = 1; i < n; i++) if(s.charAt(i) == s.charAt(i - 1)) pal[i-1][i] = true; 

        // fill for next length 
        for(int len = 3; len <= n; len++) {
            for(int j = 0; j + len <= n; j++) {
                if(s.charAt(j) == s.charAt(j + len - 1) &&
                pal[j + 1][j + len - 2]) {
                    pal[j][j + len - 1] = true;
                }
            }
        }


        int dp[] = new int[n]; // where dp[i] max ending at i with length `k` 

        for(int i = 0; i < n; i++) {
            if(i > 0) dp[i] = dp[i - 1]; 
            for(int j = 0; j <= i; j++) {
                if(i - j >= k - 1 && pal[j][i]) {
                    dp[i] = Math.max(dp[i], 1 + (j > 0 ? dp[j - 1] : 0)); // as we take [j..i] prev one is dp[j - 1]
                }
            }
        }

        return dp[n - 1]; 
    }
}