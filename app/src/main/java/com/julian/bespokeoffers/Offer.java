package com.julian.bespokeoffers;

/**
 * Created by juliancurrie on 7/16/14.
 */
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Offer implements Parcelable{

    private String uuid;
    private String title;
    private String description;
    @SerializedName("end_date")
    private String endDate;
    @SerializedName("earliest_redemption_date")
    private String earliestRedemptionDate;
    private String image;
    private String discount;
    @SerializedName("terms_of_service")
    private String termsOfService;
    @SerializedName("merchant_name")
    private String merchantName;
    @SerializedName("merchant_logo")
    private String merchantLogo;
    @SerializedName("merchant_contact_phone_number")
    private String merchantContactPhoneNumber;
    @SerializedName("merchant_contact_email_address")
    private String merchantContactEmailAddress;
    @SerializedName("merchant_website")
    private String merchantWebsite;
    private List<Object> stores = new ArrayList<Object>();
    @SerializedName("available_count")
    private Integer availableCount;
    @SerializedName("how_to_use")
    private String howToUse;
    private String type;
    @SerializedName("roundel_url")
    private String roundelUrl;
    @SerializedName("latest_marketable_date")
    private String latestMarketableDate;
    @SerializedName("voucher_expiry")
    private String voucherExpiry;
    @SerializedName("purchase_url")
    private String purchaseUrl;
    @SerializedName("redemption_url")
    private String redemptionUrl;
    @SerializedName("claimable_url")
    private String claimableUrl;
    private String slug;
    private Boolean claimable;
    private Boolean trending;
    private Boolean saved;
    private String price;
    @SerializedName("collect_consumer_delivery_details")
    private Boolean collectConsumerDeliveryDetails;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEarliestRedemptionDate() {
        return earliestRedemptionDate;
    }

    public void setEarliestRedemptionDate(String earliestRedemptionDate) {
        this.earliestRedemptionDate = earliestRedemptionDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTermsOfService() {
        return termsOfService;
    }

    public void setTermsOfService(String termsOfService) {
        this.termsOfService = termsOfService;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantLogo() {
        return merchantLogo;
    }

    public void setMerchantLogo(String merchantLogo) {
        this.merchantLogo = merchantLogo;
    }

    public String getMerchantContactPhoneNumber() {
        return merchantContactPhoneNumber;
    }

    public void setMerchantContactPhoneNumber(String merchantContactPhoneNumber) {
        this.merchantContactPhoneNumber = merchantContactPhoneNumber;
    }

    public String getMerchantContactEmailAddress() {
        return merchantContactEmailAddress;
    }

    public void setMerchantContactEmailAddress(String merchantContactEmailAddress) {
        this.merchantContactEmailAddress = merchantContactEmailAddress;
    }

    public String getMerchantWebsite() {
        return merchantWebsite;
    }

    public void setMerchantWebsite(String merchantWebsite) {
        this.merchantWebsite = merchantWebsite;
    }

    public List<Object> getStores() {
        return stores;
    }

    public void setStores(List<Object> stores) {
        this.stores = stores;
    }

    public Integer getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }

    public String getHowToUse() {
        return howToUse;
    }

    public void setHowToUse(String howToUse) {
        this.howToUse = howToUse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoundelUrl() {
        return roundelUrl;
    }

    public void setRoundelUrl(String roundelUrl) {
        this.roundelUrl = roundelUrl;
    }

    public String getLatestMarketableDate() {
        return latestMarketableDate;
    }

    public void setLatestMarketableDate(String latestMarketableDate) {
        this.latestMarketableDate = latestMarketableDate;
    }

    public String getVoucherExpiry() {
        return voucherExpiry;
    }

    public void setVoucherExpiry(String voucherExpiry) {
        this.voucherExpiry = voucherExpiry;
    }

    public String getPurchaseUrl() {
        return purchaseUrl;
    }

    public void setPurchaseUrl(String purchaseUrl) {
        this.purchaseUrl = purchaseUrl;
    }

    public String getRedemptionUrl() {
        return redemptionUrl;
    }

    public void setRedemptionUrl(String redemptionUrl) {
        this.redemptionUrl = redemptionUrl;
    }

    public String getClaimableUrl() {
        return claimableUrl;
    }

    public void setClaimableUrl(String claimableUrl) {
        this.claimableUrl = claimableUrl;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Boolean getClaimable() {
        return claimable;
    }

    public void setClaimable(Boolean claimable) {
        this.claimable = claimable;
    }

    public Boolean getTrending() {
        return trending;
    }

    public void setTrending(Boolean trending) {
        this.trending = trending;
    }

    public Boolean getSaved() {
        return saved;
    }

    public void setSaved(Boolean saved) {
        this.saved = saved;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Boolean getCollectConsumerDeliveryDetails() {
        return collectConsumerDeliveryDetails;
    }

    public void setCollectConsumerDeliveryDetails(Boolean collectConsumerDeliveryDetails) {
        this.collectConsumerDeliveryDetails = collectConsumerDeliveryDetails;
    }

    private  Offer(Parcel in) {
        readFromParcel(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeString(uuid);
        destination.writeString(title);
        destination.writeString(description);
        destination.writeString(endDate);
        destination.writeString(earliestRedemptionDate);
        destination.writeString(image);
        destination.writeString(discount);
        destination.writeString(termsOfService);
        destination.writeString(merchantName);
        destination.writeString(merchantLogo);
        destination.writeString(merchantContactPhoneNumber);
        destination.writeString(merchantContactEmailAddress);
        destination.writeString(merchantWebsite);
        destination.writeInt(availableCount);
        destination.writeString(howToUse);
        destination.writeString(type);
        destination.writeString(roundelUrl);
        destination.writeString(latestMarketableDate);
        destination.writeString(voucherExpiry);
        destination.writeString(purchaseUrl);
        destination.writeString(redemptionUrl);
        destination.writeString(claimableUrl);
        destination.writeString(slug);
        destination.writeByte((byte) (claimable ? 1 : 0));
        destination.writeByte((byte) (trending ? 1 : 0));
        destination.writeByte((byte) (saved ? 1 : 0));
        destination.writeString(price);
        destination.writeByte((byte) (collectConsumerDeliveryDetails ? 1 : 0));
    }

    private void readFromParcel(Parcel in) {
        uuid = in.readString();
        title = in.readString();
        description = in.readString();
        endDate = in.readString();
        earliestRedemptionDate = in.readString();
        image = in.readString();
        discount = in.readString();
        termsOfService = in.readString();
        merchantName = in.readString();
        merchantLogo = in.readString();
        merchantContactPhoneNumber = in.readString();
        merchantContactEmailAddress = in.readString();
        merchantWebsite = in.readString();
        availableCount = in.readInt();
        howToUse = in.readString();
        type = in.readString();
        roundelUrl = in.readString();
        latestMarketableDate = in.readString();
        voucherExpiry = in.readString();
        purchaseUrl = in.readString();
        redemptionUrl = in.readString();
        claimableUrl = in.readString();
        slug = in.readString();
        claimable = in.readByte() != 0;
        trending = in.readByte() != 0;
        saved = in.readByte() != 0;
        price = in.readString();
        collectConsumerDeliveryDetails = in.readByte() != 0;
    }
}