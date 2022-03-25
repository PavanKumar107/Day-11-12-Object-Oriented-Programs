package objectorientedprograms;

import java.util.Scanner;

public class AccountTest {

	void testDebit(int debitAmount, Account account) {
		if(account.getBalance()<0) {
			System.out.println("Debit amounbt is exceeding the account balance");
			account.depositMoney(debitAmount);
			System.out.println("The current account balance is Rs." + account.getBalance());
		}
		else {
			System.out.println("Amount withdrawn is Rs." + debitAmount );
			System.out.println("The current Account balance is Rs." + account.getBalance());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		AccountTest accountTest = new AccountTest();

		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter (0/1) to deposit or withdraw the money respectively..Press 2 to stop :");
			int response = scan.nextInt();
			if(response == 0) {
				System.out.println("Enter the Deposit Amount :");
				int deposit = scan.nextInt();
				account.depositMoney(deposit);
			}
			else if(response == 1) {
				System.out.println("Enter the withdrawl Amount :");
				int withdrawl = scan.nextInt();
				account.withdrawMoney(withdrawl);
				accountTest.testDebit(withdrawl, account);
			}
			else if(response == 2) {
				System.out.println("Transaction complete");
				break;
			}
			else {
				System.out.println("Enter valid command");
			}
		}

	}

}

