package unipampa.edu.br.rupampa.model;

import android.support.v7.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Guto on 13/11/2016.
 */
public class Refeicao extends AppCompatActivity implements Serializable{

    private long id;
    private String nomeRefeicao;
    private String acompanhamentos;
    private String pratoPrincipal;
    private String guarnicao;
    private String saladas;
    private String sobremesa;
    private String suco;
    private String avaliacao;
    private String data;
    private String opcaoVeg;

    public Refeicao() {

    }

    public Refeicao(String nomeRefeicao, String acompanhamentos, String pratoPrincipal,
                    String guarnicao, String saladas, String sobremesa, String suco,
                    String data, String opcaoVeg) {

        this.nomeRefeicao = nomeRefeicao;
        this.acompanhamentos = acompanhamentos;
        this.pratoPrincipal = pratoPrincipal;
        this.guarnicao = guarnicao;
        this.saladas = saladas;
        this.sobremesa = sobremesa;
        this.suco = suco;
        this.data = data;
        this.opcaoVeg = opcaoVeg;
    }
    public Refeicao(long id,String nomeRefeicao, String acompanhamentos, String pratoPrincipal,
                    String guarnicao, String saladas, String sobremesa, String suco,
                    String data, String opcaoVeg) {

        this.nomeRefeicao = nomeRefeicao;
        this.acompanhamentos = acompanhamentos;
        this.pratoPrincipal = pratoPrincipal;
        this.guarnicao = guarnicao;
        this.saladas = saladas;
        this.sobremesa = sobremesa;
        this.suco = suco;
        this.data = data;
        this.opcaoVeg = opcaoVeg;
        this.id = id;
    }

    public String getNomeRefeicao() {
        return nomeRefeicao;
    }

    public void setNomeRefeicao(String nomeRefeicao) {
        this.nomeRefeicao = nomeRefeicao;
    }

    public String getAcompanhamentos() {
        return acompanhamentos;
    }

    public void setAcompanhamentos(String acompanhamentos) {
        this.acompanhamentos = acompanhamentos;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPratoPrincipal() {
        return pratoPrincipal;
    }

    public void setPratoPrincipal(String pratoPrincipal) {
        this.pratoPrincipal = pratoPrincipal;
    }

    public String getGuarnicao() {
        return guarnicao;
    }

    public void setGuarnicao(String guarnicao) {
        this.guarnicao = guarnicao;
    }

    public String getSaladas() {
        return saladas;
    }

    public void setSaladas(String saladas) {
        this.saladas = saladas;
    }

    public String getSobremesa() {
        return sobremesa;
    }

    public void setSobremesa(String sobremesa) {
        this.sobremesa = sobremesa;
    }

    public String getSuco() {
        return suco;
    }

    public void setSuco(String suco) {
        this.suco = suco;
    }


    public String getOpcaoVeg() {
        return opcaoVeg;
    }

    public void setOpcaoVeg(String opcaoVeg) {
        this.opcaoVeg = opcaoVeg;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
}
