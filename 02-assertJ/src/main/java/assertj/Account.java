package assertj;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private BigDecimal value = BigDecimal.ZERO.setScale(2);

    private List<Operation> operations;

    public void credit(BigDecimal v) {
        if(BigDecimal.ZERO.compareTo(v) >= 0) {
            return;
        }

        value = value.add(v);
    }


    public void debit(BigDecimal v) {
        if(BigDecimal.ZERO.compareTo(v) >= 0) {
            return;
        }
        value = value.subtract(v);
    }


    private void addOperation(OperationType type, BigDecimal value) {
        operations.add(new Operation(type, value));
    }


    public BigDecimal getValue() {
        return value;
    }

    public List<Operation> getOperations() {
        return new ArrayList<>(operations);
    }
}
