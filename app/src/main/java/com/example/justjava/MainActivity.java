/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int coffee=2;
    public void submitOrder(View view) {
        int price=coffee*5;
        CheckBox checkBox= findViewById(R.id.checkbox);
        boolean ans=checkBox.isChecked();
        CheckBox checkBox1= findViewById(R.id.checkbox1);
        boolean choco=checkBox1.isChecked();
        EditText name=  findViewById(R.id.yourname);
        String fname=name.getText().toString();
        if(ans)
        price=price+coffee;
        if(choco)
            price=price+coffee*2;
        String s="Name: "+fname+"\nAdd wipped cream? "+ans+"\nAdd chocolate: "+choco+"\nQuantity :" +coffee+"\ntotal : "+price+"\nThank you!";
//        displaymessage(s);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: "));
        intent.putExtra(Intent.EXTRA_SUBJECT,"just java order for "+fname);
        intent.putExtra(Intent.EXTRA_TEXT,""+s);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
    }
//    private void displaymessage(String message) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(message);
    }
    public void increment(View view) {
        if(coffee==100) {
            Toast.makeText(this,"You cannot have more Coffees",Toast.LENGTH_SHORT).show();
            return;
        }
        coffee++;
        display(coffee);
    }
    public void decrement(View view)
    {
        if(coffee==1) {
            Toast.makeText(this,"You cannot have 0 Coffees",Toast.LENGTH_SHORT).show();
            return;
        }
        coffee--;
        display(coffee);
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

    }
