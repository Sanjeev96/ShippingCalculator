package com.dhillon.shippingcalculator;
// Controller for appllication
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.TextView;
import android.widget.EditText;//PROVIDES INTERFACE WITH TEXT
import android.text.TextWatcher;// INTERFACE TO KNOW WHEN USER HAS ALTERED EDITEXT INPUT VALUES
import android.app.Activity;
import android.text.Editable;
public class MyActivity extends AppCompatActivity {
    //DATA MODEL FOR SHIP ITEM
    private ShipItem shipItem;

    //VIEW OBJECTS FOR LAYOUT UI REFERENCE
    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //SET ACTIVITY CONTENT
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //CREATE DATA MODEL FOR STORING A SHIPPING ITEM
        shipItem = new ShipItem();//OBJECT CREATED TO STORE ITEM INFO

        //ESTABLISH REFERENCE TO INPUT WEIGHT ELEMENT
        weightET = (EditText) findViewById(R.id.EditText);

        // ESTABLISH REFERENCE TO OUTPUT ELEMENTS
        baseCostTV = (TextView) findViewById(R.id.textView4);
        addedCostTV = (TextView) findViewById(R.id.textView6);
        totalCostTV = (TextView) findViewById(R.id.textView8);

        //REGISTER LISTENER EVENT FOR WEIGHT INPUT
        weightET.addTextChangedListener(weightTextWatcher);// 3 CALL METHODS REQUIRED FOR TEXTWATCHER

    }

    private TextWatcher weightTextWatcher = new TextWatcher() {

//CALLED EACH TIME USER ENTERS WEIGHT (purpose = add exception for any input that is not numeric
        public void onTextChanged(CharSequence s, int start, int before, int count){
            //INPUT ELEMENT IS ATTACHED TO AN EDITABLE THERFORE METHOD BELOW IS CALLED WHEN TEXT IS CHANGED

            try {
                shipItem.setWeight((int)
                Double.parseDouble(s.toString()));
            } catch (NumberFormatException e) {
                shipItem.setWeight(0);
            }
            displayShipping();
        }
        public void afterTextChanged(Editable s) {}// REQUIRED FOR TEXTWATCHER INTEFACE BUT NOT USED
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}// REQUIRED FOR TEXTWATCHER INTEFACE BUT NOT USED
    };

    private void displayShipping(){// USED TO DISPLAY COMPUTED SHIPPING COSTS TO USER
        //DISPLAY ALL TYPES OF COST

        baseCostTV.setText("£" + String.format("%.02f", shipItem.getBaseCost()));
        addedCostTV.setText("£" + String.format("%.02f",shipItem.getAddedCost()));
        totalCostTV.setText("£" + String.format("%.02f",shipItem.getTotalCost()));
    }





}

