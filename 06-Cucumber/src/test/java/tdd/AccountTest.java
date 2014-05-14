package tdd;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * User: david.wursteisen
 * Date: 14/05/14
 * Time: 14:28
 */
@RunWith(Cucumber.class)
@Cucumber.Options(features = "classpath:features")
public class AccountTest {
}
