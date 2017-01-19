package embitel.com.databindingexample.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import embitel.com.databindingexample.R;
import embitel.com.databindingexample.databinding.ActivityMainBinding;
import embitel.com.databindingexample.helper.ListAdapter;
import embitel.com.databindingexample.helper.ModifyInBackgroundTask;
import embitel.com.databindingexample.helper.MovieStore;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        RecyclerView list = binding.list;
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        final ListAdapter adapter = new ListAdapter(this,MovieStore.getAllMovies());
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_modify) {
            new ModifyInBackgroundTask(MovieStore.getAllMovies()).execute();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
