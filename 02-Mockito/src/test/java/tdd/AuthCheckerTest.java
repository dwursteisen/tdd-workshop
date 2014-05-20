package tdd;

import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AuthCheckerTest {

    private RemoteWebService service;
    private AuthChecker checker;

    /**
     * Use only for compiling
     */
    @Deprecated
    private final User replaceMe = null;

    @Before
    public void setUp() throws Exception {
        service = mock(RemoteWebService.class);
        checker = new AuthChecker(service);
    }




    /**
     * Sur cette partie, il est nécessaire de créer un mock
     * pour simuler différent scénario
     */
    @Test
    public void user_should_exist() {
        Assertions.assertThat(checker.isUserExist("azerty")).isTrue();
    }

    @Test
    public void user_should_not_exist() {
        Assertions.assertThat(checker.isUserExist("azerty")).isFalse();
    }


    /**
     * Il est possible de simuler des exceptions avec mockito.
     * Peut être que c'est le moment d'essayer ?
     */
    @Test
    public void should_update_user() throws IOException {

        User result = checker.updateUser(replaceMe, "description");
        Assertions.assertThat(result).isSameAs(replaceMe);

    }

    @Test
    public void should_update_user_with_exception() throws IOException {
        User result = checker.updateUser(replaceMe, "description");
        Assertions.assertThat(result).isNull();
    }


    /**
     * Via Mockito, il est possible d'utiliser Verify pour être sûr si le bon service a été appelé (ou non) correctement
     */
    @Test
    public void should_be_autorized() {

        boolean autorized = checker.isAutorized(new User("userId"), "password");
        Assertions.assertThat(autorized).isTrue();
        Mockito.verify(service).getData(replaceMe);
    }

    @Test
    public void should_not_be_autorized() {

        boolean autorized = checker.isAutorized(replaceMe, "password");
        Assertions.assertThat(autorized).isFalse();
    }


    /**
     * Utiliser Argument Captor pour vérifier que le user a correctement été créé
     */
    @Test
    public void should_create_user() {

        checker.createNewUser("userId");

//        assertThat(argument.getValue().getId()).isEqualTo("userId");
    }


    /**
     * Il est possible d'utiliser des Answser pour configurer un mock
     */
    @Test
    public void should_be_autorized_with_answer() {
        boolean autorized = checker.isAutorized(replaceMe, "password");
        Assertions.assertThat(autorized).isFalse();
    }
}
