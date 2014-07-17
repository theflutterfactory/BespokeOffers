package com.julian.bespokeoffers;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class OfferActivity extends Activity implements Callback<OfferResponse> {

    ListView offerListView;
    OfferListAdapter offerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        offerListView = (ListView)findViewById(R.id.offer_lv);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://www.bespokeoffers.co.uk")
                .build();

        OffersAPI simpleApi = restAdapter.create(OffersAPI.class);
        simpleApi.getOffers(this);
    }

    @Override
    public void success(OfferResponse offerResponse, Response apiResponse) {
        offerAdapter = new OfferListAdapter(this, R.layout.offer_list_item, offerResponse.getOffers());
        offerListView.setAdapter(offerAdapter);
    }

    @Override
    public void failure(RetrofitError error) {
        Toast.makeText(this, "Failure! " + error.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
