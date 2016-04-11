package ingrid.jack.matteo.projectnative;

import android.util.Log;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;

/**
 * Created by Ingrid on 10/04/2016.
 */
public class CallPost {

    private final String URL = "http://incaneva.it/wp-admin/admin-ajax.php";
    private AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    private Home mContext;
    private Adapter mAdpter;

    public class JsonException extends Exception {
        public JsonException(){
            Log.d("JSON", "Success false!");
        }
    }

    public CallPost(Home context, Adapter adapter){
        mContext = context;
        mAdpter = adapter;
    }

    public void request(){

        RequestParams eventi = new RequestParams();
        eventi.put("action", "incaneva_events");
        eventi.put("blog", "1,6,7,8");
        eventi.put("limit", "10");


        asyncHttpClient.post(URL, eventi, new AsyncHttpResponseHandler() {
            JSONArray data;
            JSONArray type;

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                boolean success;
                try {
                    JSONObject jsonObject = new JSONObject(new String(responseBody));
                    success = jsonObject.getBoolean("success");
                    if (success) {
                        Log.d("HTTP", "true");
                        data = jsonObject.getJSONArray("data");
                        for (int i = 0; i < data.length(); i++) {
                            JSONObject jo = data.getJSONObject(i);
                            EventCaneva event = new EventCaneva();
                            event.setBlogname(jo.getString("blogname"));
                            event.setPost_title(jo.getString("post_title"));
                            event.setPost_excerpt(jo.getString("post_excerpt"));
                            event.setPost_content(jo.getString("post_content"));
                            event.setPermalink(jo.getString("permalink"));
                            event.setCategory_name(jo.getString("category_name"));
                            event.setCategory_link(jo.getString("category_link"));

                            type = jo.getJSONArray("event_type");
                            event.setEvent_type(new ArrayList<String>());
                            for (int j = 0; j < type.length(); j++) {
                                event.getEvent_type().add(type.get(j));
                            }

                            event.setPost_thumbnail(jo.getString("post_thumbnail"));
                            event.setEvcal_srow(jo.getString("evcal_srow"));
                            event.setEvcal_erow(jo.getString("evcal_erow"));
                            event.setEvcal_allday(jo.getString("evcal_allday"));
                            event.setEvcal_location(jo.getString("evcal_location"));
                            event.setEvcal_location_name(jo.getString("evcal_location_name"));
                            event.setEvcal_organizer(jo.getString("evcal_organizer"));
                            mContext.arrayList.add(event);
                        }
                    } else {
                        throw new JsonException();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.d("HTTP","DATASETCHANGED");
                mContext.mParam2 = true;
                mAdpter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("FAILURE", "questo fallimento di programma,MINCHIA!");
            }
        });
    }
}
