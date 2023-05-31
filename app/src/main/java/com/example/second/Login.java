package com.example.second;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText emailEditText, passwordEditText;
    Button loginBtn;
    TextView createAccountBtnTextView;
    TextView forgotPasswordBtnTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            emailEditText =findViewById(R.id.email);
            passwordEditText = findViewById(R.id.password);
            loginBtn = findViewById(R.id.btn_login);
            createAccountBtnTextView = findViewById(R.id.create_account_text_view_btn);
            forgotPasswordBtnTextView =findViewById(R.id.forgot_password);

            loginBtn.setOnClickListener((v) -> loginUser());
            createAccountBtnTextView.setOnClickListener((v)-> startActivities(new Intent[]{new Intent(Login.this, Sign_up.class)}));
            forgotPasswordBtnTextView.setOnClickListener(v-> startActivities(new Intent[]{new Intent(Login.this,Sign_up.class)}));


    }
    void loginUser(){
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        boolean isvalidated = validateData(email, password);
        if(!isvalidated){
            return;
        }
        loginAccountInFirebase(email, password);
   }
   void loginAccountInFirebase(String email, String password){
       FirebaseAuth firebaseAuth =FirebaseAuth.getInstance();
       firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()){
                   if(firebaseAuth.getCurrentUser().isEmailVerified()){
                       startActivity(new Intent(Login.this,MainActivity.class));

                   }else{
                        Utility.showToast(Login.this,"Email chưa được xác thực, vui lòng xác thực email !");
                   }
               }else {
                    Utility.showToast(Login.this, task.getException().getLocalizedMessage());
               }
           }
       });

   }
    boolean validateData(String email, String password){
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Email không đúng !");
            return false;
        }
        if(password.length()<6){
            passwordEditText.setError("Độ dài mật khẩu không đủ !");
            return false;
        }
        return true;
    }
}