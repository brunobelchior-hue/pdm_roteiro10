package com.example.sgm;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SGMViewModel extends AndroidViewModel {
    private final SGMDatabase db;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final MutableLiveData<List<Cliente>> clientes = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<List<Veiculo>> veiculos = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<Boolean> carregando = new MutableLiveData<>(false);
    private final MutableLiveData<String> mensagem = new MutableLiveData<>();
    private final AtomicInteger operacoesAtivas = new AtomicInteger(0);

    private void iniciarOperacao() { if (operacoesAtivas.incrementAndGet() == 1) carregando.postValue(true); }
    private void finalizarOperacao() { if (operacoesAtivas.decrementAndGet() <= 0) { operacoesAtivas.set(0); carregando.postValue(false); } }

    public SGMViewModel(@NonNull Application application) {
        super(application);
        db = SGMDatabase.getInstance(application);
        atualizarClientes();
        atualizarVeiculos();
    }
    public LiveData<List<Cliente>> getClientes() { return clientes; }
    public LiveData<List<Veiculo>> getVeiculos() { return veiculos; }
    public LiveData<Boolean> getCarregando() { return carregando; }
    public LiveData<String> getMensagem() { return mensagem; }

    public void atualizarClientes() {
        iniciarOperacao();
        executor.execute(() -> { try { clientes.postValue(db.clienteDao().listar()); } catch (Exception e) { mensagem.postValue("Erro ao carregar clientes: " + e.getMessage()); } finally { finalizarOperacao(); } });
    }
    public void atualizarVeiculos() {
        iniciarOperacao();
        executor.execute(() -> { try { veiculos.postValue(db.veiculoDao().listar()); } catch (Exception e) { mensagem.postValue("Erro ao carregar veículos: " + e.getMessage()); } finally { finalizarOperacao(); } });
    }
    public void salvarCliente(Cliente c) {
        iniciarOperacao(); executor.execute(() -> { try { if (c.id == 0) db.clienteDao().inserir(c); else db.clienteDao().atualizar(c); clientes.postValue(db.clienteDao().listar()); mensagem.postValue("Cliente salvo com sucesso."); } catch (Exception e) { mensagem.postValue("Erro ao salvar cliente: " + e.getMessage()); } finally { finalizarOperacao(); } });
    }
    public void excluirCliente(Cliente c) {
        iniciarOperacao(); executor.execute(() -> { try { db.clienteDao().excluir(c); clientes.postValue(db.clienteDao().listar()); mensagem.postValue("Cliente excluído."); } catch (Exception e) { mensagem.postValue("Erro ao excluir cliente: " + e.getMessage()); } finally { finalizarOperacao(); } });
    }
    public void salvarVeiculo(Veiculo v) {
        iniciarOperacao(); executor.execute(() -> { try { if (v.id == 0) db.veiculoDao().inserir(v); else db.veiculoDao().atualizar(v); veiculos.postValue(db.veiculoDao().listar()); mensagem.postValue("Veículo salvo com sucesso."); } catch (Exception e) { mensagem.postValue("Erro ao salvar veículo: " + e.getMessage()); } finally { finalizarOperacao(); } });
    }
    public void excluirVeiculo(Veiculo v) {
        iniciarOperacao(); executor.execute(() -> { try { db.veiculoDao().excluir(v); veiculos.postValue(db.veiculoDao().listar()); mensagem.postValue("Veículo excluído."); } catch (Exception e) { mensagem.postValue("Erro ao excluir veículo: " + e.getMessage()); } finally { finalizarOperacao(); } });
    }
    @Override protected void onCleared() { super.onCleared(); executor.shutdown(); }
}
