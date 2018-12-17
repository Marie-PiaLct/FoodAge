package tsp.lacotte.helpfood;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncTask2 extends AsyncTask<String, Void, JSONObject> {
    private Activity myActivity;


    public AsyncTask2(Activity mainActivity) {
        myActivity = mainActivity;
    }

    @Override
    protected JSONObject doInBackground(String... strings) {

        URL url = null;
        HttpURLConnection urlConnection = null;
        String result = null;
        try {
            url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection(); // Open
            InputStream in = new BufferedInputStream(urlConnection.getInputStream()); // Stream

            result = readStream(in); // Read stream
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }

        JSONObject json = null;
        try {
            json = new JSONObject(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return json; // returns the result
    }

    private String readStream(InputStream in) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(in),1000);
        for (String line = r.readLine(); line != null; line =r.readLine()){
            sb.append(line);
        }
        in.close();

        // Extracting the JSON object from the String
        String jsonextracted = String.valueOf(sb);

        return jsonextracted;
    }

    @Override
    protected void onPostExecute(JSONObject s) {

        ListView list = (ListView) myActivity.findViewById(R.id.listview);

        RecipeAdapter tableau_recette = new RecipeAdapter(list.getContext());
        list.setAdapter(tableau_recette);

        try {
            JSONArray items = s.getJSONArray("hits");
            for (int i = 0; i < items.length(); i++) {
                JSONObject recipes = items.getJSONObject(i);
                String title_recipe = recipes.getJSONObject("recipe").getString("label");
                Log.i("CIO", "Title recipe: " + title_recipe);


                String urlmedia = recipes.getJSONObject("recipe").getString("image");
                Log.i("CIO", "URL media: " + urlmedia);

                String ingredientList = recipes.getJSONObject("recipe").getString("ingredientLines");
                Log.i("CIO", "Ingredient List: " + ingredientList);


                // Test title, image and ingredients

                AsyncDownload abdt = new AsyncDownload(tableau_recette);
                MyClass params = new MyClass(title_recipe,urlmedia,ingredientList);
                abdt.execute(params);



            }

        } catch (JSONException e) {
            e.printStackTrace();
        }




    }
}





