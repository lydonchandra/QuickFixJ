package com.don.quickfix.QuickFix;

import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.MessageCracker;
import quickfix.RejectLogon;
import quickfix.SessionID;
import quickfix.SessionSettings;
import quickfix.UnsupportedMessageType;

/**
 * Hello world!
 *
 */
public class Application extends MessageCracker implements quickfix.Application 
{

	private MarketIntelligence mi = null;
	
	public Application( SessionSettings settings) {
		mi = new MarketIntelligence();
		String ask = mi.getAsk("1");
		System.out.println(ask);
	}
	
	public void fromAdmin(Message arg0, SessionID arg1) throws FieldNotFound,
			IncorrectDataFormat, IncorrectTagValue, RejectLogon {
		// TODO Auto-generated method stub
		
	}

	public void fromApp(Message arg0, SessionID arg1) throws FieldNotFound,
			IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {

		crack(arg0, arg1);
		
	}

	public void onCreate(SessionID arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onLogon(SessionID arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onLogout(SessionID arg0) {
		// TODO Auto-generated method stub
		
	}

	public void toAdmin(Message arg0, SessionID arg1) {
		// TODO Auto-generated method stub
		
	}

	public void toApp(Message arg0, SessionID arg1) throws DoNotSend {
		// TODO Auto-generated method stub
		
	}
    
}
