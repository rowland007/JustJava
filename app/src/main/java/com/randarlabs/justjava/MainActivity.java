package com.randarlabs.justjava;

import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int numberOfCoffees = 0;
    double pricePerCoffee = 5.00;
    String priceMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // displayPrice(numberOfCoffees * pricePerCoffee);
        if (numberOfCoffees == 0) {
            Toast.makeText(getApplicationContext(), "Nothing ordered", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Thank you!", Toast.LENGTH_SHORT).show();
        }
        priceMessage = "Price per coffee: " + NumberFormat.getCurrencyInstance().format(pricePerCoffee) + "\n" +
                "Total: " + NumberFormat.getCurrencyInstance().format(numberOfCoffees * pricePerCoffee);
        displayMessage(priceMessage);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void increaseQuantity(View view) {
        numberOfCoffees = numberOfCoffees + 1;
        display(numberOfCoffees);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void decreaseQuantity(View view) {
        if (numberOfCoffees <= 0) {
            Toast.makeText(getApplicationContext(), "ERROR: Can't have less than 0", Toast.LENGTH_SHORT).show();
        }
        numberOfCoffees = numberOfCoffees > 0 ? numberOfCoffees - 1 : 0;
        display(numberOfCoffees);
    }

    private void displayMessage(String string) {
        TextView priceTextView = (TextView) findViewById(R.id.price_value);
        priceTextView.setText(string);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_value);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(double number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_value);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}