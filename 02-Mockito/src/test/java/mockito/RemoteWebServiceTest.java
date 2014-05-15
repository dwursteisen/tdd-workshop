package mockito;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class RemoteWebServiceTest {

    @Test
    public void should_be_mocked() {
        Data toBeReturned = new Data("blabla", "id");

        RemoteWebService mock = mock(RemoteWebService.class);
        doReturn(toBeReturned).when(mock).getData(new User("userId"));

        assertThat(mock.getData(new User("userId"))).isEqualTo(toBeReturned);
    }
}
