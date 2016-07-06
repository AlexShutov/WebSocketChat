package alex_shutov.com.websocketchat.web.api_impl;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import alex_shutov.com.websocketchat.R;
import alex_shutov.com.websocketchat.web.api.AllUsersApi;
import alex_shutov.com.websocketchat.web.web_model.all_users.AllUsersResponse;
import alex_shutov.com.websocketchat.web.web_model.all_users.User;
import okhttp3.ResponseBody;
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

    private Context context;
    /** we can move it into di's module */
    Retrofit restLib;
    AllUsersApi api;

    public AllUsersFetcher(Context context){
        this.context = context;
        restLib = createRetrofitInstance();
        api = restLib.create(AllUsersApi.class);
    }

    /**
     *
      * @param token token set new token if not null or empty, use the existing one otherwise
     * @return postponed task
     */
    public Observable<AllUsersResponse> getAllusers(String token){

        Observable<AllUsersResponse> allUsersTask =
        api.getAllUsers("application/json", "JWT " + token)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .map(response -> {
                    List<User> users = response.getUsers();
                    if (null == users || users.size() == 0){
                        Log.i(LOG_TAG, "There are no users");
                    }else {
                        Log.i(LOG_TAG, "There are " + users.size()+ " users");
                    }
                    return response;
                });
        return Observable.defer(() -> allUsersTask);
    }

    public Observable<ResponseBody> getAllusersNotParsed(String token){

        Observable<ResponseBody> allUsersTask =
                api.getAllUsersNotParsed("application/json", "JWT " + token)
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.computation());

        return Observable.defer(() -> allUsersTask);
    }


    private String getChatServerURL(){
        String url = context.getString(R.string.base_url_address);
        return url;
    }

    // TODO: move to base class, define only interceptor here
    private Retrofit createRetrofitInstance(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getChatServerURL())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

}
