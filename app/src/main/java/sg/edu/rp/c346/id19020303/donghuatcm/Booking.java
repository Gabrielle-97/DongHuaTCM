package sg.edu.rp.c346.id19020303.donghuatcm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

public class Booking extends AppCompatActivity {

    private EditText timeET, reasonET;
    private CalendarView calendarView;
    private Button bookBtn;
    private String selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        timeET = (EditText)findViewById(R.id.timeET);
        calendarView = (CalendarView) findViewById(R.id.bookingCalendarView);
        bookBtn = (Button)findViewById(R.id.bookBtn);
        reasonET = (EditText)findViewById(R.id.reasonET);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int dayofMonth, int month, int year) {

                selectedDate = Integer.toString(dayofMonth) + Integer.toString(month) +Integer.toString(year);

            }
        });

        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = "+6591592275";
                String message = "Hi";
                boolean installed = appInstalledorNot("com.whatsapp");

                if(installed){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://api.whatsapp.com/send?phone="+number +"&text="+ message));
                    startActivity(intent);
                }
                else{
                    Toast.makeText(Booking.this, "WhatsApp is not installed on your device", Toast.LENGTH_LONG);
                }
            }
        });
    }


    //Create method application
    private boolean appInstalledorNot(String url){
        PackageManager packageManager = getPackageManager();
        boolean app_installed;
        try{
            packageManager.getPackageInfo(url,PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e){
            app_installed = false;
        }
        return app_installed;
    }
}