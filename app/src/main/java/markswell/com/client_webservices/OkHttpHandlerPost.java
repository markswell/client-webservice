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

public class OkHttpHandlerPost extends AsyncTask<String, Void, String> {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();
    String json;

    public OkHttpHandlerPost(String json) {
        this.json = json;
    }

    @Override
    protected String doInBackground(String... params) {

        RequestBody formBody = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url(params[0]).post(formBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response.toString());
            return response.body().string();

        } catch (Exception e) {
        }

        return null;
    }
}
