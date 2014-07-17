package com.julian.bespokeoffers;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class OfferActivity extends Activity implements Callback<OfferResponse> {

    private ListView offerListView;
    private OfferListAdapter offerAdapter;
    public static final String OFFER = "offer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        offerListView = (ListView)findViewById(R.id.offer_lv);
        offerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Offer selectedOffer = (Offer)parent.getItemAtPosition(position);
                OfferDetailFragment.newInstance(selectedOffer)
                        .show(getFragmentManager(), OFFER);
            }
        });

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
