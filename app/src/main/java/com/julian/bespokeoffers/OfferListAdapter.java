package com.julian.bespokeoffers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by juliancurrie on 7/15/14.
 */
public class OfferListAdapter extends ArrayAdapter<Offer> {
    int resource;
    Context context;
    List<Offer> offerList;

    public OfferListAdapter(Context context, int resource, List<Offer> offerArrayList) {
        super(context, resource, offerArrayList);
        this.resource = resource;
        this.context = context;
        offerList = offerArrayList;
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        ViewHolder holder;
        Offer offer = offerList.get(position);

        if (convertView == null ) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(offer.getTitle());
        holder.description.setText(offer.getDescription());
        holder.date_range.setText("Valid: " + offer.getEarliestRedemptionDate()
                + " - " + offer.getVoucherExpiry());
        holder.offersRemaining.setText("Offers Remaining: " + offer.getAvailableCount());

        Picasso.with(context).load(offer.getImage())
                .resize(300, 300)
                .placeholder(R.drawable.ic_launcher)
                .into(holder.offerImage);

        return convertView;
    }

    static class ViewHolder{
        private TextView title;
        private TextView description;
        private TextView date_range;
        private TextView offersRemaining;
        private ImageView offerImage;

        public ViewHolder(View row) {
            title = (TextView)row.findViewById(R.id.title);
            description = (TextView)row.findViewById(R.id.description);
            date_range = (TextView)row.findViewById(R.id.valid_date_range);
            offersRemaining = (TextView)row.findViewById(R.id.remaining_offers);
            offerImage = (ImageView)row.findViewById(R.id.offer_image);
        }
    }
}
