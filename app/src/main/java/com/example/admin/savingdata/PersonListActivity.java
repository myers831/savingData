package com.example.admin.savingdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class PersonListActivity extends AppCompatActivity {

    private static final String TAG ="PersonListActivity" ;
    private ListView lvPersons;;
    DatabaseHelper databaseHelper =  new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        lvPersons = (ListView) findViewById(R.id.lvPersons);
        List<Person> personList = databaseHelper.getPersonList();

        String[] values = new String[]{
                "value1",
                "value2",
                "value3",
                "value4"
        };

        //ArrayAdapter<Person> adapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, personList);

        PersonListAdapter personListAdapter = new PersonListAdapter(this, R.layout.custom_list_item, personList);

        lvPersons.setAdapter(personListAdapter);

    }
}
