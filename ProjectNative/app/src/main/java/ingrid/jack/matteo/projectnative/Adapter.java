package ingrid.jack.matteo.projectnative;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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


    public static class ViewEventHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView eventName;
        TextView eventDate;
        Context context;
        IMyViewHolderClicks mListener;


        ViewEventHolder( View itemView, IMyViewHolderClicks listener ) {
            super(itemView);
            context = itemView.getContext();
            mListener = listener;
            cv = (CardView)itemView.findViewById(R.id.cv);
            eventName = (TextView)itemView.findViewById(R.id.event_name);
            eventDate = (TextView)itemView.findViewById(R.id.event_age);
        }

        public interface IMyViewHolderClicks {
             void onSuccess(Context context);
        }

        @Override
        public void onClick(View v){
            mListener.onSuccess(context);
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
        final int q = i;
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_layout, viewGroup, false);
        ViewEventHolder pvh = new ViewEventHolder(v, new ViewEventHolder.IMyViewHolderClicks() {
            @Override
            public void onSuccess(Context context) {
                Intent intent = new Intent(context, Details.activity);
                Bundle bundle = new Bundle();
                bundle.putSerializable("ARRAY", event);
                bundle.putInt("INT", q);
                context.startActivity(intent);
            }
        });
        return pvh;
    }


}
