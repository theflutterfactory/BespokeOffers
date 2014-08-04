package com.julian.bespokeoffers;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class OfferActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
        setFragment();
    }

    private void setFragment(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.listFragment, OfferListFragment.newInstance());
        transaction.commit();
    }
}
