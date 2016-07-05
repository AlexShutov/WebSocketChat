package alex_shutov.com.websocketchat.web.api;

import alex_shutov.com.websocketchat.web.web_model.LoginData;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by lodoss on 28/06/16.
 */
public interface LoginApi {

    @POST("api/login")
    Observable<String> login(@Body LoginData loginParam);
}