
package com.example.androidclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] state = {"Uttar pradesh", "Delhi",
            "Maharashtra", "Madhya Pradesh",
            "Rajasthan", "Gujarat"};
    String[] cities = {"Agra","Delhi","Mumbai","Indore","Jaipur","Ahmedabad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner s = (Spinner) findViewById(R.id.dropstate);
        s.setOnItemSelectedListener(this);
        //adaptar setup
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, state);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(dataAdapter);

        Spinner c = (Spinner) findViewById(R.id.dropciti);
        s.setOnItemSelectedListener(this);
        {
            ArrayAdapter<String> city = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
            city.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            c.setAdapter(city);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedClass = parent.getItemAtPosition(position).toString();
        switch (selectedClass){
            case "State":
                Toast.makeText(getApplicationContext(),
                                state[position],
                                Toast.LENGTH_LONG)
                        .show();
            case "citi":
                Toast.makeText(getApplicationContext(),
                                cities[position],
                                Toast.LENGTH_LONG)
                        .show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}