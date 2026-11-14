class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min_sum = Integer.MAX_VALUE;

        for (int size = l; size <= r; size++) {
            int total = 0;

            for (int i = 0; i < size; i++) {
                total += nums.get(i);
            }

            if (total > 0) {
                min_sum = Math.min(min_sum, total);
            }

            for (int right = size; right < nums.size(); right++) {
                total = total + nums.get(right) - nums.get(right - size);

                if (total > 0) {
                    min_sum = Math.min(min_sum, total);
                }
            }
        }

        return min_sum == Integer.MAX_VALUE ? -1 : min_sum;
    }
}