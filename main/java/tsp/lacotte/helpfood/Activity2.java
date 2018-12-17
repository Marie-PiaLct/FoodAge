package tsp.lacotte.helpfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Activity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preactivity2);
        String age = getIntent().getStringExtra("age");
        String type = getIntent().getStringExtra("type");
        String occasion = getIntent().getStringExtra("occasion");
        String url = null;
        Log.i("MyInfo","age : "+ age + " type : " + type + " occasion : " + occasion);
        if (age.equals("Bebe")) {
            if(type.equals("Entrée")){
                url = "pureed+vegetable+soup";
            }
            if (type.equals("Plats")){
                url = "pureed+vegetable+soup";
            }
            if (type.equals("Dessert")){
                url = "dessert+mixed+fruit";
            }

        }
        if (age.equals("Enfant")) {
            if(type.equals("Entrée")){
                url = "entree+for+kids";
            }
            if (type.equals("Plats")){
                url = "dish+for+kids";
            }
            if (type.equals("Dessert")){
                url = "dessert+for+kids";
            }

        }
        if (age.equals("Adolescent")) {
            if (type.equals("Entrée")) {
                url = "entree";
            }
            if (type.equals("Plats")) {
                url = "easy/alcohol-free/high-fiber/high-protein";
            }
            if (type.equals("Dessert")) {
                url = "dessert/alcohol-free/balanced";
            }
        }
                AsyncTask2 task = new AsyncTask2(Activity2.this);
                task.execute("https://api.edamam.com/search?q=" +
                        url +
                        "&app_id=6f2e744e&app_key=5106e7bb189e2c9e6874ad457288d151");

        ;

    }
}
