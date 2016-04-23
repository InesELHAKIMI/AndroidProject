package tn.ines.fashinistaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Inscrire extends AppCompatActivity {


    EditText ET_nom,Et_motpasse;
    Button bt;
    String nom,motpasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscrire);

        ET_nom=(EditText)findViewById(R.id.edit1);
        Et_motpasse=(EditText)findViewById(R.id.edit2);
    }


    public void userReg(View view){
        nom=ET_nom.getText().toString();
        motpasse=Et_motpasse.getText().toString();

        String methode="register";
        BackgroundTask backgroundTask =new BackgroundTask(this);
        backgroundTask.execute(methode, nom,motpasse);
        finish();

    }


}
