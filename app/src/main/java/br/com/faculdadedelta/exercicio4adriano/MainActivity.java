package br.com.faculdadedelta.exercicio4adriano;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int CODIGO_RETORNO = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar(View view) {

        EditText etProduto = findViewById(R.id.etProduto);
        EditText etValor = findViewById(R.id.etValor);
        EditText etFornecedor = findViewById(R.id.etFornecedor);
        EditText etQuant = findViewById(R.id.etQuant);

        Intent intent = new Intent(getBaseContext(), ValidacaoActivity.class);

        String produtoParam = etProduto.getText().toString();
        String valorParam = etValor.getText().toString();
        String fornecedorParam = etFornecedor.getText().toString();
        String quantParam = etQuant.getText().toString();

        if (produtoParam.isEmpty()) {
            Toast.makeText(getBaseContext(),
                    "O campo produto é obrigatório!",
                    Toast.LENGTH_LONG).show();
        } else if (valorParam.isEmpty()) {
            Toast.makeText(getBaseContext(),
                    "O campo valor  é obrigatório!",
                    Toast.LENGTH_LONG).show();
        } else if (fornecedorParam.isEmpty()) {
            Toast.makeText(getBaseContext(),
                    "O campo fornecedor é obrigatorio!",
                    Toast.LENGTH_LONG).show();
        } else if (quantParam.isEmpty()) {
            Toast.makeText(getBaseContext(),
                    "O campo quantidade é obrigatorio!",
                    Toast.LENGTH_LONG).show();
        } else {


            intent.putExtra("produtoParam", produtoParam);
            intent.putExtra("valorParam", valorParam);
            intent.putExtra("fornecedorParam", fornecedorParam);
            intent.putExtra("quantParam", quantParam);

            startActivityForResult(intent, CODIGO_RETORNO);


        }


    }

    public void limpar(View view) {
        EditText etProduto = findViewById(R.id.etProduto);
        EditText etValor = findViewById(R.id.etValor);
        EditText etFornecedor = findViewById(R.id.etFornecedor);
        EditText etQuant = findViewById(R.id.etQuant);
        etProduto.setText("");
        etValor.setText("");
        etFornecedor.setText("");
        etQuant.setText("");

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODIGO_RETORNO) {
            if (resultCode == ValidacaoActivity.RESULT_CODE_SUCCESS) {
                String resposta = data.getStringExtra("resposta");
                Toast.makeText(getBaseContext(), resposta, Toast.LENGTH_LONG).show();

            }
        }

    }
}
