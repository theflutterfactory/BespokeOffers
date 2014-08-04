package com.julian.bespokeoffers;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by juliancurrie on 8/4/14.
 */
public class OfferListFragment extends Fragment implements Callback<OfferResponse> {

    private ListView offerListView;
    private OfferListAdapter offerAdapter;
    public static final String OFFER = "offer";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_offer_list, container, false);
        offerListView = (ListView)v.findViewById(R.id.listView);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("OfferList", "fragment created");
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
        offerAdapter = new OfferListAdapter(getActivity(), R.layout.offer_list_item, offerResponse.getOffers());
        offerListView.setAdapter(offerAdapter);
    }

    @Override
    public void failure(RetrofitError error) {
        Toast.makeText(getActivity(), "Failure! " + error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    public static OfferListFragment newInstance() {
        OfferListFragment frag = new OfferListFragment();
        return frag;
    }
}
