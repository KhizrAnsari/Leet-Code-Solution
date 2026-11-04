class Solution {
    private long[] cnt, sum;
    private int m;

    private void update(int p, int delta, int value) {
        for (; p <= m; p += p & -p) {
            cnt[p] += delta;
            sum[p] += (long) delta * value;
        }
    }

    private long[] query(int p) {
        long c = 0, s = 0;
        for (; p > 0; p -= p & -p) {
            c += cnt[p];
            s += sum[p];
        }
        return new long[]{c, s};
    }

    private int kth(int rank) {
        int p = 0;
        int step = Integer.highestOneBit(m);

        for (; step > 0; step >>= 1) {
            int np = p + step;
            if (np <= m && cnt[np] < rank) {
                rank -= (int) cnt[np];
                p = np;
            }
        }
        return p + 1;
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        if ((long) x * k > n) return -1;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] vals = new int[n];
        m = 0;

        for (int v : sorted) {
            if (m == 0 || vals[m - 1] != v) {
                vals[m++] = v;
            }
        }

        cnt = new long[m + 1];
        sum = new long[m + 1];

        long[] ops = new long[n];
        long total = 0;

        for (int i = 0; i < n; i++) {
            int p = Arrays.binarySearch(vals, 0, m, nums[i]) + 1;
            update(p, 1, nums[i]);
            total += nums[i];

            if (i >= x) {
                int old = Arrays.binarySearch(
                    vals, 0, m, nums[i - x]
                ) + 1;

                update(old, -1, nums[i - x]);
                total -= nums[i - x];
            }

            if (i >= x - 1) {
                int midPos = kth((x + 1) / 2);
                long mid = vals[midPos - 1];

                long[] left = query(midPos);
                long lc = left[0], ls = left[1];
                long rc = x - lc, rs = total - ls;

                ops[i] = mid * lc - ls + rs - mid * rc;
            }
        }

        long INF = Long.MAX_VALUE / 4;
        long[] pre = new long[n + 1];
        long[] cur = new long[n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(cur, INF);

            for (int i = j * x; i <= n; i++) {
                cur[i] = Math.min(
                    cur[i - 1],
                    pre[i - x] + ops[i - 1]
                );
            }

            long[] temp = pre;
            pre = cur;
            cur = temp;
        }

        return pre[n];
    }
}