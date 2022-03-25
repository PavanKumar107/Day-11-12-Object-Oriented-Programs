package objectorientedprograms;

import java.util.ArrayList;

public class StockPortfolio {
	private  ArrayList<Stockaccount> stockList = new ArrayList<Stockaccount>();
	void addStock(Stockaccount stock) {
		stockList.add(stock);
	}

	void calculateEachStock() {
		for(Stockaccount stock : stockList) {
			System.out.println("Stock Name :"+ stock.getStockName()+ " ||| Total value of shares Rs.:" +stock.getNoOfShares() * stock.getSharePrice());
		}
	}

	void totalValueStocks() {
		int stocksValue = 0;
		for(Stockaccount stock : stockList) {
			stocksValue += stock.getNoOfShares() * stock.getSharePrice();
		}
		System.out.println("Total value of stocks Rs.:" + stocksValue);
	}

	void infoPortfolio() {
		calculateEachStock();
		totalValueStocks();
	}
}
