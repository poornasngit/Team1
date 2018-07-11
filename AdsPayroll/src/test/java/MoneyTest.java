import static org.junit.Assert.*;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;


public class MoneyTest {
	CurrencyUnit usd = CurrencyUnit.USD;

	@Test
	public void creationTest() {
		Money money = Money.parse("USD 23.87");
		assertEquals("USD 23.87", money.toString());
	}

	@Test
	public void additionTest() {
		Money money1 = Money.parse("USD 525.00");
		Money money2 = Money.parse("USD 100.53");
		Money answer = money1.plus(money2);
		assertEquals(625, answer.getAmountMajorInt());
		assertEquals(62553, answer.getAmountMinorInt());
		assertEquals("USD 625.53", answer.toString());
		assertEquals(53, answer.getMinorPart());
	}
	
	@Test
	public void ofTest() {
		Money money = Money.of(usd, 100.00d);
		assertEquals("USD 100.00", money.toString());
	}
	@Test
	public void ofMinorTest() {
		Money money = Money.ofMinor(usd, 10000);
		assertEquals("USD 100.00", money.toString());
	}
	
	@Test
	public void factoryTestUsingDouble() {
		Money dollars = Dollars.amount(100.00d);
		assertEquals("USD 100.00", dollars.toString());
	}
	
	@Test
	public void factoryTestUsingParse() {
		Dollars	 dollars = Dollars.parse("100.00");
		assertEquals("USD 100.00", dollars.toString());
	}
	
	@Test
	public void cleanString() {
		Dollars dollars = Dollars.parse("100.00");
		assertEquals("100.00", dollars.toCleanString());
	}
	
	@Test
	public void dollarAdditionTest() {
		Dollars oneHundred = Dollars.parse("100.00");
		Dollars one = Dollars.parse("1.00");
		Dollars answer = oneHundred.plus(one);
		assertEquals("101.00", answer.toCleanString());
	}
	
	@Test
	public void dollarSubractionTest() {
		Dollars oneHundred = Dollars.parse("100.00");
		Dollars one = Dollars.parse("1.00");
		Dollars answer = oneHundred.minus(one);
		assertEquals("99.00", answer.toCleanString());
	}
	
	@Test
	public void dollarMultipicationTest() {
		Dollars oneHundred = Dollars.parse("100.00");
		Dollars answer = oneHundred.times(5);
		assertEquals("500.00", answer.toCleanString());
	}
	
	@Test
	public void dollarMultipicationByFractionTest() {
		Dollars oneHundred = Dollars.parse("100.00");
		Dollars answer = oneHundred.times(0.25);
		assertEquals("25.00", answer.toCleanString());
	}
	
	@Test
	public void equalsTest() {
		assertEquals(Money.parse("USD 1840"), Money.parse("USD 1840"));
	}
	
	@Test
	public void greaterThanTest() throws Exception {
		assertTrue(Dollars.parse("1840.01").isGreaterThan(Dollars.parse("1840")));
	}
}
