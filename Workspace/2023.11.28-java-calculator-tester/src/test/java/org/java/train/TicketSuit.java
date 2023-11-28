package org.java.train;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({TicketInitTest.class, TicketPriceTest.class})
public class TicketSuit {

}
