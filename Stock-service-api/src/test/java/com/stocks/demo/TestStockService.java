//package com.stocks.demo;
//
//import com.stocks.entity.Stock;
//import com.stocks.entity.StockList;
//import com.stocks.service.StockServiceImpl;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import com.stocks.persistence.StockDao;
//
//@RunWith(MockitoJUnitRunner.class)
//class TestStockService {
//
//    @InjectMocks
//    private StockServiceImpl stationServiceImpl;
//    @Mock
//    private StockDao stationdao;
//    private AutoCloseable autoCloseable;
//
//    @BeforeEach
//	void setUp() throws Exception {
//		/*
//		 * tells mockito to scan the test class instance 
//		 * for all the fields annotated with @Mock
//		 * and initialize those fields as mocks
//		 * 
//		 */
//		autoCloseable=MockitoAnnotations.openMocks(this);
//	}
//
//    @AfterEach
//	void tearDown() throws Exception {
//		autoCloseable.close();
//	}
//
//    // positive
//    @Test
//    void getAllStationsPos() {
//    	
//    	List<Stock> stations = new LinkedList<Stock>();
//    	stocks.add(new Stock(02, "Waterloo"));
//    	stocks.add(new Stock(03, "Paddington"));
//       
//    	when(stockdao.findAll()).thenReturn(stocks);
//    	
//    	assertEquals(stations, stationServiceImpl.getAllStocks().getStocks());
//    }
//    
//    // negative
//    @Test
//    void getAllStationsNeg() {
//    	
//    	StockList stationList = new StockList();
//
//    	when(stationdao.findAll()).thenReturn(null);
//    	assertEquals(stationList, stationServiceImpl.getAllStations());
//    }
//
//    //checking the search by name method 
//    @Test
//    void searchStationByNameTest() {
//    	Stock station = new Stock(02, "Waterloo");
//    	when(stationdao.searchStationByStationName("Waterloo")).thenReturn(station);
//    	assertEquals(station, stationServiceImpl.getStationByStationName("Waterloo"));
//    	//assertTrue(stationServiceImpl.searchStationById(01)!=null);
//    }
//    
//    // negative test not needed as the user never gets the option to input their own station due to dropdown
//    
//    // checking the route cost method
//    @Test
//    void checkRouteCostTest() {
//    	Stock sourceStation = new Stock(2, "Waterloo");
//    	Stock destinationStation = new Stock(3, "Paddington");
//    	
//    	when(stationdao.searchStationByStationName("Waterloo")).thenReturn(sourceStation);
//    	when(stationdao.searchStationByStationName("Paddington")).thenReturn(destinationStation);
//    	
//    	double result = stationServiceImpl.checkRouteCost("Waterloo", "Paddington");
//    	double expected = 5;
//    	
//    	assertEquals(result, expected);
//    
//    }
//    
//    // negative test not needed as the user never gets the option to input their own station due to dropdown
//
//}