package grocery.gohool.loginnregister;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView id,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (TextView) findViewById(R.id.id);
        password = (TextView) findViewById(R.id.password);
        Intent intent = getIntent();
        String userId = intent.getStringExtra("userID");
        String userPass = intent.getStringExtra("userPass");
        id.setText(userId);
        password.setText(userPass);


    }
}