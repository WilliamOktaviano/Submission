package pemrogramanmobile.wisatajabodetabek;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvObjekWisata;
    private ArrayList<TempatWisata> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvObjekWisata = findViewById(R.id.rv_objekwisata);
        rvObjekWisata.setHasFixedSize(true);

        list.addAll(TempatWisataDetail.getListData());
        showRecyclerList();
    }

    public boolean onCreateOptionsMenu(Menu about) {
        getMenuInflater().inflate(R.menu.menu_main, about);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_about:
                startActivity(new Intent(MainActivity.this, AboutMe.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void showRecyclerList() {
        rvObjekWisata.setLayoutManager(new LinearLayoutManager(this));
        ListObjekWisataAdapter listObjekWisataAdapter = new ListObjekWisataAdapter(list);
        rvObjekWisata.setAdapter(listObjekWisataAdapter);

        listObjekWisataAdapter.setOnItemClickCallback(new ListObjekWisataAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(TempatWisata data) {
                showDetailTempatWisata(data);
            }
        });
    }

    private void showDetailTempatWisata(TempatWisata tempatwisata) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra("TempatWisata", tempatwisata);
        startActivity(i);

    }
}
