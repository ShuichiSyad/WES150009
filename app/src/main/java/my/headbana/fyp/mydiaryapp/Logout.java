package my.headbana.fyp.mydiaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Logout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        RadioGroup rate = findViewById(R.id.radioRate);

        rate.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String rating = "5";
                if(i == R.id.radio1) {
                    rating = "1";
                }
                else if(i == R.id.radio2){
                    rating = "2";
                }
                else if(i == R.id.radio3){
                    rating = "3";
                }
                else if(i == R.id.radio4){
                    rating = "4";
                }
                else if(i == R.id.radio5){
                    rating = "5";
                }
                Toast.makeText(getApplicationContext(),"Thank you for rating us as "+rating+" !",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
