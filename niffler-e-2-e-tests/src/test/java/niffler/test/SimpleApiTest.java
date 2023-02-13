package niffler.test;

import niffler.api.NifflerSpendClient;
import niffler.api.NifflerUserdataClient;
import niffler.api.NifflerUserdataService;
import niffler.jupiter.Spend;
import niffler.jupiter.UserData;
import niffler.model.SpendJson;
import niffler.model.UserJson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SimpleApiTest {

    private NifflerSpendClient nsc = new NifflerSpendClient();
    private NifflerUserdataClient nifflerUserdataClient = new NifflerUserdataClient();

    @ValueSource(strings = {
            "data/spendings/spend0.json",
            "data/spendings/spend1.json"
    })
    @ParameterizedTest
    void addSpend(@Spend SpendJson spend) throws Exception {
        SpendJson created = nsc.createSpend(spend);
        Assertions.assertNotNull(created.getId());
    }

    @ValueSource(strings = {
            "data/users/user0.json",
            "data/users/user1.json"
    })
    @ParameterizedTest
    void updateUserData(@UserData UserJson user) throws Exception {
        UserJson created = nifflerUserdataClient.updateUserdata(user);
        Assertions.assertNotNull(created.getId());
    }
}
