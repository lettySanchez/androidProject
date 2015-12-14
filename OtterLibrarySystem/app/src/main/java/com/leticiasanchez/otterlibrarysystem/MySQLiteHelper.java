package com.leticiasanchez.otterlibrarysystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by leticiasanchez on 12/11/15.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    //Database Name - BookDB and AccountsDB (OtterLibraryDB)
    private static final String DATABASE_NAME = "OtterLibraryBD";

    //Table Name - books, accounts and Transaction
    private static final String TABLE_BOOKS = "books";
    private static final String TABLE_ACCOUNTS = "accounts";
    private static final String TABLE_TRANSACTIONS = "transaction";

    //Column Names of BOOKS Table
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_PRICE = "price";

    //Column Names of ACCOUNTS Table
    private static final String KEY_ID2 = "id2";
    private static final String KEY_USERNAME =  "username";
    private static final String KEY_PASSWORD = "password";

    //Column Names of Transaction Table
    private static final String KEY_ID3 = "id3";
    private static final String KEY_TRANSACTIONTYPE = "transactiontype";
    private static final String KEY_CUSTOMERUSERNAME = "customerusername";
    private static final String KEY_CURRENTDATETIME = "currentdatetime";
    private static final String KEY_PICKUPDATEHOUR = "pickupdatehour";
    private static final String KEY_RETURNDATEHOUR = "returndatehour";
    private static final String KEY_BOOKTITLE = "booktitle";
    private static final String KEY_RESERVATIONNUMBER = "reservationnumber";
    private static final String KEY_TOTALAMOUNT = "totalamount";
    private static final String KEY_TRANSACTIONDATE = "transactiondate";

    //Datavase Version
    private static final int DATABASE_VERSION = 1;

    //Log TAG for debugging purpose
    private static final String TAG  = "SQLiteAppLog";

    //Constructor
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //super(context, DATABASE2_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL statement to create a table called "books"
        String CREATE_BOOK_TABLE = "CREATE TABLE books (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, " +
                "author TEXT, "+
                "price REAL)";

        //SQL statement to create a table called "accounts"
        String CREATE_ACCOUNTS_TABLE = "CREATE TABLE accounts (" +
                "id2 INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, " +
                "password TEXT)";

        //SQL statement to create a table called "transaction"
        String CREATE_TRANSACTION_TABLE = "CREATE TABLE transaction (" +
                "id3 INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "transactiontype TEXT, " +
                "customerusername TEXT, " +
                "currentdatetime TEXT, " +
                "pickupdatehour TEXT, " +
                "returndatehour TEXT, " +
                "booktitle TEXT, " +
                "reservationnumber TEXT, " +
                "totalamount TEXT, " +
                "transactiondate TEXT)";

        //execute an SQL statement to create the table
        db.execSQL(CREATE_ACCOUNTS_TABLE);
        db.execSQL(CREATE_BOOK_TABLE);
        //db.execSQL(CREATE_TRANSACTION_TABLE);
        //db.execSQL(CREATE_TRANSACTION_TABLE);

    }

    //onUpdate() is invoked when you upgrade the database scheme.
    //Don't consider it seriously for the sample app.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS books");
        db.execSQL("DROP TABLE IF EXISTS accounts");
        db.execSQL("DROP TABLE IF EXITS transactions");

        //create fresh books table
        this.onCreate(db);
        //this.onCreate(db);
    }
    //---------------------------------------------------------------------\
    //*********************---------BOOKS-------------*********************************************
    //add Book
    public void addBook(Book book){
        Log.d(TAG, "addBook() - " + book.toString());
        //1. get refence to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        //2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, book.getTitle());//get Title
        values.put(KEY_AUTHOR, book.getAuthor());//get author
        values.put(KEY_PRICE, book.getPrice());//get price

        //3. insert
        db.insert(TABLE_BOOKS, //TABLE
                null, //nullColumnHack
                values);//key/values -> keys = column names/ values = column values
        //4. close - release the reference of writable DB
        db.close();
    }
    //*********************************************************************************************
    //*********************--------ACCOUNTS------------*********************************************
    //add Account
    public void addAccount(Account account){
        Log.d(TAG, "addAccount() - " + account.toString());
        //1. get refence to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        //2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, account.getUsername());//get username
        values.put(KEY_PASSWORD, account.getPassword());//get password

        //3. insert
        db.insert(TABLE_ACCOUNTS, //TABLE
                null, //nullColumnHack
                values);//key/values -> keys = column names/ values = column values
        //4. close - release the reference of writable DB
        db.close();
    }
    //**********************************************************************************************

    //*********************---------TRANSACTION--------*********************************************
    //addTransaction
    public void addTransaction(Transaction transaction){
        Log.d(TAG, "addTransaction() - " + transaction.toString());
        //1. get refence to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        //2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_TRANSACTIONTYPE, transaction.getTransactiontype());
        values.put(KEY_CUSTOMERUSERNAME, transaction.getCustomerusername());//get customerusername
        values.put(KEY_CURRENTDATETIME, transaction.getCurrentdatetime());//get currentdatetime
        values.put(KEY_PICKUPDATEHOUR, transaction.getPickupdatehour());
        values.put(KEY_RETURNDATEHOUR, transaction.getReturndatehour());
        values.put(KEY_BOOKTITLE, transaction.getTransactiondate());
        values.put(KEY_RESERVATIONNUMBER, transaction.getReservationnumber());
        values.put(KEY_TOTALAMOUNT , transaction.getTotalamount());
        values.put(KEY_TRANSACTIONDATE, transaction.getTransactiondate());

        //3. insert
        db.insert(TABLE_TRANSACTIONS, //TABLE
                null, //nullColumnHack
                values);//key/values -> keys = column names/ values = column values
        //4. close - release the reference of writable DB
        db.close();

    }


    //**********************************************************************************************

    //*********************---------BOOKS-------------*********************************************
    //Get all books from the database
    public ArrayList<Book> getAllBooks(){
        ArrayList<Book> books = new ArrayList<Book>();

        //1. build the query
        String query  = "SELECT * FROM " + TABLE_BOOKS;

        //2. get reference to writable DB
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //3. go over each row, build book and add it to the list
        Book book = null;
        if(cursor.moveToFirst()){
            do{
               book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setAuthor(cursor.getString(2));
                book.setPrice(Double.parseDouble(cursor.getString(3)));

                //Add book to books
                books.add(book);
            }while (cursor.moveToNext());
        }

        Log.d(TAG, "getAllBooks() - " + book.toString());

        //return books
        return books;
    }
    //**********************************************************************************************

    //*********************---------ACCOUNTS-----------*********************************************
   //Get all Accounts from the database
    public ArrayList<Account> getAllAccounts(){
        ArrayList<Account> accounts = new ArrayList<Account>();
        //1. build the query
        String query  = "SELECT * FROM " + TABLE_ACCOUNTS;
        //2. get reference to writable DB
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //3. go over each row, build account and add it to the list
        Account account = null;
        if(cursor.moveToFirst()) {
            do {
                account = new Account();
                account.setId(Integer.parseInt(cursor.getString(0)));
                account.setUsername(cursor.getString(1));
                account.setPassword(cursor.getString(2));

                //Add account to accounts
                accounts.add(account);
            }while (cursor.moveToNext());
        }

        Log.d(TAG, "getAllAccounts() - " + account.toString());
        //return books
        return accounts;
    }
    //**********************************************************************************************
    //*********************---------TRANSACTION-----------******************************************
    public ArrayList<Transaction> getAllTransactions(){
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        //1. build the query
        String query = "SELECT * FROM" + TABLE_TRANSACTIONS;
        //2. get reference to writable DB
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        //3. go over each row, build account and add it to the list
        Transaction transaction = null;
        if(cursor.moveToFirst()){
            do{
                transaction = new Transaction();
                transaction.setId(Integer.parseInt(cursor.getString(0)));
                transaction.setTransactiontype(cursor.getString(1));
                transaction.setCustomerusername(cursor.getString(2));
                transaction.setCurrentdatetime(cursor.getString(3));
                transaction.setPickupdatehour(cursor.getString(4));
                transaction.setReturndatehour(cursor.getString(5));
                transaction.setBooktitle(cursor.getString(6));
                transaction.setReservationnumber(cursor.getString(7));
                transaction.setTotalamount(cursor.getString(8));
                transaction.setTransactiondate(cursor.getString(9));

                transactions.add(transaction);
            }while (cursor.moveToNext());
        }
        Log.d(TAG, "getAllAccounts() - " + transaction.toString());
        //return books
        return transactions;
    }
    //**********************************************************************************************

    //*********************---------BOOKS-------------*********************************************
    //Updating single book
    public int updateBook(Book book){
        //1. get reference to writable DB
        SQLiteDatabase  db = this.getWritableDatabase();

        //2. create ContentValues to add key "column"/ values
        ContentValues values = new ContentValues();
        values.put("title", book.getTitle());//get title
        values.put("author", book.getAuthor());//get author
        values.put("price", book.getPrice());//get price

        //3. updating row
        int i = db.update(TABLE_BOOKS, //table
                            values, //column /value
                            KEY_ID+" =?", //selections
                            new String[] { String.valueOf(book.getId()) });// selection args
        //4. close
        db.close();

        return i;
    }
    //**********************************************************************************************

    //*********************---------ACCOUNTS-----------*********************************************
    //Updating single account
    public int updateAccount(Account account){
        //1. get reference to writable DB
        SQLiteDatabase  db = this.getWritableDatabase();

        //2. create ContentValues to add key "column"/ values
        ContentValues values = new ContentValues();
        values.put("username", account.getUsername());//get username
        values.put("password", account.getPassword());//get password

        //3. updating row
        int i = db.update(TABLE_ACCOUNTS, //table
                values, //column /value
                KEY_ID2+" =?", //selections
                new String[] { String.valueOf(account.getId()) });// selection args
        //4. close
        db.close();

        return i;
    }
    //**********************************************************************************************
    //*********************---------TRANSACTION-----------******************************************
    //Updating single account
    public int updateTransaction(Transaction transaction){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("transactiontype", transaction.getTransactiontype());
        values.put("customerusername", transaction.getCustomerusername());
        values.put("currentdatetime", transaction.getCurrentdatetime());
        values.put("pickupdatehour", transaction.getPickupdatehour());
        values.put("returndatehour", transaction.getReturndatehour());
        values.put("booktitle", transaction.getBooktitle());
        values.put("reservationnumber", transaction.getReservationnumber());
        values.put("totalamount", transaction.getTotalamount());
        values.put("transactiondate", transaction.getTransactiondate());

        //3. updating row
        int i = db.update(TABLE_TRANSACTIONS, //table
                values, //column /value
                KEY_ID3+" =?", //selections
                new String[] { String.valueOf(transaction.getId()) });// selection args
        //4. close
        db.close();

        return i;
    }
    //**********************************************************************************************
    //***************************---------BOOKS-----------*****************************************
    //Deleting single book
    public void deleteBook(Book book){
        //1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        //2. delete
        db.delete(TABLE_BOOKS,
                KEY_ID+" = ? ",
                new String[]{String.valueOf(book.getId())});
        //3.close
        db.close();

        Log.d(TAG, "deleteBook() -" + book.toString());

    }
    //**********************************************************************************************

    //***************************---------ACCOUNTS-----------***************************************
    //Deleting single account
    public void deleteAccount(Account account){
        //1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        //2. delete
        db.delete(TABLE_ACCOUNTS,
                KEY_ID2+" = ? ",
                new String[]{String.valueOf(account.getId())});
        //3.close
        db.close();

        Log.d(TAG, "deleteAccount() -" + account.toString());

    }
    //***************************---------TRANSACTION---------***************************************
    //Deleting single account
    public void deleteTransaction(Transaction transaction){
        //1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        //delete
        db.delete(TABLE_TRANSACTIONS, KEY_ID3+" = ?",
                new String[]{String.valueOf(transaction.getId())});
        //close
        db.close();

        Log.d(TAG, "deleteBook() -" + transaction.toString());


    }

    //**********************************************************************************************

}
