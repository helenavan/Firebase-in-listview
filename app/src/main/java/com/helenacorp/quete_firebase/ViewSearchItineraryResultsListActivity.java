package com.helenacorp.quete_firebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {
    String messageDeparture, messageDestination;
    private TextView textDeparture, textDestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        Intent intent = getIntent();
        messageDeparture = intent.getStringExtra(SearchItineraryActivity.EXTRA_MESSAGE1);
        messageDestination = intent.getStringExtra(SearchItineraryActivity.EXTRA_MESSAGE2);

        textDeparture = (TextView) findViewById(R.id.text_departure);
        textDestination = (TextView) findViewById(R.id.text_destination);

        textDeparture.setText(messageDeparture.toString());
        textDestination.setText(messageDestination.toString());
    }
}
