class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int leftValue = Math.abs(nums[left]);
            int rightValue = Math.abs(nums[right]);

            if (leftValue > rightValue) {
                ans[i] = leftValue * leftValue;
                left++;
            } else {
                ans[i] = rightValue * rightValue;
                right--;
            }
        }

        return ans;
    }
}