package com.example.atividade02entrega.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.atividade02entrega.model.PontoLocalidade;

@Database(entities = {PontoLocalidade.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PontoLocalidadeDAO pontoLocalidadeDAO();
}
