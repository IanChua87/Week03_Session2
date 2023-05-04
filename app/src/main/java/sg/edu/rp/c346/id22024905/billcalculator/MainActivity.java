package sg.edu.rp.c346.id22024905.billcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText etAmt;
    EditText etPax;
    ToggleButton tbSVS;
    ToggleButton tbGST;
    EditText etDisc;
    Button btSplit;
    Button btReset;

    TextView totalDisplay;
    TextView eachDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAmt = findViewById(R.id.editTextAmount);
        etPax = findViewById(R.id.editTextPax);
        tbSVS = findViewById(R.id.toggleButtonSVS);
        tbGST = findViewById(R.id.toggleButtonGST);
        etDisc = findViewById(R.id.editTextDiscount);
        btSplit = findViewById(R.id.buttonSplit);
        btReset = findViewById(R.id.buttonReset);
        totalDisplay = findViewById(R.id.showTextBill);
        eachDisplay = findViewById(R.id.showEachPay);

        tbSVS.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String Amt = etAmt.getText().toString();
                double a = Double.parseDouble(Amt);
                String Pax = etPax.getText().toString();
                double p = Double.parseDouble(Pax);
                String Disc = etDisc.getText().toString();
                double d = Double.parseDouble(Disc);
                boolean isChecked = tbSVS.isChecked();
                double svs = 0;
                double totalBill;
                if(isChecked){
                    svs += 1.1;
                }

            }
        });

        tbGST.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        btSplit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });

    }
}