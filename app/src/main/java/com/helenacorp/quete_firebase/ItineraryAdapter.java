package com.helenacorp.quete_firebase;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.Query;

/**
 * Created by helena on 03/07/2017.
 */

public class ItineraryAdapter extends FirebaseListAdapter<ItineraryModel> {
    private TextView txtdepart, txtprice, txtdestination;

    public ItineraryAdapter(Query mRef, Activity activity, int mLayout) {
        super(mRef, ItineraryModel.class, mLayout, activity);
    }

    @Override
    protected void populateView(View view, ItineraryModel model) {

        txtdepart = (TextView) view.findViewById(R.id.departureList);
        txtdepart.setText(model.getDeparture().toString());
        txtdestination = (TextView) view.findViewById(R.id.destinationList);
        txtdestination.setText(model.getDestination().toString());
        txtprice = (TextView) view.findViewById(R.id.priceList);
        txtprice.setText(String.valueOf(model.getPrice()));

    }

}
