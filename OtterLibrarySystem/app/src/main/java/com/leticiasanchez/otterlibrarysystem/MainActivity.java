package com.leticiasanchez.otterlibrarysystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //***********DATABASE**********//
        //---------------------------------------------------------

        //create a database for the app (Books database)
        MySQLiteHelper db = new MySQLiteHelper(this);
        /*//create a database for account database
        MySQLiteHelper2 db2 = new MySQLiteHelper2(this);*/

        //add books to the database table.
        db.addBook(new Book("Java Progamming", "Dr. Byun", 100.0));
        db.addBook(new Book("Computer Networking", "Dr. Seetharam", 100.25));
        db.addBook(new Book("Alice in Wonderful Land", "Alice", 300.00));

        //add accounts to the database table
        db.addAccount(new Account("a@lice5", "@csit100"));
        db.addAccount(new Account("$brian7", "123abc##"));
        db.addAccount(new Account("!chris12!", "CHRIS12!!"));


        //Read all the books information from the database
        //and store it to an array list.
        ArrayList<Book> list = db.getAllBooks();

        //Read all the accounts information from the database and store it to an arrayList
        ArrayList<Account> accountList = db.getAllAccounts();

        //&&&&&&&&&&&&&&&&&&&&&&&&&&&----BOOKS---&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
        //Update the database information of the first book in the array list.
        Book mybook = list.get(0);
        mybook.setAuthor("Prof. Sathya");
        mybook.setTitle("Android Programming.");
        mybook.setPrice((220.20));
        db.updateBook(mybook);

        //&&&&&&&&&&&&&&&&&&&&&&&&&&&----ACCOUNTS---&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
        //Update the database information of the first account in the array list.
        Account myAccount = accountList.get(0);
        myAccount.setUsername("l3tici@!!");
        myAccount.setPassword("zxy098*!");
        db.updateAccount(myAccount);

        //This is for the debugging purpose of updateBook() & updatingAccount() method.
        db.getAllBooks();
        db.getAllAccounts();

        //delete the first book and delete the first Account from the updatebase
        db.deleteBook(mybook);
        db.deleteAccount(myAccount);

        //This is for the debugging purpose of the deleteBook() & deleteAccount() method.
        db.getAllBooks();
        db.getAllAccounts();

        //---------------------------------------------------------------------------------------------

        //set up a click listener for the create account button
        View createAccountButton = findViewById(R.id.createaccount_button);
        createAccountButton.setOnClickListener(this);

        //set up a click listener for the place hold button
        View placeHoldButton = findViewById(R.id.placehold_button);
        placeHoldButton.setOnClickListener(this);

        //set up a click listener for cancel hold button
        View cancelHoldButton = findViewById(R.id.cancelhold_button);
        cancelHoldButton.setOnClickListener(this);

        //set up a click listener for manage system button
        View manageSystemButton = findViewById(R.id.managesystem_button);
        manageSystemButton.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.createaccount_button){

            Intent i = new Intent(this, CreateAccount.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.placehold_button){
            Intent i = new Intent(this, PlaceHold.class);
            startActivity(i);

        }
        else if(v.getId() == R.id.cancelhold_button){
            Intent i = new Intent(this, CancelHold.class);
            startActivity(i);
        }
        else if(v.getId() == R.id.managesystem_button){
            Intent i = new Intent(this, ManageSystem.class);
            startActivity(i);
        }
    }

}
