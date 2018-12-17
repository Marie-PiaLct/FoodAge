package tsp.lacotte.helpfood;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;

public class Recipe {
    public String label;
    public Bitmap image ;
    public String ingredientList;
    public Recipe(String label, Bitmap image, String ingredientList){
        this.label = label;
        this.image = image;
        this.ingredientList = ingredientList;
    }
}

