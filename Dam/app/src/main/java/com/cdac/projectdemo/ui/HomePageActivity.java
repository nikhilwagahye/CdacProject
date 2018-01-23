package com.cdac.projectdemo.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cdac.projectdemo.R;
import com.cdac.projectdemo.Utils.NetworkUtil;
import com.cdac.projectdemo.Utils.SharedPreferenceManager;
import com.cdac.projectdemo.model.User;
import com.cdac.projectdemo.ui.fragments.HomeFragment;
import com.cdac.projectdemo.ui.fragments.OrdersFragment;

import java.util.prefs.Preferences;

public class HomePageActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView toolBarHomePageTitle;
    private TextView textViewUserName;
    private TextView textViewEmailId;
    private FragmentManager fragManager;
    private LinearLayout linearLayoutEdit;
    private LinearLayout linearLayoutShoppingCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);




        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        toolBarHomePageTitle = (TextView) findViewById(R.id.toolBarHomePageTitle);

        // for navigation view
        SharedPreferenceManager.setApplicationContext(HomePageActivity.this);
        User user = SharedPreferenceManager.getUserObjectFromSharedPreference();

        View headerLayout = navigationView.getHeaderView(0);

        textViewUserName = (TextView) headerLayout.findViewById(R.id.textViewUserName);
        textViewEmailId = (TextView) headerLayout.findViewById(R.id.textViewEmailId);

        linearLayoutEdit = (LinearLayout) headerLayout.findViewById(R.id.linearLayoutEdit);
        linearLayoutEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, EditUserDetailsActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        linearLayoutShoppingCart = (LinearLayout) findViewById(R.id.linearLayoutShoppingCart);
        linearLayoutShoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NetworkUtil.isConnectionAvailable(HomePageActivity.this)) {
                    Intent intent = new Intent(HomePageActivity.this, CartActivity.class);
                    startActivity(intent);
                } else {
                Toast.makeText(HomePageActivity.this, getString(R.string.no_internet_message), Toast.LENGTH_SHORT).show();
            }
            }
        });

        Menu menu = navigationView.getMenu();

        MenuItem navigationLogout = menu.findItem(R.id.navigationLogout);

        if (user != null) {
            textViewEmailId.setVisibility(View.VISIBLE);
            textViewUserName.setText(user.getFirstName() + " " + user.getLastName());
            textViewEmailId.setText(user.getEmailId());
            linearLayoutEdit.setVisibility(View.VISIBLE);
            navigationLogout.setVisible(true);
        } else {
            textViewEmailId.setVisibility(View.INVISIBLE);
            linearLayoutEdit.setVisibility(View.GONE);

            textViewUserName.setText("Welcome, Guest");
            navigationLogout.setVisible(false);

        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.navigationHomeItem:
                        // HomeFragment fragment = new HomeFragment();
                        fragManager.beginTransaction().replace(R.id.dash_board_container, new HomeFragment()).commit();
                        break;

                    case R.id.navigationYourOrders:
                        fragManager.beginTransaction().replace(R.id.dash_board_container, new OrdersFragment()).commit();
                        break;


                    case R.id.navigationYourAccount:
                        fragManager.beginTransaction().replace(R.id.dash_board_container, new HomeFragment()).commit();
                        break;
                    case R.id.navigationUserAddress:
                        fragManager.beginTransaction().replace(R.id.dash_board_container, new HomeFragment()).commit();
                        break;

                    case R.id.navigationLogout:
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomePageActivity.this);
                        // Setting Dialog Title
                        alertDialog.setTitle("Logout");
                        // Setting Dialog Message
                        alertDialog.setMessage("Are you sure you want to logout?");
                        // Setting Icon to Dialog
                        // Setting Positive "Yes" Button
                        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int which) {
                                SharedPreferenceManager.clearPreferences();
                                Intent intent = new Intent(HomePageActivity.this, LandingPageActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        });
                        // Setting Negative "NO" Button
                        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        // Showing Alert Message
                        alertDialog.show();

                        break;
                }
                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        fragManager = getSupportFragmentManager();
        fragManager.beginTransaction().replace(R.id.dash_board_container, new HomeFragment()).commit();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
                if (result.equalsIgnoreCase("SUCCESS")) {
                    User user = SharedPreferenceManager.getUserObjectFromSharedPreference();
                    textViewEmailId.setVisibility(View.VISIBLE);
                    textViewUserName.setText(user.getFirstName() + " " + user.getLastName());
                    textViewEmailId.setText(user.getEmailId());
                }
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }
}
