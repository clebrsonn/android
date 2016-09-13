package hyteck.com.br.headache.dao;

import android.provider.BaseColumns;

/**
 * Created by clebr on 10/09/2016.
 */
public final class HeadacheContractor implements BaseColumns {

    public HeadacheContractor() {
    }

    public static final String TABLE_NAME = "headache";
    public static final String COLUMN_NAME_HEADACH_ID = "id";
    public static final String COLUMN_NAME_DATAINI = "data_inicio";
    public static final String COLUMN_NAME_HORAINI = "hora_inicio";
    public static final String COLUMN_NAME_HORAFIM = "hora_fim";
    public static final String COLUMN_NAME_DATAFIM = "data_fim";
    public static final String COLUMN_NAME_INTENSIDADE = "intensidade";


    private static final String TEXT_TYPE = " TEXT";
    //    private static final String DATE_TYPE = " DATE";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY NOT NULL, " +
                    COLUMN_NAME_HEADACH_ID + INTEGER_TYPE + COMMA_SEP +
                    COLUMN_NAME_DATAFIM + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_DATAINI + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_HORAFIM + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_HORAINI + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_INTENSIDADE + TEXT_TYPE +
                    " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


}
