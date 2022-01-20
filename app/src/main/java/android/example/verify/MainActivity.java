package android.example.verify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText email,pass;
    Button loginadmin;
    Button loginemp;
     FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        pass =findViewById(R.id.pass);
        loginadmin = findViewById(R.id.LoginAdmin);
        loginemp = findViewById(R.id.emplogin);





        loginadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gotemail = email.getText().toString();
                String gotpass = pass.getText().toString();

                mAuth.signInWithEmailAndPassword(gotemail,gotpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful())
                      {
                          Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                          Intent i = new Intent(MainActivity.this,AdminActivity.class);
                          startActivity(i);

                      }
                      else{
                          Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                      }
                    }
                });


            }
        });



        loginemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String empemail = email.getText().toString();
                String emppass = pass.getText().toString();

                mAuth.signInWithEmailAndPassword(empemail,emppass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this, " Emp Login Successfully", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this,EmpLogin.class);
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(MainActivity.this, " Emp login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });






    }
}