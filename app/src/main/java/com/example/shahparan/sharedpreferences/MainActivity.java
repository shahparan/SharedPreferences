package com.example.shahparan.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static final String MY_SHARED_NAME = "myShared";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edtTxt);
        textView = findViewById(R.id.tvShowData);
        sharedPreferences = getSharedPreferences(MY_SHARED_NAME,0);
        editor = sharedPreferences.edit();
    }


    public void saveData(View view) {
        editor.putString("sound",editText.getText().toString());
        editor.putString("level",editText.getText().toString());
        editor.commit();
        Toast.makeText(this, sharedPreferences.getString("sound","Data Not Found."), Toast.LENGTH_SHORT).show();
    }

    public void showData(View view) {
        textView.setText(sharedPreferences.getString("name","Data Not Found."));
    }

    public void removeData(View view) {
        editor.remove("name");
        editor.commit();
    }
}
