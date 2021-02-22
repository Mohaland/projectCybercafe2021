package com.example.bottomnavmyapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;



public class Personnel extends AppCompatActivity {
    private ProgressDialog pdialogue;
    private ArrayList<HashMap<String, String>> menuPerso;
    private ListView listperso;
    private PersonnelCostumList adapter;
    private ArrayList<PersonnelAdapter> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personnel);

        listperso = (ListView) findViewById(R.id.idlvperso);
        arrayList = new ArrayList<>();
        menuPerso = new ArrayList<>();

        new getPersonnel().execute();
    }
    private class getPersonnel extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            menuPerso.clear();
            listperso.setAdapter(null);
            pdialogue = new ProgressDialog(Personnel.this);
            pdialogue.setMessage("Chargement en cours...");
            pdialogue.setCancelable(false);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            System.out.println("erreur");

            //String url = "http://10.0.2.2:8080/gl3c_shop/webresources/controllerpersonnel/listepersonnel";
            String url = "http://192.168.1.102:8080/gl3c_shop/webresources/controllerpersonnel/listepersonnel";
            HttpHandler service = new HttpHandler();
            String jsonperson = service.serviceCall(url);

            System.out.println("erreur 2 : "+service);

            if(jsonperson!=null){
                try {
                    JSONArray personnels = new JSONArray(jsonperson);
                    for(int i=0; i<personnels.length(); i++){
                        JSONObject p = personnels.getJSONObject(i);
                        int idpersonnel = p.getInt("idpersonnel");
                        String nom = p.getString("nom");
                        String login = p.getString("login");
                        String password = p.getString("password");

                        System.out.println("erreur : "+nom);

                        arrayList.add(new PersonnelAdapter(idpersonnel,nom,nom,login,password));

                        HashMap<String, String> hashmap = new HashMap<>();
                        hashmap.put("idpersonnel",  Integer.toString(idpersonnel));
                        hashmap.put("nom", nom);
                        hashmap.put("login", login);
                        hashmap.put("mdp", password);
                        menuPerso.add(hashmap);
                    }
                } catch (JSONException e) {
                    Toast.makeText(Personnel.this, "Reessayer dans klk minutes", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(Personnel.this, "Reessayer dans klk minutes 2", Toast.LENGTH_LONG).show();

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(pdialogue.isShowing())pdialogue.dismiss();
            adapter = new PersonnelCostumList(Personnel.this, R.layout.itempersonnel, arrayList);
            listperso.setAdapter(adapter);
        }
    }

}
