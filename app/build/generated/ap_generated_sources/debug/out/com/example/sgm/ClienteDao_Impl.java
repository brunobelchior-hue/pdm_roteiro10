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
public final class ClienteDao_Impl implements ClienteDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<Cliente> __insertAdapterOfCliente;

  private final EntityDeleteOrUpdateAdapter<Cliente> __deleteAdapterOfCliente;

  private final EntityDeleteOrUpdateAdapter<Cliente> __updateAdapterOfCliente;

  public ClienteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfCliente = new EntityInsertAdapter<Cliente>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `clientes` (`id`,`nome`,`telefone`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, final Cliente entity) {
        statement.bindLong(1, entity.id);
        if (entity.nome == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.nome);
        }
        if (entity.telefone == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.telefone);
        }
      }
    };
    this.__deleteAdapterOfCliente = new EntityDeleteOrUpdateAdapter<Cliente>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `clientes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, final Cliente entity) {
        statement.bindLong(1, entity.id);
      }
    };
    this.__updateAdapterOfCliente = new EntityDeleteOrUpdateAdapter<Cliente>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `clientes` SET `id` = ?,`nome` = ?,`telefone` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement, final Cliente entity) {
        statement.bindLong(1, entity.id);
        if (entity.nome == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.nome);
        }
        if (entity.telefone == null) {
          statement.bindNull(3);
        } else {
          statement.bindText(3, entity.telefone);
        }
        statement.bindLong(4, entity.id);
      }
    };
  }

  @Override
  public long inserir(final Cliente cliente) {
    return DBUtil.performBlocking(__db, false, true, (_connection) -> {
      return __insertAdapterOfCliente.insertAndReturnId(_connection, cliente);
    });
  }

  @Override
  public int excluir(final Cliente cliente) {
    return DBUtil.performBlocking(__db, false, true, (_connection) -> {
      int _result = 0;
      _result += __deleteAdapterOfCliente.handle(_connection, cliente);
      return _result;
    });
  }

  @Override
  public int atualizar(final Cliente cliente) {
    return DBUtil.performBlocking(__db, false, true, (_connection) -> {
      int _result = 0;
      _result += __updateAdapterOfCliente.handle(_connection, cliente);
      return _result;
    });
  }

  @Override
  public List<Cliente> listar() {
    final String _sql = "SELECT * FROM clientes ORDER BY id DESC";
    return DBUtil.performBlocking(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfNome = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "nome");
        final int _columnIndexOfTelefone = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "telefone");
        final List<Cliente> _result = new ArrayList<Cliente>();
        while (_stmt.step()) {
          final Cliente _item;
          final String _tmpNome;
          if (_stmt.isNull(_columnIndexOfNome)) {
            _tmpNome = null;
          } else {
            _tmpNome = _stmt.getText(_columnIndexOfNome);
          }
          final String _tmpTelefone;
          if (_stmt.isNull(_columnIndexOfTelefone)) {
            _tmpTelefone = null;
          } else {
            _tmpTelefone = _stmt.getText(_columnIndexOfTelefone);
          }
          _item = new Cliente(_tmpNome,_tmpTelefone);
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
