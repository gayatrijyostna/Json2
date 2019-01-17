package com.example.sys.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        recyclerView=findViewById(R.id.recyclerview);

        String details="{\n" +
                "\n" +
                "\"users\": [\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"name\": \"Suresh Dasari\",\n" +
                "\n" +
                "\"designation\": \"Team Leader\",\n" +
                "\n" +
                "\"location\": \"Hyderabad\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"name\": \"Rohini Alavala\",\n" +
                "\n" +
                "\"designation\": \"Agricultural Officer\",\n" +
                "\n" +
                "\"location\": \"Guntur\"\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}";
        try{
            ArrayList<HashMap<String,String>> userlist = new ArrayList<>();
            JSONObject jObj = new JSONObject(details);
            JSONArray jsonArry = jObj.getJSONArray("users");
            for(int i=0;i<jsonArry.length();i++){
                HashMap<String,String> user = new HashMap<>();
                JSONObject obj = jsonArry.getJSONObject(i);
                user.put("name",obj.getString("name"));
                user.put("designation",obj.getString("designation"));
                user.put("location",obj.getString("location"));
                userlist.add(user);
            }
//            Log.e("userlist",userlist.toString());
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(layoutManager);

//            ListView listView=findViewById(R.id.list_view);
            CustomAdaptor customAdapter=new CustomAdaptor(this,userlist);
            recyclerView.setAdapter(customAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    }

