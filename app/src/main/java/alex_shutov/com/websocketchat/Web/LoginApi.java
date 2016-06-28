package alex_shutov.com.websocketchat.Web;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by lodoss on 28/06/16.
 */
public interface LoginApi {

    @POST("login")
    Observable<String> login(@Body LoginData loginParam);
}
