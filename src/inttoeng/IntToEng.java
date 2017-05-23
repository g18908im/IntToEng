package inttoeng;
import java.util.InputMismatchException;
import java.util.Scanner;


public class IntToEng {
	 // メインメソッド
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //int input = sc.nextInt();
        try{
        	int input = sc.nextInt();
        	if(input<100){
        		System.out.println(translateEng(input));
        	}else if(input<1000){
        		System.out.println(translateEng100(input));
        	}else if(input<1000000){
        		System.out.println(translateEng1000(input));
        	}else if(input<1000000000){
        		System.out.println(translateEngM(input));
        	}else if(input<=2147483647){
        		System.out.println(translateEngB(input));
        	}
        }catch(InputMismatchException e){
        	System.out.println("2,147,483,648以上は表示できません");
        }
    }

    // 数値を英訳する変換するメソッド
    static String translateEng(int n) {//0~99
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
    static String translateEng100(int n){//100~999
    	String m = "";
    	String h = "hundred";
    	if(n%100 == 0){
    		m = translateEng(n/100) + " " + h;
    	}else{
    		m = translateEng(n/100) + " " + h + " " + translateEng(n%100);
    	}
    	return m;
    }
    static String translateEng1000(int n){//1,000~999,999
    	String m = "";
    	String t = "thousand";
    	if(n%1000 == 0){
    		m = translateEng(n/1000) + " " + t;
    	}else{
    		if(n/1000 >= 100){
    			m = translateEng100(n/1000) + " " + t + " " + translateEng100(n%1000);
    		}else{
    			m = translateEng(n/1000) + " " + t + " " + translateEng100(n%1000);
    		}
    	}
    	return m;
    }
    static String translateEngM(int n){//1,000,000~999,999,999
    	String m = "";
    	String mi = "million";
    	if(n%1000000 == 0){
    		if(n/1000000 < 100){
    			m = translateEng(n/1000000) + " " + mi;
    		}else{
    			m = translateEng100(n/1000000) + " " + mi;
    		}
    	}else{
    		if(n/1000000 >= 100){
    			m = translateEng100(n/1000000) + " " + mi + " " + translateEng1000(n%1000000);
    		}else{
    			m = translateEng(n/1000000) + " " + mi + " " + translateEng1000(n%1000000);
    		}
    	} 	
    	return m;
    }
    static String translateEngB(int n){//1,000,000,000~2,147,483,647
    	String m = "";
    	String b = "billion";
    	if(n%1000000000 == 0){
    		if(n/1000000000 < 100){
    			m = translateEng(n/1000000000) + " " + b;
    		}else{
    			m = translateEng100(n/1000000000) + " " + b;
    		}
    	}else{
    		if(n/1000000000 >= 100){
    			m = translateEng100(n/1000000000) + " " + b + translateEngM(n%1000000000);
    		}else{
    			m = translateEng(n/1000000000) + " " + b + translateEngM(n%1000000000);
    		}
    	}
    	return m;
    }
}
