package com.example.parsejson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Etudiant> lst = new ArrayList<Etudiant>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSON task = new JSON();
        task.execute("http://172.17.36.148:5001/api/Etudiant");

    }

    public static List<Etudiant> getelem(Context context, URL url) throws IOException, JSONException {

        JSONArray m_jArry = new JSONArray(Readbodyhttp_Req(context,url));
        //JSONArray m_jArry = obj.getJSONArray("");

        for (int i=0; i<m_jArry.length(); i++) {
            System.out.println("hiiii");
            lst.add(

                    new Etudiant(
                            Integer.parseInt(m_jArry.getJSONObject(i).getString("id")),
                            Integer.parseInt(m_jArry.getJSONObject(i).getString("age")),
                            m_jArry.getJSONObject(i).getString("nom"),
                            m_jArry.getJSONObject(i).getString("prenom"),
                            m_jArry.getJSONObject(i).getString("cin")

                    )
            );

        }
        return  lst;
    }


    public static String Readbodyhttp_Req(Context constext, URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String body = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }

            body = sb.toString();

            Log.d("HTTP-GET", body);



        } catch (Exception e){
            Log.i("Exception", String.valueOf(e));
        }
        return  body;
    }

    public class JSON extends AsyncTask<String, Void, List<Etudiant>> {

        @Override
        protected List<Etudiant> doInBackground(String... strings) {
            List<Etudiant> lst = new ArrayList<Etudiant>();
            try {
                lst = getelem(getApplicationContext(), new URL(strings[0]));

            } catch (IOException e) {
                System.out.println("==IO" + e);
            } catch (JSONException e) {
                System.out.println("==JSON" + e);
            }

            return lst;
        }

        @Override
        protected void onPostExecute(List<Etudiant> flickItems) {
            super.onPostExecute(lst);
            final RecyclerView view = (RecyclerView) findViewById(R.id.rv);

            view.setAdapter(new MyAdapter( getApplicationContext(),lst));

        }
    }
}