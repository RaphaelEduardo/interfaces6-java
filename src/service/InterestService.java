package service;

import java.security.InvalidParameterException;

public interface InterestService {

	Double getInterestRate();
	default Double payment(double amount, int months) {
		if (months < 1) {
			throw new InvalidParameterException("Months must be greater than zero");
		} else {
			double result = amount;
			double percentRate = 1 + (getInterestRate() / 100);
			for (int i = 1; i <= months; i++) {
				result *= percentRate;
			}
			System.out.println("Payment after " + months + " months:");
			return result;
		}
	}
}
