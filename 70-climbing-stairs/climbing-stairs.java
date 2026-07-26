class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;  // Base cases

        int first = 1;   // ways to reach step 1
        int second = 2;  // ways to reach step 2
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = first + second; // recurrence relation
            first = second;
            second = result;
        }

        return result;
    }
}
