package com.example.atividade02entrega.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.atividade02entrega.model.PontoLocalidade;

import java.util.List;

@Dao
public interface PontoLocalidadeDAO {
    @Query("SELECT * FROM pontoLocalidade")
    List<PontoLocalidade> getAll();

    @Insert
    void insertAll(PontoLocalidade... pontosLocalidades);

    @Delete
    void delete(PontoLocalidade pontoLocalidade);
}
