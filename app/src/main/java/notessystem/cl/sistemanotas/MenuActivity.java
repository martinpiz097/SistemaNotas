package notessystem.cl.sistemanotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;

import notessystem.cl.sistemanotas.base.Data;
import notessystem.cl.sistemanotas.base.Score;

public class MenuActivity extends AppCompatActivity {

    private ArrayAdapter<Score> listAdapter;
    private EditText txtScore;
    private EditText txtPond;
    private ListView lvScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        listAdapter = new ArrayAdapter<Score>(
                this,
                android.R.layout.simple_list_item_1,
                Data.getInstance().getScores()
        );
        txtScore = findViewById(R.id.txtScore);
        txtPond = findViewById(R.id.txtPond);
        lvScores = findViewById(R.id.lvScores);
        lvScores.setAdapter(listAdapter);
    }

    public void btnAddScoreOnClick(View v) {
        String strScore = txtScore.getText().toString();
        String strPond = txtPond.getText().toString();

        if (strScore.length() == 0 || strPond.length() == 0) {
            MainActivity.showToastMsg(this, "Al menos " +
                    "uno de los campos está vacío");
            txtScore.selectAll();
            txtScore.requestFocus();
        }
        else {
            try {
                double score = Double.parseDouble(strScore);
                byte pond = Byte.parseByte(strPond);

                boolean added =
                        Data.getInstance().addScore(score, pond);

                if (added) {
                    lvScores.setAdapter(new ArrayAdapter<Score>(
                            this, android.R.layout.simple_list_item_1,
                            Data.getInstance().getScores()
                    ));
                    txtScore.setText(null);
                    txtPond.setText(null);
                    txtScore.requestFocus();
                }
                else
                    MainActivity.showToastMsg(this, "No puede pasarse del límite " +
                            "(100%) de ponderación");
            }catch (NumberFormatException ex) {
                MainActivity.showToastMsg(this, "Formato incorrecto");
                txtScore.selectAll();
                txtScore.requestFocus();
            }
        }
    }


}
