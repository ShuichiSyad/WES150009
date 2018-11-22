package my.headbana.fyp.mydiaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EditFontType extends AppCompatActivity implements View.OnClickListener {

    TextView lorem_ipsum;
    TextView tv_font_size;
    Button increase, decrease, home;
    float font_size = 13; // initialized in layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_font_type);

        lorem_ipsum = findViewById(R.id.lorem_ipsum);
        tv_font_size = findViewById(R.id.font_size);

        increase = findViewById(R.id.increase);
        decrease = findViewById(R.id.decrease);
        home = findViewById(R.id.button_home);

        increase.setOnClickListener(this);
        decrease.setOnClickListener(this);
        home.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.increase:
                font_size+=1;
                changeFontSize(font_size);
                break;
            case R.id.decrease:
                font_size-=1;
                changeFontSize(font_size);
                break;
            case R.id.button_home:
                onBackPressed();
                break;
        }
    }

    private void changeFontSize(float size){
        lorem_ipsum.setTextSize(size);
        tv_font_size.setText(size+" sp");
    }

    private void toast(String str){
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
    }
}
