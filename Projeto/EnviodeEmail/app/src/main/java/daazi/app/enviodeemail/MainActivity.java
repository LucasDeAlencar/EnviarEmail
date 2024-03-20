package daazi.app.enviodeemail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editEmail,editAssunto,editMensagem;
    Button btnEnviar;
    String emailDestinatario, assunto, mensagem;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        Inicializar();
        
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(AppUtil.getVazioEdit(editEmail,editAssunto,editMensagem)){

                    processarFormulario();

                    /*Intent*/
                    intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailDestinatario});/*Email da pessoa*/
                    intent.putExtra(Intent.EXTRA_SUBJECT, assunto);/*assunto*/
                    intent.putExtra(Intent.EXTRA_TEXT, mensagem);/*A Mensagem*/

                    intent.setType("message/rfc822");

                    startActivity(Intent.createChooser(intent,"Selecione um aplicativo"));

                }else {
                    AppUtil.voErroEdit("* Campo NULO",editEmail,editAssunto,editMensagem);
                }

            }
        });

    }

    private void Inicializar() {

        editEmail = findViewById(R.id.editEmail);
        editAssunto = findViewById(R.id.editAssunto);
        editMensagem = findViewById(R.id.editMensagem);
        btnEnviar = findViewById(R.id.btnEnviar);


    }

    public void processarFormulario(){
        emailDestinatario = editEmail.getText().toString();
        assunto = editAssunto.getText().toString();
        mensagem = editMensagem.getText().toString();
    }



}