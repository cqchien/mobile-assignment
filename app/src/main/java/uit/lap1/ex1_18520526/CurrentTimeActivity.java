package uit.lap1.ex1_18520526;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class CurrentTimeActivity extends AppCompatActivity {
    Button btnShowTime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_time);
        btnShowTime = findViewById(R.id.btnCurrentTime);
        btnShowTime.setOnClickListener((View view) -> ShowCurrentTime());
    }
    private void ShowCurrentTime(){
        AlertDialog alert = new AlertDialog.Builder(this).create();
        Date time = new Date();
        String message = "Current time : " + time;
        alert.setMessage(message);
        alert.show();
    }
}
