package in.co.onetwork.obill;

import android.content.Intent;
import android.opengl.EGLDisplay;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText ed1,ed2;
    String email,password;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth=FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser()!=null){
            Toast.makeText(this, "Already Signed in.", Toast.LENGTH_SHORT).show();
        }
        setContentView(R.layout.activity_login);
        ed1=(EditText)findViewById(R.id.email);
        ed2=(EditText)findViewById(R.id.passw);
    }
    public void login(View v){
        email=ed1.getText().toString();
        password=ed2.getText().toString();
        if(email.equals("")||password.equals("")){
            Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Login.this, "Signed in Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this,Homescreen.class));
                    }else{
                        Toast.makeText(Login.this, "Signin error!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    public void signup(View v){
        startActivity(new Intent(Login.this,Signup.class));
    }
}
