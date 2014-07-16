package com.julian.bespokeoffers;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;

/**
 * Created by juliancurrie on 7/15/14.
 */
public interface OffersAPI {

    @GET("/mobile-api/v1/offers.json?page_size=10&page=1")
    void getOffers(Callback<Response> callback);
}