package exeption;

public class EventoNonTrovato extends Throwable {
    public EventoNonTrovato(long id){
        super("l'evento che cerchi non è stato trovato");
    }
}
