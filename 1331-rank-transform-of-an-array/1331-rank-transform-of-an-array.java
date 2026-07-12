class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] nums = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums);

        int rank = 1;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            nums[i] = map.get(arr[i]);
        }

        return nums;
    }
}