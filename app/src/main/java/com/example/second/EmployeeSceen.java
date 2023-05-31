package com.example.second;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.second.databinding.ActivityEmployeescennnBinding;
import com.google.android.material.navigation.NavigationView;

public class EmployeeSceen extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
private ActivityEmployeescennnBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityEmployeescennnBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        //Tiêu đề toolbar
        setSupportActionBar(binding.appBarEmployeescennn.toolbar);

        //Thông báo của floatingactionbutton
//        binding.appBarEmployeescennn.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Mày muốn thêm gì !", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_nguyen_lieu, R.id.nav_san_pham, R.id.nav_khach_hang,R.id.nav_my_profile,R.id.nav_change_password,R.id.nav_logout)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_employeescennn);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.employeescennn, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_employeescennn);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_vietnam) {
            Intent intent = new Intent(EmployeeSceen.this, Login.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_english) {
            Intent intent = new Intent(EmployeeSceen.this, Login.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_logout) {
            Intent intent = new Intent(EmployeeSceen.this, Login.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_my_profile) {
            Intent intent = new Intent(this, MyProfile.class);
            startActivity(intent);
        }
         else if (id == R.id.nav_change_password) {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_logout) {
            AlertDialog.Builder b=new AlertDialog.Builder(EmployeeSceen.this);
            b.setTitle("Đăng Xuất");
            b.setMessage("Bạn có muốn đăng xuất?");
            b.setIcon(R.drawable.ic_logout);
            b.setPositiveButton("Yes", new DialogInterface. OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    OpenLogin();
                    finish();
                }});
            b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    dialog.cancel();
                }
            });
            b.create().show();
        } else {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void OpenLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}