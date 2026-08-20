class Solution {
    public int hIndex(int[] citations) {

        int h = 0;

        for (int i = 1; i <= citations.length; i++) {

            int count = 0;

            for (int j = 0; j < citations.length; j++) {

                if (citations[j] >= i) {
                    count++;
                }
            }

            if (count >= i) {
                h = i;
            }
        }

        return h;
    }
}