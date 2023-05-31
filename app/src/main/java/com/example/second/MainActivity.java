package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDialog(View view) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_login_option);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.white_bg_rounded);

        //Dialog dialog = new Dialog(this);
        dialog.setTitle("Lựa chọn đăng nhập");
        dialog.setContentView(R.layout.dialog_login_option);
        // mapping
        Button employeeBtn = dialog.findViewById(R.id.dialog_employee_btn);
        Button managerBtn = dialog.findViewById(R.id.dialog_manager_btn);
        TextView option_tv = dialog.findViewById(R.id.dialog_option_tv);
        EditText code_edt = dialog.findViewById(R.id.dialog_code_edt);
        Button oke_btn = dialog.findViewById(R.id.dialog_ok_btn);

        employeeBtn.setOnClickListener(v->{
            option_tv.setText("Nhập mã xác thực nhân viên");
            option_tv.setVisibility(View.VISIBLE);
            oke_btn.setVisibility(View.VISIBLE);
            code_edt.setVisibility(View.VISIBLE);

        });
        managerBtn.setOnClickListener(v->{
            option_tv.setText("Nhập mã xác thực quản lý");
            option_tv.setVisibility(View.VISIBLE);
            oke_btn.setVisibility(View.VISIBLE);
            code_edt.setVisibility(View.VISIBLE);

        });
        oke_btn.setOnClickListener(view1 ->{
            String code_str = code_edt.getText().toString().trim();
            if(code_str.equals("nhanvien")){
                startActivity(new Intent(MainActivity.this, EmployeeSceen.class));
                Utility.showToast(MainActivity.this,"Đăng nhập thành công");
            }
            else {
                Utility.showToast(MainActivity.this,"Sai code xác thực, vui lòng thử lại");
            }
        });
        dialog.show();
    }
}