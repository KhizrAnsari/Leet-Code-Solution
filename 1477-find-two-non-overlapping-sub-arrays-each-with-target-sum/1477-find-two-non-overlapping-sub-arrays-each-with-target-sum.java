class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        long sum = 0;
        int n = arr.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int l = 0, r = 0;
        while (r < n) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l++];
            }
            if (sum == target) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(l);
                temp.add(r);
                list.add(temp);
            }
            r++;
        }
        int pairs = list.size();
        list.sort((a, b) -> {
            if (a.get(0) != b.get(0)) {
                return Integer.compare(a.get(0), b.get(0));
            }
            return Integer.compare(a.get(1), b.get(1));
        });
        long[][] dp = new long[pairs + 1][4];
        for (long[] one : dp) {
            Arrays.fill(one, -1);
        }
        long ans = solve(list, dp, 0, 0);
        if (ans >= Integer.MAX_VALUE)
            return -1;
        return (int) ans;
    }

    public long solve(ArrayList<ArrayList<Integer>> list, long[][] dp, int i, int curr) {
        if (curr >= 2)
            return 0;
        if (i >= list.size())
            return Integer.MAX_VALUE;
        if (dp[i][curr] != -1)
            return dp[i][curr];
        long notPick = solve(list, dp, i + 1, curr);
        int right = list.get(i).get(1);
        int next = lowerBound(list, right + 1);
        long pick = list.get(i).get(1) - list.get(i).get(0) + 1 + solve(list, dp, next, curr + 1);
        return dp[i][curr] = Math.min(pick, notPick);
    }

    private int lowerBound(ArrayList<ArrayList<Integer>> list, int target) {
        int lo = 0, hi = list.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid).get(0) < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }
}