package tsp.lacotte.helpfood;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailRecette extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailrecette);
        String titre = getIntent().getStringExtra("titre");
        String ingredt = getIntent().getStringExtra("ingredient");
        Bitmap image =getIntent().getParcelableExtra("Bitmapimage");
        TextView titleview = (TextView) findViewById(R.id.titre);
        TextView ingredientview = (TextView) findViewById(R.id.ingredt);
        ImageView imageview = (ImageView) findViewById(R.id.ivrecipe);
        titleview.setText(titre);
        ingredientview.setText(ingredt);
        imageview.setImageBitmap(image);
    }

}
