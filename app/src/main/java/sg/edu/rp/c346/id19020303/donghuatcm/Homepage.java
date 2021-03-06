package sg.edu.rp.c346.id19020303.donghuatcm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Homepage extends AppCompatActivity {

    ImageButton professionalBtn, treatmentBtn;
    Button bookingBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        professionalBtn = (ImageButton)findViewById(R.id.profBtn);
        treatmentBtn = (ImageButton)findViewById(R.id.treatBtn);
        bookingBtn = (Button)findViewById(R.id.bookingBtn);

        professionalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homepage.this, ProfessionalActivity.class);
                startActivity(intent);
            }
        });

        treatmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homepage.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        bookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homepage.this, Booking.class);
                startActivity(intent);
            }
        });
    }
}