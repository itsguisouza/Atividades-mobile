package com.example.cadastroloja;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextNome, editTextIdade, editTextUF, editTextCidade, editTextTelefone, editTextEmail;
    RadioGroup radioGroupTamanho;
    CheckBox checkAzul, checkPreto, checkBranco, checkVerde;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. Ligar as variáveis com os componentes do XML
        editTextNome = findViewById(R.id.editTextNome);
        editTextIdade = findViewById(R.id.editTextIdade);
        editTextUF = findViewById(R.id.editTextUF);
        editTextCidade = findViewById(R.id.editTextCidade);
        editTextTelefone = findViewById(R.id.editTextTelefone);
        editTextEmail = findViewById(R.id.editTextEmail);
        radioGroupTamanho = findViewById(R.id.radioGroupTamanho);
        checkAzul = findViewById(R.id.checkAzul);
        checkPreto = findViewById(R.id.checkPreto);
        checkBranco = findViewById(R.id.checkBranco);
        checkVerde = findViewById(R.id.checkVerde);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        // 3. Configurar o clique do botão
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarCadastro();
            }
        });
    }

    private void realizarCadastro() {
        // --- VALIDAÇÃO DOS CAMPOS ---
        if (editTextNome.getText().toString().trim().isEmpty() ||
                editTextIdade.getText().toString().trim().isEmpty() ||
                editTextUF.getText().toString().trim().isEmpty() ||
                editTextCidade.getText().toString().trim().isEmpty() ||
                editTextTelefone.getText().toString().trim().isEmpty() ||
                editTextEmail.getText().toString().trim().isEmpty()) {

            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        // --- COLETA DOS DADOS ---

        String nome = editTextNome.getText().toString().trim();
        String idade = editTextIdade.getText().toString().trim();
        String uf = editTextUF.getText().toString().trim();
        String cidade = editTextCidade.getText().toString().trim();
        String telefone = editTextTelefone.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        int idRadioSelecionado = radioGroupTamanho.getCheckedRadioButtonId();
        if (idRadioSelecionado == -1) {
            Toast.makeText(this, "Por favor, selecione um tamanho.", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton radioSelecionado = findViewById(idRadioSelecionado);
        String tamanho = radioSelecionado.getText().toString();

        ArrayList<String> cores = new ArrayList<>();
        if (checkAzul.isChecked()) cores.add("Azul");
        if (checkPreto.isChecked()) cores.add("Preto");
        if (checkBranco.isChecked()) cores.add("Branco");
        if (checkVerde.isChecked()) cores.add("Verde");

        if (cores.isEmpty()) {
            Toast.makeText(this, "Por favor, selecione ao menos uma cor.", Toast.LENGTH_SHORT).show();
            return;
        }

        // --- EXIBIÇÃO DO RESULTADO COM TOAST ---

        // Montando a string de resumo
        StringBuilder resumo = new StringBuilder();
        resumo.append("Cadastro de ").append(nome).append(" realizado!\n");
        resumo.append("Tamanho: ").append(tamanho).append("\n");
        resumo.append("Cores: ").append(String.join(", ", cores));

        // Exibindo o resumo em um Toast de longa duração
        Toast.makeText(this, resumo.toString(), Toast.LENGTH_LONG).show();
    }
}

