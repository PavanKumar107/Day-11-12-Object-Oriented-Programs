package objectorientedprograms;

public class Account {
	private static int balanceMoney;

	int getBalance() {
		return balanceMoney;
	}
	void depositMoney(int money) {
		balanceMoney += money;
		System.out.println("The current account balance is Rs." + balanceMoney);
	}
	void withdrawMoney(int money) {
		balanceMoney -= money;
	}
	void transactionProcess() {
	}
}
