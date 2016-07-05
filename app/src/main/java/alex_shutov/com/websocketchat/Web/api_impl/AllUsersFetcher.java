package alex_shutov.com.websocketchat.web.api_impl;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import alex_shutov.com.websocketchat.R;
import alex_shutov.com.websocketchat.web.api.AllUsersApi;
import alex_shutov.com.websocketchat.web.web_model.all_users.User;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by lodoss on 05/07/16.
 */
public class AllUsersFetcher {
    private static final String LOG_TAG = AllUsersFetcher.class.getSimpleName();

    private class TokenHeaderInterceptor implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            String name = "Authorization";
            String headerValue = "JWT " +
                    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoidGVzdHVzZXIiLCJpZCI6IkV1Zm5ZVFpBdWMiLCJ1c2VybmFtZSI6InRlc3R1c2VyIiwiX2lkIjoiRXVmbllUWkF1YyIsImlhdCI6MTQ2NzcwODY1NywiZXhwIjoxMjM0NTY3ODkxNTkxMTY1NDAwfQ.3HTK1AD0TbLNCTOxW8OaDwbXkXoAFl2bLTXx1huy6S0";

            Request request = chain.request();

            request = request.newBuilder()
                    .addHeader(name, headerValue)
                    .build();

            Response response = chain.proceed(request);
            Log.w(LOG_TAG, response.body().string());
            return response;
        }
    }

    private Context context;
    private String token;
    /** we can move it into di's module */
    Retrofit restLib;
    AllUsersApi api;

    public AllUsersFetcher(Context context){
        token = "";
        this.context = context;
        restLib = createRetrofitInstance();
        api = restLib.create(AllUsersApi.class);
    }

    /**
     *
      * @param token token set new token if not null or empty, use the existing one otherwise
     * @return postponed task
     */
    public Observable<List<User>> getAllusers(String token){
        if (null != token){
            // okClient get token from this class dynamically, so we don't need to get
            setToken(token);
        }
        Observable<List<User>> allUsersTask =
        api.getAllUsers("application/json", getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map(v -> {
                    List<User> users = v.getUsers();
                    if (null == users || users.size() == 0){
                        Log.i(LOG_TAG, "There are no users");
                    }else {
                        Log.i(LOG_TAG, "There are " + users.size()+ " users");
                    }
                    return users;
                });

        return Observable.defer(() -> allUsersTask);
    }

    public Observable<String> getAllusersNotParsed(String token){
        if (null != token){
            // okClient get token from this class dynamically, so we don't need to get
            setToken(token);
        }
        Observable<String> allUsersTask =
                api.getAllUsersNotParsed("application/json", "JWT " + getToken())
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.computation());

        return Observable.defer(() -> allUsersTask);
    }


    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    private String getChatServerURL(){
        String url = context.getString(R.string.base_url_address);
        return url;
    }

    /**
     * TODO: move interface definition to the base class for better looking
     * Token interceptor knows about 'token' because it is an inner class
     * @return
     */
    private Interceptor createHeaderInterceptor(){
        TokenHeaderInterceptor interceptor = new TokenHeaderInterceptor();
        return interceptor;
    }

    // TODO: move to base class, define only interceptor here
    private Retrofit createRetrofitInstance(){

        /** Token is returned as just string, not Json, so use converter in lenient mode
         * We could possibly use only one GSON for all thread, but not sure, if it is
         * thread safe
         * */
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getChatServerURL())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

}
