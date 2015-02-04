package com.persistent.esansad;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.persistent.esansad.fragments.Section1Fragment;
import com.persistent.esansad.fragments.Section2Fragment;
import com.persistent.esansad.fragments.Section3Fragment;

import java.util.ArrayList;
import java.util.List;

import br.liveo.interfaces.NavigationLiveoListener;
import br.liveo.navigationliveo.NavigationLiveo;

/**
 * Created by ashwin_valento on 03-Feb-15.
 */
public class MainActivity extends NavigationLiveo implements NavigationLiveoListener {


    @Override
    public void onUserInformation() {
        //User information here
        this.mUserName.setText("Ashwin Valento");
        this.mUserEmail.setText("ashwinvalento@gmail.com");
        this.mUserPhoto.setImageResource(R.drawable.ic_rudsonlive);
        this.mUserBackground.setImageResource(R.drawable.ic_user_background);


//        View mCustomHeader = getLayoutInflater().inflate(R.layout.custom_header_user, this.getListView(), false);
//        ImageView imageView = (ImageView) mCustomHeader.findViewById(R.id.imageView);
//        this.addCustomHeader(mCustomHeader); //This will add the new header and remove the default user header
    }

    @Override
    public void onInt(Bundle bundle) {
//Creation of the list items is here

        // set listener {required}
        this.setNavigationListener(this);

        // name of the list items
        List<String> mListNameItem = new ArrayList<>();
        mListNameItem.add(0, "Section 1");
        mListNameItem.add(1, "Section 2");
        mListNameItem.add(2, "Section 3");


        // icons list items
        List<Integer> mListIconItem = new ArrayList<>();
        mListIconItem.add(0, R.drawable.ic_drawer);
        mListIconItem.add(1, R.drawable.ic_drawer);
        mListIconItem.add(2, R.drawable.ic_drawer);


        //{optional} - Among the names there is some subheader, you must indicate it here
        List<Integer> mListHeaderItem = new ArrayList<>();
        mListHeaderItem.add(3);

        //{optional} - Among the names there is any item counter, you must indicate it (position) and the value here
        SparseIntArray mSparseCounterItem = new SparseIntArray(); //indicate all items that have a counter
        mSparseCounterItem.put(0, 123);   // appears next to section 1

        //If not please use the FooterDrawer use the setFooterVisible(boolean visible) method with value false
        this.setFooterInformationDrawer(R.string.action_settings, R.drawable.ic_drawer);

        this.setNavigationAdapter(mListNameItem, mListIconItem, mListHeaderItem, mSparseCounterItem);
    }

    @Override
    public void onItemClickNavigation(int position, int layoutContainerId) {


        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new Section1Fragment();
                break;
            case 1:
                fragment = new Section2Fragment();
                break;
            case 2:
                fragment = new Section3Fragment();
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();


    }

    @Override
    public void onPrepareOptionsMenuNavigation(Menu menu, int i, boolean b) {

    }

    @Override
    public void onClickFooterItemNavigation(View view) {

    }

    @Override
    public void onClickUserPhotoNavigation(View view) {

    }
}
