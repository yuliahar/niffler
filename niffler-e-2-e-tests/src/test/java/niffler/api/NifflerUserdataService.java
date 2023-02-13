package niffler.api;

import niffler.model.UserJson;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import static niffler.config.AppConfigReader.appConfig;

public interface NifflerUserdataService {
    String nifflerUserdataUri = appConfig.userdataUrl();

    @POST("/updateUserInfo")
    Call<UserJson> updateUserInfo(@Body UserJson user);
}
