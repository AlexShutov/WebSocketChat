package alex_shutov.com.websocketchat.web.api_impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import alex_shutov.com.websocketchat.R;
import alex_shutov.com.websocketchat.web.api.LoginApi;
import alex_shutov.com.websocketchat.web.web_model.LoginData;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
import rx.subscriptions.BooleanSubscription;

/**
 * Created by lodoss on 28/06/16.
 */
public class LoginManager {
    public static final String LOG_TAG = LoginManager.class.getSimpleName();
    private static final String PREFS_KEY_TOKEN = "PREFS_KEY_TOKEN";

    private Context context;

    Retrofit retrofit;
    LoginData loginData;

    private static void saveToken(Context context, String token){
        if (null == token){
            Log.e(LOG_TAG, "trying to save null token");
        }
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString(PREFS_KEY_TOKEN, token).commit();
    }

    public static String getToken(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        if (!prefs.contains(PREFS_KEY_TOKEN)){
            Log.w(LOG_TAG, "there are no saved token");
            return "";
        }
        String token = prefs.getString(PREFS_KEY_TOKEN, "");
        return token;
    }

    public LoginManager(Context context){
        this.context = context;
        retrofit = createRetrofitInstance();
    }



    public Observable<Boolean> login(){
        Toast.makeText(context, "oishef", Toast.LENGTH_SHORT).show();
        // create REST API library instance
        LoginApi loginApi = retrofit.create(LoginApi.class);

        Observable<Boolean> loginResult =
        loginApi.login(loginData)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map(r -> {
                            Log.i(LOG_TAG, "Response: " + r);
                            saveToken(LoginManager.this.context, r);
                    return true;
                })
                // we don't expect .onError - return true or false
                .onErrorReturn(throwable -> {
                    throwable.printStackTrace();
                    Log.i(LOG_TAG, "Error: " + throwable.getMessage());
                    return false;
                });
        return Observable.defer(() -> loginResult);
    }

    private String getChatServerURL(){
        String url = context.getString(R.string.base_url_address);
        return url;
    }

    /**
     * create retrofit instance. Token is passed inside request header so we need to create
     * new instance every time. We could move this code into DI stuff instead.
     * @return
     */
    private Retrofit createRetrofitInstance(){
        /** create interceptor to add header */
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .build();
        /** Token is returned as just string, not Json, so use converter in lenient mode */
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getChatServerURL())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public void setLoginData(LoginData loginData) {
        this.loginData = loginData;
    }
}
