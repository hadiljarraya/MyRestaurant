package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class acceuil extends AppCompatActivity {
    private Button check_buttton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.acceuil );
        check_buttton = (Button) findViewById( R.id.check );
        check_buttton.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent( acceuil.this, MainActivity.class );
                startActivity( intent );
                finish();
            }
        } );

    }

}





