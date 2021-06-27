package br.ufjf.dcc196.thomassantos.atividade3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private EditText editTextNumero1;
    private EditText editTextNumero2;
    private RadioGroup radioGroupOperacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
        editTextNumero1 = findViewById(R.id.editTextNumero1);
        editTextNumero2 = findViewById(R.id.editTextNumero2);
        radioGroupOperacao = findViewById(R.id.radioGroupOperacao);

        radioGroupOperacao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                calcular(group);
            }
        });
    }

    public void calcular(View view){
        Double resultado = 0.0;
        Double numero1 = Double.parseDouble(editTextNumero1.getText().toString());
        Double numero2 = Double.parseDouble(editTextNumero2.getText().toString());

        switch(radioGroupOperacao.getCheckedRadioButtonId()){
            case R.id.radioButtonSoma:
                resultado = numero1 + numero2;
                break;
            case R.id.radioButtonSub:
                resultado = numero1 - numero2;
                break;
            case R.id.radioButtonMult:
                resultado = numero1 * numero2;
                break;
            default:
                resultado = numero1 / numero2;
        }

        textViewResult.setText(resultado.toString());
    }

    public void limpar(View view){
        editTextNumero1.setText("");
        editTextNumero2.setText("");
        textViewResult.setText("");
    }
}