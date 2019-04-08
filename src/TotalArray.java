import java.util.ArrayList;
import java.util.List;

public class TotalArray {
    public static List<List<Integer>> solutionList = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        List<Integer> tempSolution = new ArrayList<>();
        traceBack(tempSolution, nums);

        System.out.println(solutionList.size());

        for (List<Integer> list : solutionList
             ) {
            System.out.println(list.toString());
        }

    }

    private static void traceBack(List<Integer> tempSolution, int[] nums) {
        if(tempSolution.size() == nums.length){
            solutionList.add(new ArrayList<Integer>(tempSolution));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(tempSolution.contains(nums[i])) continue;

                tempSolution.add(nums[i]);
                System.out.println(tempSolution.toString());
                traceBack(tempSolution, nums)  ;
                tempSolution.remove(tempSolution.size() - 1);
            }
        }

    }
}
