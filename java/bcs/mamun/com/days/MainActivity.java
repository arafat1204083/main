package bcs.mamun.com.days;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import bcs.mamun.com.days.Adapter.DictionaryLoader;
import bcs.mamun.com.days.Model.daysItem;

public class MainActivity extends AppCompatActivity {
Button test, eLite;
public static ArrayList<daysItem> list;
public enum months {January, February, March, April, May, June, July, August, September, October, November, December;};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = new ArrayList<daysItem>();

        InputStream inputStream = getResources().openRawResource(R.raw.days);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        DictionaryLoader dl = new DictionaryLoader();
        list = dl.loadData(bufferedReader);


        test = (Button) findViewById(R.id.testButton);
        eLite = (Button) findViewById(R.id.buttonLite);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, ""+IDGenerator("2 April"), Toast.LENGTH_SHORT).show();
                Intent in = new Intent(MainActivity.this, TestActivity.class);
                startActivity(in);
            }
        });

        eLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, Literature.class);
                startActivity(in);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, DictionaryLoader.st , Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


}
