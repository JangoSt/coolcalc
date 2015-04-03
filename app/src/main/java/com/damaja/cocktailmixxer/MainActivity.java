package com.damaja.cocktailmixxer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.damaja.cocktailmixxer.MainContent.PanelContent;
import com.damaja.cocktailmixxer.MainContent.PanelSlideUp;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content_main, PanelContent.newInstance(), PanelContent.getTAG()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content_slideup, PanelSlideUp.newInstance(), PanelSlideUp.getTAG()).commit();
    }


}
