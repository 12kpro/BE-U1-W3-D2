package app;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.EventoDAO;
import entities.Evento;
import lombok.extern.slf4j.Slf4j;
import utils.JpaUtil;
import utils.TipoEvento;

@Slf4j
public class Application {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		try {
			EntityManager em = emf.createEntityManager();
			EventoDAO ev = new EventoDAO(em);

			Evento elvenking = new Evento("concerto elvenking", "Concerto elvenking Fontanafredda", LocalDate.now(),
					TipoEvento.PUBBLICO, 250);
			ev.save(elvenking);

			// log.info(ev.getById(UUID.fromString("9d77551d-f970-4809-8116-3fc64972c8ba")));
			System.out.println(ev.getById(UUID.fromString("9d77551d-f970-4809-8116-3fc64972c8ba")));
			ev.delete(UUID.fromString("935ebec4-7598-4ce6-8821-81d564a833d7"));
		} catch (ExceptionInInitializerError e) {
			log.error(e.getMessage());
		}
	}
}
