package com.stocks.persistence;

import org.springframework.stereotype.Repository;

import com.stocks.entity.Stock;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StockDao extends JpaRepository<Stock, Integer> {

	public Stock searchStockByStockName(String stockName);
	
//	public Collection<Station> getAllStations();
	

}
