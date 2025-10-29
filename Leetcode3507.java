import java.util.ArrayList;
import java.util.List;

public class Leetcode3507 {

    public static int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                ans++;
                processToValide(nums, n);
                i = -1;
                n--;
            }
        }

        return ans;

    }

    public static void processToValide(int nums[], int n) {
        int minSumIndex = 0;
        int minSum = nums[0] + nums[1];

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] + nums[i + 1] < minSum) {
                minSum = nums[i] + nums[i + 1];
                minSumIndex = i;
            }
        }

        nums[minSumIndex] = minSum;

        for (int i = minSumIndex + 1; i < n - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(minimumPairRemoval(new int[] { 5, 2, 3, 1 }));
    }
}
