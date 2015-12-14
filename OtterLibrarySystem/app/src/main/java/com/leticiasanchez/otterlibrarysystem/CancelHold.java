package com.leticiasanchez.otterlibrarysystem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by leticiasanchez on 12/8/15.
 */
public class CancelHold extends Activity implements View.OnClickListener {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancelhold);

//        View doneButton = findViewById(R.id.done_button);
//        doneButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

    }
}
