package com.activitats.silvia.actividad5a;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Profesor extends Activity {
    private MyDBAdapter dbAdapter;
    private EditText nom, edad, ciclo, curso, desp;
    private Button insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);
        nom= (EditText)findViewById(R.id.etNomP);
        edad= (EditText)findViewById(R.id.etEdadP);
        ciclo = (EditText)findViewById(R.id.etCicloP);
        curso = (EditText)findViewById(R.id.etCursoTut);
        desp= (EditText)findViewById(R.id.etDespacho);
        insert= (Button) findViewById(R.id.bRegProf);
        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbAdapter.insertarProfesor(nom.getText().toString(), Integer.valueOf(edad.getText().toString()), ciclo.getText().toString(), curso.getText().toString(), Integer.valueOf(desp.getText().toString()));
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profesor, menu);
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
