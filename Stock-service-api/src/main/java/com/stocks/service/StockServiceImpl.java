// Page needs editing

package com.stocks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stocks.entity.Stock;
import com.stocks.entity.StockList;
import com.stocks.persistence.StockDao;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDao stockDao;

	@Override
	public StockList getAllStocks() {
		
		StockList stockList = new StockList();
		
		stockList.setStocks(stockDao.findAll());
		
		return stockList;
	}

	// setting a constant value for the price of travel between two stations
//	static final double ADJACENT_STOCKS = 5.00;
	
	// checking the cost of the route based on how many stations are travelled
	// will cost 0 if the swipe in/swipe out station is the same
	// allows for travel both ways
//	@Override
//	public double checkRouteCost(String sourceStation, String destStation) {
//		Stock source = stockDao.searchStockByStockName(sourceStation);
//		Stock des = stockDao.searchStockByStockName(destStation);
//		int sourceId = source.getStockId();
//		int desId = des.getStockId();
//		
//		int distance;
//		
//		if (sourceId == desId) {
//			return 0;
//		} else if (sourceId > desId) {
//			distance = sourceId - desId;
//		} else {
//			distance = desId - sourceId;
//		}
//		
//		double price = ADJACENT_STOCKS * distance;
//		
//		return price;
//	}

	// returning a station object based on the name input
	@Override
	public Stock getStockByStockName(String stockName) {
		
		return stockDao.searchStockByStockName(stockName);
	}

}