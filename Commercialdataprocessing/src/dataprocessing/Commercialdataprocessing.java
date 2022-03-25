package dataprocessing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Commercialdataprocessing {
	private static ArrayList<Commercialdataprocessing> files = new ArrayList<Commercialdataprocessing>();
	private  ArrayList<CompanyShares> companyShares = new ArrayList<CompanyShares>();
	private String filename;
	LocalDateTime localDateTime = LocalDateTime.now();

	public Commercialdataprocessing() {
	}
	public Commercialdataprocessing(String filename) {
		this.filename = filename;
	}
	double valueOfStock() {
		double totalValue = 0;
		for (Commercialdataprocessing file : files) {
			for (CompanyShares companyShare : companyShares) {
				totalValue = totalValue + companyShare.getTotalValue();
			}
		}
		return totalValue;
	}

	void buy(int amount, String symbol, int noOfShares) {
		int condition = 0;
		for (CompanyShares company : companyShares) {
			if (company.getSymbol().equals(symbol)) {
				if (company.buyTotalValue(amount) == 1) {
					company.setDate(localDateTime);
					company.setTime(localDateTime);
					company.buyShare(noOfShares);
					System.out.println(symbol + " shares added to existing shares.");

				} else {
					System.out.println("You can't purchase shares and as the coount balance is critically low ");
				}
				condition = 1;
				break;
			}
		}
		if (condition == 0) {
			CompanyShares newCompany = new CompanyShares();
			if (newCompany.buyTotalValue(amount) == 1) {
				newCompany.setDate(localDateTime);
				newCompany.setTime(localDateTime);
				newCompany.setSymbol(symbol);
				newCompany.buyShare(noOfShares);
				companyShares.add(newCompany);
				System.out.println(symbol + " Shares Purchased.");
			}
		}
	}

	void sell(int amount, String symbol, int noOfShare) {
		int condition = 0;
		for (CompanyShares company : companyShares) {
			if (company.getSymbol().equals(symbol)) {
				condition =1;
				if (company.sellShare(noOfShare) == 1) {
					company.sellTotalValue(amount);
					company.setDate(localDateTime);
					company.setTime(localDateTime);
					System.out.println(symbol + " Share Sold.");
				} else {
					System.out.println("Total number of selling shares are exceeded than present share.");
				}
				break;
			}

		}
		if(condition == 0) {
			System.out.println("You don't have these shares. Please buy first");
		}
	}

	void save(Commercialdataprocessing fileName) {
		files.add(fileName);
		System.out.println("File saved");
	}

	void printReport() {
		if(files.size()==0) {
			System.out.println("There is nothing in the report please add account with new filename");
		}
		else {
			for (Commercialdataprocessing file : files) {
				System.out.println("Filename :" + file.filename);
				for ( CompanyShares companyShare : file.companyShares) {
					System.out.println(
							"Symbol :" + companyShare.getSymbol() + "|||| Total Shares :" + companyShare.getTotalShares() + "||||Total account balance :" + companyShare.getTotalValue()
							+ " ||||Date :" + companyShare.getDate() + "|||| Time :" + companyShare.timeFormat);
					System.out.println();
				}
			}
		}
	}

	public static void main(String[] args) {
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println(
					"Enter 0 to add the new Account Filename or press 1 to see the report or press 2 to quit the program ");
			int input = scan.nextInt();
			if (input == 0) {
				Scanner scan1 =new Scanner(System.in);
				System.out.println("Add the filename ");
				String fileName = scan1.nextLine();
				Commercialdataprocessing file = new Commercialdataprocessing(fileName);
				while (true) {

					System.out.println("Enter 0 to buy share , press 1 to sell share, Press 2 to go back to main menu");
					int response = scan1.nextInt();
					if (response == 0) {
						Scanner scan2 =new Scanner(System.in);
						// CompanyShares share = new CompanyShares();
						System.out.println("Enter the symbol name of share "); //// Symbol refers to the company name
						String symbol = scan2.nextLine();
						System.out.println("Enter the total no of shares to buy ");
						int noOfShares = scan2.nextInt();
						System.out.println("Enter the total purchasing price of shares ");
						int amount = scan2.nextInt();
						file.buy(amount, symbol, noOfShares);
					} 

					else if (response == 1) {
						Scanner scan3 =new Scanner(System.in);
						System.out.println("Enter the symbol name of share "); //// Symbol refers to the company name
						String symbol = scan3.nextLine();
						System.out.println("Enter the total no of shares to sell ");
						int noOfShares = scan3.nextInt();
						System.out.println("Enter the total selling price of shares ");
						int amount = scan3.nextInt();
						file.sell(amount, symbol, noOfShares);

					} 
					else if (response == 2) {
						break;
					}

					else {
						System.out.println("Enter valid command");
					}
				}
				file.save(file);

			} 
			else if (input == 1) {
				Commercialdataprocessing file = new Commercialdataprocessing();
				file.printReport();
			}
			else if(input ==2) {
				System.out.println("Program is closed");
				break;
			}
			else {
				System.out.println("Enter the valid command");
			}
		}

	}

}

