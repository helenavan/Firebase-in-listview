package com.helenacorp.quete_firebase;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.Query;

/**
 * Created by helena on 03/07/2017.
 */

public class ItineraryAdapter extends FirebaseListAdapter<ItineraryModel> {
    private TextView depart, prix, date;

    public ItineraryAdapter(Query mRef, Activity activity, int mLayout) {
        super(mRef, ItineraryModel.class, mLayout, activity);
    }

    @Override
    protected void populateView(View view, ItineraryModel model) {

        depart = (TextView) view.findViewById(R.id.datext);
        depart.setText(model.getDeparture().toString());
        prix = (TextView) view.findViewById(R.id.price);
        prix.setText(Integer.toString(model.getPrice()));

        //date
        //Date dateDeparture = model.getDepartureDate();
        date = (TextView) view.findViewById(R.id.time);
        date.setText(model.getDepartureDate().toString());
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
    }

}
