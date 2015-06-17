package com.example.mymodule.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class RegisterActivity extends ActionBarActivity {

    private CheckBox checkBox;
    private EditText etpassword;
    private EditText etconfirmpwd;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register );

        //get the password and confirm password edit text
        etpassword = (EditText)findViewById(R.id.pwd);
        etconfirmpwd = (EditText)findViewById(R.id.confirmpwd);
        //get the password checkbox
        checkBox = (CheckBox)findViewById(R.id.checkpwd);

        //add onCheck listener on checkbox
        //When user clicks on checkbox, this is the handler
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                //checkbox status is changed from unchecked to checked
                if(!isChecked) {
                    //show password
                    etpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    etconfirmpwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                    else{
                        //hide password
                    etpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    etconfirmpwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }

            }
        });

        btn1 = (Button)findViewById(R.id.btnRegister);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Confirm if both passwords are the same when button is clicked.
                String a = etpassword.getText().toString();
                String b = etconfirmpwd.getText().toString();

                if(a == b){
                    Toast.makeText(getApplicationContext(),"Done!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Sorry,passwords don't match",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


