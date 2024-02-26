import java.util.Scanner;

public class PasswordValidator{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.println("\nCheck if your password meets the requirements.");
			String input = sc.nextLine();
			if(input.equals("exit")){
				break;
			} else {
				validatePassword(input);
			}
		}
	}
	
	public static void validatePassword(String password){
		
		boolean hasLowerCase = false;
		boolean hasUpperCase = false;
		boolean hasNumber = false;
		
		if(password.length() < 6 || password.length() > 13){
			System.out.println("Password is too short or too long, the minimum characters is 6 and maximum characters is 13");
			return;
		}
		
		for (char ch: password.toCharArray()){
			if (ch == 'T' || ch == '&'){
				System.out.println("Password contains a illegal char: " + ch + ". Please choose another password.");
				return;
			}
			
			if(Character.isUpperCase(ch)) hasUpperCase = true;
			if(Character.isLowerCase(ch)) hasLowerCase = true;
			if(Character.isDigit(ch)) hasNumber = true;
		}
		
		if(hasUpperCase == true && hasLowerCase == true && hasNumber == true){
			System.out.println("Your password: " + password + " is correct!");
		} else {
			System.out.println("Your password is missing one of the following requirements!");
		}
	}
}