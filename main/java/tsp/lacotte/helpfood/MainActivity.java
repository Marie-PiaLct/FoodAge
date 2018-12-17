package tsp.lacotte.helpfood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Button b = (Button) findViewById(R.id.buttong);
            b.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Spinner sage = (Spinner) findViewById(R.id.spinner_age);
                    Spinner stype = (Spinner) findViewById(R.id.spinner_type);
                    Spinner soccasion = (Spinner) findViewById(R.id.spinner_occasion);
                    Toast.makeText(view.getContext(), "Go !", Toast.LENGTH_SHORT).show();
                    Intent preActvity = new Intent(MainActivity.this, Activity2.class);
                    preActvity.putExtra("age", sage.getSelectedItem().toString());
                    preActvity.putExtra("type", stype.getSelectedItem().toString());
                    preActvity.putExtra("occasion", soccasion.getSelectedItem().toString());
                    startActivity(preActvity);
                }
            });
        Button search = (Button) findViewById(R.id.buttonsearch);
        final EditText eText = (EditText) findViewById(R.id.EditText1);
        search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = eText.getText().toString();
                Intent searchActvity = new Intent(MainActivity.this, Search.class);
                searchActvity.putExtra("recherche", str);
                startActivity(searchActvity);

            }
        });
        Button pref = (Button) findViewById(R.id.buttonpref);
        pref.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prefActvity = new Intent(MainActivity.this, PreferenceActivitytest.class);
                startActivity(prefActvity);

            }
        });


        }
    }


