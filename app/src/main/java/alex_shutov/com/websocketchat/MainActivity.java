package alex_shutov.com.websocketchat;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import alex_shutov.com.websocketchat.Web.LoginManager;
import alex_shutov.com.websocketchat.Web.SocketManager;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btnTest);
        btn.setOnClickListener(v -> {
                testSocket();


            });
    }

    void testSocket(){
        Log.i(LOG_TAG, "Test buttom pressed");
        ChatApplication app = (ChatApplication) getApplication();
        LoginManager lm = app.getLoginManager();
        //lm.test();

        SocketManager sm = app.getSocketManager();
        sm.testConnection();
    }

}
