package com.example.mission10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class Fragment1 extends Fragment {
    ViewPager pager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        pager = rootView.findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);

        MyPagerAdapter adapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());

        imgFragment imgFragment1 = new imgFragment();
        adapter.addItem(imgFragment1);

        imgFragment imgFragment2 = new imgFragment();
        adapter.addItem(imgFragment2);

        imgFragment imgFragment3 = new imgFragment();
        adapter.addItem(imgFragment3);

        pager.setAdapter(adapter);

        return rootView;
    }


    class MyPagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public MyPagerAdapter(FragmentManager fm){
            super(fm);
        }
        public void addItem(Fragment item){
            items.add(item);
        }
        public Fragment getItem(int position){
            return items.get(position);
        }

        public int getCount(){
            return items.size();
        }
    }
}

