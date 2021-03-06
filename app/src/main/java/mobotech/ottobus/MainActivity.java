package mobotech.ottobus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import org.json.JSONObject;

import mobotech.ottobus.bus.JsonObjectResultEvent;
import mobotech.ottobus.contoller.GetJsonData;
import mobotech.ottobus.utils.MyBus;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView; ListView listView;
    String url = "http://api.androidhive.info/volley/person_object.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyBus.getInstance().register(this);

        GetJsonData.simpleVolleyRequest(this , url);

        // Otto EventBus

        // Make Bust Class which return instance of Bus
        // initialize ResultEvent Interface
        // Post to Bus After getting Json Response in GetJsonData class
        //

    }

    @Subscribe
    public void getJsonObject(JsonObjectResultEvent event){
        JSONObject jsonObject = event.getJsonObject();
        Log.i("MY_TAG", "Event Bus OBJECT: " + jsonObject.toString());
    }

    public void showNewActivity(View view){

        Intent intent = new Intent(this , Main2Activity.class);
        startActivity(intent);


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

    @Override
    public void onClick(View view) {

    }
}
