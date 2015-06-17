package com.lavineoluoch.helloworld.calculator.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SubtractionActivity extends ActionBarActivity {

    TextView tv1;
    EditText  et1,et2;
    double a,b,c;
    Button btn1;

    public  double subtract(double one,double two){
        c = one - two;
        return c;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction);

        //Initialize variables
        btn1 = (Button)findViewById(R.id.subtractbtn);
        et1 = (EditText)findViewById(R.id.numoneet);
        et2 = (EditText)findViewById(R.id.numtwoet);
        tv1 = (TextView)findViewById(R.id.resulttv);

        //Create onClick method for subtraction button
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get user input from the EditText
                et2.getText();
                et1.getText();

                //Convert the input to String then to Double and store in variables
                a = Double.parseDouble(et1.getText().toString());
                b = Double.parseDouble(et2.getText().toString());

                //Call the subtraction method
                subtract(a, b);

                //Convert returned value to String and set text on the TextView
                tv1.setText(Double.toString(c));

            }

        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_subtraction, menu);
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
