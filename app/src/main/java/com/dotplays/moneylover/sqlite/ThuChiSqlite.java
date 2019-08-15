package com.dotplays.moneylover.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dotplays.moneylover.model.ThuChi;

public class ThuChiSqlite extends SQLiteOpenHelper {

    public static final String tc_id = "id";

    public static final String tc_ten = "ten";

    public static final String tc_tien = "tien";

    public static final String tc_thoiGian = "thoiGian";

    public static final String tc_khoanThuChi = "khoanThuChi";

    public static final String tc_loaiThuChi = "loaiThuChi";

    public static final String thuChi_Table = "khoanThuChi";

    public static final String taobangThuChi =
            "Create table khoanThuChi (id integer primary key autoincrement," +
                    "ten TEXT,tien FLOAT,thoiGian TEXT,khoanThuChi TEXT," +
                    "loaiThuChi TEXT)";


    public ThuChiSqlite(Context context) {
        super(context, "thuChi.db", null, 1);
    }

    public long delThuChi(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        long kq = sqLiteDatabase.delete(thuChi_Table, tc_id + "=?",
                new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
        return kq;
    }

    public long insertThuChi(ThuChi thuChi) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(tc_ten, thuChi.tc_ten);
        contentValues.put(tc_tien, thuChi.tc_tien);
        contentValues.put(tc_thoiGian, thuChi.tc_thoiGian);
        contentValues.put(tc_khoanThuChi, thuChi.tc_khoanThuChi);
        contentValues.put(tc_loaiThuChi, thuChi.tc_loaiThuChi);

        long kq = sqLiteDatabase.insert(thuChi_Table, null, contentValues);

        sqLiteDatabase.close();

        return kq;


    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(taobangThuChi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
