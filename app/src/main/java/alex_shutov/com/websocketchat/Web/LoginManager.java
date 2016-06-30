package alex_shutov.com.websocketchat.Web;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import alex_shutov.com.websocketchat.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by lodoss on 28/06/16.
 */
public class LoginManager {
    public static final String LOG_TAG = LoginManager.class.getSimpleName();
    public static final String CHAT_SERVER_URL = "http://173.233.68.166:3002/";
    private static final String PREFS_KEY_TOKEN = "PREFS_KEY_TOKEN";

    private Context context;

    Retrofit retrofit;

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


    public void test(){
        Toast.makeText(context, "oishef", Toast.LENGTH_SHORT).show();

        LoginApi loginApi = retrofit.create(LoginApi.class);

        String contentType = "application/json";
        LoginData ld = new LoginData();
        ld.setVendor("Local");
        ld.setUsername("testuser");
        ld.setPassword("300000");

        loginApi.login(ld)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(r -> {
                    Log.i(LOG_TAG, "Response: " + r);
                    saveToken(LoginManager.this.context, r);
                    },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                throwable.printStackTrace();
                                Log.i(LOG_TAG, "Error: " + throwable.getMessage());
                            }
                        });
    }

    Retrofit createRetrofitInstance(){
        /** create interceptor to add header */
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())
                .build();
        /** Token is returned as just string, not Json, so use converter in lenient mode */
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CHAT_SERVER_URL)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

}
