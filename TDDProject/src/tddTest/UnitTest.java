package tddTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tddDate.DateConverter;

public class UnitTest {

	private DateConverter dateConverter;

	@Before
	public void setUp() throws Exception {
		dateConverter = new DateConverter();
	}

	@Test
	public void testBasicString() {
		String result = dateConverter.getDate("10/09/08");
		assertEquals("10/09/2008", result);
	}
	
	@Test
	public void testCorrectString() {
		String result = dateConverter.getDate("01/02/03");
		assertEquals("03/02/2001", result);
	}
	
	@Test
	public void testDateRestrictionString() {
		String result = dateConverter.getDate("01/02/30");
		assertEquals("30/01/2002", result);
	}
	
	@Test
	public void testEmptyDate() {
		String result = dateConverter.getDate("");
		assertEquals("Codification Error", result);
	}
	
	@Test
	public void testErrorDate() {
		String result = dateConverter.getDate("13/2/9");
		assertEquals("13/09/2002", result);
	}
	
	@Test
	public void testZeroDate() {
		String result = dateConverter.getDate("0/03/12");
		assertEquals("12/03/2000", result);
	}
	
}
