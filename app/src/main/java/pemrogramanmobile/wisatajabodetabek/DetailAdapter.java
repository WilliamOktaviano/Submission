package pemrogramanmobile.wisatajabodetabek;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ListViewHolder>{
    private ArrayList<TempatWisata> listdetail;
    public DetailAdapter(ArrayList<TempatWisata> list) {
        this.listdetail = list;
    }


    public DetailAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detail, viewGroup, false);
        return new DetailAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailAdapter.ListViewHolder holder, int position) {
        TempatWisata tempatWisata = listdetail.get(position);
        Glide.with(holder.itemView.getContext())
                .load(tempatWisata.getDetailphoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgObjekWisata);
        holder.tvNamaObjek.setText(tempatWisata.getObjekwisata_name());
        holder.tvDetailObjek.setText(tempatWisata.getLokasi());
    }

    @Override
    public int getItemCount() {
        return listdetail.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgObjekWisata;
        TextView tvNamaObjek;
        TextView tvDetailObjek;
        ListViewHolder(View itemView) {
            super(itemView);
            imgObjekWisata = itemView.findViewById(R.id.img_objek_wisata);
            tvNamaObjek = itemView.findViewById(R.id.tv_objek_wisata);
            tvDetailObjek = itemView.findViewById(R.id.tv_objek_wisata_detail);
        }
    }
}
