class Solution {
    public int subsetXORSum(int[] nums) {
        int ans = 0;

        for (int mask = 0; mask < (1 << nums.length); mask++) {
            int xor = 0;

            for (int i = 0; i < nums.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    xor ^= nums[i];
                }
            }

            ans += xor;
        }

        return ans;
    }
}