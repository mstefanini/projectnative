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
public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    ArrayList<EventCaneva> event;

    public static class viewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;

        viewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
        }
    }

    public Adapter(ArrayList<EventCaneva> arrayList){
        event = arrayList;
    }

    @Override
    public int getItemCount() {
        return event.size();
    }

    @Override
    public void onBindViewHolder(viewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(event.get(i).name);
        personViewHolder.personAge.setText(event.get(i).age)        ;
    }

    public viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        viewHolder pvh = new viewHolder(v);
        return pvh;
    }
}
