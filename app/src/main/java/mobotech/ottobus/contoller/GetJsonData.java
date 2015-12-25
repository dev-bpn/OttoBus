package mobotech.ottobus.contoller;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import mobotech.ottobus.bus.JsonObjectResultEvent;
import mobotech.ottobus.utils.MyBus;

/**
 * Created by Dell on 12/25/2015.
 */
public class GetJsonData {

    public static void simpleVolleyRequest(final Context context , String url){

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                Log.i("MY_TAG", "Response: " + response.toString());
                MyBus.getInstance().post(new JsonObjectResultEvent(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context , "Error: "+error.toString(), Toast.LENGTH_SHORT).show();
                Log.i("MY_TAG", "Error: " + error.toString());
            }
        });
        requestQueue.add(jsonObjReq);

    }

}
