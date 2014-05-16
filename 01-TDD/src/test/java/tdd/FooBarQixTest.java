package tdd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * User: david.wursteisen
 * Date: 15/05/14
 * Time: 14:30
 */
public class FooBarQixTest {

    @Test
    public void should_be_true() {
        assertThat(true).isTrue(); // yeah, really !
    }
}
