package com.stocks.service;

import com.stocks.entity.Stock;
import com.stocks.entity.StockList;

public interface StockService {
	
	StockList getAllStocks();
	
	Stock getStockByStockName(String stockName);
	
	//double checkRouteCost(String sourceStation, String destStation);
}
