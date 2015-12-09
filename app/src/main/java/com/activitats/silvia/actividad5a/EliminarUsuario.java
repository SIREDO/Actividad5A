package com.activitats.silvia.actividad5a;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EliminarUsuario extends Activity {
    private MyDBAdapter dbAdapter;
    private TextView intro;
    private EditText id;
    private Button elim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_usuario);
        intro = (TextView) findViewById(R.id.tvId);
        id =(EditText) findViewById(R.id.editText);
        elim = (Button) findViewById(R.id.bE);

        elim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getIntent().getExtras().getString("usu")=="estudiante"){
                    dbAdapter.eliminarEstudiante(Integer.valueOf(id.getText().toString()));
                } else if (getIntent().getExtras().getString("usu")=="profesor"){
                    dbAdapter.eliminarProfesor(Integer.valueOf(id.getText().toString()));
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eliminar_usuario, menu);
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
