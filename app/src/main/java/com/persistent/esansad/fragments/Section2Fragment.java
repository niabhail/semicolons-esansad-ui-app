package com.persistent.esansad.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.persistent.esansad.R;

/**
 * Created by ashwin_valento on 03-Feb-15.
 */
public class Section2Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_nav_section_2_layout,container,false);

        return rootView;
    }
}