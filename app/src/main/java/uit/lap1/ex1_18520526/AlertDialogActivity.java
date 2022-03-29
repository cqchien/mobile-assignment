package uit.lap1.ex1_18520526;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogActivity extends AppCompatActivity {
    EditText showEditText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_alert_dialog);
        showEditText = findViewById(R.id.editTextAlert);

        final AlertDialog alert = new AlertDialog.Builder(this).create();
        showEditText.setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                String message = showEditText.getText().toString();
                alert.setMessage(message);
                alert.show();
                return true;
            }
            return false;
        });

    }
}
