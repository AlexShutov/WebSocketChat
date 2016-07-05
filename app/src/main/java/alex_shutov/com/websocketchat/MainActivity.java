package alex_shutov.com.websocketchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import alex_shutov.com.websocketchat.web.api_impl.AllUsersFetcher;
import alex_shutov.com.websocketchat.web.api_impl.LoginManager;
import alex_shutov.com.websocketchat.web.api_impl.SocketManager;
import alex_shutov.com.websocketchat.web.web_model.LoginData;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();


    ChatApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        app = (ChatApplication) getApplication();

        Button btn = (Button) findViewById(R.id.btnTestLogin);
        btn.setOnClickListener(v -> {
                testLogin();
            });
        btn = (Button) findViewById(R.id.btnTestConnect);
        btn.setOnClickListener(v -> {
            //testConect();
            testAllUsers();
        });
    }

    void testLogin(){
        Log.i(LOG_TAG, "Test buttom pressed");
        ChatApplication app = (ChatApplication) getApplication();
        LoginManager lm = app.getLoginManager();
        // login using a fake credentials
        LoginData ld = new LoginData();
        ld.setVendor("Local");
        ld.setUsername("testuser");
        ld.setPassword("400000");
        lm.setLoginData(ld);
        lm.login()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(res -> {
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT)
                            .show();
                });
    }

    void testConect(){
        ChatApplication app = (ChatApplication) getApplication();
        SocketManager sm = app.getSocketManager();
        sm.testConnection();
    }

    void testAllUsers(){
        AllUsersFetcher allUsersFetcher = app.getAllUsersFetcher();
        String token = LoginManager.getToken(this);
        allUsersFetcher.setToken(token);

        /**
        allUsersFetcher.getAllusers(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    if (null != users && !users.isEmpty()){
                        Log.i(LOG_TAG, "Users: " + users.size());
                    }
                }, t -> {
                    t.printStackTrace();
                    Log.i(LOG_TAG, "Error: " + t.getMessage());
                });
         */

        allUsersFetcher.getAllusersNotParsed(null)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(r -> {
                    Log.i(LOG_TAG, "Response: " + r);
                });

    }

}
