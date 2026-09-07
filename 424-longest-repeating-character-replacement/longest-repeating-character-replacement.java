class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];

        int left = 0;
        int maxFreq = 0;
        int answer = 0;

        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'A';

            count[index]++;
            maxFreq = Math.max(maxFreq, count[index]);

            if (right - left + 1 - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}