package my.headbana.fyp.mydiaryapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    String username;
    Button new_entry, read_past_entries, edit_font_type, logout;
    public static final String USER_SETTINGS = "UserSettings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        SharedPreferences prefs = getSharedPreferences(USER_SETTINGS, MODE_PRIVATE);
        username = prefs.getString("username", "Dummy !");

        TextView greeting = findViewById(R.id.greeting);
        greeting.setText("Welcome Back, "+username+"!");

        new_entry = findViewById(R.id.button_new_entry);
        read_past_entries = findViewById(R.id.button_read_past_entries);
        edit_font_type = findViewById(R.id.button_edit_font_type);
        logout = findViewById(R.id.button_logout);

        new_entry.setOnClickListener(this);
        read_past_entries.setOnClickListener(this);
        edit_font_type.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        // Fake initialize in case theres something wrong later
        intent = new Intent(getApplicationContext(),MainActivity.class);
        switch (view.getId()){
            case R.id.button_new_entry:
                intent = new Intent(getApplicationContext(),MainActivity.class);
                break;
            case R.id.button_read_past_entries:
                intent = new Intent(getApplicationContext(),View_Past_Entries.class);
                break;
            case R.id.button_edit_font_type:
                intent = new Intent(getApplicationContext(),EditFontType.class);
                break;
            case R.id.button_logout:
                intent = new Intent(getApplicationContext(),Logout.class);
                break;
        }
        startActivity(intent);
    }
}
