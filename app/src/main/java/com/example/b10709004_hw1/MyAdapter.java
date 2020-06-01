package com.example.b10709004_hw1;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.NumberViewHolder> {
    private List<LikeFruit> ListData;
    MyAdapter(List<LikeFruit> inList)
    {
        ListData = inList;
    }
    private int mcounter=0;


    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final NumberViewHolder holder, final int position) {
        LikeFruit item = ListData.get(position);
        holder.listItemNumberView.setText(item.getText());
        holder.listItemCheckBox.setChecked(item.isChecked());
        holder.listItemCheckBox.setOnClickListener(new View.OnClickListener()
        {
            //計算選取數量
            public void onClick(View v) {
                boolean cb = ((CheckBox)v).isChecked();
                holder.listItemCheckBox.setChecked(cb);
                ListData.get(position).setChecked(cb);
                if(cb==true)
                    mcounter++;
                else
                    mcounter--;
            }
        }
        );
    }


    @Override
    public int getItemCount() {
        return ListData.size();
    }
    class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView listItemNumberView;
        CheckBox listItemCheckBox;

        public NumberViewHolder(View itemView) {
            super(itemView);
            listItemNumberView = (TextView) itemView.findViewById(R.id.textView);
            listItemCheckBox = (CheckBox)itemView.findViewById(R.id.list_cb);
        }
        void bind(int listIndex) {
            listItemNumberView.setText(String.valueOf(listIndex));
        }
    }

    public int getCounter(){
        return mcounter;
    }
}
