package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText edItem;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edItem = findViewById(R.id.edItem);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        edItem.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        //Check editing then save
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create intent with modified result
                Intent intent = new Intent();

                //paas the edited text
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, edItem.getText().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                //set the result
                setResult(RESULT_OK,intent);

                //go back to main screen
                finish();

            }
        });
    }
}