package tn.ines.fashinistaapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Acceuil extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    View myview;
    ListView list;

    String[] imagetitles;
    String[] imagedescription;
    int[] images ={R.drawable.image1ete,R.drawable.image4ete,R.drawable.image5ete};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Resources res=getResources();
        imagetitles=res.getStringArray(R.array.titles);
        imagedescription=res.getStringArray(R.array.description);
        list=(ListView) findViewById(R.id.listView);
        projetandroidAdapter adapter=new projetandroidAdapter(this,imagetitles,images,imagedescription);
        list.setAdapter(adapter);


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
                Toast.makeText(Acceuil.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.acceuil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if(id==R.id.nav_tend){

            fragmentManager.beginTransaction().replace(R.id.content_frame,new SecondFragment()).commit();

        }else if(id==R.id.nav_chercher)
        {
            fragmentManager.beginTransaction().replace(R.id.content_frame,new FirstFragment()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class projetandroidAdapter extends ArrayAdapter<String>
    {
        Context context;
        int[] images;
        String[] titlesArray;
        String[] descriptionArray;

        projetandroidAdapter(Context c, String[] titles,int[] imgs,String[] desc)
        {
            super(c,R.layout.single_row,R.id.textView,titles);
            this.context=c;
            this.images=imgs;
            this.titlesArray=titles;
            this.descriptionArray=desc;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row=convertView;
            if(row==null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.single_row, parent, false);
            }
            ImageView Myimage= (ImageView) row.findViewById(R.id.imageView);
            TextView Mytitle= (TextView) row.findViewById(R.id.textView);
            TextView Mydescription= (TextView) row.findViewById(R.id.textView2);

            Myimage.setImageResource(images [position]);
            Mytitle.setText(titlesArray[position]);
            Mydescription.setText(descriptionArray[position]);



            return row;
        }
    }


}
