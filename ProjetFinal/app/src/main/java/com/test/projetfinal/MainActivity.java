package com.test.projetfinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    public List categories;
    public CategorieAdapter adapter;
    RequestQueue requestQueue;
    String showUrl = "http://192.168.1.86/Php/showStudents.php";
    ArrayList T_alimentaire_description = new ArrayList();
    ArrayList T_alimentaire = new ArrayList();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        requestQueue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                showUrl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response.toString());
                try {
                    JSONArray etudiants = response.getJSONArray("etudiants");

                    Map<String, Categorie> categories1 = new HashMap<String, Categorie>();

                    for (int i = 0; i < etudiants.length(); i++) {
                        System.out.println("ttttttttttttttt");

                        JSONObject commerces = etudiants.getJSONObject(i);//i

                        String firstname = commerces.getString("firstname");
                        String lastname = commerces.getString("lastname");
                        T_alimentaire_description.add(firstname);
                        T_alimentaire.add(lastname);


                    }



                } catch (JSONException e) {
                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.append(error.getMessage());

            }
        });
        requestQueue.add(jsonObjectRequest);

        ///categories = genererCategorie(null);
        ///adapter = new CategorieAdapter(MainActivity.this, categories, mListView);
        ///mListView.setAdapter(adapter);
        categories = genererCategorie(null,T_alimentaire,T_alimentaire_description);
        adapter = new CategorieAdapter(MainActivity.this, categories, mListView);
        mListView.setAdapter(adapter);
    }
