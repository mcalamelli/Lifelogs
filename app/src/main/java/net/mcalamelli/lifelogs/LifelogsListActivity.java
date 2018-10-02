package net.mcalamelli.lifelogs;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class LifelogsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifelogslist);

        //sendAndRequestResponse();
        getLifelogs();
    }

    private void sendAndRequestResponse() {
        RequestQueue mRequestQueue;
        StringRequest mStringRequest;
        String url = "https://www.mcalamelli.net/wp-json/wp/v2/lifelogs";
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

    private void getLifelogs() {
        RequestQueue mRequestQueue;
        JsonArrayRequest mJsonArrayRequest;
        String url = "https://www.mcalamelli.net/wp-json/wp/v2/lifelogs";
        final ConstraintLayout mConstraintLayout;
        final RecyclerView mRecyclerViewLifelogs;

        mConstraintLayout = findViewById(R.id.constraintLayout_lifelogs);
        mRecyclerViewLifelogs = findViewById(R.id.recyclerView_lifelogs);
        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);
        //JsonRequest initialized
        mJsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response) {
                //Toast.makeText(getApplicationContext(),"Lifelogs as come.", Toast.LENGTH_LONG).show(); // display the response on screen
                try{
                    // Loop through the array elements
                    for (int i = 0; i < response.length(); i++){
                        // Get current json object
                        JSONObject lifelogs = response.getJSONObject(i);

                        //Toast.makeText(getApplicationContext(), lifelogs.toString(), Toast.LENGTH_LONG).show();

                        // Get the current student (json object) data
                        String content = lifelogs.getString("content");
                        String datetime = lifelogs.getString("modified");
                        Integer id = lifelogs.getInt("id");

                        // Initialize a new CardView
                        CardView card = new CardView(getApplicationContext());
                        // Set the CardView layoutParams
                        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
                        card.setLayoutParams(params);
                        // Set CardView elevation
                        card.setCardElevation(3);

                        // Initialize a new LinearLayout
                        LinearLayout mLinearLayout = new LinearLayout(getApplicationContext());
                        mLinearLayout.setOrientation(LinearLayout.VERTICAL);

                        // Initialize a new TextView
                        TextView mLifelogContent = new TextView(getApplicationContext());
                        LayoutParams paramsTextViewContent = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                        mLifelogContent.setLayoutParams(paramsTextViewContent);
                        mLifelogContent.setPadding(16, 16, 16, 16);
                        mLifelogContent.setText(content);

                        // Add Textview to LinearLayout
                        mLinearLayout.addView(mLifelogContent);
                        // Add vertical LinearLayout to card
                        card.addView(mLinearLayout);
                        // Add card to main layout
                        //mConstraintLayout.addView(card);
                        //mRecyclerViewLifelogs.
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Lifelogs error : " + error.toString(), Toast.LENGTH_LONG).show(); // display the response on screen
            }
        });
        mRequestQueue.add(mJsonArrayRequest);
    }

    private void buildCardList() {

    }
}
