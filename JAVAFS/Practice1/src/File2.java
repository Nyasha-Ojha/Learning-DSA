import java.util.*;

public class File2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sumTarget = sc.nextInt();
        int[] arr = {1, 2, 1};
        System.out.println(f(0, arr, 0, sumTarget));;
    }
    public static int f(int idx, int[] arr, int sum, int sumTarget){
        if(idx == arr.length){
            if(sum == sumTarget){
                return 1;
            }
            else return 0;

        }
        sum += arr[idx];

        int l = f(idx+1, arr, sum, sumTarget);

        sum -= arr[idx];

        int r = f(idx + 1, arr, sum, sumTarget);

        return l + r;
    }
}
