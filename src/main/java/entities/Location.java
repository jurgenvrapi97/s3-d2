package entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "città")
    private String città;

    @OneToMany(mappedBy = "location")
    private List<Evento> eventi;

    public Location(){}

    public Location(String nome, String città) {
        this.nome = nome;
        this.città = città;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCittà() {
        return città;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", città='" + città + '\'' +
                '}';
    }
}
