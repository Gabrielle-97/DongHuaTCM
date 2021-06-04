package sg.edu.rp.c346.id19020303.donghuatcm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button btnSignUp, btnSignIn;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.etName);
        password = (EditText)findViewById(R.id.etPassword);
        repassword = (EditText)findViewById(R.id.etREPassword);
        btnSignIn = (Button) findViewById(R.id.loginBtn);
        btnSignUp = (Button)findViewById(R.id.registerBtn);

        myDB = new DBHelper(MainActivity.this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("") || pass.equals("") || repass.equals("")){
                    Toast.makeText(MainActivity.this, "Please Fill in all the details", Toast.LENGTH_LONG).show();

                }

                else{

                    if(pass.equals(repass)){

                       Boolean userCheckResult = myDB.checkUsername(user);

                       if(userCheckResult == false){

                           Boolean regResult = myDB.insertData(user,pass);
                           if(regResult == true){
                               Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                               Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                               startActivity(intent);
                           }
                           else {
                               Toast.makeText(MainActivity.this, "Registration Unsuccessful", Toast.LENGTH_LONG).show();
                           }

                       }
                       else{
                           Toast.makeText(MainActivity.this, "User Already exist, please sign in", Toast.LENGTH_LONG).show();
                       }

                    }
                    else{
                        Toast.makeText(MainActivity.this, "Password did not match", Toast.LENGTH_LONG).show();
                    }

                }

            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}