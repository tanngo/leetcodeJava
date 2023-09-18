package Array;

// F(0) = 0, F(1) = 1, F(2) = 2
// F(n) = F(n-1) + F(n-2);
public class FibonacciesApp {

    public static void main(String[] args){
        int result =getFibonacci(12);
        System.out.println(result);
    }
    public static int getFibonacci(int n){
        int a = 0;
        int b=1;
        int c =0;
        for(int i=2 ;i<=n;i++){
            c = a+b;
            a = b;
            b= c;
        }
        return b;
    }
}
