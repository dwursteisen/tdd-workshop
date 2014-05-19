package tdd;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

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


    // utlisation de mock
    // simulation d'exception
    // utilisation de verify
    // argument captor


    @Test
    public void user_should_not_exist() {
        doReturn(null).when(service).findUserById("azerty");
        Assertions.assertThat(checker.isUserExist("azerty")).isFalse();
    }

    @Test
    public void user_should_exist() {
        doReturn(new User("azerty")).when(service).findUserById("azerty");
        Assertions.assertThat(checker.isUserExist("azerty")).isTrue();
    }

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


    @Test
    public void should_update_user() {
        checker.updateUser(new User("azerty"), "description");

    }

    @Test
    public void should_update_user_with_exception() {

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
