package bcs.mamun.com.days;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import bcs.mamun.com.days.Model.daysItem;

public class TestActivity extends AppCompatActivity {
    Button dayB, dataB;
    final Context context = this;
    Dialog dialog;
    TextView text;
    int num;

    private List<daysItem> tempList = MainActivity.list;
    Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        dayB = (Button) findViewById(R.id.buttonDay);
        dataB = (Button) findViewById(R.id.buttonData);

        dataB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom_layout);

                text = (TextView) dialog.findViewById(R.id.textViewData);
                dialog.setTitle("Answer Plz...");

                newData();

                Button closeButton = (Button) dialog.findViewById(R.id.buttonClose);
                Button nextButton = (Button) dialog.findViewById(R.id.buttonNext);
                Button ansButton = (Button) dialog.findViewById(R.id.buttonAns);

                ansButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog alertDialog = new AlertDialog.Builder(TestActivity.this).create();
                        alertDialog.setTitle("Answer");
                        alertDialog.setMessage(String.valueOf(tempList.get(num).getDate()));
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                });

                nextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        newData();

                    }
                });
                
                // if button is clicked, close the custom dialog
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    private void newData() {
        num = rand.nextInt(tempList.size());
        text.setText(String.valueOf(tempList.get(num).getData()));


    }
}
