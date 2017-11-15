package br.imobox.com.imobox.model;

import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by matheuscatossi on 15/11/17.
 */

public class Realtor {

    private int id;
    private String creci;
    private String tipoImovel;
    private String disponibilidade;
    private String preferencia;

    public Realtor() {

    }

    public Realtor(String creci, String tipoImovel, String disponibilidade, String preferencia) {
        this.creci = creci;
        this.tipoImovel =tipoImovel;
        this.disponibilidade = disponibilidade;
        this.preferencia = preferencia;
    }

    public Realtor(int id, String creci, String tipoImovel, String disponibilidade, String preferencia) {
        this.id = id;
        this.creci = creci;
        this.tipoImovel = tipoImovel;
        this.disponibilidade = disponibilidade;
        this.preferencia = preferencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreci() {
        return creci;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }
}
