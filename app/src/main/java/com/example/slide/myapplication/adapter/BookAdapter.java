package com.example.slide.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.slide.myapplication.R;
import com.example.slide.myapplication.model.DataBuku;

import java.util.ArrayList;
import java.util.List;

/**
 * * Written by @JoeFachrizal 02/10/2019.
 **/
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> implements Filterable {
    private List<DataBuku> bookList;
    private List<DataBuku> bookListFiltered;
    private Context context;

    public void setMovieList(Context ctx, List<DataBuku> bookList) {
        this.context = ctx;
        if (this.bookList == null) {
            this.bookList = bookList;
            this.bookListFiltered = bookList;
            notifyItemChanged(0, bookListFiltered.size());
        } else {
            final DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return BookAdapter.this.bookList.size();
                }

                @Override
                public int getNewListSize() {
                    return bookList.size();
                }

                @Override
                public boolean areItemsTheSame(int i, int i1) {
                    return BookAdapter.this.bookList.get(i).getNamaBuku().equals(bookList.get(i1).getNamaBuku());
                }

                @Override
                public boolean areContentsTheSame(int i, int i1) {
                    DataBuku newBuku = BookAdapter.this.bookList.get(i);
                    DataBuku oldBuku = bookList.get(i1);
                    return newBuku.getNamaBuku().equals(oldBuku.getNamaBuku());
                }
            });
            this.bookList = bookList;
            this.bookListFiltered = bookList;
            result.dispatchUpdatesTo(this);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_buku, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(bookListFiltered.get(i).getNamaBuku());
    }

    @Override
    public int getItemCount() {
        if (bookList != null) {
            return bookListFiltered.size();
        } else {
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.TxtNamaBuku);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    bookListFiltered = bookList;
                } else {
                    List<DataBuku> filteredList = new ArrayList<>();
                    for (DataBuku dataBuku : bookList) {
                        if (dataBuku.getNamaBuku().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(dataBuku);
                        }
                    }
                    bookListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = bookListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                bookListFiltered = (ArrayList<DataBuku>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
