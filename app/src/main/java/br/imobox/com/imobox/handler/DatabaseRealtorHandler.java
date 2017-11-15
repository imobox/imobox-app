package br.imobox.com.imobox.handler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.imobox.com.imobox.model.Client;
import br.imobox.com.imobox.model.Realtor;

/**
 * Created by matheuscatossi on 15/11/17.
 */

public class DatabaseRealtorHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "realtorManager";
    private static final String TABLE_REALTOR = "realtor";

    private static final String KEY_ID = "id";
    private static final String KEY_CRECI = "creci";
    private static final String KEY_TIPO_IMOVEL = "tipo_imovel";
    private static final String KEY_DISPONIBILIDADE = "disponibilidade";
    private static final String KEY_PREFERENCIA = "preferencia";

    public DatabaseRealtorHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_REALTOR + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_CRECI + " TEXT,"
                + KEY_TIPO_IMOVEL + " TEXT,"
                + KEY_DISPONIBILIDADE + " TEXT,"
                + KEY_PREFERENCIA + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REALTOR);
        onCreate(db);
    }

    public void addRealtor(Realtor realtor) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_CRECI, realtor.getCreci());
        values.put(KEY_TIPO_IMOVEL, realtor.getTipoImovel());
        values.put(KEY_DISPONIBILIDADE, realtor.getDisponibilidade());
        values.put(KEY_PREFERENCIA, realtor.getPreferencia());

        db.insert(TABLE_REALTOR, null, values);
        db.close();
    }

    public Realtor getRealtor(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_REALTOR, new String[]{KEY_ID,
                        KEY_CRECI, KEY_TIPO_IMOVEL, KEY_DISPONIBILIDADE, KEY_PREFERENCIA}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Realtor realtor = new Realtor(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
        return realtor;
    }

    public int updateRealtor(Realtor realtor) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CRECI, realtor.getCreci());
        values.put(KEY_TIPO_IMOVEL, realtor.getTipoImovel());
        values.put(KEY_DISPONIBILIDADE, realtor.getDisponibilidade());
        values.put(KEY_PREFERENCIA, realtor.getPreferencia());

        return db.update(TABLE_REALTOR, values, KEY_ID + " = ?",
                new String[]{String.valueOf(realtor.getId())});
    }

    public void deleteUser(Client client) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_REALTOR, KEY_ID + " = ?",
                new String[]{String.valueOf(client.getId())});
        db.close();
    }

    public int getRealtorCounts() {
        String countQuery = "SELECT  * FROM " + TABLE_REALTOR;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();

        return cursor.getCount();
    }
}

