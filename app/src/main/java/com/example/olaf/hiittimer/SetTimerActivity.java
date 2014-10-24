package com.example.olaf.hiittimer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.NumberPicker;
import android.widget.TextView;

/**
 * Activity to set the HIIT Timer. Once the the intervals are set the user can
 * launch the CountDownActivity.
 *
 * @author olaf
 * @version "%l%G%"
 */
public class SetTimerActivity extends Activity {

    private NumberPicker warmUpMinPicker;
    private NumberPicker warmUpSecPicker;
    private NumberPicker coolDownMinPicker;
    private NumberPicker coolDownSecPicker;
    private NumberPicker workMinPicker;
    private NumberPicker workSecPicker;
    private NumberPicker restMinPicker;
    private NumberPicker restSecPicker;
    private NumberPicker repCountPicker;
    private TextView totalTextView;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_timer);

        warmUpMinPicker = (NumberPicker) findViewById(R.id.warmUpMinPicker);
        warmUpMinPicker.setMaxValue(59);
        warmUpMinPicker.setMinValue(0);
        warmUpMinPicker.setValue(0);
        warmUpMinPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                calculateTotalTime();
            }
        });


        warmUpSecPicker = (NumberPicker) findViewById(R.id.warmUpSecPicker);
        warmUpSecPicker.setMaxValue(59);
        warmUpSecPicker.setMinValue(0);
        warmUpSecPicker.setValue(0);
        warmUpSecPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                calculateTotalTime();
            }
        });

        coolDownMinPicker = (NumberPicker) findViewById(R.id.coolDownMinPicker);
        coolDownMinPicker.setMaxValue(59);
        coolDownMinPicker.setMinValue(0);
        coolDownMinPicker.setValue(0);
        coolDownMinPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                calculateTotalTime();
            }
        });

        coolDownSecPicker = (NumberPicker) findViewById(R.id.coolDownSecPicker);
        coolDownSecPicker.setMaxValue(59);
        coolDownSecPicker.setMinValue(0);
        coolDownSecPicker.setValue(0);
        coolDownSecPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                calculateTotalTime();
            }
        });

        workMinPicker = (NumberPicker) findViewById(R.id.workMinPicker);
        workMinPicker.setMaxValue(59);
        workMinPicker.setMinValue(0);
        workMinPicker.setValue(0);
        workMinPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                calculateTotalTime();
            }
        });

        workSecPicker = (NumberPicker) findViewById(R.id.workSecPicker);
        workSecPicker.setMaxValue(59);
        workSecPicker.setMinValue(0);
        workSecPicker.setValue(0);
        workSecPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                calculateTotalTime();
            }
        });

        restMinPicker = (NumberPicker) findViewById(R.id.restMinPicker);
        restMinPicker.setMaxValue(59);
        restMinPicker.setMinValue(0);
        restMinPicker.setValue(0);
        restMinPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                calculateTotalTime();
            }
        });

        restSecPicker = (NumberPicker) findViewById(R.id.restSecPicker);
        restSecPicker.setMaxValue(59);
        restSecPicker.setMinValue(0);
        restSecPicker.setValue(0);
        restSecPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                calculateTotalTime();
            }
        });

        repCountPicker = (NumberPicker) findViewById(R.id.repCountPicker);
        repCountPicker.setMaxValue(100);
        repCountPicker.setMinValue(0);
        repCountPicker.setValue(1);
        repCountPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                calculateTotalTime();
            }
        });

    }

    /**
     * Calculates the total interval time which is
     * totalTime = warmUp + reps*(work+rest) + coolDown
     */
    private void calculateTotalTime() {


        int warmUpMin = 60 * warmUpMinPicker.getValue();
        int warmUpSec = warmUpSecPicker.getValue();
        int totalWarmUpInSec = warmUpMin + warmUpSec;

        int coolDownMin = 60 * coolDownMinPicker.getValue();
        int coolDownSec = coolDownSecPicker.getValue();
        int totalCoolDownInSec = coolDownMin + coolDownSec;

        int workMin = 60 * workMinPicker.getValue();
        int workSec = workSecPicker.getValue();
        int totalWork = workMin + workSec;

        int restMin = 60 * restMinPicker.getValue();
        int restSec = restSecPicker.getValue();
        int totalRest = restMin + restSec;

        int numOfReps = repCountPicker.getValue();

        int totalTime = totalWarmUpInSec + totalCoolDownInSec + numOfReps * (totalWork + totalRest);

        Integer totalTimeMin = totalTime / 60;
        Integer totalTimeSec = totalTime % 60;

        totalTextView = (TextView) findViewById(R.id.totalTextView);
        totalTextView.setText(String.format("Total: %d : %02d", totalTimeMin, totalTimeSec));

    }

    private void resetTimer() {
        warmUpMinPicker.setValue(0);
        warmUpSecPicker.setValue(0);
        coolDownMinPicker.setValue(0);

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
        if (id == R.id.action_settings) return true;
        return super.onOptionsItemSelected(item);
    }
}
