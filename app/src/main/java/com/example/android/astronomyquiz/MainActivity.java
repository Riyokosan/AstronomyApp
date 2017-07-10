package com.example.android.astronomyquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    EditText etAnswer1;

    //@BindView(R.id.answer2_1)
    CheckBox answer2_1;
    CheckBox answer2_2;
    CheckBox answer2_3;
    CheckBox answer2_4;
    CheckBox answer2_5;

    RadioGroup rgAnswer3;

    RadioGroup rgAnswer4;

    RadioGroup rgAnswer5;

    EditText etAnswer6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // more code in the oncreate
//        if (Build.VERSION.SDK_INT < 19) {
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        } else {
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
//        }

        etAnswer1 = (EditText) findViewById(R.id.answer1);

        answer2_1 = (CheckBox) findViewById(R.id.answer2_1);
        answer2_2 = (CheckBox) findViewById(R.id.answer2_2);
        answer2_3 = (CheckBox) findViewById(R.id.answer2_3);
        answer2_4 = (CheckBox) findViewById(R.id.answer2_4);
        answer2_5 = (CheckBox) findViewById(R.id.answer2_5);

        rgAnswer3 = (RadioGroup) findViewById(R.id.qcuQuestion3);

        rgAnswer4 = (RadioGroup) findViewById(R.id.qcuQuestion4);

        rgAnswer5 = (RadioGroup) findViewById(R.id.qcuQuestion5);

        etAnswer6 = (EditText) findViewById(R.id.answer6);

    }

    public void submitResult(View view) {
        score = 0;

        String answer1 = getString(R.string.answer1);
        String answer1User = etAnswer1.getText().toString();
        if (answer1.equalsIgnoreCase(answer1User)) {
            score++;
        }

        if (!answer2_1.isChecked() && answer2_2.isChecked() && !answer2_3.isChecked() && !answer2_4.isChecked() && answer2_5.isChecked()) {
            score++;
        }

        if (rgAnswer3.getCheckedRadioButtonId() == R.id.answer3_4) {
            score++;
        }

        if (rgAnswer4.getCheckedRadioButtonId() == R.id.answer4_1) {
            score++;
        }

        if (rgAnswer5.getCheckedRadioButtonId() == R.id.answer5_3) {
            score++;
        }

        String answer6 = getString(R.string.answer6);
        String answer6User = etAnswer6.getText().toString();
        if (answer6.equalsIgnoreCase(answer6User)) {
            score++;
        }

        if (score == 6){

            Toast.makeText(this, "Amazing! You\'ve got a perfect score!", Toast.LENGTH_SHORT).show();

        } else if (score >= 4) {

            Toast.makeText(this, "Congratulations, your score is: " + score, Toast.LENGTH_SHORT).show();
        }

        else {

            Toast.makeText(this, "Your score is: " + score + "\nBetter luck next time!", Toast.LENGTH_SHORT).show();
        }
    }


}
