package ingrid.jack.matteo.projectnative;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by matteo on 11/04/16.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewEventHolder> {

    ArrayList<EventCaneva> event;

    public static class ViewEventHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView eventName;
        TextView eventDate;

        ViewEventHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            eventName = (TextView)itemView.findViewById(R.id.event_name);
            eventDate = (TextView)itemView.findViewById(R.id.event_age);
        }
    }

    public Adapter(ArrayList<EventCaneva> arrayList){
        event = arrayList;
    }

    @Override
    public int getItemCount() {
        if(event == null)
            return 0;
        return event.size();
    }

    @Override
    public void onBindViewHolder(ViewEventHolder ViewHolder, int i) {
        ViewHolder.eventName.setText(event.get(i).getPost_title());
        ViewHolder.eventDate.setText(event.get(i).getPost_excerpt());
    }

    public ViewEventHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ViewEventHolder pvh = new ViewEventHolder(v);
        return pvh;
    }
}
