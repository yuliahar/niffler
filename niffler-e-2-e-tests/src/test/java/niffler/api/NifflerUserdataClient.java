package niffler.api;

import niffler.model.UserJson;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class NifflerUserdataClient {

    private OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .build();

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(NifflerUserdataService.nifflerUserdataUri)
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    private NifflerUserdataService nifflerUserdataService = retrofit.create(NifflerUserdataService.class);

    public UserJson updateUserdata(UserJson user) throws Exception {
        return nifflerUserdataService.updateUserInfo(user).execute().body();
    }

}
