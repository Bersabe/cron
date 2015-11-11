package com.example.omnisport.cronometro;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Chronometer cronometro;
    Button iniciar,pausa,reiniciar;
    TextView Funciones;
    long elapsedtime=0;
    String currentTime="";
    Boolean activity =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cronometro = (Chronometer)findViewById(R.id.chronometer);
        iniciar = (Button)findViewById(R.id.button_Iniciar);
        pausa = (Button)findViewById(R.id.button_pausa);
        reiniciar = (Button)findViewById(R.id.button_Reiniciar);
        Funciones = (TextView)findViewById(R.id.textView_Funcion);


        iniciar.setEnabled(true);
        pausa.setEnabled(false);
        reiniciar.setEnabled(false);

        iniciar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                iniciar.setEnabled(false);
                pausa.setEnabled(true);
                reiniciar.setEnabled(true);
                Funciones.setText(">");

                if (!activity) {
                    cronometro.setBase(SystemClock.elapsedRealtime());
                    cronometro.start();
                }
            }
        } );
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
}
