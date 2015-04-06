package com.damaja.cocktailmixxer.AddCocktail;

/**
 * Created by Matze on 03.04.2015.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.damaja.cocktailmixxer.R;


public class AddCocktail extends Fragment {


    private static String TAG = "AddCocktail";
    View rootView;

    public static String getTAG() {
        return TAG;
    }
    public static AddCocktail newInstance() {
        AddCocktail fragment = new AddCocktail();

        return fragment;
    }

    public AddCocktail() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.addcocktail_main, container, false);
        return rootView;
    }



}
