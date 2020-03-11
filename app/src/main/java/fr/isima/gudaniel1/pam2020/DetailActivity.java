package fr.isima.gudaniel1.pam2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        TextView text = findViewById(R.id.activity_detail_text);
        ImageView img = findViewById(R.id.activity_detail_img);

        Intent intent = getIntent();
        Comic c = (Comic) intent.getSerializableExtra(MainActivity.COMIC_EXTRA);

        setTitle(c.getNum() + " : " + c.getTitle() + " (" + c.getDay() + "/" + c.getMonth() + "/" + c.getYear() + ")");

        text.setText(c.getTitle() + "\n" + c.getDay() + "/" + c.getMonth() + "/" + c.getYear());

        Picasso.get().load(c.img).into(img);

    }
}
