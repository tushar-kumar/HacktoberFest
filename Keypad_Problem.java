package recursion;

public class Keypad_Problem {
	
	public static String[] keypad(int n) {
		
		if(n <= 1) {
			String output[] = {""};
			return output;
		}
		String prev[] = keypad(n/10);
		String actual[] = new String[pow(4, count(n))];
		String helper = setofcharacters(n%10);
		int k = 0;
		
		for(int i = 0; i < helper.length(); i++) {
			for(int j = 0; j < prev.length; j++) {
				actual[k] = prev[j] + helper.charAt(i);
				
				k++;
			}
		}
		
		// counting no. of strings with null as a character
		int count = 0;
		for(int i = 0; i < actual.length; i++) {
			if(actual[i] == null) {
				count++;
			}
		}
		
		String output[] = new String[actual.length - count];
		for(int i = 0; i < actual.length; i++) {
			if(actual[i] != null) {
				output[i] = actual[i];
			}
		}
		return output;
		
	}
	
	//func for counting no. of integers
	
	private static int count(int num) {
		int count = 0;
		while(num>0) {
			count++;
			num=num/10;
		}
		return count;
	}
	
	private static String setofcharacters(int n) {
		switch(n) {
		case 2: return "abc";
		
		case 3: return "def";
		
		case 4: return "ghi";
		
		case 5: return "jkl";
		
		case 6: return "mno";
		
		case 7: return "pqrs";
		
		case 8: return "tuv";
		
		case 9: return "wxyz";
		
		default:break;
		}
		return "";
	}
	
	private static int pow(int n,int x) {
		if(x == 0) {
			return 1;
		}
		return n*pow(n,x-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 234;
		String output[] = keypad(n);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}

	}

}
