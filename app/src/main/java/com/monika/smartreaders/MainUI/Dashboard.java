package com.monika.smartreaders.MainUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.ColorInt;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.monika.smartreaders.DrawerAdapter;
import com.monika.smartreaders.MainUI.fragments.Home;
import com.monika.smartreaders.MainUI.fragments.Main_Dashboard;
import com.monika.smartreaders.MainUI.fragments.MyProfile;
import com.monika.smartreaders.MainUI.fragments.UserSettings;
import com.monika.smartreaders.MsAuthPage;
import com.monika.smartreaders.R;

import java.util.Arrays;

import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;


public class Dashboard extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener,UserSettings.Callbacks {

    private static final int POS_CLOSE = 1;
    private static final int POS_DASHBOARD = 3;
    private static final int POS_MY_PROFILE = 4;
    private static final int POS_SETTING = 5;
    private static final int POS_LOGOUT = 7;
    private static final String TAG = "Dashboard";
    private final FragmentManager fm= getSupportFragmentManager();
    private String username;


    public String[] screenTitles;
    private Drawable[] screenIcons;
    private SlidingRootNav mSlidingRootNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        setContentView(R.layout.activity_dashboard);

        username=getIntent().getStringExtra("name");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSlidingRootNav = new SlidingRootNavBuilder(this)
                .withRootViewScale(0.75f)
                .withRootViewElevation(50)
                .withDragDistance(200)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.drawer_menu)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                new SpaceItem(20),
                createItem(POS_CLOSE),
                new SpaceItem(100),
                createItem(POS_DASHBOARD).setChecked(true),
                createItem(POS_MY_PROFILE),
                createItem(POS_SETTING),
                new SpaceItem(200),
                createItem(POS_LOGOUT)

        ));
        adapter.setListener(this);

        RecyclerView list = findViewById(R.id.drawer_list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_DASHBOARD);
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.id_activityScreenTitles);
    }

    @SuppressLint("ResourceAsColor")
    private DrawerItem createItem(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconInt(color(R.color.white))
                .withTextInt(color(R.color.white))
                .withSelectedIconInt(color(R.color.black))
                .withSelectedTextInt(color(R.color.black));

    }

    @SuppressLint("ResourceType")
    @ColorInt
    private int color(@ColorInt int res) {
        return ContextCompat.getColor(this, res);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray typedArray = getResources().obtainTypedArray(R.array.id_activityScreenIcons);
        Drawable[] icons = new Drawable[typedArray.length()];

        for (int i = 0; i < typedArray.length(); i++) {
            int id = typedArray.getResourceId(i, -1);
            if (id != -1) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        typedArray.recycle();
        return icons;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mSlidingRootNav.closeMenu();
    }
    /*@Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }*/

    @Override
    protected void onNightModeChanged(int mode) {
        super.onNightModeChanged(mode);
    }

    @Override
    public void onItemSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //System.out.println(position);
        switch (position) {
            case POS_DASHBOARD:
                Main_Dashboard dashBoard = new Main_Dashboard();
                transaction.replace(R.id.container, dashBoard);
                break;
            case POS_CLOSE:
                break;
            case POS_MY_PROFILE:
                MyProfile myProfile = new MyProfile();
                transaction.replace(R.id.container, myProfile);
                break;
            case POS_SETTING:
                UserSettings settings = new UserSettings();
                transaction.replace(R.id.container, settings);
                break;
            case POS_LOGOUT:
                Intent i = new Intent(this, MsAuthPage.class);
                i.putExtra("signoutinfo","signoutasap");
                startActivity(i);
                finish();
                break;
            default:
                Home home = new Home();
                transaction.replace(R.id.container, home);
        }
        mSlidingRootNav.closeMenu();
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public String getData(){
        return username;
    }













    @Override
    public void onReplaceFragment(@IdRes Integer fragmentId) {
        switch (fragmentId){
            case R.id.profile:
                MyProfile myProfile = new MyProfile();
                fm.beginTransaction().replace(R.id.container,myProfile).addToBackStack(null).commit();
        }

    }
}
