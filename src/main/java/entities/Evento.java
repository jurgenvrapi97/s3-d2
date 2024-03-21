package entities;


import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "evento")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Evento {
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

    @ManyToOne
    @JoinColumn(name="id_location", nullable=false)
    private Location location;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioni;
    public Evento(){}

    public Evento(String titolo, String dataEvento, String descrizione, TipoEvento tipoEvento, double postiDisponibili, Location location) {
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
        this.location = location;
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
