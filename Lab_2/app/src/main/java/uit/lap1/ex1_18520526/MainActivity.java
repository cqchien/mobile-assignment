package uit.lap1.ex1_18520526;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCallPhone, btnCurrentTime, btnAlertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CallLayout();
        EventListen();
    }
    public void CallLayout(){
        btnCallPhone = findViewById(R.id.btnCallPhone);
        btnCurrentTime = findViewById(R.id.btnCurrentTime);
        btnAlertDialog = findViewById(R.id.btnAlertDialog);
    }
    public void EventListen(){
        btnCallPhone.setOnClickListener((View view) -> CallPhoneAt());
        btnCurrentTime.setOnClickListener((View view) -> CurrentTimeAt());
        btnAlertDialog.setOnClickListener((View view) -> ShowAlertDialogAt());
    }
    private void CallPhoneAt(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, CallPhoneActivity.class);
        startActivity(intent);
    }
    private void CurrentTimeAt(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, CurrentTimeActivity.class);
        startActivity(intent);
    }
    private void ShowAlertDialogAt(){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, AlertDialogActivity.class);
        startActivity(intent);
    }
}