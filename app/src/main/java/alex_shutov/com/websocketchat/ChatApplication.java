package alex_shutov.com.websocketchat;

import android.app.Application;

import alex_shutov.com.websocketchat.web.api_impl.AllUsersFetcher;
import alex_shutov.com.websocketchat.web.api_impl.LoginManager;
import alex_shutov.com.websocketchat.web.api_impl.SocketManager;

/**
 * Created by lodoss on 28/06/16.
 */
public class ChatApplication extends Application {

    private LoginManager loginManager;
    private SocketManager socketManager;

    private AllUsersFetcher allUsersFetcher;

    LoginManager getLoginManager(){ return loginManager;}
    SocketManager getSocketManager(){ return socketManager;}
    public AllUsersFetcher getAllUsersFetcher() { return allUsersFetcher; }

    @Override
    public void onCreate() {

        loginManager = new LoginManager(this);
        socketManager = new SocketManager(this);
        allUsersFetcher = new AllUsersFetcher(this);
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
