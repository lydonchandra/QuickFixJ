package com.don.quickfix.QuickFix;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MarketIntelligence {
	private static final int maxPrice = 500;
	private Random generator;
	private HashMap<String, String> bids;
	private HashMap<String, String> asks;
	
	public MarketIntelligence() {
		bids = new HashMap<String, String>();
		asks = new HashMap<String, String>();
		
		generator = new Random();
		
		int basePrice;
		double decimal;
		double price;
		String symbol, bid_price, ask_price;
		
		for( int index=1; index<1000; index++) {
			basePrice = generator.nextInt(maxPrice);
			decimal = generator.nextDouble();
			price = basePrice + decimal;
			symbol = ""+ index;
			bid_price = "" + price;
			ask_price = "" + (price+0.01);
			bids.put(symbol, bid_price);
			asks.put(symbol, ask_price);			
		}
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				update();
			}
		};
		timer.scheduleAtFixedRate(task, 0, 200);
	}
	
	public String getBid( String symbol) {
		return bids.get(symbol);
	}
	
	public String getAsk( String symbol ) {
		return asks.get(symbol);		
	}
	
	public void update() {
		double current_bid, current_ask, new_bid, new_ask;
		double delta, price;
		int up_dn;
		String current_key;
		
		for( Map.Entry entry: bids.entrySet() ) {
			current_key = (String) entry.getKey();
			current_bid = Double.parseDouble(bids.get(current_key));
			current_ask = Double.parseDouble(asks.get(current_key));
			
			delta = generator.nextDouble();
			up_dn = generator.nextInt() % 2;
			delta = up_dn * delta;
			new_bid = current_bid + delta;
			new_ask = new_bid + 0.1;
			
			bids.put(current_key, ""+new_bid);
			asks.put(current_key, ""+new_ask);
			
		}
		
	}
}
