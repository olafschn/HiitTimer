package com.example.olaf.hiittimer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;


public class SetTimerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_timer);


        final NumberPicker warmUpMinPicker = (NumberPicker) findViewById(R.id.warmUpMinPicker);
        warmUpMinPicker.setMaxValue(59);
        warmUpMinPicker.setMinValue(0);
        warmUpMinPicker.setValue(0);

        final NumberPicker warmUpSecPicker = (NumberPicker) findViewById(R.id.warmUpSecPicker);
        warmUpSecPicker.setMaxValue(59);
        warmUpSecPicker.setMinValue(0);
        warmUpSecPicker.setValue(0);

        final NumberPicker coolDownMinPicker = (NumberPicker) findViewById(R.id.coolDownMinPicker);
        coolDownMinPicker.setMaxValue(59);
        coolDownMinPicker.setMinValue(0);
        coolDownMinPicker.setValue(0);

        final NumberPicker coolDownSecPicker = (NumberPicker) findViewById(R.id.coolDownSecPicker);
        coolDownSecPicker.setMaxValue(59);
        coolDownSecPicker.setMinValue(0);
        coolDownSecPicker.setValue(0);

        final NumberPicker workMinPicker = (NumberPicker) findViewById(R.id.workMinPicker);
        workMinPicker.setMaxValue(59);
        workMinPicker.setMinValue(0);
        workMinPicker.setValue(0);

        final NumberPicker workSecPicker = (NumberPicker) findViewById(R.id.workSecPicker);
        workSecPicker.setMaxValue(59);
        workSecPicker.setMinValue(0);
        workSecPicker.setValue(0);

        final NumberPicker restMinPicker = (NumberPicker) findViewById(R.id.restMinPicker);
        restMinPicker.setMaxValue(59);
        restMinPicker.setMinValue(0);
        restMinPicker.setValue(0);

        final NumberPicker restSecPicker = (NumberPicker) findViewById(R.id.restSecPicker);
        restSecPicker.setMaxValue(59);
        restSecPicker.setMinValue(0);
        restSecPicker.setValue(0);
        restMinPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                calculateTotalTime();
            }
        });

        final NumberPicker repCountPicker = (NumberPicker) findViewById(R.id.repCountPicker);
        repCountPicker.setMaxValue(100);
        repCountPicker.setMinValue(0);
        repCountPicker.setValue(1);

    }

    private void calculateTotalTime() {
        final NumberPicker restMinPicker = (NumberPicker) findViewById(R.id.restMinPicker);
        final NumberPicker restSecPicker = (NumberPicker) findViewById(R.id.restSecPicker);


        Integer total = new Integer(restMinPicker.getValue());

        final EditText totalTime = (EditText) findViewById(R.id.totalTime);
        totalTime.setText(total.toString());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.set_timer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
