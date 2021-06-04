package sg.edu.rp.c346.id19020303.donghuatcm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button loginBtn;

    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.etLoginName);
        password =(EditText) findViewById(R.id.etLoginPassword);
        loginBtn = (Button) findViewById(R.id.loginBtnBtn);

        myDB = new DBHelper(LoginActivity.this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Please Fill in all the details", Toast.LENGTH_LONG).show();
                }
                else {

                    //Check user from the database
                   Boolean result =  myDB.checkUsernamePassword(user,pass);
                   if(result == true){
                       //user is valid
                       Intent intent = new Intent(LoginActivity.this, Homepage.class);
                       startActivity(intent);
                   }
                   else{
                       Toast.makeText(LoginActivity.this, "Invalid Details", Toast.LENGTH_LONG).show();
                   }

                }
            }
        });
    }
}