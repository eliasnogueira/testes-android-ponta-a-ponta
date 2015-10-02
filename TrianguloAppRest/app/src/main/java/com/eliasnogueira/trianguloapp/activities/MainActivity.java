package com.eliasnogueira.trianguloapp.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.eliasnogueira.trianguloapp.R;
import com.eliasnogueira.trianguloapp.api.TrianguloApi;
import com.eliasnogueira.trianguloapp.models.CalculaTriangulo;
import com.eliasnogueira.trianguloapp.models.TrianguloResponse;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    EditText lado1e, lado2e, lado3e;
    String lado1, lado2, lado3;
    TextView txtResultado;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void calcular(View v) {
        progressBar.setVisibility(View.VISIBLE);
        final String BASE_URL = "http://eliasnogueira.com/apis/";

        RestAdapter builder =  new RestAdapter.Builder().setEndpoint(BASE_URL).setLogLevel(RestAdapter.LogLevel.FULL).build();
        TrianguloApi api = builder.create(TrianguloApi.class);

        obterDadosActivity();
        api.calculaTriangulo(lado1, lado2, lado3, new Callback<TrianguloResponse>() {
            @Override
            public void success(TrianguloResponse trianguloResponse, Response response) {
                Log.w("TRIANGULOAPPREST", trianguloResponse.getResultado());

                txtResultado = (TextView) findViewById(R.id.txtResultado);
                txtResultado.setText(trianguloResponse.getResultado().toString());
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void failure(RetrofitError error) {
                progressBar.setVisibility(View.INVISIBLE);
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setMessage("Ocorreu um erro!")
                        .setTitle("ERRO")
                        .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    public void calcularLocal(View v) {
        obterDadosActivity();

        txtResultado = (TextView) findViewById(R.id.txtResultado);
        txtResultado.setText(CalculaTriangulo.calculaTipoTriangulo(lado1, lado2, lado3));
    }

    private void obterDadosActivity() {
        lado1e = (EditText) findViewById(R.id.txtLado1);
        lado2e = (EditText) findViewById(R.id.txtLado2);
        lado3e = (EditText) findViewById(R.id.txtLado3);

        lado1 = lado1e.getText().toString();
        lado2 = lado2e.getText().toString();
        lado3 = lado3e.getText().toString();
    }
}
