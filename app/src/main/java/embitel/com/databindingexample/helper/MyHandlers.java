package embitel.com.databindingexample.helper;

import android.content.Context;
import android.view.View;

import embitel.com.databindingexample.activity.DetailActivity;

public class MyHandlers {

   /* public View.OnClickListener onItemClicked(final Movie movie){
        return new View.OnClickListener() {

            public void onClick(View v) {
                Context context = v.getContext();
                context.startActivity(DetailActivity.buildIntent(context, movie));
            }
        };
    }*/

    public void onItemClicked(View v, Movie movie) {
        Context context = v.getContext();
        context.startActivity(DetailActivity.buildIntent(context, movie));
    }


}
