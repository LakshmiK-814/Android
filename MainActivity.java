package com.example.android.androidapplication;


import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;

import android.support.design.widget.Snackbar;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;

import android.util.Log;

import android.view.View;
import android.view.Menu;

import android.view.MenuItem;
import android.widget.Button;


import com.android.volley.Request;

import com.android.volley.RequestQueue;

import com.android.volley.Response;

import com.android.volley.VolleyError;

import com.android.volley.toolbox.StringRequest;

import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {

    
private static final String TAG = MainActivity.class.getName();
   
 private Button btnpost;
    private RequestQueue mRequestQueue;
    
private StringRequest StringRequest;
   
 private String url = "http://www.mocky.io/v2/5c35b76b3000002c0021b491";

private Volley volley;


 
   @Override
    protected void onCreate(Bundle savedInstanceState) {
       
 super.onCreate(savedInstanceState);
       
 setContentView(R.layout.activity_main);
     
   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        
setSupportActionBar(toolbar);

       
 FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        
fab.setOnClickListener(new View.OnClickListener() {
          
  @Override
            public void onClick(View view) {
               
 Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
      .setAction("Action", null).show();

      btnpost = (Button) findViewById(R.id.btnpost);

      btnpost.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sendRequestAndPrintResponse();
                    }
                });
            }
        });
    }

    private void sendRequestAndPrintResponse() {
        mRequestQueue = volley.newRequestQueue(this);
        StringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, "Response:" + response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "Error:" + error.toString());

          
  }
        });

        


  
  }





    
@Override
  
  public boolean onCreateOptionsMenu(Menu menu) {
        
// Inflate the menu; this adds items to the action bar if it is present.
        
getMenuInflater().inflate(R.menu.menu_main, menu);
       
 return true;
   
 }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}