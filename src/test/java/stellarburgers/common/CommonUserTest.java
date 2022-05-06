package stellarburgers.common;

import stellarburgers.api.user.User;
import stellarburgers.api.user.UserClient;
import stellarburgers.api.user.UserCredentials;

//общий класс для тестов, где применяется апи
public class CommonUserTest extends CommonTest {
    protected User user;
    protected UserClient userClient = new UserClient();
    protected UserCredentials userCredentials;
}
