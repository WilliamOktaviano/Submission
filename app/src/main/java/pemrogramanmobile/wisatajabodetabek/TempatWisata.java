package pemrogramanmobile.wisatajabodetabek;

import android.os.Parcel;
import android.os.Parcelable;

public class TempatWisata implements Parcelable {
    public static final Parcelable.Creator<TempatWisata> CREATOR = new Parcelable.Creator<TempatWisata>() {

        @Override
        public TempatWisata createFromParcel(Parcel parcel) {
            return new TempatWisata(parcel);
        }

        @Override
        public TempatWisata[] newArray(int size) {
            return new TempatWisata[0];
        }
    };
    private String objekwisata_name;
    private String lokasi;
    private String detailphoto;

    public TempatWisata(Parcel parcel) {
        objekwisata_name = parcel.readString();
        lokasi = parcel.readString();
        detailphoto = parcel.readString();
    }

    public TempatWisata() {

    }

    public String getObjekwisata_name() {
        return objekwisata_name;

    }

    public void setObjekwisata_name(String objekwisata_name) {
        this.objekwisata_name = objekwisata_name;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getDetailphoto() {
        return detailphoto;
    }

    public void setDetailphoto(String detailphoto) {
        this.detailphoto = detailphoto;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(objekwisata_name);
        dest.writeString(lokasi);
        dest.writeString(detailphoto);
    }
}
