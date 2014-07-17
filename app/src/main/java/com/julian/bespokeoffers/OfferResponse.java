package com.julian.bespokeoffers;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class OfferResponse {

    private List<Offer> offers = new ArrayList<Offer>();
    @SerializedName("related_offers")
    private List<Object> relatedOffers = new ArrayList<Object>();
    @SerializedName("total_count")
    private Integer totalCount;
    private String page;
    @SerializedName("page_size")
    private String pageSize;

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public List<Object> getRelatedOffers() {
        return relatedOffers;
    }

    public void setRelatedOffers(List<Object> relatedOffers) {
        this.relatedOffers = relatedOffers;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

}