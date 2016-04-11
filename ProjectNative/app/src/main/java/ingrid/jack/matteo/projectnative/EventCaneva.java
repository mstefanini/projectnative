package ingrid.jack.matteo.projectnative;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Ingrid on 10/04/2016.
 */
public class EventCaneva implements Serializable {

    String name;
    String age;


    public EventCaneva(String string, String string1){
        name = string;
        age = string1;
    }


}
