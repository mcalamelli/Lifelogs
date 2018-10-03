package net.mcalamelli.lifelogs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Lifelogs> lifelogs;

    public DataAdapter(ArrayList<Lifelogs> lifelogs) {
        this.lifelogs = lifelogs;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.content.setText(lifelogs.get(i).getlContent());
        viewHolder.date.setText(lifelogs.get(i).getlDate());
        viewHolder.time.setText(lifelogs.get(i).getlTime());
    }

    @Override
    public int getItemCount() {
        return lifelogs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView lContent, lDate, lTime;
        public ViewHolder(View view) {
            super(view);

            lContent = (TextView)view.findViewById(R.id.lContent);
            lDate = (TextView)view.findViewById(R.id.lDate);
            lTime = (TextView)view.findViewById(R.id.lTime);

        }
    }

}