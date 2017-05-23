package inttoeng;
import java.util.InputMismatchException;
import java.util.Scanner;


public class IntToEng {
	 // メインメソッド
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);       
        try{
        	int input = sc.nextInt();
        	System.out.println(translateEng(input));
        }catch(InputMismatchException e){
        	System.out.println("2,147,483,648以上は表示できません");
        }
    }

    static String translateEng(int n) {//0~99
    	String m = "";
    	if(n<100){
    		m = translateEng99(n);
    	}else if(n<1000){
    		m = translateEng100(n);
    	}else if(n<1000000){
    		m = translateEng1000(n);
    	}else if(n<1000000000){
    		m = translateEngM(n);
    	}else if(n<=2147483647){
    		m = translateEngB(n);
    	}
    	return m;
    }
    static String translateEng99(int n){
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
    		m = translateEng99(n/100) + " " + h;
    	}else{
    		m = translateEng99(n/100) + " " + h + " " + translateEng99(n%100);
    	}
    	return m;
    }
    static String translateEng1000(int n){//1,000~999,999
    	String m = "";
    	String t = "thousand";
    	if(n%1000 == 0){
    		if(n/1000 < 100){
    			m = translateEng99(n/1000) + " " + t;
    		}else{
    			m = translateEng100(n/1000) + " " + t;
    		}
    	}else{
    		if(n/1000 >= 100){
    			m = translateEng100(n/1000) + " " + t + " " + translateEng100(n%1000);
    		}else{
    			m = translateEng99(n/1000) + " " + t + " " + translateEng100(n%1000);
    		}
    	}
    	return m;
    }
    static String translateEngM(int n){//1,000,000~999,999,999
    	String m = "";
    	String mi = "million";
    	if(n%1000000 == 0){
    		if(n/1000000 < 100){
    			m = translateEng99(n/1000000) + " " + mi;
    		}else{
    			m = translateEng100(n/1000000) + " " + mi;
    		}
    	}else{
    		if(n/1000000 >= 100){
    			m = translateEng100(n/1000000) + " " + mi + " " + translateEng1000(n%1000000);
    		}else{
    			m = translateEng99(n/1000000) + " " + mi + " " + translateEng1000(n%1000000);
    		}
    	} 	
    	return m;
    }
    static String translateEngB(int n){//1,000,000,000~2,147,483,647
    	String m = "";
    	String b = "billion";
    	if(n%1000000000 == 0){
    		if(n/1000000000 < 100){
    			m = translateEng99(n/1000000000) + " " + b;
    		}else{
    			m = translateEng100(n/1000000000) + " " + b;
    		}
    	}else{
    		if(n/1000000000 >= 100){
    			m = translateEng100(n/1000000000) + " " + b + " " + translateEngM(n%1000000000);
    		}else{
    			m = translateEng99(n/1000000000) + " " + b + " " + translateEngM(n%1000000000);
    		}
    	}
    	return m;
    }
}
