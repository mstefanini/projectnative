package ingrid.jack.matteo.projectnative;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<EventCaneva> event;
    Boolean riuscito = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CallPost callPost = new CallPost(this);
        callPost.request();

    }

    public ArrayList<EventCaneva> getEvent(){
        return event;
    }

}
