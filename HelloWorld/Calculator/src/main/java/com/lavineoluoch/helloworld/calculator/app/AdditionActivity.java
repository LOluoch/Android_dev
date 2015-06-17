package com.lavineoluoch.helloworld.calculator.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AdditionActivity extends ActionBarActivity {
    //Declare variables
    EditText et1,et2;
    TextView tv1;
    Button btn1;
    double a,b,c;

    //Create the addition method
    public double add(double one,double two){
        c = one + two;
        return c;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        //Initialize variables
        et1 = (EditText)findViewById(R.id.numoneet);
        et2 = (EditText)findViewById(R.id.numtwoet);
        btn1 = (Button)findViewById(R.id.addbtn);
        tv1 = (TextView)findViewById(R.id.resulttv);

        //Get user input from EditText
        et1.getText();
        et2.getText();

        //Create onClick method
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get user input and convert to string then double
                a = Double.parseDouble(et1.getText().toString());
                b = Double.parseDouble(et2.getText().toString());

                //Call addition method
                add(a,b);

                //Get returned value and convert to string them display on screen
                tv1.setText(Double.toString(c));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_addition, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
