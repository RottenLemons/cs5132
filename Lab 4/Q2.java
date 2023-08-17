import java.lang.Math;
public class Q2 {
	public static int tailcombihelper(int n,int k,double accumulator){
		//add your code for tail recursion here
        if (n == k + 1) {
            return (int)Math.round(n * accumulator);
        }
        return tailcombihelper(n - 1, k, n / (double) (n-k) * accumulator);
	}
	
	
	public static int tailcombi(int n,int k){
		return tailcombihelper(n,k,1);
	}
	
	public static void main(String[] args) {
		System.out.println(tailcombi(35,23));//834451800
	}

}
