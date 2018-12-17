package tsp.lacotte.helpfood;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AsyncDownload extends AsyncTask<MyClass, Void, Recipe> {

    RecipeAdapter adapter_ = null;

    public AsyncDownload(RecipeAdapter adapter) {
        adapter_ = adapter;
    }

    @Override
    protected Recipe doInBackground(MyClass... List) {
        String recipe_title =List[0].label;
        String ingredientList = List[0].ingredientList;
        //URL url = null;
        HttpURLConnection urlConnection = null;
        //Recipe recette = null;
        Bitmap bm = null;
        try {
            URL url = new URL(List[0].image);
            urlConnection = (HttpURLConnection) url.openConnection(); // Open
            InputStream in = new BufferedInputStream(urlConnection.getInputStream()); // Stream
            bm = BitmapFactory.decodeStream(in);
            in.close();
        }
        catch (MalformedURLException e) { e.printStackTrace(); }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }
        Recipe recette = new Recipe(recipe_title, bm,ingredientList);
        return recette;
    }

    @Override
    protected void onPostExecute(Recipe recette) {
        adapter_.add(recette);
        adapter_.notifyDataSetChanged();
    }

}


