package alex_shutov.com.websocketchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import alex_shutov.com.websocketchat.web.api_impl.AllUsersFetcher;
import alex_shutov.com.websocketchat.web.api_impl.LoginManager;
import alex_shutov.com.websocketchat.web.api_impl.SocketManager;
import alex_shutov.com.websocketchat.web.web_model.LoginData;
import alex_shutov.com.websocketchat.web.web_model.all_users.AllUsersResponse;
import alex_shutov.com.websocketchat.web.web_model.all_users.User;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();


    ChatApplication app;

    private void showToast(String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT)
                .show();
    }

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
                    String msg = res ? "Login successful" : "Login failed";
                    showToast(msg);
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


        allUsersFetcher.getAllusers(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(resp -> {
                    List<User> users = null;
                    if (null != resp){
                        users = resp.getUsers();
                        showToast("There are " + users.size() + " known users");
                    }

                }, t -> {
                    t.printStackTrace();
                    Log.i(LOG_TAG, "Error: " + t.getMessage());
                });

    }

}
