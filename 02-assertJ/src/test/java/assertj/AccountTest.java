package assertj;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class AccountTest {


    @Test
    public void should_get_operation() {

        Account account = new Account();
        account.credit(BigDecimal.ONE);

        assertThat(account.getValue()).isEqualTo("1.00");
    }
}
