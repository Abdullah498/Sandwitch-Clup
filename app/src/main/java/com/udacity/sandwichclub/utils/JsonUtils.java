package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {



    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich=new Sandwich();


        try {
            JSONObject jsonObject=new JSONObject(json);
            JSONObject name=jsonObject.getJSONObject("name");
            String mainName=name.getString("mainName");
            JSONArray jsonAlsoKnownAs =name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs =new ArrayList<>();
            for(int i=0;i<jsonAlsoKnownAs.length();i++){
                alsoKnownAs.add(jsonAlsoKnownAs.getString(i));
            }
            String placeOfOrigin=jsonObject.getString("placeOfOrigin");
            String description=jsonObject.getString("description");
            String image=jsonObject.getString("image");
            JSONArray jsonIngredients = jsonObject.getJSONArray("ingredients");
            List<String> ingredients =new ArrayList<>();
            for(int i=0;i<jsonAlsoKnownAs.length();i++){
                ingredients.add(jsonIngredients.getString(i));
            }

            sandwich.setMainName(mainName);
            sandwich.setAlsoKnownAs(alsoKnownAs);
            sandwich.setPlaceOfOrigin(placeOfOrigin);
            sandwich.setDescription(description);
            sandwich.setImage(image);
            sandwich.setIngredients(ingredients);
            return sandwich;// new Sandwich(mainName,alsoKnownAs,placeOfOrigin,description,image,ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
