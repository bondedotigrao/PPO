package model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Adrielly Sales
 */
@Entity
public class Piloto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id_piloto;
        @Column(length = 50)
    	private String nome;
        @Column
	private String cpf;
        @Column
	private String endereco;
        @Column
	private Date dataNasc;
        @Column
        private String status;
        @Column
        private String sexo;
        
        @Column 
        private String email;
        
         @Column 
        private String telefone;
        
        @OneToOne
        @JoinColumn(name ="cod_moto",referencedColumnName ="id_moto")
        private Moto moto;
        
        @Column
        private String senha;
        @Column
        private String login;
        
        public Piloto(){
            
        }

    public Piloto( String nome, String cpf, String endereco, Date dataNasc, String status, String sexo, String email, String telefone, Moto moto, String senha, String login) {
        
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNasc = dataNasc;
        this.status = status;
        this.sexo = sexo;
        this.email = email;
        this.telefone = telefone;
        this.moto = moto;
        this.senha = senha;
        this.login = login;
    }

    public int getId_piloto() {
        return id_piloto;
    }

    public void setId_piloto(int id_piloto) {
        this.id_piloto = id_piloto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_piloto;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.cpf);
        hash = 97 * hash + Objects.hashCode(this.endereco);
        hash = 97 * hash + Objects.hashCode(this.dataNasc);
        hash = 97 * hash + Objects.hashCode(this.status);
        hash = 97 * hash + Objects.hashCode(this.sexo);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.telefone);
        hash = 97 * hash + Objects.hashCode(this.moto);
        hash = 97 * hash + Objects.hashCode(this.senha);
        hash = 97 * hash + Objects.hashCode(this.login);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piloto other = (Piloto) obj;
        if (this.id_piloto != other.id_piloto) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.dataNasc, other.dataNasc)) {
            return false;
        }
        if (!Objects.equals(this.moto, other.moto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Piloto{" + "id_piloto=" + id_piloto + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", dataNasc=" + dataNasc + ", status=" + status + ", sexo=" + sexo + ", email=" + email + ", telefone=" + telefone + ", moto=" + moto + ", senha=" + senha + ", login=" + login + '}';
    }

        
        
        
        
        
}
