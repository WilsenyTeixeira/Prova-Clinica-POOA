package controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.Medico;
import service.MedicoService;


@ViewScoped
@ManagedBean
public class MedicoBean {
	@EJB
	private MedicoService medicoService;
	
	private Medico medico = new Medico();
	private List<Medico> medicos = new ArrayList<Medico>();
	
	@PostConstruct
	public void inicializar() {
		atualizarLista();
	}
	
	public void gravarMedico() {
		System.out.println(medico.getDataNascimento());
		medicoService.create(medico);
		medico = new Medico();
		atualizarLista();
	}
	
	private void atualizarLista() {
		medicos = medicoService.listAll();
	}
	
	
	public MedicoService getMedicoService() {
		return medicoService;
	}
	public void setMedicoService(MedicoService medicoService) {
		this.medicoService = medicoService;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public List<Medico> getMedicos() {
		return medicos;
	}
	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}
	
	
}
