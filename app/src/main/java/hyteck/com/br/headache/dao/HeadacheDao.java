package hyteck.com.br.headache.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hyteck.com.br.headache.entity.Headache;

/**
 * Created by clebr on 09/09/2016.
 */
public class HeadacheDao {

    private SQLiteDatabase database;
    private CreateDB dbHelper;

    //Campos da tabela Agenda
    private String[] colunas = {
            HeadacheContractor._ID,
            HeadacheContractor.COLUMN_NAME_DATAINI,
            HeadacheContractor.COLUMN_NAME_HORAINI,
            HeadacheContractor.COLUMN_NAME_DATAFIM,
            HeadacheContractor.COLUMN_NAME_HORAFIM,
            HeadacheContractor.COLUMN_NAME_INTENSIDADE,
            HeadacheContractor.COLUMN_NAME_HEADACH_ID,

    };

    public HeadacheDao(Context context) {
        dbHelper = new CreateDB(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void read() throws SQLException {
        database = dbHelper.getReadableDatabase();
    }

    public Long inserir(Headache pValue) {
        open();
        ContentValues values = valuesPut(pValue);

        //Carregar os valores nos campos do Contato que será incluído
//        values.put(HeadacheContractor.COLUMN_NAME_HEADACH_ID, pValue.getId());
//        values.put(HeadacheContractor.COLUMN_NAME_DATAFIM, String.valueOf(pValue.getDataTermino()));
//        values.put(HeadacheContractor.COLUMN_NAME_DATAINI, String.valueOf(pValue.getDataInicio()));
//        values.put(HeadacheContractor.COLUMN_NAME_HORAFIM, pValue.getHoraTermino());
//        values.put(HeadacheContractor.COLUMN_NAME_HORAINI, pValue.getHoraTermino());
//        values.put(HeadacheContractor.COLUMN_NAME_INTENSIDADE, String.valueOf(pValue.getIntensidade()));

        Long result = database.insert(HeadacheContractor.TABLE_NAME, null, values);
        close();

        return result;
    }


    public int alterar(Headache pValue) {
        open();

        Long id = pValue.getId();

        Log.i("id_alt", "id para alterar: " + String.valueOf(id));
        //Carregar os novos valores nos campos que serão alterados
        ContentValues values = valuesPut(pValue);

        //Alterar o registro com base no ID
        int result = database.update(HeadacheContractor.TABLE_NAME, values,
                HeadacheContractor._ID + " = " + id, null);

        close();

        return result;
    }
//
//    public int excluir(Headache pValue) {
//
//        Long id = pValue.getId();
//
//        //Exclui o registro com base no ID
//        int result = database.delete(HeadacheContractor.TABLE_NAME,
//                HeadacheContractor._ID + " = " + id, null);
//        return result;
//    }

    public List<Headache> consultar() {

        read();
        List<Headache> lstAgenda = new ArrayList<>();

        //Consulta para trazer todos os dados da tabela headache ordenados pela coluna data inicio
        Cursor cursor = database.query(HeadacheContractor.TABLE_NAME, colunas,
                null, null, null, null, HeadacheContractor.COLUMN_NAME_DATAINI);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Headache iHeadache = cursorHeadache(cursor);
            lstAgenda.add(iHeadache);
            cursor.moveToNext();
        }

        //Tenha certeza que você fechou o cursor
        cursor.close();
        close();
        return lstAgenda;
    }

    //Converter o Cursor de dados no objeto POJO ContatoVO
    private Headache cursorHeadache(Cursor cursor) {
        Headache lContatoVO = new Headache();

        Log.i("id", "id " + String.valueOf(cursor.getLong(0)));
        Log.i("dtfim", "1: " + cursor.getString(1));
        Log.i("dtini", "2: " + cursor.getString(2));
        Log.i("hrfim", "3: " + cursor.getString(3));
        Log.i("hrini", "4: " + cursor.getString(4));
        Log.i("nsei", "5: " + cursor.getString(5));


        lContatoVO.setId(cursor.getLong(0));
        lContatoVO.setDataInicio(cursor.getString(1));
        lContatoVO.setHoraInicio(cursor.getString(2));
        lContatoVO.setDataTermino(cursor.getString(3));
        lContatoVO.setHoraTermino(cursor.getString(4));
        lContatoVO.setIntensidade(cursor.getString(5));
        return lContatoVO;
    }

    private ContentValues valuesPut(Headache pValue) {
        ContentValues values = new ContentValues();

        values.put(HeadacheContractor._ID, pValue.getId());
        values.put(HeadacheContractor.COLUMN_NAME_HEADACH_ID, pValue.getId());
        values.put(HeadacheContractor.COLUMN_NAME_DATAFIM, pValue.getDataTermino());
        values.put(HeadacheContractor.COLUMN_NAME_DATAINI, pValue.getDataInicio());
        values.put(HeadacheContractor.COLUMN_NAME_HORAFIM, pValue.getHoraTermino());
        values.put(HeadacheContractor.COLUMN_NAME_HORAINI, pValue.getHoraInicio());
        values.put(HeadacheContractor.COLUMN_NAME_INTENSIDADE, pValue.getIntensidade());

        return values;
    }
}
