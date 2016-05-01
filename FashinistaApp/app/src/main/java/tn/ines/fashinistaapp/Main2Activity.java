package tn.ines.fashinistaapp;

import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    ListView list;

    String[] imagetitles;
    String[] imagedescription;
    int[] images ={R.drawable.image1ete,R.drawable.image4ete,R.drawable.image5ete};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Resources res=getResources();
        imagetitles=res.getStringArray(R.array.titles);
        imagedescription=res.getStringArray(R.array.description);
        list=(ListView) findViewById(R.id.listView);
        projetandroidAdapter adapter=new projetandroidAdapter(this,images,images,images);
        list.setAdapter(adapter);


    }
}


  class projetandroidAdapter extends ArrayAdapter<String> {
    Context context;
    int[] images;
    String[] titlesArray;
    String[] descriptionArray;

    projetandroidAdapter(Context c, int[] m, int[] imgs, int[] n) {
        super(c, R.layout.activity_main2);
        this.context = c;
        this.images = imgs;
       // this.titlesArray = titles;
       // this.descriptionArray = desc;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.activity_main2, parent, false);
        }
        ImageView Myimage = (ImageView) row.findViewById(R.id.imageView);
      //  TextView Mytitle = (TextView) row.findViewById(R.id.textView);
       // TextView Mydescription = (TextView) row.findViewById(R.id.textView2);

        Myimage.setImageResource(images[position]);
       // Mytitle.setText(titlesArray[position]);
     //  Mydescription.setText(descriptionArray[position]);


        return row;
    }





}