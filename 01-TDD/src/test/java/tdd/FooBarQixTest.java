package tdd;

import org.assertj.core.api.Assertions;
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
    11
    Foo
    Foo
    Qix
    FooBarBar
    16
    Qix
    Foo
    19
    Bar
    FooQix
    22
    Foo
    Foo
    BarBar
    26
    FooQix
     **/

    @Test
    public void should_be_true() {
        Assertions.assertThat(true).isTrue();
    }
}
