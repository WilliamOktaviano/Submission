package pemrogramanmobile.wisatajabodetabek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private ArrayList<TempatWisata> listdetail = new ArrayList<>();

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

        Bundle extras = getIntent().getExtras();
        String[] arrayList = extras.getStringArray("detail");
        imgObjekWisata.setImageURI(Uri.parse(arrayList[0]));
        tvNamaObjek.setText(arrayList[1]);
        tvDetailObjek.setText(arrayList[2]);
    }
}
