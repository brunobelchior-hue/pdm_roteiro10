package com.example.sgm;

import androidx.annotation.NonNull;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class VeiculoDao_Impl implements VeiculoDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<Veiculo> __insertAdapterOfVeiculo;

  private final EntityDeleteOrUpdateAdapter<Veiculo> __deleteAdapterOfVeiculo;

  private final EntityDeleteOrUpdateAdapter<Veiculo> __updateAdapterOfVeiculo;

  public VeiculoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfVeiculo = new EntityInsertAdapter<Veiculo>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `veiculos` (`id`,`marca`,`modelo`,`valor`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, final Veiculo entity) {
        statement.bindLong(1, entity.id);
        if (entity.marca == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.marca);
        }
        if (entity.modelo == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.modelo);
        }
        if (entity.valor == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.valor);
        }
      }
    };
    this.__deleteAdapterOfVeiculo = new EntityDeleteOrUpdateAdapter<Veiculo>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `veiculos` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, final Veiculo entity) {
        statement.bindLong(1, entity.id);
      }
    };
    this.__updateAdapterOfVeiculo = new EntityDeleteOrUpdateAdapter<Veiculo>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `veiculos` SET `id` = ?,`marca` = ?,`modelo` = ?,`valor` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, final Veiculo entity) {
        statement.bindLong(1, entity.id);
        if (entity.marca == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.marca);
        }
        if (entity.modelo == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.modelo);
        }
        if (entity.valor == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.valor);
        }
        statement.bindLong(5, entity.id);
      }
    };
  }

  @Override
  public long inserir(final Veiculo veiculo) {
    return DBUtil.performBlocking(__db, false, true, (_connection) -> {
      return __insertAdapterOfVeiculo.insertAndReturnId(_connection, veiculo);
    });
  }

  @Override
  public int excluir(final Veiculo veiculo) {
    return DBUtil.performBlocking(__db, false, true, (_connection) -> {
      int _result = 0;
      _result += __deleteAdapterOfVeiculo.handle(_connection, veiculo);
      return _result;
    });
  }

  @Override
  public int atualizar(final Veiculo veiculo) {
    return DBUtil.performBlocking(__db, false, true, (_connection) -> {
      int _result = 0;
      _result += __updateAdapterOfVeiculo.handle(_connection, veiculo);
      return _result;
    });
  }

  @Override
  public List<Veiculo> listar() {
    final String _sql = "SELECT * FROM veiculos ORDER BY id DESC";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfMarca = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "marca");
        final int _columnIndexOfModelo = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "modelo");
        final int _columnIndexOfValor = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "valor");
        final List<Veiculo> _result = new ArrayList<Veiculo>();
        while (_stmt.step()) {
          final Veiculo _item;
          final String _tmpMarca;
          if (_stmt.isNull(_columnIndexOfMarca)) {
            _tmpMarca = null;
          } else {
            _tmpMarca = _stmt.getText(_columnIndexOfMarca);
          }
          final String _tmpModelo;
          if (_stmt.isNull(_columnIndexOfModelo)) {
            _tmpModelo = null;
          } else {
            _tmpModelo = _stmt.getText(_columnIndexOfModelo);
          }
          final String _tmpValor;
          if (_stmt.isNull(_columnIndexOfValor)) {
            _tmpValor = null;
          } else {
            _tmpValor = _stmt.getText(_columnIndexOfValor);
          }
          _item = new Veiculo(_tmpMarca,_tmpModelo,_tmpValor);
          _item.id = (int) (_stmt.getLong(_columnIndexOfId));
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
