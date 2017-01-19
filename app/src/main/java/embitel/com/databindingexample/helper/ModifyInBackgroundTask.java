package embitel.com.databindingexample.helper;

import android.os.AsyncTask;

import java.util.List;

public class ModifyInBackgroundTask extends AsyncTask<Void, Void, Void> {
   private final List<Movie> allMovies;

   public ModifyInBackgroundTask(List<Movie> allMovies) {
      this.allMovies=allMovies;
   }

   @Override
   protected Void doInBackground(Void... params) {
      for (Movie movie : allMovies) {
         movie.setTitle(movie.getTitle() + " modified");
      }
      return null;
   }
}
