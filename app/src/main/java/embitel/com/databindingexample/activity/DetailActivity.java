package embitel.com.databindingexample.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import embitel.com.databindingexample.R;
import embitel.com.databindingexample.databinding.ActivityDetailBinding;
import embitel.com.databindingexample.helper.DateUtils;
import embitel.com.databindingexample.helper.Movie;

public class DetailActivity extends AppCompatActivity {

   private static final String EXTRA_MOVIE = "EXTRA_MOVIE";
   private ActivityDetailBinding binding;

   public static Intent buildIntent(final Context context, final Movie movie) {
      Intent intent = new Intent(context, DetailActivity.class);
      intent.putExtra(EXTRA_MOVIE, movie);
      return intent;
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      final Movie movie = (Movie)getIntent().getSerializableExtra(EXTRA_MOVIE);
      binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
      binding.setMovie(movie);
      binding.saveButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            String title = binding.title.getText().toString();
            String genre = binding.genre.getText().toString();
            String publicationDateString = binding.publicationDate.getText().toString();
            movie.setTitle(title);
            movie.setGenre(genre);
            movie.setPublicationDate(DateUtils.parseDate(publicationDateString));
            finish();
         }
      });
   }
}
