package com.don.quickfix.QuickFix;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MarketIntelligenceTest 
    extends TestCase
{
    public MarketIntelligenceTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( MarketIntelligenceTest.class );
    }

    public void testApp() throws InterruptedException
    {
        assertTrue( true );
        MarketIntelligence mi = new MarketIntelligence();
        while( true ) {
        	String ask = mi.getAsk("1");
        	System.out.println(ask);
        	Thread.sleep(1000);
        }
    }
}
