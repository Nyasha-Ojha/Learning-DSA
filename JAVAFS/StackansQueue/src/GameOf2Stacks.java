import java.util.*;
public class GameOf2Stacks {
    static int twoStacks(int maxSum, int[] a, int[] b){
        return helper(maxSum, a, b, 0, 0) - 1;
    }
    private static int helper(int maxSum, int[] a, int[] b, int sumSoFar, int count){
        if(sumSoFar > maxSum){
            return count;
        }
        if(a.length == 0 || b.length==0){
            return count;
        }
        int ans1 = helper(maxSum, Arrays.copyOfRange(a,1, a.length),b, sumSoFar + a[0], count+1);
        int ans2 = helper(maxSum, a, Arrays.copyOfRange(b, 1, b.length), sumSoFar+b[0], count+1);
        return Math.max(ans1, ans2);
    }
}
