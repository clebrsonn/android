package hyteck.com.br.headache;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import hyteck.com.br.headache.entity.Headache;

/**
 * Created by clebr on 10/09/2016.
 */
public class RecyclerHeadache extends RecyclerView.Adapter<RecyclerHeadache.RecyclerHeadacheViewHolder> {

    private List<Headache> mList;

    public static ClickRecyclerViewInterface clickRecyclerViewInterface;
    Context mctx;

    public RecyclerHeadache(Context ctx, List<Headache> list, ClickRecyclerViewInterface clickRecyclerViewInterface) {
        this.mctx = ctx;
        this.mList = list;
        RecyclerHeadache.clickRecyclerViewInterface = clickRecyclerViewInterface;
    }


    @Override
    public RecyclerHeadacheViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_headache, viewGroup, false);
        return new RecyclerHeadacheViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerHeadacheViewHolder holder, int position) {
        Headache headache = mList.get(position);
        holder.viewNome.setText(headache.getIntensidade());
        holder.viewDate.setText(headache.getDataInicio());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    protected class RecyclerHeadacheViewHolder extends RecyclerView.ViewHolder {

        protected TextView viewNome;
        protected TextView viewDate;

        public RecyclerHeadacheViewHolder(final View itemView) {
            super(itemView);

            viewNome = (TextView) itemView.findViewById(R.id.textview_intensidade);
            viewDate = (TextView) itemView.findViewById(R.id.textview_data);

            //Setup the click listener
            itemView.setOnClickListener(v -> {
                clickRecyclerViewInterface.onCustomClick(mList.get(getLayoutPosition()));
            });
        }
    }


}
