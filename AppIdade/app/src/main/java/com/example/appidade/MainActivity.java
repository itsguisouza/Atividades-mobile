package com.example.appidade;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextIdade;
    Button btnVerificar;
    TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editTextNome = findViewById(R.id.editTextNome);
        editTextIdade = findViewById(R.id.editTextIdade);
        btnVerificar = findViewById(R.id.btnVerificar);
        textViewResultado = findViewById(R.id.textViewResultado);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarMaioridade();
            }
        });
    }

    private void verificarMaioridade() {
        // Pega o texto dos campos
        String nome = editTextNome.getText().toString();
        String idadeStr = editTextIdade.getText().toString();

        // Verifica se os campos não estão vazios antes de continuar
        if (nome.isEmpty() || idadeStr.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Converte a idade de String para int
        int idade = Integer.parseInt(idadeStr);

        // Variável para guardar a mensagem final
        String mensagemResultado;

        // 5. A Lógica Condicional (IF/ELSE)
        if (idade >= 18) {
            // Se a idade for 18 ou mais
            mensagemResultado = "Olá, " + nome + "! Você é MAIOR de idade.";
        } else {
            // Se a idade for menor que 18
            mensagemResultado = "Olá, " + nome + "! Você é MENOR de idade.";
        }

        // 6. Exibe o resultado final no TextView
        textViewResultado.setText(mensagemResultado);
    }
}