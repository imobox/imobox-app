package br.imobox.com.imobox.handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.imobox.com.imobox.model.Client;

/**
 * Created by matheuscatossi on 15/11/17.
 */

public class DatabaseRealtorHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "clientManager";
    private static final String TABLE_CLIENT = "client";

    private static final String KEY_ID = "id";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PERFIL = "perfil";
    private static final String KEY_ABOUT = "about";
    private static final String KEY_BIRTHDAY = "birthday";
    private static final String KEY_SCHOOL_RECORDS = "school_records";
    private static final String KEY_WORK_RECORDS = "work_records";
    private static final String KEY_LOCATION = "location";
    private static final String KEY_SEX = "sex";
    private static final String KEY_TYPE = "type";
    private static final String KEY_LOOKING_FOR = "looking_for";
    private static final String KEY_MOMENT = "moment";


    public DatabaseRealtorHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CLIENT + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_EMAIL + " TEXT,"
                + KEY_PERFIL + " TEXT,"
                + KEY_ABOUT + " TEXT,"
                + KEY_BIRTHDAY + " TEXT,"
                + KEY_SCHOOL_RECORDS + " TEXT,"
                + KEY_WORK_RECORDS + " TEXT,"
                + KEY_LOCATION + " TEXT,"
                + KEY_TYPE + " TEXT,"
                + KEY_SEX + " TEXT,"
                + KEY_LOOKING_FOR + " TEXT,"
                + KEY_MOMENT + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENT);
        onCreate(db);
    }

    public void addClient(Client user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_EMAIL, user.getEmail());
        values.put(KEY_PERFIL, user.getPerfil());
        values.put(KEY_ABOUT, user.getAbout());
        values.put(KEY_BIRTHDAY, user.getBirthday());
        values.put(KEY_SCHOOL_RECORDS, user.getSchoolRecords());
        values.put(KEY_WORK_RECORDS, user.getWorkRecords());
        values.put(KEY_LOCATION, user.getLocation());
        values.put(KEY_TYPE, user.getType());
        values.put(KEY_SEX, user.getSex());
        values.put(KEY_LOOKING_FOR, user.getLookingFor());
        values.put(KEY_MOMENT, user.getMoment());

        db.insert(TABLE_CLIENT, null, values);
        db.close();
    }

    public Client getClient(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CLIENT, new String[]{KEY_ID,
                        KEY_EMAIL, KEY_PERFIL, KEY_ABOUT, KEY_BIRTHDAY, KEY_SCHOOL_RECORDS, KEY_WORK_RECORDS, KEY_LOCATION, KEY_SEX, KEY_TYPE, KEY_LOOKING_FOR, KEY_MOMENT}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Client client = new Client(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11));

        return client;
    }

    public int updateClient(Client user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, user.getEmail());
        values.put(KEY_PERFIL, user.getPerfil());
        values.put(KEY_ABOUT, user.getAbout());
        values.put(KEY_BIRTHDAY, user.getBirthday());
        values.put(KEY_SCHOOL_RECORDS, user.getSchoolRecords());
        values.put(KEY_WORK_RECORDS, user.getWorkRecords());
        values.put(KEY_LOCATION, user.getLocation());
        values.put(KEY_TYPE, user.getType());
        values.put(KEY_LOOKING_FOR, user.getLookingFor());
        values.put(KEY_MOMENT, user.getMoment());

        return db.update(TABLE_CLIENT, values, KEY_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
    }

    public void deleteUser(Client client) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CLIENT, KEY_ID + " = ?",
                new String[]{String.valueOf(client.getId())});
        db.close();
    }

    public int getClientsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CLIENT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();

        return cursor.getCount();
    }
}

