class Solution {
    public String minWindow(String s, String t) {

        int[] count = new int[128];

        for (char c : t.toCharArray())
            count[c]++;

        int left = 0;
        int need = t.length();

        int start = 0;
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            if (count[c] > 0)
                need--;

            count[c]--;

            while (need == 0) {

                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }

                char x = s.charAt(left);

                count[x]++;

                if (count[x] > 0)
                    need++;

                left++;
            }
        }

        if (min == Integer.MAX_VALUE)
            return "";

        return s.substring(start, start + min);
    }
}