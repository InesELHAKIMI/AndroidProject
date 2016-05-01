package tn.ines.fashinistaapp;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // array.titles

        populateEventList();
        registerCallBack();

    }


    private void populateEventList() {
        String[] myItems={"Marriage","Soutenance","Fiançaille","Picnic"};

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.listitem,R.id.textview, myItems);

        ListView list =(ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
    }

    private void registerCallBack() {
        ListView list =(ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textview = (TextView) view;
                String message = "Vous avez choisi " + textview.getText().toString();
                Toast.makeText(Main2Activity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}