//---------------------------------------------------



    ///private ArrayList genererCategorie(ArrayList sousCats) {

    private ArrayList genererCategorie(ArrayList sousCats, ArrayList A, ArrayList B) {
        if (sousCats != null) {
            return sousCats;
        }
        ArrayList categories = new ArrayList();

        Categorie alimentaire = new Categorie("Alimentation",R.mipmap.ic_launcher);


//--------------------------------------





        //String T_alimentaire_description[] = {"Alimentation Générale","Boucheries - Charcuteries - Traiteurs","Boulangeries - Patisseries","Cavistes","Chocolateries - Confiseries - Glacier - Torréfaction - Thés","Fromageries","Produits diététiques, biologiques, naturels"};
        //String T_alimentaire[] = {"alimgene","boucherie","boulangerie","cavistes","chocolaterie","formagerie","dietetique"};


        // ALIMENTAIRE
        //----------------------------------------------------------------------------------------------------//
       /*
        Map<String,Categorie> categories1 = new HashMap<String,Categorie>();
        for (int i =0; i<T_alimentaire.length; i++){
            String key = T_alimentaire[i];
            String desc = T_alimentaire_description[i];
            Categorie value = new Categorie(desc,R.mipmap.ic_launcher);
            categories1.put(key, value);
            alimentaire.addCat(categories1.get(key));
        }*/


        Map<String,Categorie> categories1 = new HashMap<String,Categorie>();
        for (int i =0; i<A.size(); i++){
            String key = (String)A.get(i);
            String desc = (String)B.get(i);
            Categorie value = new Categorie(desc,R.mipmap.ic_launcher);
            categories1.put(key, value);
            alimentaire.addCat(categories1.get(key));
        }

        // Et pour récupérer une valeur :
        //Categorie c = categories.get("boucherie");
        //----------------------------------------------------------------------------------------------------//s
/*
        Categorie alimgene = new Categorie("Alimentation Générale",R.mipmap.ic_launcher);
        Categorie boucherie = new Categorie("Boucheries - Charcuteries - Traiteurs",R.mipmap.ic_launcher);
        Categorie boulangerie = new Categorie("Boulangeries - Patisseries",R.mipmap.ic_launcher);
        Categorie cavistes = new Categorie("Cavistes",R.mipmap.ic_launcher);
        Categorie choco = new Categorie("Chocolateries - Confiseries - Glacier - Torréfaction - Thés",R.mipmap.ic_launcher);
        Categorie formagerie = new Categorie("Fromageries",R.mipmap.ic_launcher);
        Categorie dietetique = new Categorie("Produits diététiques, biologiques, naturels",R.mipmap.ic_launcher);
        Categorie Lol = new Categorie("Produits Lolien, ta, zey",R.mipmap.ic_launcher);
        Categorie Alle = new Categorie("Produits diététiques, biologiques, naturels",R.mipmap.ic_launcher);

        alimentaire.addCat(alimgene);
        alimentaire.addCat(boucherie);
        alimentaire.addCat(boulangerie);
        alimentaire.addCat(cavistes);
        alimentaire.addCat(choco);
        alimentaire.addCat(formagerie);
        alimentaire.addCat(dietetique);
        alimentaire.addCat(Lol);
        alimentaire.addCat(Alle);
*/
        //Categorie match = new Categorie("Match",R.mipmap.ic_launcher);
        //categories1.get("alimgene").addCat(match);


        // Animaux Fleuriste Jardin
        Categorie animauxFleu = new Categorie("Animaux - Fleuristes - Jardin",R.mipmap.ic_launcher);

        Categorie animaux = new Categorie("Animaux",R.mipmap.ic_launcher);
        Categorie fleuristes = new Categorie("Fleuristes",R.mipmap.ic_launcher);
        Categorie jardin = new Categorie("Jardin",R.mipmap.ic_launcher);

        animauxFleu.addCat(animaux);
        animauxFleu.addCat(fleuristes);
        animauxFleu.addCat(jardin);


        // Batiments Immobilier
        Categorie batimmo = new Categorie("Batiments - Immobilier",R.mipmap.ic_launcher);



        //Beauté - Bien être
        Categorie beautebienetre = new Categorie("Beauté - Bien-être",R.mipmap.ic_launcher);



        //Café Tabac Presse
        Categorie cafetabacpresse = new Categorie("Café - Tabac - Presse",R.mipmap.ic_launcher);



        //Finances
        Categorie finances = new Categorie("Finances",R.mipmap.ic_launcher);



        //Hébergement - Restauration
        Categorie hebergResto = new Categorie("Hébergement - Restauration",R.mipmap.ic_launcher);



        //Loisirs
        Categorie loisirs = new Categorie("Loisirs",R.mipmap.ic_launcher);



        //Maison Bricolage Déco
        Categorie bricodeco = new Categorie("Maison - Bricolage - Déco",R.mipmap.ic_launcher);



        //Mode
        Categorie mode = new Categorie("Mode",R.mipmap.ic_launcher);



        //Multimédia
        Categorie multimédia = new Categorie("Multimédia",R.mipmap.ic_launcher);



        //Santé
        Categorie sante = new Categorie("Santé",R.mipmap.ic_launcher);



        //Transport Vehicule
        Categorie transpovehic = new Categorie("Transports - Véhicules",R.mipmap.ic_launcher);



        //Autres
        Categorie autres = new Categorie("Autres",R.mipmap.ic_launcher);



        //Compilation
        categories.add(alimentaire);
        categories.add(animauxFleu);
        categories.add(batimmo);
        categories.add(beautebienetre);
        categories.add(cafetabacpresse);
        categories.add(finances);
        categories.add(hebergResto);
        categories.add(loisirs);
        categories.add(bricodeco);
        categories.add(mode);
        categories.add(multimédia);
        categories.add(sante);
        categories.add(transpovehic);
        categories.add(autres);

        return categories;
    }

    /*public void clickCategorie(View view) {

        mListView.setAdapter(null);

        Categorie boucherie = new Categorie("Boucherie");
        Categorie boulangerie = new Categorie("Boulangerie");
        categories.clear();
        categories.add(boucherie);
        categories.add(boulangerie);
        adapter = new CategorieAdapter(MainActivity.this,categories);



    } */
}
