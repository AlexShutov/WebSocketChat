package alex_shutov.com.websocketchat;

import android.app.Application;

import alex_shutov.com.websocketchat.Web.LoginManager;
import alex_shutov.com.websocketchat.Web.SocketManager;

/**
 * Created by lodoss on 28/06/16.
 */
public class ChatApplication extends Application {

    private LoginManager loginManager;
    private SocketManager socketManager;

    LoginManager getLoginManager(){ return loginManager;}
    SocketManager getSocketManager(){ return socketManager;}

    @Override
    public void onCreate() {

        loginManager = new LoginManager(this);
        socketManager = new SocketManager(this);
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
