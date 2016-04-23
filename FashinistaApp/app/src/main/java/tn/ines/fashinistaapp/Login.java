package tn.ines.fashinistaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    EditText ET_nom,Et_motpasse;
    String nom,motpasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ET_nom=(EditText)findViewById(R.id.edit1);
        Et_motpasse=(EditText)findViewById(R.id.edit2);
    }


    public  void Register(View view)
    {
        startActivity(new Intent(this,Inscrire.class));
    }


    public  void userlogin(View view)
    {
        nom=ET_nom.getText().toString();
        motpasse=Et_motpasse.getText().toString();

        String methode="Login";
        BackgroundTask backgroundTask =new BackgroundTask(this);
        backgroundTask.execute(methode, nom, motpasse);
        finish();

            startActivity(new Intent(this,Acceuil.class));

    }



}
