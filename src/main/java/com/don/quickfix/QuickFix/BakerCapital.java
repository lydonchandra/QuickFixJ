package com.don.quickfix.QuickFix;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FileStoreFactory;
import quickfix.Initiator;
import quickfix.LogFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.ScreenLogFactory;
import quickfix.SessionSettings;
import quickfix.SocketInitiator;

public class BakerCapital {
	
	public static void main(String args[]) throws ConfigError, FileNotFoundException {
		
		SessionSettings settings = new SessionSettings( new FileInputStream("/Users/lydonchandra/Documents/workspace-sts-carbon3/QuickFix/src/main/resources/bakerCapital.cfg"));
		
		Application application = new Application(settings);
		MessageStoreFactory messageStoreFactory = new FileStoreFactory(settings);
		LogFactory logFactory = new ScreenLogFactory( true, true, true);
		MessageFactory messageFactory = new DefaultMessageFactory();
		
		Initiator initiator = new SocketInitiator(application, messageStoreFactory, settings, logFactory, messageFactory);
		initiator.start();
		
		
	}
}
