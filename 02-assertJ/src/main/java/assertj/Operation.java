package assertj;

import java.math.BigDecimal;
import java.util.Date;

public class Operation {

    private final OperationType type;
    private final BigDecimal value;
    private final Date operationTime;

    public Operation(OperationType type, BigDecimal value) {
        this.type = type;
        this.value = value;
        this.operationTime = new Date();
    }

    public OperationType getType() {
        return type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Date getOperationTime() {
        return operationTime;
    }
}
