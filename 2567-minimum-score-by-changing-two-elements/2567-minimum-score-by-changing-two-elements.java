class Solution {
    public int minimizeSum(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        int p1 = Math.abs(nums[1] - nums[n-2]);
        int p2 = Math.abs(nums[0] - nums[n-3]);
        int p3 = Math.abs(nums[2] - nums[n-1]);
        return Math.min(p1,Math.min(p2,p3));
    }
}