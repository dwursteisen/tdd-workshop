package tdd;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.*;

public class AuthCheckerTest {

    private RemoteWebService service;
    private AuthChecker checker;

    @Before
    public void setUp() throws Exception {
        service = Mockito.mock(RemoteWebService.class);
        checker = new AuthChecker(service);
    }

    @Ignore
    @Test
    public void should_create_user() {
        // TODO: use argument captor !

        checker.createNewUser("userId");

        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        Mockito.verify(service).saveUser(argument.capture());

        assertThat(argument.getValue().getId()).isEqualTo("userId");
    }

    @Ignore
    @Test
    public void should_not_be_autorized() {
        // TODO: use mock
        boolean autorized = checker.isAutorized("userId", "password");
        Assertions.assertThat(autorized).isFalse();
    }

    @Ignore
    @Test
    public void should_be_autorized() {
        // TODO: use mock
        boolean autorized = checker.isAutorized("userId", "password");
        Assertions.assertThat(autorized).isTrue();
    }

    @Ignore
    @Test
    public void should_be_autorized_with_answer() {
        // TODO: use mock and answer on
        boolean autorized = checker.isAutorized("userId", "password");
        Assertions.assertThat(autorized).isTrue();
    }
}
