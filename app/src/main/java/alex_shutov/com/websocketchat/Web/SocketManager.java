package alex_shutov.com.websocketchat.Web;

import android.content.Context;
import android.util.EventLog;
import android.util.Log;
import android.util.Printer;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

/**
 * Created by Alex on 6/28/2016.
 */
public class SocketManager {
    private static final String LOG_TAG = SocketManager.class.getSimpleName();
    private Context context;
    private String baseUrl;
    Socket socketСlient;
    String token;

    public SocketManager(Context context){
        this.context = context;
        baseUrl = "http://173.233.68.166:3002";
    }

    public void connect(){
        token = LoginManager.getToken(context);

        socketСlient = createSocket(baseUrl, token);

        socketСlient.on(Socket.EVENT_CONNECT, onConnect);
        socketСlient.on(Socket.EVENT_DISCONNECT, onDisconnect);
        socketСlient.on("connection", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i(LOG_TAG, "connected: connection ");
            }
        });
        socketСlient.on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i(LOG_TAG, "connection error: " + args[0].toString());
            }
        });

        socketСlient.on("getMyInfo", onMyInfo);

        socketСlient.on("authenticate", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i(LOG_TAG, "authenticate");
            }
        });

        socketСlient.connect();
    }

    /**
     * append token as additional parameter, force creationi of new socket on connect
     * @return new socket instance
     */
    Socket createSocket(String baseUrl, String token){

        JSONObject params = new JSONObject();
        try {
            params.put("token", token);
        }catch (JSONException e){}

        IO.Options options = new IO.Options();
        options.query = params.toString();
        Socket client = null;
        try {
            client = IO.socket(baseUrl, options);
        } catch (URISyntaxException e){
            throw new RuntimeException(e);
        }
        return client;

    }
    

    private Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            int N = 20;
            Log.i(LOG_TAG, "onConnect ");
            socketСlient.emit("getMyInfo", "EufnYTZAuc");
        }
    };

    private Emitter.Listener onMyInfo = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.i(LOG_TAG, "onMyInfo");
        }
    };


    private Emitter.Listener onDisconnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            Log.i(LOG_TAG, "onDisconnect " + args[0].toString() );
        }
    };

    public void testConnection(){
        String token = LoginManager.getToken(context);
        connect();
    }



}
