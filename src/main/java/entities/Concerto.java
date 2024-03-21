package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "concerto")
public class Concerto extends Evento {



    private Genere genere;
    private boolean inStreaming;
    public Concerto(){}
    public Concerto(String titolo, String dataEvento, String descrizione, TipoEvento tipoEvento, double postiDisponibili, Location location, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, postiDisponibili, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                "} " + super.toString();
    }
}
