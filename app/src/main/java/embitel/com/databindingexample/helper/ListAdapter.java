package embitel.com.databindingexample.helper;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import embitel.com.databindingexample.R;
import embitel.com.databindingexample.databinding.ListItemBinding;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final List<Movie> movies;

    public ListAdapter(Context context, List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.binding.setMovie(movies.get(position));
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ListItemBinding binding;

        ViewHolder(final View view) {
            super(view);
            binding=DataBindingUtil.bind(view);
            binding.setHandler(new MyHandlers());
        }
    }
}
