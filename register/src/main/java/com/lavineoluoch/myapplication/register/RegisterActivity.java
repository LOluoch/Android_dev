package com.lavineoluoch.myapplication.register;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends ActionBarActivity implements View.OnClickListener{
    private Button btnRegister;
    private EditText etFirstName,etSurname,etUsername,etPassword;
    DBHandler dbHandler;
    CheckBox cbPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        cbPassword = (CheckBox)findViewById(R.id.cbPassword);
        etFirstName = (EditText)findViewById(R.id.etFirstName);
        etSurname = (EditText)findViewById(R.id.etSurname);
        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        dbHandler = new DBHandler(this,null,null,1);

        btnRegister = (Button)findViewById(R.id.btnregister);
        btnRegister.setOnClickListener(this);

        cbPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked){
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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

    @Override
    public void onClick(View v) {
        String firstname = etFirstName.getText().toString();
        String surname = etSurname.getText().toString();
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        User user = new User(firstname,surname,username,password);
        dbHandler.addUser(user);
        //Toast.makeText(getApplicationContext(),"You have successfully registered",Toast.LENGTH_SHORT).show();

        }



}
