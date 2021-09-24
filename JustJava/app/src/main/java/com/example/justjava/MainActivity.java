package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name_edit_text);


    }

    String name2;
    int quantity = 2, price = 0;
    boolean isWhippedCream = false;
    boolean isChocolate = false;
   EditText name;



    public void submitOrder(View view) {

        name2 = name.getText().toString();
        price=5*quantity;
         if(isWhippedCream)
        {
           price += 1*quantity;
        }
        if(isChocolate)
        {
            price+= 2*quantity;
        }

        String priceMessage = "Thank you : " + name2;
        priceMessage += "\nTotal Item price :\n$" + price + "\n Toppings:";
        if (isWhippedCream) {
            priceMessage += "\n Whipped cream";

        }
        if (isChocolate) {
            priceMessage += "\n Chocolate";
        }
//        displayMessage(priceMessage);
        composeEmail(priceMessage);

    }

    public void composeEmail(String addresses) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_TEXT, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT,"thank you for ordering");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
   int whip=0;
   int cho=0;
    public void iswhippedcream(View v) {
        isWhippedCream = true;
        whip++;
        if (whip % 2 == 0)
            isWhippedCream = false;
    }

    public void ischocolate(View v) {
        isChocolate = true;
        cho++;
        if (cho % 2 == 0)
            isChocolate = false;
    }

    public void increment(View View) {
        quantity++;
        display(quantity);
    }

    public void decrement(View View) {
        if (quantity > 2)
            quantity--;
        display(quantity);

    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}

