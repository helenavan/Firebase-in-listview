package com.helenacorp.quete_firebase;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SubmitItineraryActivity extends AppCompatActivity {
    private EditText departureEdit, destinationEdit, dateEdit, priceEdit;
    private Button buttonEdit, buttonCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_itinerary);

        departureEdit = (EditText) findViewById(R.id.departEdit);
        destinationEdit = (EditText) findViewById(R.id.destinationEdit);
        dateEdit = (EditText) findViewById(R.id.dateEdit);
        priceEdit = (EditText) findViewById(R.id.priceEdit);
        buttonEdit = (Button) findViewById(R.id.btnSubmitItinerary);
        buttonCall = (Button) findViewById(R.id.btnSCall);

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
        buttonCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(SubmitItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                startActivity(intent);
            }

        });


    }

    public void sendMessage(View view) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("itineraries");
        //DatabaseReference myRef = ref.child("itineraries");

        Map<String, ItineraryModel> users = new HashMap<String, ItineraryModel>();
        users.put("departs".toString(), new ItineraryModel(0, null, null, null, priceEdit.getInputType(), departureEdit.getText().toString(), destinationEdit.getText().toString()));
       /* myRef.setValue(destinationEdit.getText().toString());
        myRef.setValue(dateEdit.getText().toString());
        myRef.setValue(priceEdit.getText().toString());*/
        ref.setValue(users);
    }
}
