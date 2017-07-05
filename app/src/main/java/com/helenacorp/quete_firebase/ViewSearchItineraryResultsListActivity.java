package com.helenacorp.quete_firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {
    ListView listView;
    private DatabaseReference mDatabase;
    private ItineraryAdapter mItineraryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        mDatabase = FirebaseDatabase.getInstance().getReference("itineraries");
        mItineraryAdapter = new ItineraryAdapter(mDatabase, this, R.layout.item_itinerary);
        listView = (ListView) this.findViewById(R.id.listviewEdit);
        listView.setAdapter(mItineraryAdapter);
    }
}
