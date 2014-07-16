package com.julian.bespokeoffers;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class OfferActivity extends Activity implements Callback<Response> {

    ArrayList<Offer> offerList;
    ListView offerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
        offerListView = (ListView)findViewById(R.id.offer_lv);

        offerList = new ArrayList<Offer>();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://www.bespokeoffers.co.uk")
                .build();

        OffersAPI simpleApi = restAdapter.create(OffersAPI.class);
        simpleApi.getOffers(this);
    }

    @Override
    public void success(Response s, Response response) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        try {

            bufferedReader = new BufferedReader(new InputStreamReader(response.getBody().in()));

            String line;

            try {
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        String result = sb.toString();
        Log.d("OffersActivity", "response " + result);
    }

    @Override
    public void failure(RetrofitError error) {
        Toast.makeText(this, "Failure! " + error.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
