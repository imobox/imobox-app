package br.imobox.com.imobox.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by matheuscatossi on 15/11/17.
 */

public class Client implements Parcelable {
    private String id;
    private String email;
    private String perfil;
    private String about;
    private String birthday;
    private String schoolRecords;
    private String workRecords;
    private String location;
    private String sex;
    private String type;
    private String lookingFor;
    private String moment;

    public Client() {

    }

    public Client(String id, String email, String perfil, String about, String birthday, String schoolRecords, String workRecords, String location, String sex, String type, String lookingFor, String moment) {
        this.id = id;
        this.email = email;
        this.perfil = perfil;
        this.about = about;
        this.birthday = birthday;
        this.schoolRecords = schoolRecords;
        this.workRecords = workRecords;
        this.location = location;
        this.sex = sex;
        this.type = type;
        this.lookingFor = lookingFor;
        this.moment = moment;
    }

    public Client(String email, String perfil, String about, String birthday, String schoolRecords, String workRecords, String location, String sex, String type, String lookingFor, String moment) {
        this.email = email;
        this.perfil = perfil;
        this.about = about;
        this.birthday = birthday;
        this.schoolRecords = schoolRecords;
        this.workRecords = workRecords;
        this.location = location;
        this.sex = sex;
        this.type = type;
        this.lookingFor = lookingFor;
        this.moment = moment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSchoolRecords() {
        return schoolRecords;
    }

    public void setSchoolRecords(String schoolRecords) {
        this.schoolRecords = schoolRecords;
    }

    public String getWorkRecords() {
        return workRecords;
    }

    public void setWorkRecords(String workRecords) {
        this.workRecords = workRecords;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(String lookingFor) {
        this.lookingFor = lookingFor;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.email);
        dest.writeString(this.perfil);
        dest.writeString(this.about);
        dest.writeString(this.birthday);
        dest.writeString(this.schoolRecords);
        dest.writeString(this.workRecords);
        dest.writeString(this.location);
        dest.writeString(this.sex);
        dest.writeString(this.type);
        dest.writeString(this.lookingFor);
        dest.writeString(this.moment);
    }

    protected Client(Parcel in) {
        this.id = in.readString();
        this.email = in.readString();
        this.perfil = in.readString();
        this.about = in.readString();
        this.birthday = in.readString();
        this.schoolRecords = in.readString();
        this.workRecords = in.readString();
        this.location = in.readString();
        this.sex = in.readString();
        this.type = in.readString();
        this.lookingFor = in.readString();
        this.moment = in.readString();
    }

    public static final Parcelable.Creator<Client> CREATOR = new Parcelable.Creator<Client>() {
        @Override
        public Client createFromParcel(Parcel source) {
            return new Client(source);
        }

        @Override
        public Client[] newArray(int size) {
            return new Client[size];
        }
    };
}
