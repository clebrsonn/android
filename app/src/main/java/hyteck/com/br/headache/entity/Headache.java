package hyteck.com.br.headache.entity;

import java.io.Serializable;

/**
 * Created by clebr on 10/09/2016.
 */
public class Headache implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String dataInicio;
    private String horaInicio;
    private String minutoInicio;
    private String horaTermino;
    private String minutoTermino;
    private String dataTermino;
    private String intensidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getMinutoInicio() {
        return minutoInicio;
    }

    public void setMinutoInicio(String minutoInicio) {
        this.minutoInicio = minutoInicio;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }

    public String getMinutoTermino() {
        return minutoTermino;
    }

    public void setMinutoTermino(String minutoTermino) {
        this.minutoTermino = minutoTermino;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(String intensidade) {
        this.intensidade = intensidade;
    }


}
