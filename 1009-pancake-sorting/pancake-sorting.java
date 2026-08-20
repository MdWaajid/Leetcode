import java.util.*;

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();

        for (int n = arr.length; n > 1; n--) {
            int max = 0;

            for (int i = 1; i < n; i++) {
                if (arr[i] > arr[max])
                    max = i;
            }

            if (max != n - 1) {
                flip(arr, max + 1);
                ans.add(max + 1);

                flip(arr, n);
                ans.add(n);
            }
        }

        return ans;
    }

    void flip(int[] arr, int k) {
        int i = 0;
        int j = k - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}