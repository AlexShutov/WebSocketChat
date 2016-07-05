package alex_shutov.com.websocketchat.web.api;

import alex_shutov.com.websocketchat.web.web_model.all_users.AllUsersResponse;
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
    Observable<AllUsersResponse> getAllUsers();

    @POST("/api/allUsers")
    Observable<String> getAllUsersNotParsed();

}
