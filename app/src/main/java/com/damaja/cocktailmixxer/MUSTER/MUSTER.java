package com.damaja.cocktailmixxer.MUSTER;

/**
 * Created by Matze on 03.04.2015.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.damaja.cocktailmixxer.R;


public class MUSTER extends Fragment {


    private static String TAG = "MUSTER";
    View rootView;

    public static String getTAG() {
        return TAG;
    }
    public static MUSTER newInstance() {
        MUSTER fragment = new MUSTER();

        return fragment;
    }

    public MUSTER() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.panel_content, container, false);
        return rootView;
    }



}
