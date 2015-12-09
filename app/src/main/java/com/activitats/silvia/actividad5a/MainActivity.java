package com.activitats.silvia.actividad5a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private MyDBAdapter dbAdapter;
    private Button prof, est, elimDB, elimP, elimE;
    private TextView text;
    private EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        est = (Button) findViewById(R.id.bEst);
        prof = (Button) findViewById(R.id.bProf);
        elimDB = (Button) findViewById(R.id.bElimBD);
        elimE= (Button) findViewById(R.id.bElimEst);
        elimP= (Button) findViewById(R.id.bElimPro);

        est.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Estudiante.class);
                startActivity(i);
            }
        });
        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Profesor.class);
                startActivity(i);
            }
        });
        elimE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EliminarUsuario.class);
                Bundle b = new Bundle();
                b.putString("usu", "estudiante");
                i.putExtras(b);
                startActivity(i);

            }
        });
        elimP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EliminarUsuario.class);
                Bundle b = new Bundle();
                b.putString("usu", "profesor");
                i.putExtras(b);
                startActivity(i);
            }
        });
        elimDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            dbAdapter.eliminarBD();
            }
        });

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
