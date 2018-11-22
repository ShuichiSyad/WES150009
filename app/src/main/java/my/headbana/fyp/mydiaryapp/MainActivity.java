package my.headbana.fyp.mydiaryapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    String data_username, data_password;
    String valid_username = "WES150009";
    String valid_password = "1234abc";
    public static final String USER_SETTINGS = "UserSettings";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.input_username);
        password = findViewById(R.id.input_password);

        Button login = findViewById(R.id.button_login);
        Button register = findViewById(R.id.button_register);

        login.setOnClickListener(this);
    }

    private void login (){
        data_username = username.getText().toString();
        data_password = password.getText().toString();

        if(data_username.equals("") || data_password.equals("")){
            toast("All field are required !");
        }
        else{
            if (data_username.equals(valid_username) && data_password.equals(valid_password)){
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                SharedPreferences.Editor editor = getSharedPreferences(USER_SETTINGS, MODE_PRIVATE).edit();
                editor.putString("username", data_username);
                editor.apply();
                toast("Logging in ...");
                startActivity(intent);
            }else{
                toast("Authentication failed !");
            }
        }
    }

    private void toast(String str){
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_login:
                login();
                break;
            case R.id.button_register:
                toast("Function not yet developed !");
                break;
        }
    }
}
