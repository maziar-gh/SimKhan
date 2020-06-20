package ir.maziardev.simkhan.adapter;


import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ir.maziardev.simkhan.R;
import ir.maziardev.simkhan.model.SimCardListRows;
import ir.maziardev.simkhan.enums.Extras;

public class SimCardAdapter extends RecyclerView.Adapter<SimCardAdapter.ViewHolder> {
    private List<SimCardListRows> dataList;
    private Context mContext;
    private int lastPosition = -1;
    boolean isMoreDataAvailable = true;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_number, tv_description, tv_price, tv_action;
        public CardView cardView;


        public ViewHolder(View v) {
            super(v);
            tv_action = (TextView) v.findViewById(R.id.sim_action);
            tv_number = (TextView) v.findViewById(R.id.sim_number);
            tv_description = (TextView) v.findViewById(R.id.sim_description);
            tv_price = (TextView) v.findViewById(R.id.sim_price);
            cardView = (CardView) v.findViewById(R.id.sim_cardview);
        }
    }

    public SimCardAdapter(Context context, List<SimCardListRows> dataList) {
        mContext = context;
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sim_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        /*Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.up_from_bottom
                        : R.anim.down_from_top);
        holder.itemView.startAnimation(animation);
        lastPosition = position;*/

        SimCardListRows list = dataList.get(position);
        holder.tv_number.setText(list.getSimCardNumber());
        holder.tv_description.setText(list.getSimCardDescription());
        holder.tv_price.setText(list.getPrice());

        holder.tv_action.setOnClickListener(new onActionClick(holder.getAdapterPosition()));
        //holder.iv_share.setOnClickListener(new onPostShare(holder.getAdapterPosition()));
    }


    class onActionClick implements View.OnClickListener {
        int position;

        public onActionClick(int adapterPosition) {
            this.position = adapterPosition;
        }

        @Override
        public void onClick(View view) {
            SimCardListRows list = dataList.get(position);

            Toast.makeText(mContext, "pay", Toast.LENGTH_SHORT).show();

            /*Intent intent = new Intent(mContext, WebActivity.class);
            intent.putExtra(Extras.NUMBER.toString(), list.getSimCardNumber());
            intent.putExtra(Extras.DESCRIPTION.toString(), list.getSimCardDescription());
            intent.putExtra(Extras.PRICE.toString(), list.getPrice());
            mContext.startActivity(intent);*/
        }
    }

    class onPostShare implements View.OnClickListener {
        int position;

        public onPostShare(int adapterPosition) {
            this.position = adapterPosition;
        }

        @Override
        public void onClick(View view) {
            SimCardListRows list = dataList.get(position);

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    list.getSimCardNumber() + " \n" + list.getPrice());
            sendIntent.setType("text/plain");
            mContext.startActivity(Intent.createChooser(sendIntent, "اشتراک گذاری در..."));
        }
    }

    @Override
    public int getItemCount() {
        try{
            return dataList.size();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public void setMoreDataAvailable(boolean moreDataAvailable) {
        isMoreDataAvailable = moreDataAvailable;
    }

    public boolean getMoreDataAvailable() {
        return isMoreDataAvailable;
    }

    public int dpToPx(int dp) {
        DisplayMetrics displayMetrics = mContext.getResources()
                .getDisplayMetrics();
        return Math.round(dp
                * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
