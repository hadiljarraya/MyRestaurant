package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;





public class MainActivity extends AppCompatActivity {

    static EditText e1, e2;
    Button b1, b2;

    private static String msg, NumTable;




    static MyThread thread = new MyThread();

    private ConnectionHelper connectionHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                e1 = (EditText) findViewById(R.id.edit1);
                e2 = (EditText) findViewById(R.id.edit2);
                b1 = (Button) findViewById(R.id.button1);
                b2 = (Button) findViewById(R.id.btnPay);
                // creating a new dbhandler class
                // and passing our context to it.
                connectionHelper = new ConnectionHelper(MainActivity.this);
                class myTask extends AsyncTask<Void, Void, Void> {
                    @SuppressLint("SetTextI18n")
                    @Override
                    protected Void doInBackground(Void... params) {


                        thread.sendMessage(msg);
                        System.out.println(thread.getMessage());

                        if (thread.getMessage() != "") {
                            e2.setText(thread.getMessage());
                        }

                        return null;
                    }

                    ;
                }
                ;
                b1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        NumTable = e1.getText().toString();
                        msg = e1.getText().toString();
                        thread.sendMessage(msg);
                        e2.setText(thread.getMessage());
                        myTask mt = new myTask();
                        mt.execute();
                        if (thread.getMessage() != "") {
                            e2.setText(thread.getMessage());
                        }
                        String Order = e2.getText().toString();
                        // on below line we are calling a method to add new
                        // course to sqlite data and pass all our values to it.
                        connectionHelper.addNewAddition(NumTable, Order);
                        Toast.makeText(getApplicationContext(), "Data sent", Toast.LENGTH_LONG).show();


                    }

                    ;
                });

                b2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        String Order = e2.getText().toString();
                        connectionHelper.addNewAddition(NumTable, Order);
                        Toast.makeText(MainActivity.this, "Addition has been added to the BD successfully.", Toast.LENGTH_SHORT).show();

                    }

                    ;
                });

            };
        };








