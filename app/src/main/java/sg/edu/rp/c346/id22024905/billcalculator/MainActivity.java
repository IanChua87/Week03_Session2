package sg.edu.rp.c346.id22024905.billcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    RadioGroup rdPaymentMth;
    RadioButton rdCash;


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
        rdPaymentMth = findViewById(R.id.radioPaymentMethod);
        rdCash = findViewById(R.id.radioButtonCash);


        btSplit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                String Amt = etAmt.getText().toString();
                double a = Double.parseDouble(Amt);
                String Pax = etPax.getText().toString();
                int p = Integer.parseInt(Pax);
                String Disc = etDisc.getText().toString();
                double d = Double.parseDouble(Disc);
                double svs = 0;
                double gst = 0;
                double totalBill = 0;
                double eachtoPay = 0;
                if(tbSVS.isChecked() && tbGST.isChecked()){
                    svs = a * 0.1;
                    gst = a * 0.07;
                    totalBill = svs + gst + (1-d/100)*a;
               } else if(tbGST.isChecked()){
                    gst = a * 0.07;
                    totalBill = gst + (1-d/100)*a;
                } else if(tbSVS.isChecked()){
                    svs = a * 0.1;
                    totalBill = svs + (1-d/100)*a;
                } else{
                    totalBill = (1-d/100)*a;
                }
                totalDisplay.setText("Total bill: " + totalBill);

                eachtoPay = totalBill/p;
                if(rdCash.isChecked()){
                    eachDisplay.setText("Each pays: " + String.format("%.2f", eachtoPay) + " in cash");
                }  else{
                    eachDisplay.setText("Each pays: " + String.format("%.2f", eachtoPay) + " via PayNow  to 912345678");
                }





            }
        });


    }
}