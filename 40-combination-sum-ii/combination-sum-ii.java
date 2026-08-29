class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(candidates, target, 0, path, result);

        return result;
    }

    void backtrack(int[] a, int target, int start,
                   List<Integer> path, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < a.length; i++) {

            if (a[i] > target)
                break;

            if (i > start && a[i] == a[i - 1])
                continue;

            path.add(a[i]);

            backtrack(a, target - a[i], i + 1, path, result);

            path.remove(path.size() - 1);
        }
    }
}