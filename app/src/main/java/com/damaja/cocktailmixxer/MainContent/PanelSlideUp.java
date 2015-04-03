package com.damaja.cocktailmixxer.MainContent;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.damaja.cocktailmixxer.R;



public class PanelSlideUp extends Fragment {

    public static String getTAG() {
        return TAG;
    }

    private static String TAG = "PanelSlideUp";

    public static PanelSlideUp newInstance() {
        PanelSlideUp fragment = new PanelSlideUp();
        return fragment;
    }

    public PanelSlideUp() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.panel_slideup, container, false);
    }


}
