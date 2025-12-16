import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
//        print(n);
//        printLinearly(1, n);
//        System.out.println();
//        printLinearlyOpp(n);
//        System.out.println();
//        printLinearlyOpp2(n, 1);
//        System.out.println();
//        printWithoutUsingPlusButInAscendingOrder(n, n);
//        System.out.println();
        printWithoutUsingMinusButInDescendingOrder(1, n);
        System.out.println();
        System.out.println(sum(n));
        sum2(n, 0);
        System.out.println(factorial(n));
    }
    public static void print(int n){
        if(n==0) return;
        System.out.println("Nyasha");
        print(n-1);
    }
    public static void printLinearly(int i, int n){
        if(i > n) return;
        System.out.print(i + " ");
        printLinearly(i+1, n);
    }
    public static void printLinearlyOpp(int n){
        if(n==0) return;
        System.out.print(n + " ");
        printLinearlyOpp(n-1);
    }
    public static void printLinearlyOpp2(int n, int i){
        if(n < i) return;
        System.out.print(n + " ");
        printLinearlyOpp2(n-1, i);
    }
    public static void printWithoutUsingPlusButInAscendingOrder(int i, int n){
        if(i<1) return;
        printWithoutUsingPlusButInAscendingOrder(i-1,n);
        System.out.print(i + " ");
    }
    public static void printWithoutUsingMinusButInDescendingOrder(int i, int n){
        if(i > n) return;
        printWithoutUsingPlusButInAscendingOrder(i+1,n);
        System.out.print(i + " ");
    }
    public static int sum(int n){
        if (n == 0) return 0;
        return n + sum(n-1);
    }
    public static void sum2(int n, int sum){
        if (n < 1) {
            System.out.println(sum);
            return;
        }
        sum2(n-1, sum+n);
    }
    public static int factorial(int n){
        if (n==0 || n==1 || n<0) return 1;
        return n * factorial(n-1);
    }
}