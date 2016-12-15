package markswell.com.client_webservices;

import android.os.AsyncTask;
import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Classe de manipulacao asincrona nescessaria para as operacoes de requisicao http
 * Created by markswell on 07/12/16.
 */

public class OkHttpHandlerGet extends AsyncTask<String, Void, String> {

    OkHttpClient client = new OkHttpClient();

    @Override
    protected String doInBackground(String... params) {

        Request.Builder builder = new Request.Builder();
        builder.url(params[0]);

        Request request = builder.build();

        try {

            Response response = client.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("motivo", e.getMessage());
        }

        return null;
    }

}
