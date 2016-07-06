package alex_shutov.com.websocketchat.web.api;

import alex_shutov.com.websocketchat.web.web_model.all_users.AllUsersResponse;
import okhttp3.ResponseBody;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by lodoss on 05/07/16.
 */
public interface AllUsersApi {

    /**
     * Token is in request header
     * @return
     */
    @POST("/api/allUsers")
    Observable<AllUsersResponse> getAllUsers(@Header("Content-Type") String contentType,
                                             @Header("Authorization") String jwtToken);

    @POST("/api/allUsers")
    Observable<ResponseBody> getAllUsersNotParsed(@Header("Content-Type") String contentType,
                                                  @Header("Authorization") String jwtToken);

}
