package tsp.lacotte.helpfood;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static tsp.lacotte.helpfood.R.*;
import static tsp.lacotte.helpfood.R.layout.*;

public class RecipeAdapter extends BaseAdapter {
    public static final String RECETTE ="recette";

        private Context context_ = null;


        public RecipeAdapter(Context context) {
            context_ = context;
        }

        ArrayList<Recipe> myList = new ArrayList<Recipe>();
        Context context;

        @Override
        public int getCount() {
            return myList.size();
        }

        @Override
        public Recipe getItem(int position) {
            return myList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return myList.indexOf(getItem(position));
        }

        public void add(Recipe recette) {
            myList.add(recette);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final Recipe recette = (Recipe) getItem(position);

                if (convertView == null) {
                    convertView = LayoutInflater.from(context_)
                            .inflate(unerecette, parent, false);
                }

                final TextView tv = (TextView) convertView.findViewById(id.text_view_result);
                tv.setText(recette.label.toString());
                final ImageView iv = (ImageView)convertView.findViewById(R.id.imageView);
                iv.setImageBitmap(recette.image);
                //final TextView tvingredient = (TextView) convertView.findViewById(id.text_ingredient);
                //tvingredient.setText(recette.ingredientList.toString());
                Button more = (Button) convertView.findViewById(R.id.button_more);
                more.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent detailActvity = new Intent(view.getContext(), DetailRecette.class);
                        detailActvity.putExtra("titre",recette.label);
                        detailActvity.putExtra("ingredient", recette.ingredientList);
                        detailActvity.putExtra("Bitmapimage",recette.image);
                        view.getContext().startActivity(detailActvity);
                        Toast.makeText(view.getContext(), "More about : "+recette.label, Toast.LENGTH_SHORT).show();
                    }
                });
                Button save = (Button) convertView.findViewById(R.id.button_save);
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(view.getContext());
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString(RECETTE,recette.label);
                        editor.apply();
                        Toast.makeText(view.getContext(), "Save : "+ recette.label, Toast.LENGTH_SHORT).show();
                        Log.i("MyInfo", preferences.getString(RECETTE, ""));
                    }
                });
                return convertView;

        }

    }

