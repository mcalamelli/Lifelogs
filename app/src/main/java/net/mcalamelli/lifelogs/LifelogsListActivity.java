package net.mcalamelli.lifelogs;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class LifelogsListActivity extends AppCompatActivity {
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "https://www.mcalamelli.net/wp-json/wp/v2/lifelogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifelogslist);

        sendAndRequestResponse();
    }

    private void sendAndRequestResponse() {
        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);
        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),"Response as come.", Toast.LENGTH_LONG).show(); // display the response on screen

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error : " + error.toString(), Toast.LENGTH_LONG).show(); // display the response on screen
            }
        });

        mRequestQueue.add(mStringRequest);
    }
}
