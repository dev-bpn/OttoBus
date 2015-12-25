package mobotech.ottobus.bus;

import org.json.JSONObject;

/**
 * Created by Dell on 12/25/2015.
 */
public class JsonObjectResultEvent {

    JSONObject jsonObject;

    public JsonObjectResultEvent(JSONObject jsonObject) {

        this.jsonObject = jsonObject;

    }

    public JSONObject getJsonObject(){
        return jsonObject;
    }

}
