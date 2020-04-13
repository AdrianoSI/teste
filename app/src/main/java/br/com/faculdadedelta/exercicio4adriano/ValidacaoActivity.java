package br.com.faculdadedelta.exercicio4adriano;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ValidacaoActivity extends AppCompatActivity {
    public static final int RESULT_CODE_SUCCESS = 1;
    public static final int RESULT_CODE_ERROR = 0;
    private double valor;
    private String produto;
    private String fornecedor;
    private  int quantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validacao);

        Intent intent = getIntent();
        if (intent != null) {
            String produtoParam = intent.getStringExtra("produtoParam");
            String valorParam = intent.getStringExtra("valorParam");
            String fornecedorParam = intent.getStringExtra("fornecedorParam");
            String quantParam = intent.getStringExtra("quantParam");


            TextView tvProduto = findViewById(R.id.tvProduto);
            tvProduto.setText("Produto: " + produtoParam);

            TextView tvValor = findViewById(R.id.tvValor);
            tvValor.setText("Valor do produto: " + valorParam);

            TextView tvFornecedor = findViewById(R.id.tvFornecedor);
            tvFornecedor.setText("Fornecedor: " + fornecedorParam);

            TextView tvQuant = findViewById(R.id.tvQuant);
            tvQuant.setText("Quantidade: " + quantParam);

            valor = Double.parseDouble(valorParam);
            produto = produtoParam;
            fornecedor = fornecedorParam;
            quantidade = Integer.parseInt(quantParam);



        }
    }

    public void validar (View view){
        String resposta = " ";

        if (produto.length() < 15) {
            Toast.makeText(getBaseContext(),
                    "O campo produto nao deve ter menos de 15 caracteres !",
                    Toast.LENGTH_LONG).show();
        } else if (valor < 500) {

            Toast.makeText(getBaseContext(),
                    "O campo valor nao pode ser menor que 500 !",
                    Toast.LENGTH_LONG).show();
        } else if (fornecedor.length() < 11) {

            Toast.makeText(getBaseContext(),
                    "Valor não deve ser inferior a 11 caracteres !",
                    Toast.LENGTH_LONG).show();
        } else if(quantidade <= 0) {
            Toast.makeText(getBaseContext(),
                    "O campo quantidade nao pode ser 0 !",
                    Toast.LENGTH_LONG).show();

        }else{
            resposta = ("Dados validados com sucesso !");
        }


        Intent data = new Intent();
        data.putExtra("resposta", resposta);

        setResult(RESULT_CODE_SUCCESS, data);

        finish();

    }

}
