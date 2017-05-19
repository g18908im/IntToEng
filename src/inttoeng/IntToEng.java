package inttoeng;
import java.util.Scanner;


public class IntToEng {
	 // メインメソッド
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        
        System.out.println(translateEng(input));
    }

    // 数値を英訳する変換するメソッド
    static String translateEng(int n) {
    	String m = "";
    	final String[] Number19 = {"zero", "one", "two", "three", "four",
				"five", "six", "seven", "eight", "nine",
				"ten","eleven", "twelve", "thirteen", "fourteen",
				"fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    	final String[] Number20 = {"twenty", "thirty", "forty", "fifty", "sixty",
			    "seventy", "eighty", "ninety"};
    	if(n>=0 && n<=19){
    		m =  Number19[n];
    	}else{
    		if(n % 10 == 0){
    			m = Number20[n/10-2];
    		}else{
    			m = Number20[n/10-2] + " " +Number19[n%10];
    		}
    	}
    	return m;
    }
}
