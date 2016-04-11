package ingrid.jack.matteo.projectnative;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CallPost callPost = new CallPost();
        ArrayList<EventCaneva> event = callPost.request();

        for(EventCaneva evento: event){
            Log.d("EVENTO", evento.getBlogname());
            Log.d("EVENTO", evento.getPost_title());
        }
    }
}
