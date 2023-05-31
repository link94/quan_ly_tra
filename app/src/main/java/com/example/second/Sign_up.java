package com.example.second;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Sign_up extends AppCompatActivity {
    EditText emailEditText, passwordEditText,confirmPasswordEditText;
    Button createAccountBtn;
    TextView loginBtnTextView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        confirmPasswordEditText = findViewById(R.id.confirm_password);
        createAccountBtn = findViewById(R.id.btn_create_account);
        loginBtnTextView = findViewById(R.id.login_button_textview);

        createAccountBtn.setOnClickListener(v->createAccount());
        loginBtnTextView.setOnClickListener(v->finish());



    }
    void createAccount(){
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();

        boolean isvalidated = validateData(email, password, confirmPassword);
        if(!isvalidated){
            return;
        }
        createAccountInFirebase(email, password);

    }

    void createAccountInFirebase(String email, String password) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Sign_up.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Utility.showToast(Sign_up.this,"Tạo tài khoản thành công, kiểm tra email để xác thực !");
                    firebaseAuth.getCurrentUser().sendEmailVerification();
                    firebaseAuth.signOut();
                    finish();
                }else {
                    Utility.showToast(Sign_up.this,task.getException().getLocalizedMessage());
                }
            }
        });

    }

    boolean validateData(String email, String password, String confirmPassword){
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Email không đúng !");
            return false;
        }
        if(password.length()<6){
            passwordEditText.setError("Độ dài mật khẩu không đủ !");
            return false;
        }
        if(!password.equals((confirmPassword))){
            confirmPasswordEditText.setError("Mật khẩu không trùng");
            return false;
        }
        return true;
    }
}