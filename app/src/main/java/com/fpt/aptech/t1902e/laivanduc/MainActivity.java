package com.fpt.aptech.t1902e.laivanduc;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fpt.aptech.t1902e.laivanduc.database.AppDatabase;
import com.fpt.aptech.t1902e.laivanduc.model.FeedBackEntity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    String[] feelings = {"Love", "Normal", "Like", "Hate", "Other"};

    CheckBox checkBox;
    Button button;

    EditText name, email, detail;

    Spinner spin;

    AppDatabase appDatabase;

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addSpinner();

        addListenerOnButtonClick();


    }

    public void addSpinner(){
        spin = findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, feelings);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        position = 0;
    }


    public void addListenerOnButtonClick() {

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        detail = findViewById(R.id.detail);
        checkBox = findViewById(R.id.checkBox);
        button = findViewById(R.id.button);

        appDatabase = AppDatabase.getAppDatabase(this);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || detail.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(MainActivity.this, "Fill all the attribute", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }



                FeedBackEntity feedBackEntity = new FeedBackEntity(name.getText().toString(), email.getText().toString(), "", 0, detail.getText().toString());
                if (checkBox.isChecked()) {
                    feedBackEntity.check = 1;
                }
                feedBackEntity.feel = feelings[position];
                appDatabase.feedBackDAO().insert(feedBackEntity);



                int all = appDatabase.feedBackDAO().getAllCount();
                Toast toast = Toast.makeText(MainActivity.this, all + " Item" , Toast.LENGTH_LONG);
                toast.show();
            }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        this.position = position;

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}