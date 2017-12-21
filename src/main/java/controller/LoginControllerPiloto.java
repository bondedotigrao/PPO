package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Piloto;

@SessionScoped
@ManagedBean

public class LoginControllerPiloto {
    private Piloto pilotoLogado = null;
    public LoginControllerPiloto() {
    }

    public Piloto getPilotoLogado() {
        return (Piloto) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("pilotoLogado");
    }

    public void setPilotoLogado(Piloto pilotoLogado) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pilotoLogado", pilotoLogado);
    }

    public String realizarLoginPiloto(String login, String senha) {
        String envia=  "index.xhtml";
        List<Piloto> piloto = new PilotoController().recuperarTodos();

        for (Piloto p : piloto) {
            if (p.getCpf().equals(login)) {
                if (p.getSenha().equals(senha)) {
                    this.setPilotoLogado(p);
                    envia = "menuPiloto.xhtml";
                }
                break;

            }
        }

        return envia;
    }
public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.pilotoLogado = null;
        
        return "index.xhtml";
    }

}
