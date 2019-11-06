package pemrogramanmobile.wisatajabodetabek;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListObjekWisataAdapter extends RecyclerView.Adapter<ListObjekWisataAdapter.ListViewHolder> {
    private ArrayList<TempatWisata> listObjekWisata;

    public ListObjekWisataAdapter(ArrayList<TempatWisata> list) {
        this.listObjekWisata = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_objekwisata, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, final int position) {
        final TempatWisata tempatWisata = listObjekWisata.get(position);
        Glide.with(holder.itemView.getContext())
                .load(tempatWisata.getDetailphoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(tempatWisata.getObjekwisata_name());
        holder.tvFrom.setText(tempatWisata.getLokasi());

        holder.btnDetail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("detail", TempatWisataDetail.getListData());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listObjekWisata.size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvFrom;
        Button btnDetail;
        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_from);
            btnDetail = itemView.findViewById(R.id.btn_set_detail);
        }
    }
}
