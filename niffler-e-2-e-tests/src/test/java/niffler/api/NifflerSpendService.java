package niffler.api;

import niffler.model.SpendJson;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import static niffler.config.AppConfigReader.appConfig;

public interface NifflerSpendService {

    String nifflerSpendUri = appConfig.spendUrl();

    @POST("/addSpend")
    Call<SpendJson> addSpend(@Body SpendJson spend);

}
