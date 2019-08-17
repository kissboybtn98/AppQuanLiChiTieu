package com.example.develop.appquanlichitieu;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.develop.appquanlichitieu.Fragment.ChiFragment;
import com.example.develop.appquanlichitieu.Fragment.GioiThieuFragment;
import com.example.develop.appquanlichitieu.Fragment.NapTienVaoTaiKhoanFragment;
import com.example.develop.appquanlichitieu.Fragment.ThonKeFragment;
import com.example.develop.appquanlichitieu.Fragment.ThuFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FragmentManager fragmentManager;
    TextView txtFulllname;
    TextView txtGetTiltle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtGetTiltle=findViewById(R.id.txt_toolbar_til);
        drawerLayout = (DrawerLayout) findViewById(R.id.Drawerlayout);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        toolbar = (Toolbar) findViewById(R.id.mToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);//ba lằng;
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.mo, R.string.dong) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        navigationView.setNavigationItemSelectedListener(this);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView.setItemIconTintList(null);

        fragmentManager = getSupportFragmentManager();

        FragmentTransaction tranHienThiThongke = fragmentManager.beginTransaction();//
        ThonKeFragment hienThiThonke = new ThonKeFragment();
        tranHienThiThongke.replace(R.id.content, hienThiThonke);
        tranHienThiThongke.commit();
        setTitle("Quản Lý Thu Chi");
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

            if (id == R.id.nav_ThongKe){

                FragmentTransaction tranHienThiThongke = fragmentManager.beginTransaction();//
                ThonKeFragment hienThiThonke = new ThonKeFragment();
                tranHienThiThongke.replace(R.id.content, hienThiThonke);
                tranHienThiThongke.commit();
                setTitle("Thống Kê");
                item.setChecked(true);
                drawerLayout.closeDrawers();

            }else if (id == R.id.nav_KhoangThu) {
                FragmentTransaction tranHienThiThu = fragmentManager.beginTransaction();//
                ThuFragment hienThithu = new ThuFragment();
                tranHienThiThu.replace(R.id.content, hienThithu);
                tranHienThiThu.commit();
                setTitle("Khoảng Thu");
                item.setChecked(true);
                drawerLayout.closeDrawers();
            }else if (id == R.id.nav_KhoangChi) {
                FragmentTransaction tranHienThiChi = fragmentManager.beginTransaction();//
                ChiFragment hienThichi = new ChiFragment();
                tranHienThiChi.replace(R.id.content, hienThichi);
                tranHienThiChi.commit();
                setTitle("Khoảng Chi");
                item.setChecked(true);
                drawerLayout.closeDrawers();
            }else if (id == R.id.nav_TaiKhoan) {
                FragmentTransaction tranHienTaiKhoan = fragmentManager.beginTransaction();//

                NapTienVaoTaiKhoanFragment hienThiTaiKhoan = new NapTienVaoTaiKhoanFragment();
                tranHienTaiKhoan.replace(R.id.content, hienThiTaiKhoan);
                tranHienTaiKhoan.commit();
                setTitle("Quản Lí Tài Khoản");
                item.setChecked(true);
                drawerLayout.closeDrawers();
            }else if (id == R.id.nav_gioithieu) {
                FragmentTransaction tranHienGioiThieu = fragmentManager.beginTransaction();//

                GioiThieuFragment hienThiGioiThieu = new GioiThieuFragment();
                tranHienGioiThieu.replace(R.id.content, hienThiGioiThieu);
                tranHienGioiThieu.commit();
                setTitle("Giới Thiệu");
                item.setChecked(true);
                drawerLayout.closeDrawers();
            }else if (id == R.id.nav_thoat) {

                Context context;
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Bạn có chắc muốn thoát ?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();


        }

        return true;
    }

}
