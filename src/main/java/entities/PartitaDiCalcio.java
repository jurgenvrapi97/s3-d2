package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "partita_di_calcio")
public class PartitaDiCalcio extends Evento {
    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int numeroGolSquadraDiCasa;
    private int numeroGolSquadraOspite;

    public PartitaDiCalcio(String titolo, String dataEvento, String descrizione, TipoEvento tipoEvento, double postiDisponibili, Location location, String squadraDiCasa, String squadraOspite, String squadraVincente, int numeroGolSquadraDiCasa, int numeroGolSquadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, postiDisponibili, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGolSquadraDiCasa() {
        return numeroGolSquadraDiCasa;
    }

    public void setNumeroGolSquadraDiCasa(int numeroGolSquadraDiCasa) {
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
    }

    public int getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(int numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", numeroGolSquadraDiCasa=" + numeroGolSquadraDiCasa +
                ", numeroGolSquadraOspite=" + numeroGolSquadraOspite +
                '}';
    }
}