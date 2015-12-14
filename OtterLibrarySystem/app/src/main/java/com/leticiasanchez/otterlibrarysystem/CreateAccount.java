package com.leticiasanchez.otterlibrarysystem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by leticiasanchez on 12/7/15.
 */
public class CreateAccount extends Activity implements View.OnClickListener {

    //to store usersNane and passwords
    ArrayList<Account> accountsArray = new ArrayList<>();
    ArrayList<Transaction> transactionsArray = new ArrayList<>();
    //String specialCharSet = "!@#$";

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createaccount);

        View createAccountButton = findViewById(R.id.createa_button);
        createAccountButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        EditText username, password;
        String inputUserN, inputPassw;


        int count = 0;
        //retrieve from database
        MySQLiteHelper db = new MySQLiteHelper(this);
        accountsArray = db.getAllAccounts();
       // transactionsArray = db.getAllTransactions();

        //Log.d("TAG", "Create");
        if(view.getId() == R.id.createa_button){

            username = (EditText)findViewById(R.id.username_edittext);
            password = (EditText)findViewById(R.id.password_edittext);
            //get input from user
            inputUserN = username.getText().toString();
            inputPassw = password.getText().toString();

            boolean found  = false;

            //for loop to go through all the array of the AccountsArray
            for(int i = 0; i < accountsArray.size(); i++){
                if(accountsArray.get(i).getUsername().equals(inputUserN)){

                    //Toast.makeText(getBaseContext(), "Username already exist", Toast.LENGTH_LONG).show();
                    Toast toast = Toast.makeText(getBaseContext(),"Username already exist", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                   found= true;

                    break;
                }
            }


            //CharSequence usr = inputUserN;
            Pattern p = Pattern.compile("[a-zA-Z]");
            Pattern p1 = Pattern.compile("[!@#$]");
            Pattern p2 = Pattern.compile("[0-9]");
            Matcher m = p.matcher(inputUserN);
            Matcher m1 = p1.matcher(inputUserN);
            Matcher m2 = p2.matcher(inputUserN);


            if(inputUserN == null || inputUserN.equals("") && inputPassw == null || inputPassw.equals("")){
               //Toast.makeText(getBaseContext(), "Input field is empty", Toast.LENGTH_LONG).show();
               Toast toast = Toast.makeText(getBaseContext(),"Input field is empty!", Toast.LENGTH_LONG);
               toast.setGravity(Gravity.CENTER, 0, 0);
               toast.show();
           }
           else if(inputUserN.equals("!admin2")){
               //Toast.makeText(getBaseContext(), inputUserN + " can't be use it as username", Toast.LENGTH_LONG).show();
               Toast toast = Toast.makeText(getBaseContext(),inputUserN+" can't be use it as username!", Toast.LENGTH_LONG);
               toast.setGravity(Gravity.CENTER, 0, 0);
               toast.show();
           }
           else if(m.find() && m1.find() && m2.find() && found == false)
            {
               accountsArray.add(new Account(inputUserN, inputPassw));
               // transactionsArray.add(new Transaction());
                //adding to a dabatase
                db.addAccount(new Account(inputUserN, inputPassw));
                //db.addTransaction(new Transaction());

                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("New Account");
                alertDialog.setMessage("Congratulations! You have created a new account succesfully");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
// here you can add functions
                        //go back to main function

                    }
                });
                //alertDialog.setIcon(R.drawable.icon);
                alertDialog.show();

           }
            else{
                Toast toast = Toast.makeText(getBaseContext(),"ERROR!-- Incorrect format", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }


        }

    }
}
