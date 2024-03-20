package entities;
import jakarta.persistence.*;
@Entity
@Table(name = "Partecipazione")
public class Partecipazione {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name="id_persona", nullable=false)
    private Persona persona;
    @ManyToOne
    @JoinColumn(name="id_evento", nullable=false)
    private Evento evento;
    @Enumerated(EnumType.STRING)
    @Column(name = "stato")
    private Stato stato;



    public Partecipazione(){}

    public Partecipazione(Persona persona, Evento evento, Stato stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public long getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public Stato getStato() {
        return stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
