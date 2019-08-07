package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.util.ForwardView;
//import br.com.caelum.livraria.util.RedirectView;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();

	public Autor getAutor() {
		return autor;
	}
	
	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}

	/*public String gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

		new DAO<Autor>(Autor.class).adiciona(this.autor);
		
		this.autor = new Autor();
		
		return "livro?faces-redirect=true";
	}*/
	
	//se quisermos um forward usamos a classe ForwardView e se quisermos redirect usamos RedirectView!
	
	/*public RedirectView gravar() {
	    System.out.println("Gravando autor " + this.autor.getNome());
	    new DAO<Autor>(Autor.class).adiciona(this.autor);
	    this.autor = new Autor();

	    return new RedirectView("livro");
	}*/
	
	public ForwardView gravar() {
	    System.out.println("Gravando autor " + this.autor.getNome());

	    new DAO<Autor>(Autor.class).adiciona(this.autor);

	    this.autor = new Autor();

	    return new ForwardView("livro");
	}
}
