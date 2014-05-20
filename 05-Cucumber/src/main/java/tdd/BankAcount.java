package tdd;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * User: david.wursteisen
 * Date: 14/05/14
 * Time: 14:32
 */
public class BankAcount {

    private BigDecimal amount = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_DOWN);

    public BankAcount() {
    }

    public BankAcount(BigDecimal initialAmount) {
        this.amount = initialAmount;
    }

    public boolean deposit(BigDecimal amount) {
        this.amount = this.amount.add(amount);
        return false;
    }

    public boolean withdraw(BigDecimal amount) {
        return false;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
