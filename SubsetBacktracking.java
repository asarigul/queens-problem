import java.util.ArrayList;
import java.util.List;

public class SubsetBacktracking {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add current subset to result
        result.add(new ArrayList<>(current));

        // Try including each element in the subset
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]); // Choose
            generateSubsets(i + 1, nums, current, result); // Explore
            current.remove(current.size() - 1); // Undo the choice (backtrack)
        }
    }

    public static void main(String[] args) {
        SubsetBacktracking solution = new SubsetBacktracking();
        int[] nums = { 1, 2, 3 };
        System.out.println(solution.subsets(nums));
    }
}
