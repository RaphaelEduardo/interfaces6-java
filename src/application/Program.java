package application;

import java.util.Locale;
import java.util.Scanner;

import service.BrazilInterestService;
import service.InterestService;
import service.UsaInterestService;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Amount: ");
		double amount = sc.nextDouble();

		System.out.print("Months: ");
		int months = sc.nextInt();

		System.out.print("Interest rate from BR or USA? ");
		sc.nextLine();
		String option = sc.nextLine();
		
		InterestService br = new BrazilInterestService(2.0);
		InterestService usa = new UsaInterestService(1.0);
		
		System.out.println();
		while (true) {
			if (option.toUpperCase().equals("BR")) {
				System.out.println("R$ " + String.format("%.2f", br.payment(amount, months)));
				break;
			} else if (option.toUpperCase().equals("USA")) {
				System.out.println("U$ " + String.format("%.2f", usa.payment(amount, months)));
				break;
			} else {
				System.out.println("Invalid option!");
				System.out.println();
				System.out.println("Interest rate from BR or USA? ");
			}	
		}
		
		sc.close();
	}

}
