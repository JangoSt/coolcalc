package com.damaja.cocktailmixxer.CocktailList;

/**
 * Created by Matze on 03.04.2015.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.damaja.cocktailmixxer.Components.Cocktail;
import com.damaja.cocktailmixxer.Components.DataBus;
import com.damaja.cocktailmixxer.Components.RowItem;
import com.damaja.cocktailmixxer.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CocktailList extends Fragment {


    private static String TAG = "CocktailList";
    View rootView;
    DataBus db;
    ListView cocktailList;
    CocktailsArrayAdapter cocktailsArrayAdapter;
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
        db = (DataBus) getActivity().getApplicationContext();
        rootView = inflater.inflate(R.layout.fragment_cocktail_list, container, false);
        cocktailList = (ListView) rootView.findViewById(R.id.cocktaillist_cocktaillist);
        cocktailsArrayAdapter = new CocktailsArrayAdapter(getActivity().getApplicationContext(), db.get_CocktailList());
        cocktailList.setAdapter(cocktailsArrayAdapter);
        return rootView;
    }


    private class CocktailsArrayAdapter extends ArrayAdapter<RowItem> {
        List <RowItem> rowItem;
        Context context;
        public CocktailsArrayAdapter(Context context,
                                  List<RowItem> rowItem) {
            super(context, R.layout.rowlayout, rowItem);
            this.context = context;
            this.rowItem = rowItem;
        }



        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
            TextView desc = (TextView) rowView.findViewById(R.id.rowitem_dec);
            TextView header = (TextView) rowView.findViewById(R.id.rowitem_header);
            ImageView img = (ImageView) rowView.findViewById(R.id.rowitem_picture);

                header.setText(rowItem.get(position).getTitle());
                desc.setText(rowItem.get(position).getDesc());
                img.setImageDrawable(getResources().getDrawable(rowItem.get(position).getImageId()));

            return rowView;
        }

    }

}



