package com.lavineoluoch.myapplication.register;

/**
 * Created by USER on 7/21/2015.
 */
public class User {
    private int _id;
    private String _firstName;
    private String _surName;
    private String _username;
    private String _password;

    public User(){

    }

    public User(String _firstName,String _surName,String _username,String _password) {
        this._firstName = _firstName;
        this._surName = _surName;
        this._username = _username;
        this._password = _password;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_firstName() {
        return _firstName;
    }

    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String get_surName() {
        return _surName;
    }

    public void set_surName(String _surName) {
        this._surName = _surName;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }
}
