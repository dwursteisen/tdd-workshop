package tdd;

/**
 *

 Ecrivez un programme qui affiche les nombres de 1 à 100. Un nombre par ligne. Respectez les règles suivantes :

 Si le nombre est divisible par 3 ou contient 3, écrire “Foo” à la place de 3.
 Si le nombre est divisible par 5 ou contient 5, écrire “Bar” à la place de 5.
 Si le nombre est divisible par 7 ou contient 7, écrire “Qix” à la place de 7.



 On regarde les diviseurs avant le contenu (ex: 51 -> FooBar)
 On regarde le contenu dans l'ordre où il apparait (ex: 53 -> BarFoo)
 On regarde les multiples dans l'ordre Foo, Bar puis Qix (ex: 21 -> FooQix)
 13 contient 3 donc s'écrit “Foo”
 15 est divisible par 3 et 5 et contient un 5 donc s'écrit “FooBarBar”
 33 contient deux fois 3 et est divisible par 3 donc s'écrit “FooFooFoo”

 */
public class FooBarQix {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            // TODO !
        }
    }

    private int index = 1;
    public String next() {
        int current = index++;

        String result = "";
        result = result + isDividedBy(current, 3, "Foo") + isDividedBy(current, 5, "Bar") +  isDividedBy(current, 7, "Qix");
        result = result + contains(current, "3", "Foo") + contains(current, "5", "Bar") + contains(current, "7", "Qix");
        if(result.isEmpty()) {
            return Integer.toString(current);
        } else {
            return result;
        }
    }

    private String contains(final int current, final String container, final String appender) {
        String append = "";
        if(Integer.toString(current).contains(container)) {
            append = appender;
        }
        return append;
    }

    private String isDividedBy(final int current, final int divisor, final String appender) {
        String append = "";
        if(current % divisor == 0) {
            append = appender;
        }
        return append;
    }
}
