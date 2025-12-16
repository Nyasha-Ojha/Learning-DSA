import java.util.*;
public class File3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int n = arr.length;
        ArrayList<Integer> subseq;
        printF(0, new ArrayList<>(), arr, n);
    }
    public static void printF(int idx, ArrayList<Integer> subseq, int[] arr, int n){
        if(idx == n){
            if(subseq.size() == 0){
                System.out.print("{}");
            }else{
                for(int i : subseq){
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }

        subseq.add(arr[idx]);
        printF(idx+1, subseq, arr, n);
        subseq.remove(subseq.size()-1);
        printF(idx+1, subseq, arr, n);


    }

}
