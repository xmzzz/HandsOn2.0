package com.xmz.handson20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.xmz.handson20.data.memory.MemoryDatabaseNameFactory;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void newStart(View view) {
        deleteDatabase(MemoryDatabaseNameFactory.getDefaultDatabaseName());
        initData();
        Intent intent = new Intent(this, DeviceConnectActivity.class);
        startActivity(intent);
    }

    public void continueStart(View view) {
        Intent intent = new Intent(this, DeviceConnectActivity.class);
        startActivity(intent);
    }

    public void loadMemory(View view) {
        LoadMemoryDialog loadMemoryDialog = new LoadMemoryDialog();
        loadMemoryDialog.show(getSupportFragmentManager(), "loadMemory");
    }

    public void help(View view) {

    }

    private void initData() {
        DeviceDescriptionLocalSource.getInstance(this).initData();
        DeviceSocketLocalSource.getInstance(this).initData();
    }
}
