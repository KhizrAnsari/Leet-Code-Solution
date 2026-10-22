class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int c1 = 0;
        boolean valid1 = true;
        boolean valid2 = true;

        while (nums[c1] != 0) c1++;

        for (int i = 0; i < n; i++) {
            if (nums[(c1 + i) % n] != i) {
                valid1 = false;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[(c1 + i) % n] != (n - i) % n) {
                valid2 = false;
                break;
            }
        }

        int ans = Integer.MAX_VALUE;
        if (valid1) ans = Math.min(ans, Math.min(c1, n - c1 + 2));
        if (valid2) ans = Math.min(ans, Math.min(c1 + 2, n - c1));
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}