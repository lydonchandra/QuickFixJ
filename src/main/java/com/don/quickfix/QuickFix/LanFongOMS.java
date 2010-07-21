package com.don.quickfix.QuickFix;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FileStoreFactory;
import quickfix.LogFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.RuntimeError;
import quickfix.ScreenLogFactory;
import quickfix.SessionID;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;

public class LanFongOMS {
	private final SocketAcceptor acceptor;
	
	public LanFongOMS(SessionSettings settings) throws ConfigError {
	
		Application app = new Application(settings);
		MessageStoreFactory msgStoreFactory = new FileStoreFactory(settings);
		LogFactory logFactory = new ScreenLogFactory( true, true, true);
		MessageFactory msgFactory = new DefaultMessageFactory();
		acceptor = new SocketAcceptor(app, msgStoreFactory, settings, logFactory, msgFactory);
		
	}
	
	
	public void start() throws RuntimeError, ConfigError {
		acceptor.start();
	}
	
	public void stop() {
		acceptor.stop();
	}
	
	public static void main( String args[]) {
		
		SessionSettings sessionSettings = null;
		try {
			if( args.length != 1 ) {
				System.err.println(" Usage: LanFongOMS ");
			}
			//sessionSettings = loadConfiguration(args[0]);
			sessionSettings = loadConfiguration("/Users/lydonchandra/Documents/workspace-sts-carbon3/QuickFix/src/main/resources/lanfong.cfg");
			Iterator sectionIterator = sessionSettings.sectionIterator();

			while( sectionIterator.hasNext() ) {
			
				SessionID id = (SessionID) sectionIterator.next();
				System.out.println( id.toString() );
				
			}
			
			LanFongOMS oms = new LanFongOMS(sessionSettings);
			oms.start();
			System.out.println( "press to quit");
			System.in.read();
			oms.stop();
			
		} catch( Exception ex ) {
			
		}
		
	}
	
	private static SessionSettings loadConfiguration( String configFilePath ) {
		SessionSettings settings = null;
		try {
			InputStream inputStream  = new FileInputStream( configFilePath );
			settings  = new SessionSettings( inputStream );
			inputStream.close();
		} catch( Exception ex ) {
			System.err.println( ex.getMessage() );
		}
		return settings;
	}
	
}
