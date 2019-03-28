package com.example.maissaude;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtPeso;
    EditText txtAltura;
    EditText txtCintura;
    EditText txtBusto;
    EditText txtQuadril;
    EditText txtBiceps;
    EditText txtQuadriceps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Variaveis criadado a cima do tipo EditText  igualando a id da tela
        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        txtCintura = findViewById(R.id.txtCintura);
        txtBusto = findViewById(R.id.txtBusto);
        txtQuadril = findViewById(R.id.txtQuadril);
        txtBiceps = findViewById(R.id.txtBiceps);
        txtQuadriceps = findViewById(R.id.txtQuadriceps);

        this.carregar();

    }
        public void onSalvarClick(View Salvar){

            //Criando um arquivo no modo privato que ira salvar os dados
            SharedPreferences preferences = getSharedPreferences("MinhasMedidas",MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();

            //Dentro do arquivo MinhasMedidas terá um campo chamado peso que salvara o dado da variavel txtPeso
            editor.putString("Peso",txtPeso.getText().toString());
            editor.putString("Altura",txtAltura.getText().toString());
            editor.putString("Cintura",txtCintura.getText().toString());
            editor.putString("Busto",txtBusto.getText().toString());
            editor.putString("Quadril",txtQuadril.getText().toString());
            editor.putString("Biceps",txtBiceps.getText().toString());
            editor.putString("Quadriceps",txtQuadriceps.getText().toString());

            editor.apply(); //Salvar
        }

        public void carregar(){

            //ler
            SharedPreferences preferences = getSharedPreferences("MinhasMedidas",MODE_PRIVATE);

            //Agora iremos carregar os dados do campo PEso que foram salvao dentro do arquivo MinhasMedidas na varieavel txtPeso
            String Peso =preferences.getString("Peso","0");
            txtPeso.setText(Peso);

            String Altura = preferences.getString("Altura","0");
            txtAltura.setText(Altura);

            String Cintura = preferences.getString("Cintura","0");
            txtCintura.setText(Cintura);

            String Busto = preferences.getString("Busto","0");
            txtBusto.setText(Busto);

            String Quadril = preferences.getString("Quadril","0");
            txtQuadril.setText(Quadril);

            String Biceps = preferences.getString("Biceps","0");
            txtBiceps.setText(Biceps);

            String Quadriceps = preferences.getString("Quadriceps","0");
            txtQuadriceps.setText(Quadriceps);

    }



}
