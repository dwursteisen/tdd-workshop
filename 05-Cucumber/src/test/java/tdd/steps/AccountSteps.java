package tdd.steps;

import java.math.BigDecimal;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Quand;
import cucumber.api.java.fr.Étantdonné;

/**
 * User: david.wursteisen
 * Date: 14/05/14
 * Time: 14:35
 */
public class AccountSteps {

    @Before
    public void setUp()  {

    }

    @After
    public void tearDown() {

    }

    @Étantdonné("^un compte avec (\\d+) €,$")
    public void init_bank_account_with(BigDecimal amount) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Quand("^l’utilisateur effectue un dépôt de (\\d+) €,$")
    public void deposit_on_account(BigDecimal amount) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Alors("^le montant du compte est porté à (\\d+) €.$")
    public void check_bank_account_amount(BigDecimal amount) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

}
