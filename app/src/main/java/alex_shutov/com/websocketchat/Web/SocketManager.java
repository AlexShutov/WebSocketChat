package alex_shutov.com.websocketchat.Web;

import android.content.Context;
import android.util.EventLog;
import android.util.Log;
import android.util.Printer;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIO;
import io.socket.SocketIOException;
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
    String token;

    SocketIO socket;

    public SocketManager(Context context){
        this.context = context;
        baseUrl = "http://173.233.68.166:3002";
    }

    public void connect(){
        try {
            SocketIO.setDefaultSSLSocketFactory(SSLContext.getDefault());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        socket.connect(new IOCallback() {
            @Override
            public void onDisconnect() {
                Log.i(LOG_TAG, "onConnect");
            }

            @Override
            public void onConnect() {
                Log.i(LOG_TAG, "onDisconnect");
                socket.emit("getMyInfo", "123");
            }

            @Override
            public void onMessage(String s, IOAcknowledge ioAcknowledge) {
                Log.i(LOG_TAG, "onMessage: " + s);
            }

            @Override
            public void onMessage(JSONObject jsonObject, IOAcknowledge ioAcknowledge) {
                Log.i(LOG_TAG, "onMessage: " + jsonObject.toString());
            }

            @Override
            public void on(String s, IOAcknowledge ioAcknowledge, Object... objects) {
                Log.i(LOG_TAG, "onMessage: " + s);
            }

            @Override
            public void onError(SocketIOException e) {
                Log.i(LOG_TAG, "onError");
            }

        });
    }

    /**
     * append token as additional parameter, force creationi of new socket on connect
     * @return new socket instance
     */
    SocketIO createSocket(String baseUrl, String token){

        JSONObject params = new JSONObject();
        try {
            params.put("token", token);
        }catch (JSONException e){}

        IO.Options options = new IO.Options();
        options.forceNew = true;
        options.query = params.toString();

        //String cookie = android.webkit.CookieManager.getInstance().getCookie(baseUrl);
        SocketIO socket = null;
        try {
            socket = new SocketIO(baseUrl);
        } catch (MalformedURLException e){
            e.printStackTrace();
            Log.i(LOG_TAG, "error parsing base url");
        }
        if (null == socket) return socket;

        socket.addHeader("token", token);


        return socket;
    }

    public void testConnection(){
        token = LoginManager.getToken(context);
        socket = createSocket(baseUrl, token);
        if (null == socket){
            Log.i(LOG_TAG, "Socket instance is null");
            return;
        }
        connect();
    }



}
