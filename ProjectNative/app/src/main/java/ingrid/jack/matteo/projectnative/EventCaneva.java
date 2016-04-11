package ingrid.jack.matteo.projectnative;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ingrid on 10/04/2016.
 */
public class EventCaneva implements Parcelable {

    String name;
    String age;

    public class MyCreator implements Parcelable.Creator<EventCaneva> {
        public EventCaneva createFromParcel(Parcel source) {
            return new EventCaneva(source);
        }
        public EventCaneva[] newArray(int size) {
            return new EventCaneva[size];
        }
    }

    public EventCaneva(Parcel source){
        name = source.readString();
        age = source.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
    }
}
