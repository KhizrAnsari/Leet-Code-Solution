class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = nums[n / 2];
        int total = 0;

        for (int num : nums){
            total += Math.abs(num - mid);
        }
        return total;
    }
}