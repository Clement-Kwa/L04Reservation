package sg.edu.rp.c346.id20002694.l04reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TimePicker tp;
    DatePicker dp;

    Button submit;
    Button reset;

    CheckBox smoke;

    EditText name;
    EditText num;
    EditText size;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tp = findViewById(R.id. tp);
        dp = findViewById(R.id. dp);

        submit = findViewById(R.id. btnSub);
        reset = findViewById(R.id. btnReset);

        smoke = findViewById(R.id. smoke);

        name = findViewById(R.id. editName);
        num = findViewById(R.id. editNum);
        size = findViewById(R.id. editSize);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset date and time
                dp.updateDate(2020,0,01);
                tp.setCurrentHour(7);
                tp.setCurrentMinute(30);

                //reset edit texts
                name.setText("");
                num.setText("");
                size.setText("");

                //reset checkbox
                smoke.setChecked(false);

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "";
                String date = (dp.getDayOfMonth()+"/"+(dp.getMonth()+1)+"/"+dp.getYear());
                String time = tp.getCurrentHour()+":"+tp.getCurrentMinute();

                result += "Name: "+name.getText().toString()+", Number: "+ num.getText().toString()+", Group size: "+size.getText().toString()
                + ", Date: "+date+", Time: "+time+", Smoking table: "+smoke.isChecked();


                //plug in string here
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });

    }
}