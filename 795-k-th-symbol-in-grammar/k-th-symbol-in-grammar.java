class Solution {
    public int kthGrammar(int n, int k) {

        if (n == 1) {
            return 0;
        }

        int middle = (int) Math.pow(2, n - 2);

        if (k <= middle) {
            return kthGrammar(n - 1, k);
        } else {
            return 1 - kthGrammar(n - 1, k - middle);
        }
    }
}