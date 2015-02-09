package com.trascope.goodsclearanceclub;

import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Membership extends ActionBarActivity{
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerListener;
    private ListView listView;
    private String [] gccSideBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership);

        gccSideBar = getResources().getStringArray(R.array.GCC_sideBar);
        listView = (ListView) findViewById(R.id.drawerList);
        listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,
                gccSideBar));
        //listView.setOnClickListener((View.OnClickListener) this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplication(),gccSideBar[position],Toast.LENGTH_LONG).show();
                getSupportActionBar().setTitle(gccSideBar[position]);
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerListener = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(getApplicationContext(), "Drawer is opened", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(getApplicationContext(),"Drawer is closed",Toast.LENGTH_LONG).show();
            }
        };
        drawerLayout.setDrawerListener(drawerListener);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerListener.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerListener.onOptionsItemSelected(item)){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerListener.syncState();
    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),gccSideBar[position],Toast.LENGTH_LONG).show();
        selectItem(position);
    }

    public void selectItem(int item) {
        listView.setItemChecked(item, true);
        setTitle(gccSideBar[item]);
    }

    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
