package com.leticiasanchez.otterlibrarysystem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by leticiasanchez on 12/13/15.
 */
public class LogIn extends Activity implements View.OnClickListener {
    ArrayList<Account> loginArray = new ArrayList<Account>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        View logInButton = findViewById(R.id.login_button);
        logInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText usern, passw;
        String userInputN, userPassWord;

        MySQLiteHelper db = new MySQLiteHelper(this);
        loginArray = db.getAllAccounts();

        if(v.getId() == R.id.login_button){
            usern = (EditText)findViewById(R.id.userN_edittext);
            passw = (EditText)findViewById(R.id.passW_edittext);

            userInputN = usern.getText().toString();
            userPassWord = passw.getText().toString();

            for(int i = 0; i < loginArray.size(); i++){
                if(loginArray.get(i).getUsername().equals(usern)){
                    //let them make reservation

                }
            }

        }
    }
}


