class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    void dfs(int[] candidates, int start, int target,
             ArrayList<Integer> temp) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] > target)
                continue;

            temp.add(candidates[i]);

            // same i because reuse is allowed
            dfs(candidates, i, target - candidates[i], temp);

            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(candidates, 0, target, new ArrayList<>());

        return ans;
    }
}