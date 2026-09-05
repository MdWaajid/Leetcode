class Solution {
    public int numDecodings(String s) {
        int prev2 = 1;
        int prev1 = 1;

        for (int i = 1; i <= s.length(); i++) {
            int current = 0;

            if (s.charAt(i - 1) != '0')
                current += prev1;

            if (i >= 2) {
                int num = Integer.parseInt(s.substring(i - 2, i));

                if (num >= 10 && num <= 26)
                    current += prev2;
            }

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}