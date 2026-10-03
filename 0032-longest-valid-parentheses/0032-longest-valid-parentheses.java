class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> temp = new Stack<>();
        int ans = 0;
        temp.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                temp.push(i);
            }
            else {
                temp.pop();
                if (temp.empty()) {
                    temp.push(i);
                }
                else {
                    ans = Math.max(ans, i - temp.peek());
                }
            }
        }
        return ans;
    }
}