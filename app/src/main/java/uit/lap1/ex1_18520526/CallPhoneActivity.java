package uit.lap1.ex1_18520526;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


public class CallPhoneActivity extends AppCompatActivity {
    EditText enterNumber;
    private static int REQUEST_CALL = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);
        enterNumber = findViewById(R.id.editTextPhone);
        Button imageCall = findViewById(R.id.btn_call);
        imageCall.setOnClickListener((View view)-> callPhoneActivity());
    }
    private void callPhoneActivity() {
        String number = enterNumber.getText().toString();
        if(number.trim().length() > 0) {
            if(ContextCompat.checkSelfPermission(CallPhoneActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(CallPhoneActivity.this, new String[]{Manifest.permission.CALL_PHONE }, REQUEST_CALL);
            } else {
                String detail = "tel:" + number;
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(detail));
                startActivity(intent);
            }
        } else {
            Toast.makeText(CallPhoneActivity.this, "Please,enter phone number", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhoneActivity();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
