
import java.math.RoundingMode;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

public class Dollars {
	
	private Money money;

	public Dollars(Money money) {
		this.money = money;
	}

	static public Money amount(double amount){
		return Money.of(CurrencyUnit.USD, amount);
	}

	public static Dollars parse(String amount) {
		return new Dollars(Money.parse(CurrencyUnit.USD.toString() + " " + amount));
	}
	
	public String toString(){
		return money.toString();
	}

	public String toCleanString() {
		String string = this.toString();
		int length = string.length();
		return string.substring(4);
	}

	public Dollars plus(Dollars term) {
		return term.addMoney(this.money);
	}

	private Dollars addMoney(Money term) {
		Money result = this.money.plus(term);
		return new Dollars(result);
	}

	public Dollars minus(Dollars term) {
		return term.minusMoney(this.money);
	}

	private Dollars minusMoney(Money term) {
		Money result = term.minus(this.money);
		return new Dollars(result);
	}

	public Dollars times(int multiplier) {
		Money result = this.money.multipliedBy(multiplier);
		return new Dollars(result);
	}

	public Dollars times(double multiplier) {
		Money result = this.money.multipliedBy(multiplier, RoundingMode.HALF_DOWN);
		return new Dollars(result);
	}
	
	public boolean equals(Object other) {
		if (other == null ) return false;
		return other.equals(this.money);
	}

	public boolean isGreaterThan(Dollars otherDollars) {
		return otherDollars.isNotGreater(this.money);
	}

	private boolean isNotGreater(Money money2) {
		return money2.isGreaterThan(money);
	}
}
