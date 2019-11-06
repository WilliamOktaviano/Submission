package pemrogramanmobile.wisatajabodetabek;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView imgObjekWisata;
    TextView tvNamaObjek;
    TextView tvDetailObjek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgObjekWisata = findViewById(R.id.img_objek_wisata);
        tvNamaObjek = findViewById(R.id.tv_objek_wisata);
        tvDetailObjek = findViewById(R.id.tv_objek_wisata_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Wisata Jabodetabek");
        }

        Intent i = getIntent();
        TempatWisata tempatWisata = i.getParcelableExtra("TempatWisata");

        Glide.with(this).load(tempatWisata.getDetailphoto()).into(imgObjekWisata);
        tvNamaObjek.setText(tempatWisata.getObjekwisata_name());
        tvDetailObjek.setText(tempatWisata.getLokasi());
    }
}
