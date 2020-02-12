package fr.isima.gudaniel1.pam2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateTextview();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        recyclerView = findViewById(R.id.main_recycler_view);

        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new ComicsAdapter();
        recyclerView.setAdapter(adapter);

    }

    public void updateTextview(){
        ListViewModel viewModel = new ViewModelProvider(this).get(ListViewModel.class);

        viewModel.getComics().observe(this, comics -> {
            if(comics.isEmpty()){
                Log.d("TOTO", "Y a rien dans la liste");
            } else {
                Log.d("TOTO", comics.toString());
            }

        });

    }
}
