package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Passageiro;

@SessionScoped
@ManagedBean

public class LoginControllerPassageiro {
    private Passageiro passageiroLogado = null;
    
    public LoginControllerPassageiro() {
    }

    public Passageiro getPassageiroLogado() {
        return (Passageiro) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pilotoLogado");
    }

    public void setPassageiroLogado(Passageiro passageiroLogado) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("passageiroLogado", this.passageiroLogado);
    }

    public String realizarLoginPassageiro(String login, String senha) {
        List<Passageiro> passageiro = new PassageiroController().recuperarTodos();

        for (Passageiro ps : passageiro) {
            if (ps.getLogin().equals(login)) {
                if (ps.getSenha().equals(senha)) {
                    this.setPassageiroLogado(ps);
                     FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("passageiroLogado", this.passageiroLogado);
                    return "menuPassageiro.xhtml";
                }
                break;

            }
        }

        return "void";
    }

    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.passageiroLogado = null;
        
        return "index.xhtml";
    }

}
