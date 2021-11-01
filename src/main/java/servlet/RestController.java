package servlet;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.omg.CORBA.PRIVATE_MEMBER;

import dao.PadroneDao;
import dao.PadroneDaoMod;
import model.Padrone;


@Stateless

@Path("rest")
public class RestController {
	@Inject
	private PadroneDao padroneDao;
	@Inject
	private PadroneDaoMod padroneDaoMod;
//
	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("{id}") //variabile {}
	public Padrone getById(@PathParam("id") int id) {
		return padroneDao.get(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("all") //variabile {}
	public List<Padrone> getEvryone() {
		return padroneDao.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("insert")
	public void insertPadrone(Padrone nuovoPadrone) {
		padroneDao.save(nuovoPadrone);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("generaTrePadroni")
	public List<Padrone> generaPadrones(){
		AtomicInteger count = new AtomicInteger(1);
		Padrone padrone1 = new Padrone();
		List<Padrone> padroniList = Arrays
				.asList(new Padrone(),
						new Padrone(),
						new Padrone());
		padroniList.stream()
			.forEach(persona -> {
					persona.setNome("nome"+count.get());
					persona.setCognome("cognome"+count.getAndIncrement());
					
			});
		padrone1.setCognome("asd");
		padrone1.setNome("das");
		padrone1.setId(3);
		padroniList.stream()
			.forEach(persona ->{
				padroneDao.save(persona);
			});
		//
		
		
		//terzo inserimento illegale test
		return padroniList;
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("insertCMT")
	public void containedPadrone(Padrone padrone) {
		padroneDaoMod.save(padrone);
		
	}
	

}
