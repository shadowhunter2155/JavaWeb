package exchange.service;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class ExchangeService {
	public double getPrice(String symbol) {
		double price =0;
		try {
			Stock stock = YahooFinance.get(symbol);
			price = stock.getQuote().getPrice().doubleValue();
		} catch (Exception e) {
						
		}
		return price;
	}
}
