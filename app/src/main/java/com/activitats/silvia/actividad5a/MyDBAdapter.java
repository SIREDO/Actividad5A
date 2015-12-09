package com.activitats.silvia.actividad5a;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Silvia on 04/12/2015.
 */
public class MyDBAdapter {

    //Definiciones y constantes
    private static final String DATABASE_NAME = "dbclase.db";
    private static final String DATABASE_TABLE1 = "profesor";
    private static final String DATABASE_TABLE2 = "estudiante";
    private static final int DATABASE_VERSION = 1;

    private static final String NOMBRE = "nombre";
    private static final String EDAD = "edad";
    private static final String CICLO = "ciclo";
    private static final String CURSO = "curso";
    private static final String NOTA_MEDIA = "nota_media";
    private static final String CURSO_TUTOR = "curso_tutor";
    private static final String DESPACHO = "despacho";

    private static final String DATABASE_CREATE1 = "CREATE TABLE "+DATABASE_TABLE1+" (_id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso integer, nota_media integer);";
    private static final String DATABASE_CREATE2 = "CREATE TABLE "+DATABASE_TABLE2+" (_id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso_tutor integer, despacho integer);";
    private static final String DATABASE_DROP1 = "DROP TABLE IF EXISTS "+DATABASE_TABLE1+";";
    private static final String DATABASE_DROP2 = "DROP TABLE IF EXISTS "+DATABASE_TABLE2+";";

    // Contexto de la aplicación que usa la base de datos
    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private MyDbHelper dbHelper;
    // Instancia de la base de datos
    private SQLiteDatabase db;

    public MyDBAdapter (Context c){
        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        //OJO open();
    }

    public void open(){

        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }

    }

    public void insertarEstudiante(String n, int e, String ci, String cu, int not){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBRE,n);
        newValues.put(EDAD,e);
        newValues.put(CICLO,ci);
        newValues.put(CURSO,cu);
        newValues.put(NOTA_MEDIA, not);
        db.insert(DATABASE_TABLE1,null,newValues);
    }
    public void insertarProfesor(String n, int e, String ci, String cu, int des){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBRE,n);
        newValues.put(EDAD,e);
        newValues.put(CICLO,ci);
        newValues.put(CURSO_TUTOR,cu);
        newValues.put(DESPACHO, des);
        db.insert(DATABASE_TABLE2,null,newValues);
    }

    public void eliminarEstudiante(int id){
        db.delete(DATABASE_TABLE2, "_id=" + id, null);
    }
    public void eliminarProfesor(int id){
        db.delete(DATABASE_TABLE1, "_id="+id,null);
    }
    public void eliminarBD(){
       context.deleteDatabase(DATABASE_NAME);
    }



    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE1);
            db.execSQL(DATABASE_CREATE2);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP1);
            db.execSQL(DATABASE_DROP2);
            onCreate(db);
        }

    }







}
