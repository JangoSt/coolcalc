package com.damaja.cocktailmixxer.CocktailList;

/**
 * Created by Matze on 03.04.2015.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.damaja.cocktailmixxer.R;


public class CocktailList extends Fragment {


    private static String TAG = "CocktailList";
    View rootView;

    public static String getTAG() {
        return TAG;
    }
    public static CocktailList newInstance() {
        CocktailList fragment = new CocktailList();

        return fragment;
    }

    public CocktailList() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_cocktail_list, container, false);
        return rootView;
    }



}
