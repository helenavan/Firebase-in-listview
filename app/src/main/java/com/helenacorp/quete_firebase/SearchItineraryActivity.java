package com.helenacorp.quete_firebase;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SearchItineraryActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE1 = "key1";
    public static final String EXTRA_MESSAGE2 = "key2";
    private EditText editTextDeparture, editTextdestination, editTextPrice, editTextDate;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary2);

        editTextDeparture = (EditText) findViewById(R.id.editTextSearchDeparture);
        editTextdestination = (EditText) findViewById(R.id.editTextSearchDestination);
        button = (Button) findViewById(R.id.button);
        button.setBackgroundColor(Color.GRAY);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (editTextDeparture.getText().length() == 0 ||
                        editTextdestination.getText().length() == 0) {
                    Context context = getApplicationContext();
                    CharSequence text = "Veuillez remplir le formulaire complètement,\nsinon grrr";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    final FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference ref = database.getReference("itineraries");
                    sendMessage(button);
                }
            }
        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, ViewSearchItineraryResultsListActivity.class);
        String message1 = editTextDeparture.getText().toString();
        String message2 = editTextdestination.getText().toString();
        int mPrix = Integer.parseInt(editTextPrice.getText().toString());
        intent.putExtra(EXTRA_MESSAGE1, message1);
        intent.putExtra(EXTRA_MESSAGE2, message2);
        startActivity(intent);
    }
}
