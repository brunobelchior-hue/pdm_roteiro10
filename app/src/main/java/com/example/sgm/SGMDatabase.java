package com.example.sgm;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Delete;
import androidx.room.Query;
import java.util.List;

@Dao
interface ClienteDao {
    @Insert long inserir(Cliente cliente);
    @Update int atualizar(Cliente cliente);
    @Delete int excluir(Cliente cliente);
    @Query("SELECT * FROM clientes ORDER BY id DESC") List<Cliente> listar();
}

@Dao
interface VeiculoDao {
    @Insert long inserir(Veiculo veiculo);
    @Update int atualizar(Veiculo veiculo);
    @Delete int excluir(Veiculo veiculo);
    @Query("SELECT * FROM veiculos ORDER BY id DESC") List<Veiculo> listar();
}

@Database(entities = {Cliente.class, Veiculo.class}, version = 1, exportSchema = false)
public abstract class SGMDatabase extends RoomDatabase {
    public abstract ClienteDao clienteDao();
    public abstract VeiculoDao veiculoDao();
    private static volatile SGMDatabase INSTANCE;
    public static SGMDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SGMDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), SGMDatabase.class, "sgm_local.db").build();
                }
            }
        }
        return INSTANCE;
    }
}
