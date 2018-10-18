package com.sanmen.bluesky.doubletimepicker.ui.activity;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sanmen.bluesky.doubletimepicker.R;
import com.sanmen.bluesky.timepicker.widget.DoubleTimeSelectDialog;

public class MainActivity extends AppCompatActivity {

    Button btnDialog;

    DoubleTimeSelectDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
    }

    private void initLayout() {

        btnDialog = findViewById(R.id.button);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDoubleTimePicker();
            }
        });
        //设置最大进度
        //        roundProgressView.setMaxProgress(80);
        //        roundProgressView.setBaseUnit("fen");
        //        roundProgressView.setBorderWidth(16);
        //        roundProgressView.setTextSize(16);
        //        roundProgressView.setBorderColor(Color.BLUE);
        //        roundProgressView.setStartPosition(RoundProgressView.LEFT);

    }

    private void showDoubleTimePicker() {
        if (dialog==null){
            dialog=new DoubleTimeSelectDialog(this,"","","08:00","09:00");
            dialog.setType(DoubleTimeSelectDialog.TYPE.YEAR_MONTH_DATE);
            dialog.setOnDateSelectFinished(new DoubleTimeSelectDialog.OnDateSelectFinished() {
                @Override
                public void onSelectFinished(String startTime, String endTime) {

                }
            });

            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface d) {
                    dialog=null;
                }
            });

            if (!dialog.isShowing()) {
                dialog.show();
            }
        }
    }
}
