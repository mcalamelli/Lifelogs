package net.mcalamelli.lifelogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    //private Button button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button_login;

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        button_login = findViewById(R.id.button_login);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
