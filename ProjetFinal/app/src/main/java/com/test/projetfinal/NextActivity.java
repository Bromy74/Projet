package com.test.projetfinal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class NextActivity extends Activity {

    EditText firstname, lastname, age;
    Button insert, show;
    RequestQueue requestQueue;
    String insertUrl = "http://192.168.1.87/Php/insertStudent.php";
    String showUrl = "http://192.168.1.87/Php/showStudents.php";
    TextView enseigne;
    TextView adresse;
    TextView tel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        enseigne = (TextView) findViewById(R.id.textView2);
        adresse = (TextView) findViewById(R.id.textView4);
        tel = (TextView) findViewById(R.id.textView8);



        requestQueue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                showUrl, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response.toString());
                try {
                    JSONArray etudiants = response.getJSONArray("etudiants");
                    //for (int i = 0; i < etudiants.length(); i++) {
                        JSONObject commerces = etudiants.getJSONObject(0);//i

                        String firstname = commerces.getString("firstname");
                        String lastname = commerces.getString("lastname");
                        String age = commerces.getString("age");

                        enseigne.append(firstname);
                        adresse.append(lastname);
                        tel.append(age);

                    //}
                    //result.append("===\n");

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

    }

}
