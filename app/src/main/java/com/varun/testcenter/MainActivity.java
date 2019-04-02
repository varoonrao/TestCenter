package com.varun.testcenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText uid_i,uname_i,bloodpressure_i,heart_i,weight_i,ecg_i,sugar_level_i;
    Button generate;
    DatabaseReference ref;
    Member member;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        uid_i=findViewById ( R.id.usid);
        uname_i=findViewById ( R.id.usname );
        bloodpressure_i=findViewById ( R.id.usblood );
        weight_i=findViewById ( R.id.usweight );
        ecg_i=findViewById ( R.id.usecg );
        sugar_level_i=findViewById ( R.id.ussugar );
        heart_i=findViewById ( R.id.usheart );
        generate=(Button)findViewById ( R.id.generate );
        member=new Member ();

        ref = FirebaseDatabase.getInstance().getReference().child ( "User_data" ).child ( "0" );
        generate.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                member.setUid ( uid_i.getText ().toString ().trim () );
                member.setUname ( uname_i.getText ().toString ().trim () );
                member.setBlood ( bloodpressure_i.getText ().toString ().trim () );
                member.setEcg ( ecg_i.getText ().toString ().trim () );
                member.setHeart ( heart_i.getText ().toString ().trim () );
                member.setSugar ( sugar_level_i.getText ().toString ().trim () );
                member.setWeight ( weight_i.getText ().toString ().trim () );

                ref.push ().setValue ( member );
                Toast.makeText ( getApplicationContext (), "Inserted Successfully", Toast.LENGTH_SHORT ).show ();

//                String setuid=uid_i.getText ().toString ();
//                String setuname=uname_i.getText ().toString ();
//                String setblood=bloodpressure_i.getText ().toString ();
//                String setecg=ecg_i.getText ().toString ();
//                String setheart=heart_i.getText ().toString ();
//                String setsugar=sugar_level_i.getText ().toString ();
//                String setweight=weight_i.getText ().toString ();
//                Intent intent=new Intent ( MainActivity.this,TestResults.class );
//                intent.putExtra ( "userid",setuid );
//                intent.putExtra ( "username",setuname );
//                intent.putExtra ( "blood",setblood );
//                intent.putExtra ( "ecg",setecg );
//                intent.putExtra("heart",setheart);
//                intent.putExtra ( "sugar",setsugar );
//                intent.putExtra ( "weight",setweight );
//                startActivity ( intent );
            }
        } );

    }
}
