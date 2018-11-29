package kr.co.memo.jiyoon.memo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import  java.util.ArrayList;

import kr.co.memo.jiyoon.memo.R;
import kr.co.memo.jiyoon.memo.item.MemoItem;

public class MemoListAdapter extends RecyclerView.Adapter<MemoListAdapter.ViewHolder> {
    private Context context;
    private int resource;
    private ArrayList<MemoItem> itemList;

    public MemoListAdapter(Context context, int resource, ArrayList<MemoItem> itemList) {
        this.context=context;
        this.itemList=itemList;
        this.resource=resource;
    }

    public void addItem(MemoItem item){
        this.itemList.add(0,item);
        notifyDataSetChanged();
    }

    public void addItemList(ArrayList<MemoItem> itemList){
        this.itemList.addAll(itemList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        return this.itemList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View v=LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        final MemoItem item = itemList.get(position);

        holder.categoryText.setText(item.category);
        holder.dateText.setText(item.date);
        holder.memoText.setText(item.memo);

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(context,item.memo,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView categoryText;
        TextView memoText;
        TextView dateText;

        public ViewHolder(View itemView) {
            super(itemView);
            categoryText=itemView.findViewById(R.id.category);
            memoText=itemView.findViewById(R.id.memo);
            dateText=itemView.findViewById(R.id.regdate);
        }
    }
}
