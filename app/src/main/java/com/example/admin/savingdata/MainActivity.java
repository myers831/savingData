package com.example.admin.savingdata;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText etSaveDataToSharedPref;
    private TextView tvGetDataFromSharedPref;
    private EditText etName;
    private EditText etAge;
    private EditText etGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSaveDataToSharedPref = (EditText) findViewById(R.id.etSaveDataToSharedPref);
        tvGetDataFromSharedPref = (TextView) findViewById(R.id.tvDataFromSharedPref);
        etName = (EditText) findViewById(R.id.etName);
        etAge = (EditText) findViewById(R.id.etAge);
        etGender = (EditText) findViewById(R.id.etGender);
    }

    public void usingSharedPref(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("mySharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        switch(view.getId()){
            case R.id.btnSaveDataToSharedPref:

                editor.putString("data", etSaveDataToSharedPref.getText().toString());
                boolean isSaved = editor.commit();

                if(isSaved){
                    Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Not Saved", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btnGetDataFromSharedPref:

                String data = sharedPreferences.getString("data", "defaultValue");
                tvGetDataFromSharedPref.setText(data);

                break;
            case R.id.btnClearDataFromSharedPref:
                boolean isCleared = editor.clear().commit();

                if(isCleared){
                    Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Not Cleared", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void usingSQLite(View view) {
        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        switch (view.getId()){
            case R.id.savePerson:

                String personName = etName.getText().toString();
                String personAge = etAge.getText().toString();
                String personGender = etGender.getText().toString();

                Person person = new Person(personName, personGender, personAge);

                // TODO: 10/2/2017 Create a database to save the data

                long rowId = databaseHelper.savePerson(person);

                Toast.makeText(this, "Row id: " + rowId, Toast.LENGTH_SHORT).show();

                break;
            case R.id.getPersons:

                List<Person> personList = databaseHelper.getPersonList();
                for(int i = 0; i < personList.size(); i++){
                    Log.d(TAG, "usingSQLite: " + personList.get(i).toString());
                }

                Intent intent = new Intent(this, PersonListActivity.class);
                startActivity(intent);

                break;
        }
    }
}
