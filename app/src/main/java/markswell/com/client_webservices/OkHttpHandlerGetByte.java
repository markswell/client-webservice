package markswell.com.client_webservices;


import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 *Classe de manipulacao asincrona nescessaria para as operacoes de requisicao http
 * Created by markswell on 07/12/16.
 */

public class OkHttpHandlerGetByte extends AsyncTask<String, Void, byte[]> {

    OkHttpClient client = new OkHttpClient();

    @Override
    protected byte[] doInBackground(String... params) {

        Request.Builder builder = new Request.Builder();
        builder.url(params[0]);

        Request request = builder.build();

        try {

            Response response = client.newCall(request).execute();
            return response.body().bytes();

        } catch (Exception e) {
        }

        return null;
    }
}
