package alex_shutov.com.websocketchat.web.api_impl;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lodoss on 28/06/16.
 */
public class HeaderInterceptor implements Interceptor {
    private static final String LOG_TAG = HeaderInterceptor.class.getSimpleName();
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        request = request.newBuilder()
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = chain.proceed(request);
        Log.w(LOG_TAG, response.body().string());
        return response;
    }
}
