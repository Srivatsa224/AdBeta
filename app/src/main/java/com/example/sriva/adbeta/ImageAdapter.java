package com.example.sriva.adbeta;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Upload> mUploads;
    private OnItemClickListener mListener;


    public ImageAdapter(Context context, List<Upload> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.ad_list_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Upload uploadCurrent = mUploads.get(position);
        if (uploadCurrent.getName() != null)
            holder.textViewName.setText(uploadCurrent.getName());
        if (uploadCurrent.getSize() != null)
            holder.tvSize.setText(uploadCurrent.getSize());
        if (uploadCurrent.getPrice() != null)
            holder.tvPrice.setText(uploadCurrent.getPrice());
        if (uploadCurrent.getMaplink() != null){
            holder.tvMaplink.setText(uploadCurrent.getMaplink());
            final String url = uploadCurrent.getMaplink();
            holder.tvMaplink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    mContext.startActivity(i);
                }
            });

        }
        if (uploadCurrent.getImageUrl() != null)
            Picasso.get()
                    .load(uploadCurrent.getImageUrl())
                    .placeholder(R.mipmap.ic_launcher)
                    .fit()
                    .centerCrop()
                    .into(holder.imageView);


        final String message = "Hi, We want to book this Ad Space at "+uploadCurrent.getName()
                +" of size "+uploadCurrent.getSize() +
                " which you have listed for INR "+uploadCurrent.getPrice()
                + "located at "+ uploadCurrent.getMaplink() + " this location." +
                "    Please Share the payment details" + ",Thank You.";
        final String emailaddress="srivatsa224@gmail.com";
        final String img= uploadCurrent.getImageUrl();

        holder.bookNow.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "srivatsa224@gemail.com" });
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Ad Booking");
            emailIntent.putExtra(Intent.EXTRA_TEXT, message);
            emailIntent.setType(img);
            mContext.startActivity(emailIntent);


        }
    });
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onWhatEverClick(int position);

        void onDeleteClick(int position);
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        public TextView textViewName;
        public TextView tvSize;
        public TextView tvPrice;
        public TextView tvMaplink;
        public Button bookNow;
        public ImageView imageView;


        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewLocation);
            tvSize = itemView.findViewById(R.id.textViewSize);
            tvPrice = itemView.findViewById(R.id.textViewPrice);
            tvMaplink = itemView.findViewById(R.id.textViewMapLink);
            bookNow = itemView.findViewById(R.id.buttonBook);
            imageView = itemView.findViewById(R.id.imageViewAd);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position);
                }
            }
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select Action");
            MenuItem doWhatever = menu.add(Menu.NONE, 1, 1, "Do whatever");
            MenuItem delete = menu.add(Menu.NONE, 2, 2, "Delete");

            doWhatever.setOnMenuItemClickListener(this);
            delete.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {

                    switch (item.getItemId()) {
                        case 1:
                            mListener.onWhatEverClick(position);
                            return true;
                        case 2:
                            mListener.onDeleteClick(position);
                            return true;
                    }
                }
            }
            return false;
        }
    }
}