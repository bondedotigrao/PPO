package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Implementacoes.CorridaHibernate;
import model.Corrida;

/**
 *
 * @author Adrielly Sales
 */
@ManagedBean
@SessionScoped
public class CorridaController {
    private CorridaHibernate corridaHibernate;
    private Corrida cadCorrida;
    private Corrida selectedCorrida;

    public CorridaController() {
        this.corridaHibernate = new CorridaHibernate();
        this.cadCorrida = new Corrida();
    }
    
    public String cadastrar(){
        this.corridaHibernate.cadastrar(this.cadCorrida);
        
        this.cadCorrida = new Corrida();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Corrida cadastrada com sucesso!"));
        
        return "index.xhtml";
        
    }
    
    public String alterar(){
        this.corridaHibernate.alterar(this.selectedCorrida);
        
        this.cadCorrida = new Corrida();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Corrida alterada com sucesso!"));
        
        return "index.xhtml";
        
    }
    
    public String deletar(){
        this.corridaHibernate.deletar(this.selectedCorrida);
        
        this.cadCorrida = new Corrida();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Corrida deletada com sucesso!"));
        
        return "index.xhtml";
        
    }
    
    
    public String retornar(){
        this.corridaHibernate.recuperar(this.selectedCorrida.getId());
        
        this.cadCorrida = new Corrida();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Corrida retornada com sucesso!"));
        
        return "index.xhtml";
        
    }
    
    public String recuperaTodos(){
        this.corridaHibernate.recuperarTodos();
        
        this.cadCorrida = new Corrida();
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Corrida cadastrada com sucesso!"));
        
        return "index.xhtml";
        
    }

    public CorridaHibernate getCorridaHibernate() {
        return corridaHibernate;
    }

    public void setCorridaHibernate(CorridaHibernate corridaHibernate) {
        this.corridaHibernate = corridaHibernate;
    }

    public Corrida getCadCorrida() {
        return cadCorrida;
    }

    public void setCadCorrida(Corrida cadCorrida) {
        this.cadCorrida = cadCorrida;
    }

    public Corrida getSelectedCorrida() {
        return selectedCorrida;
    }

    public void setSelectedCorrida(Corrida selectedCorrida) {
        this.selectedCorrida = selectedCorrida;
    }
    
    
}
