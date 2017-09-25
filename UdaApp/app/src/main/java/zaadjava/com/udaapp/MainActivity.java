package zaadjava.com.udaapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button mLogin;
    EditText mEmail,mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = (EditText) findViewById(R.id.tEmail);
        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               /* if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mEmail.getText().toString()).matches()){
                    mEmail.setHintTextColor(Color.RED);
                    mEmail.setError("Please enter a valid email.");
                }*/
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mEmail.getText().toString()).matches()){
                    mEmail.setHintTextColor(Color.RED);
                    mEmail.setError("Please enter a valid email.");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
               /* if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mEmail.getText().toString()).matches()){
                    mEmail.setHintTextColor(Color.RED);
                    mEmail.setError("Please enter a valid email.");
                }*/
            }
        });

    }


}
