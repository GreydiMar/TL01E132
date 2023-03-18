package com.example.examen1.Configuracion;

public class Transacciones
{
    //Nombre de la base de datos
    public static final String NameDatabase = "EXAM";

    //Creacion de tabla y objetos

    public static final String tablacontactos = "contactos";

    //Campos de la tabla personas
    public static String id= "id";
    public static String pais= "pais";
    public static String nombre= "nombre";
    public static String telefono= "telefono";
    public static String nota= "nota";


    //Consultas SQL DDL

    public static String CreateTBContactos = "CREATE TABLE contactos ( id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "pais TEXT, nombre TEXT, telefono INTEGER, nota TEXT )";

    public static String DropTBContactos = "DROP TABLE IF EXISTS contactos";

}


