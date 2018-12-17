package tsp.lacotte.helpfood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Search  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preactivity2);
        AsyncTask2 task = new AsyncTask2(Search.this);
        String recherche = getIntent().getStringExtra("recherche");
        //gestion des espaces
        recherche = recherche.replaceAll("\\s","+");
        task.execute("https://api.edamam.com/search?q=" +
                recherche +
                "&app_id=6f2e744e&app_key=5106e7bb189e2c9e6874ad457288d151");

    }
}
