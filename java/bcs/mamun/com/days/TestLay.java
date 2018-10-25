package bcs.mamun.com.days;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import bcs.mamun.com.days.Model.eItem;

public class TestLay extends AppCompatActivity {
AutoCompleteTextView aText;
TextView tv;
Button ans, nxt;
ArrayList<eItem> allData;
String AS[],Ans;
Random ran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_lay);

        aText = findViewById(R.id.autoCompleteTextView);
        tv = findViewById(R.id.textViewQs);
        ans = findViewById(R.id.ansButton);
        nxt = findViewById(R.id.nextButton);

        ran = new Random();

        allData = Literature.listLite;
        AS = Literature.writersList;

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, AS );

        aText.setThreshold(2);
        aText.setAdapter(adapter);

        qsGenerate();


        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                andDialog();
                qsGenerate();
            }
        });

ans.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        andDialog();
    }
});

    }

    private void andDialog() {
        final AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(TestLay.this);

// Setting Dialog Title
        alertDialog2.setTitle("Answer");

// Setting Dialog Message
        alertDialog2.setMessage(Ans);

// Setting Icon to Dialog

// Setting Positive "Yes" Btn
        alertDialog2.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                        dialog.dismiss();
                    }
                });

// Showing Alert Dialog
        alertDialog2.show();
    }

    private void qsGenerate() {
        int N = ran.nextInt(allData.size());

        String S = allData.get(N).getWrites();
        Ans = allData.get(N).getWriter();

        String SS[] = S.split(";");

        int NN = ran.nextInt(SS.length);

        String QS = SS[NN];


        tv.setText(QS);
    }
}
