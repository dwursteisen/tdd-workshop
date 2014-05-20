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
        doReturn(new User("azerty")).when(service).findUserById("azerty");
        Assertions.assertThat(checker.isUserExist("azerty")).isTrue();
    }

    @Test
    public void user_should_not_exist() {
        doReturn(null).when(service).findUserById("azerty");
        Assertions.assertThat(checker.isUserExist("azerty")).isFalse();
    }


    /**
     * Il est possible de simuler des exceptions avec mockito.
     * Peut être que c'est le moment d'essayer ?
     */
    @Test
    public void should_update_user() throws IOException {

        User user = new User("azerty");

        Mockito.doReturn(user).when(service).updateData(Mockito.eq(user), Mockito.any(Data.class));
        User result = checker.updateUser(user, "description");
        Assertions.assertThat(result).isSameAs(user);

    }

    @Test
    public void should_update_user_with_exception() throws IOException {
        User user = new User("azerty");

        Mockito.doThrow(new IOException("Boom")).when(service).updateData(Mockito.eq(user), Mockito.any(Data.class));
        User result = checker.updateUser(user, "description");
        Assertions.assertThat(result).isNull();
    }

    // utilisation de verify
    // argument captor

    @Test
    public void should_be_autorized() {
        // TODO: use mock
        User user = new User("userId");

        doReturn(new Data("password", "userId")).when(service).getData(user);

        boolean autorized = checker.isAutorized(new User("userId"), "password");
        Assertions.assertThat(autorized).isTrue();
    }

    @Test
    public void should_not_be_autorized() {
        // TODO: use mock
        User user = new User("userId");

        doReturn(new Data("fakePassword", "userId")).when(service).getData(user);

        boolean autorized = checker.isAutorized(user, "password");
        Assertions.assertThat(autorized).isFalse();
    }




    @Ignore
    @Test
    public void should_be_autorized_with_answer() {
        // TODO: use mock and answer on
        boolean autorized = checker.isAutorized(new User("userId"), "password");
        Assertions.assertThat(autorized).isTrue();
    }

    @Test
    public void should_create_user() {
        // TODO: use argument captor !

        checker.createNewUser("userId");

        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(service).saveUser(argument.capture());

        assertThat(argument.getValue().getId()).isEqualTo("userId");
    }
}
