package com.julian.bespokeoffers;

import android.app.DialogFragment;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by juliancurrie on 7/16/14.
 */
public class OfferDetailFragment extends DialogFragment {

    private Offer currentOffer;
    private ImageView offerImage;
    private TextView title;
    private TextView description;
    private TextView validDateRange;
    private TextView discount;
    private ImageView merchantLogo;
    private TextView merchantName;
    private TextView merchantPhoneNumber;
    private TextView merchantEmail;
    private TextView howToUse;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            currentOffer = args.getParcelable(OfferActivity.OFFER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        getDialog().setTitle(getActivity().getString(R.string.offer_details));

        View view = inflater.inflate(R.layout.offer_details, container, false);
        offerImage = (ImageView)view.findViewById(R.id.offer_image);
        title = (TextView)view.findViewById(R.id.title);
        description = (TextView)view.findViewById(R.id.description);
        validDateRange = (TextView)view.findViewById(R.id.valid_date_range);
        discount = (TextView)view.findViewById(R.id.discount);
        merchantLogo = (ImageView)view.findViewById(R.id.merchant_logo);
        merchantName = (TextView)view.findViewById(R.id.merchant_name);
        merchantPhoneNumber = (TextView)view.findViewById(R.id.merchant_phone_number);
        merchantEmail = (TextView)view.findViewById(R.id.merchant_email);
        howToUse = (TextView)view.findViewById(R.id.how_to_use);

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        title.setText(currentOffer.getTitle());
        description.setText(currentOffer.getDescription());
        validDateRange.setText("Valid: " + currentOffer.getEarliestRedemptionDate()
                + " - " + currentOffer.getVoucherExpiry());

        String discountString = currentOffer.getDiscount();
        if (discountString != null) {
            discount.setText("Discount: " + discountString.trim());
        }

        String merchantNameString = currentOffer.getMerchantName();
        if (merchantNameString != null) {
            merchantName.setText("Merchant: " + merchantNameString.trim());
        }

        String merchantNumberString = currentOffer.getMerchantContactPhoneNumber();
        if (merchantNumberString != null) {
            String strippedNumber = merchantNumberString.substring(1).trim();
            merchantPhoneNumber.setText("Phone: " + PhoneNumberUtils.formatNumber(strippedNumber));
            //if collectConsumerDeliveryDetails in Offer is null instead of true/false
            //an NPE will be thrown when clicked
            //TODO figure out a better solution than try/catch for this
            Linkify.addLinks(merchantPhoneNumber, Linkify.PHONE_NUMBERS);
        }

        String merchantEmailString = currentOffer.getMerchantContactEmailAddress();
        if (merchantEmailString != null) {
            merchantEmail.setText("Email: " + merchantEmailString.trim());
            Linkify.addLinks(merchantEmail, Linkify.EMAIL_ADDRESSES);
        }

        String howToUseString = currentOffer.getHowToUse();
        if (howToUseString != null) {
            howToUse.setText(howToUseString);
        }

        Picasso.with(getActivity()).load(currentOffer.getImage())
                .placeholder(R.drawable.ic_launcher)
                .into(offerImage);

        Picasso.with(getActivity()).load(currentOffer.getMerchantLogo())
                .into(merchantLogo);
    }

    public static OfferDetailFragment newInstance(Offer offer) {
        OfferDetailFragment frag = new OfferDetailFragment();
        Bundle b = new Bundle(1);
        b.putParcelable(OfferActivity.OFFER, offer);
        frag.setArguments(b);
        return frag;
    }
}