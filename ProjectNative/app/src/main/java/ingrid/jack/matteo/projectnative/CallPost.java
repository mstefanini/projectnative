package ingrid.jack.matteo.projectnative;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Ingrid on 10/04/2016.
 */
public class CallPost {

    private final String URL = "http://incaneva.it/wp-admin/admin-ajax.php";
    private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

    public class JsonException extends Exception {
        public JsonException(){
            Log.d("JSON", "Success false!");
        }
    }

    public CallPost(){
        request();
    }

    public void request(){

        RequestParams eventi = new RequestParams();
        eventi.put("action", "incaneva_events");
        eventi.put("blog", "1,6,7,8");
        eventi.put("limit", "10");

        asyncHttpClient.post(URL, eventi, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                boolean success;
                try{
                    JSONObject jsonObject = new JSONObject(new String(responseBody));
                    success = jsonObject.getBoolean("success");
                    if(success){
                        Log.d("Risultato", "true");
                    } else {
                        throw new JsonException();
                    }

                } catch(Exception e) {

                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
