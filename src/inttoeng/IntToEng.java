package inttoeng;
import java.util.Scanner;


public class IntToEng {
	 // メインメソッド
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        
        if(input<100){
        	System.out.println(translateEng(input));
        }else if(input<1000){
        	System.out.println(translateEng100(input));
        }else{
        	System.out.println(translateEng1000(input));
        }
    }

    // 数値を英訳する変換するメソッド
    static String translateEng(int n) {
    	String m = "";
    	final String[] Number19 = {"zero", "one", "two", "three", "four",
				"five", "six", "seven", "eight", "nine",
				"ten","eleven", "twelve", "thirteen", "fourteen",
				"fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    	final String[] Number20 = {"","","twenty", "thirty", "forty", "fifty", "sixty",
			    "seventy", "eighty", "ninety"};

    	if(n>=0 && n<=19){
    		m =  Number19[n];
    	}else{
    		if(n % 10 == 0){
    			m = Number20[n/10];
    		}else{
    			m = Number20[n/10] + " " +Number19[n%10];
    		}
    	}
    	return m;
    }
    static String translateEng100(int n){
    	String m = "";
    	String h = "hundred";
    	if(n%100 == 0){
    		m = translateEng(n/100) + " " + h;
    	}else{
    		m = translateEng(n/100) + " " + h + " " + translateEng(n%100);
    	}
    	return m;
    }
    static String translateEng1000(int n){
    	String m = "";
    	String t = "thousand";
    	if(n%1000 == 0){
    		m = translateEng(n/1000) + " " + t;
    	}else{
    		m = translateEng(n/1000) + " " + t + " " + translateEng100(n%1000);
    	}
    	return m;
    }
}
