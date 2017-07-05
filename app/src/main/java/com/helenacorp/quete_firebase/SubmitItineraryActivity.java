package com.helenacorp.quete_firebase;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SubmitItineraryActivity extends AppCompatActivity {
    private EditText departureEdit, destinationEdit, departureDateT, priceEdit;
    private Button buttonEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_itinerary);

        departureEdit = (EditText) findViewById(R.id.departEdit);
        destinationEdit = (EditText) findViewById(R.id.destinationEdit);
        departureDateT = (EditText) findViewById(R.id.dateEdit);
        priceEdit = (EditText) findViewById(R.id.priceEdit);
        buttonEdit = (Button) findViewById(R.id.btnSubmitItinerary);


        buttonEdit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (departureEdit.getText().length() == 0 ||
                        destinationEdit.getText().length() == 0) {
                    Context context = getApplicationContext();
                    CharSequence text = "Veuillez remplir le formulaire complètement,\nsinon grrr";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    sendMessage(buttonEdit);
                }
            }
        });

    }

    public void sendMessage(View view) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("itineraries");
        ItineraryModel itModel = new ItineraryModel(0, departureDateT.getText().toString(), priceEdit.getInputType(), departureEdit.getText().toString(), destinationEdit.getText().toString());
        ref.push().setValue(itModel);
        finish();
    }
}
