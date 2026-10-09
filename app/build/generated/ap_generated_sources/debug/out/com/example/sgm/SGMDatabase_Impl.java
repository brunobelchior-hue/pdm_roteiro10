package com.example.sgm;

import androidx.annotation.NonNull;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class SGMDatabase_Impl extends SGMDatabase {
  private volatile ClienteDao _clienteDao;

  private volatile VeiculoDao _veiculoDao;

  @Override
  @NonNull
  protected RoomOpenDelegate createOpenDelegate() {
    final RoomOpenDelegate _openDelegate = new RoomOpenDelegate(1, "9a11954bce6daa7b1a1fbd00f0c4d57a", "721afb67e8772fd5c0a128865c329694") {
      @Override
      public void createAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `clientes` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT, `telefone` TEXT)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS `veiculos` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `marca` TEXT, `modelo` TEXT, `valor` TEXT)");
        SQLite.execSQL(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        SQLite.execSQL(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9a11954bce6daa7b1a1fbd00f0c4d57a')");
      }

      @Override
      public void dropAllTables(@NonNull final SQLiteConnection connection) {
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `clientes`");
        SQLite.execSQL(connection, "DROP TABLE IF EXISTS `veiculos`");
      }

      @Override
      public void onCreate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      public void onOpen(@NonNull final SQLiteConnection connection) {
        internalInitInvalidationTracker(connection);
      }

      @Override
      public void onPreMigrate(@NonNull final SQLiteConnection connection) {
        DBUtil.dropFtsSyncTriggers(connection);
      }

      @Override
      public void onPostMigrate(@NonNull final SQLiteConnection connection) {
      }

      @Override
      @NonNull
      public RoomOpenDelegate.ValidationResult onValidateSchema(
          @NonNull final SQLiteConnection connection) {
        final Map<String, TableInfo.Column> _columnsClientes = new HashMap<String, TableInfo.Column>(3);
        _columnsClientes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientes.put("nome", new TableInfo.Column("nome", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientes.put("telefone", new TableInfo.Column("telefone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysClientes = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesClientes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClientes = new TableInfo("clientes", _columnsClientes, _foreignKeysClientes, _indicesClientes);
        final TableInfo _existingClientes = TableInfo.read(connection, "clientes");
        if (!_infoClientes.equals(_existingClientes)) {
          return new RoomOpenDelegate.ValidationResult(false, "clientes(com.example.sgm.Cliente).\n"
                  + " Expected:\n" + _infoClientes + "\n"
                  + " Found:\n" + _existingClientes);
        }
        final Map<String, TableInfo.Column> _columnsVeiculos = new HashMap<String, TableInfo.Column>(4);
        _columnsVeiculos.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVeiculos.put("marca", new TableInfo.Column("marca", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVeiculos.put("modelo", new TableInfo.Column("modelo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsVeiculos.put("valor", new TableInfo.Column("valor", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final Set<TableInfo.ForeignKey> _foreignKeysVeiculos = new HashSet<TableInfo.ForeignKey>(0);
        final Set<TableInfo.Index> _indicesVeiculos = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoVeiculos = new TableInfo("veiculos", _columnsVeiculos, _foreignKeysVeiculos, _indicesVeiculos);
        final TableInfo _existingVeiculos = TableInfo.read(connection, "veiculos");
        if (!_infoVeiculos.equals(_existingVeiculos)) {
          return new RoomOpenDelegate.ValidationResult(false, "veiculos(com.example.sgm.Veiculo).\n"
                  + " Expected:\n" + _infoVeiculos + "\n"
                  + " Found:\n" + _existingVeiculos);
        }
        return new RoomOpenDelegate.ValidationResult(true, null);
      }
    };
    return _openDelegate;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final Map<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final Map<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "clientes", "veiculos");
  }

  @Override
  public void clearAllTables() {
    super.performClear(false, "clientes", "veiculos");
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final Map<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ClienteDao.class, ClienteDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(VeiculoDao.class, VeiculoDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final Set<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ClienteDao clienteDao() {
    if (_clienteDao != null) {
      return _clienteDao;
    } else {
      synchronized(this) {
        if(_clienteDao == null) {
          _clienteDao = new ClienteDao_Impl(this);
        }
        return _clienteDao;
      }
    }
  }

  @Override
  public VeiculoDao veiculoDao() {
    if (_veiculoDao != null) {
      return _veiculoDao;
    } else {
      synchronized(this) {
        if(_veiculoDao == null) {
          _veiculoDao = new VeiculoDao_Impl(this);
        }
        return _veiculoDao;
      }
    }
  }
}
