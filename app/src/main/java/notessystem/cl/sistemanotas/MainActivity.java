  package notessystem.cl.sistemanotas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import notessystem.cl.sistemanotas.base.Data;

  public class MainActivity extends AppCompatActivity {

    private Data data;
    private EditText txtPassw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPassw = findViewById(R.id.txtPassw);
        data = Data.getInstance();
    }

    public static void showToastMsg(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public void btnStartOnClick(View v) {
        final String passw = txtPassw.getText().toString();
        if (passw.length() > 0) {
            if (passw.equals(data.getPassw())) {
                showToastMsg(this, "¡Bienvenido!");
                Intent i = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(i);
            }
            else {
                showToastMsg(this, "Contraseña incorrecta");
                txtPassw.selectAll();
                txtPassw.requestFocus();
            }
        }

    }

}
