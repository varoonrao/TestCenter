package com.varun.testcenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class TestResults extends AppCompatActivity {

    TextView user_id,user_name,user_blood,user_ecg,user_weight,user_sugar,user_heart;
    DatabaseReference ref;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_testresults );

        user_id=findViewById ( R.id.user_id);
        user_name=findViewById ( R.id.user_name );
        user_blood=findViewById ( R.id.blood_pressure );
        user_ecg=findViewById ( R.id.ecg );
        user_sugar=findViewById ( R.id.sugar_level );
        user_heart=findViewById ( R.id.heart_rate );


        user_id.setText(getIntent ().getStringExtra ( "userid" ));
        user_name.setText(getIntent ().getStringExtra ("username" ));
        user_blood.setText ( getIntent ().getStringExtra ( "blood" ) );
        user_sugar.setText ( getIntent ().getStringExtra ( "sugar" ) );
        user_ecg.setText(getIntent ().getStringExtra ( "ecg" ));
        user_heart.setText(getIntent ().getStringExtra ( "heart" ));




    }
}
