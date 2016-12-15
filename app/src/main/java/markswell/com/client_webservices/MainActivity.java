package markswell.com.client_webservices;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText endereco;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.endereco = (EditText) findViewById(R.id.endereco);
        this.texto = (TextView) findViewById(R.id.texto);

    }

    public void acessarUrl(View view){
        String url = "http://"+ endereco.getText().toString()+ ":8080/webservices/teste";
        OkHttpHandlerPost handler = new OkHttpHandlerPost("{nome:lucaS,idade:12,peso:50,altura:1.60}");
        //OkHttpHandlerGet handler = new OkHttpHandlerGet();
        String result = null;

        try{
            result = handler.execute(url).get();
        }catch (Exception e){
            result = "não deu: " + e.getMessage();
        }
        texto.setText(result);
    }


}
