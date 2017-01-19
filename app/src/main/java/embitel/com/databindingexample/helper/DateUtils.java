package embitel.com.databindingexample.helper;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateUtils {

   private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance();

   public static String formatDate(final Date date) {
      return DATE_FORMAT.format(date);
   }

   public static Date parseDate(final String dateString) {
      try {
         return DATE_FORMAT.parse(dateString);
      } catch (ParseException e) {
         return null;
      }
   }

   @BindingAdapter({"bind:imageUrl","bind:error"})
   public static void loadImage(ImageView view, String url, Drawable error) {
      Picasso.with(view.getContext()).load(url).error(error).into(view);
   }
}
