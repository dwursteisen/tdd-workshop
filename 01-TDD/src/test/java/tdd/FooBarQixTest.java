package tdd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * User: david.wursteisen
 * Date: 15/05/14
 * Time: 14:30
 */
public class FooBarQixTest {



   /**

   Les premières valeurs de l'exercice doivent être :

   1
   2
   FooFoo
   4
   BarBar
   Foo
   QixQix
   8
   Foo
   Bar
   Foo
   FooBarBar
   FooQix
   FooFooFoo
   FooBar
   BarFoo
     **/
    @Test
    public void should_be_true() {
        assertThat(true).isTrue(); // yeah, really !
    }
}
