package com.stocks.resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stocks.entity.Stock;
import com.stocks.entity.StockList;
import com.stocks.service.StockService;

@RestController
public class StockResource {

	@Autowired
	private StockService stockService;
	
//	// GET method for determining the cost of travel between two stations
//	@GetMapping(path="/stocks/{source}/{des}",produces = MediaType.TEXT_PLAIN_VALUE)
//	public String stockCheckResource(@PathVariable("source") String source, @PathVariable("des") String des) {
//		return String.valueOf(stockService.checkRouteCost(source, des));
//	}
	
	// GET method for returning a station object on input of a station name - for input of station id into transaction
	@GetMapping(path = "stocks/{stockName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Stock stockResource(@PathVariable("stockName") String stockName) {
	        return stockService.getStockByStockName(stockName);
	}
	
	// GET method for returning all stocks - used so that customer can pick from drop down
	@GetMapping(path = "/stocks",produces =MediaType.APPLICATION_JSON_VALUE)
	public StockList getAllStockResource(){
		return stockService.getAllStocks();
	}
}