package fr.isima.gudaniel1.pam2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ShowDetailCallback {

    public static final String COMIC_EXTRA = "fr.isima.gudaniel1.pam2020.COMIC_EXTRA";

    private RecyclerView recyclerView;
    private ComicsAdapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateTextview();


        recyclerView = findViewById(R.id.main_recycler_view);

        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new ComicsAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    public void updateTextview(){
        ListViewModel viewModel = new ViewModelProvider(this).get(ListViewModel.class);

        LiveData<List<Comic>> comics = viewModel.getComics();
        if(comics.getValue() == null){
            Toast.makeText(this, "Mise a jour en cours...", Toast.LENGTH_LONG).show();
        }
        comics.observe(this, list -> {
            if(list == null || list.isEmpty()){
                Log.d("MainActivity", "Liste Vide");
                Toast.makeText(this, "Erreur lors de la récupération des Comics", Toast.LENGTH_LONG).show();
            } else {
                adapter.setList(list);
            }

        });

    }

    @Override
    public void showDetail(Comic c){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(COMIC_EXTRA, c);
        startActivity(intent);
    }
}
