package app;

import dao.EventoDAO;
import entities.Evento;
import lombok.extern.slf4j.Slf4j;
import utils.JpaUtil;
import utils.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;

@Slf4j
public class Application {

    private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO ev = new EventoDAO(em);

        Evento elvenking = new Evento("concerto elvenking", "Concerto elvenking Fontanafredda", LocalDate.now(), TipoEvento.PUBBLICO,250);
        ev.save(elvenking);
    }
}
