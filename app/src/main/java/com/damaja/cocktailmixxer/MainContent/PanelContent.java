package com.damaja.cocktailmixxer.MainContent;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.damaja.cocktailmixxer.CocktailList.CocktailList;
import com.damaja.cocktailmixxer.R;
import com.viewpagerindicator.LinePageIndicator;
import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.TitlePageIndicator;


public class PanelContent extends Fragment {

    private static String[] titles = {"CocktailListe", "Neuer Cocktail", "Verbinden", "Benutzer"};
    private static String TAG = "PanelContent";
    View rootView;
    PagerAdapter mPagerAdapter;

    public static String getTAG() {
        return TAG;
    }
    public static PanelContent newInstance() {
        PanelContent fragment = new PanelContent();

        return fragment;
    }

    public PanelContent() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.panel_content, container, false);
        initView();
        return rootView;
    }
    public void initView(){
        ViewPager mViewPager = (ViewPager) rootView.findViewById(R.id.contentviewpager);
        TitlePageIndicator indicator = (TitlePageIndicator)rootView.findViewById(R.id.contentindicator);
        mPagerAdapter = new PagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        indicator.setViewPager(mViewPager);
        indicator.setFooterColor(getResources().getColor(R.color.appColor));
        indicator.setTextSize(30);
        indicator.setSelectedColor(getResources().getColor(R.color.appColor));
        indicator.setFooterIndicatorPadding(10);
    }

    public class PagerAdapter extends FragmentPagerAdapter{
        public PagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return CocktailList.newInstance();
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }



}
