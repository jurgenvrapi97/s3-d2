package entities;


import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "evento")

public class Evento {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "titolo")
    private String titolo;

    @Column(name = "data_evento")
    private Date dataEvento;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @Column(name = "posti_disponibili")
    private double postiDisponibili;
    public Evento(){}

    public Evento(String titolo, String dataEvento, String descrizione, TipoEvento tipoEvento, double postiDisponibili) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = formato.parse(dataEvento);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.titolo = titolo;
        this.dataEvento = data;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.postiDisponibili = postiDisponibili;
    }

    public long getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public double getPostiDisponibili() {
        return postiDisponibili;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", postiDisponibili=" + postiDisponibili +
                '}';
    }
}
