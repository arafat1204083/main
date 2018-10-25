package bcs.mamun.com.days;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import bcs.mamun.com.days.Adapter.DictionaryLoader;
import bcs.mamun.com.days.Adapter.LiteData;
import bcs.mamun.com.days.Model.eItem;

public class Literature extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
static ArrayList<eItem> listLite = new ArrayList<>();
static String[] writersList = new String[131];
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_literature);

        InputStream inputStream = getResources().openRawResource(R.raw.eliterature);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        LiteData ld = new LiteData();
        listLite = ld.loadData(bufferedReader);

        for(int i = 0; i<listLite.size();i++){
            writersList[i] = listLite.get(i).getWriter();
        }
        Arrays.sort(writersList);
        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.spinner);
        lv = findViewById(R.id.listView);
//create a list of items for the spinner.

//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, writersList);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);
    }
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        Toast.makeText(this,parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

        String writerName = parent.getSelectedItem().toString();
        String writes = null;
        int i;
        for(i=0; i<listLite.size(); i++){
            if(writerName.trim().equals(listLite.get(i).getWriter().trim())){
                writes = listLite.get(i).getWrites();
                break;
            }
        }
        if(i==listLite.size()){
            writes = "A;B;C;D";
        }
        String writess[] = writes.split(";");
        ArrayAdapter<String> adapterListView = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, writess);
        lv.setAdapter(adapterListView);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_literature, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exam) {
            Intent in = new Intent(Literature.this, TestLay.class);
            startActivity(in);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
