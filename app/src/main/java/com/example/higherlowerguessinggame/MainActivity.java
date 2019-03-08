package com.example.higherlowerguessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int MAX_NUMBER =1000;
    public static final Random RANDOM = new Random();
    private TextView msgText;
    private EditText numberEnteredEt;
    private Button validate;
    private  int numberTries, numberToFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msgText = findViewById(R.id.msg);

        numberEnteredEt=findViewById(R.id.numberEnteredEt);
        validate =findViewById(R.id.validate);
        validate.setOnClickListener(this);

        newGame();
    }

    @Override
    public void onClick(View view) {
        if (view ==validate){
            validate();
        }
    }

    private void validate() {
        int n = Integer.parseInt(numberEnteredEt.getText().toString());
        numberTries++;

        if(n==numberToFind) {
            Toast.makeText(this, "Congratulations! You found the number " + numberToFind
                    + " in " + numberTries + " tries", Toast.LENGTH_LONG).show();
            newGame();
        } else if (n>numberToFind) {
            msgText.setText(R.string.too_high);
        }else if(n<numberToFind){
            msgText.setText(R.string.too_low);
        }
    }
    private  void newGame(){
        numberToFind = RANDOM.nextInt(MAX_NUMBER)+1;
        msgText.setText(R.string.start_msg);
        numberEnteredEt.setText("");
        numberTries=0;
    }
}
