package tn.ines.fashinistaapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by micro on 30/04/2016.
 */
public class FirstFragment extends Fragment {

    View myview;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview=inflater.inflate(R.layout.activity_main2,container,false);

        return myview;
    }











}
