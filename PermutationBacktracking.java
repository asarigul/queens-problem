import java.util.ArrayList;
import java.util.List;

public class PermutationBacktracking {
    public List<String> permute(String str) {
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[str.length()];
        generatePermutations("", str, used, result);
        return result;
    }

    private void generatePermutations(String current, String str, boolean[] used, List<String> result) {
        if (current.length() == str.length()) {
            result.add(current);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (used[i])
                continue;

            // Choose
            used[i] = true;
            generatePermutations(current + str.charAt(i), str, used, result);

            // Backtrack
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        PermutationBacktracking solution = new PermutationBacktracking();
        System.out.println(solution.permute("ABC"));
    }
}
