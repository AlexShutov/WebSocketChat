package alex_shutov.com.websocketchat;

import android.app.Application;

import alex_shutov.com.websocketchat.Web.LoginManager;

/**
 * Created by lodoss on 28/06/16.
 */
public class ChatApplication extends Application {

    private LoginManager socketManager;

    LoginManager getSocketManager(){ return socketManager;}

    @Override
    public void onCreate() {

        socketManager = new LoginManager(this);
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
