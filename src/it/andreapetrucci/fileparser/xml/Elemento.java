package it.andreapetrucci.fileparser.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //(name="elemento")
@XmlAccessorType(XmlAccessType.FIELD)

public class Elemento {
	
	@XmlAttribute
	private String tipo;
	@XmlAttribute
	private int prog;
	@XmlAttribute
	private int canna;
	@XmlAttribute
	private int km;
	@XmlAttribute
	private String cabina;
	@XmlAttribute
	private String c_con;
	@XmlAttribute
	private String quadro;
	@XmlAttribute
	private String descrizione;
	@XmlAttribute
	private String nome;
	@XmlAttribute
	private int sottotipo;
	@XmlElement
	private int stato;
	@XmlElement
	private Allarme allarme;
	
	
	public Elemento(String tipo, int prog, int canna, int km, String cabina, String c_con, String quadro, String descrizione, String nome, int sottotipo, int stato, Allarme allarme) {
		super();
		this.tipo=tipo;
		this.prog=prog;
		this.canna=canna;
		this.km=km;
		this.cabina=cabina;
		this.c_con=c_con;
		this.quadro=quadro;
		this.descrizione=descrizione;
		this.nome=nome;
		this.sottotipo=sottotipo;
		this.stato=stato;
		this.allarme = new Allarme(allarme);
	}
	public Elemento(Elemento elemento) {
		super();
		this.tipo=elemento.tipo;
		this.prog=elemento.prog;
		this.canna=elemento.canna;
		this.km=elemento.km;
		this.cabina=elemento.cabina;
		this.c_con=elemento.c_con;
		this.quadro=elemento.quadro;
		this.descrizione=elemento.descrizione;
		this.nome=elemento.nome;
		this.sottotipo=elemento.sottotipo;
		this.stato=elemento.stato;
		this.allarme = new Allarme(elemento.allarme);
	}
	public Elemento() {
		super();
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String descrizione) {
		this.tipo = descrizione;
	}
	
	public int getProg() {
		return prog;
	}
	public void setProg(int prog) {
		this.prog = prog;
	}
	public int getCanna() {
		return canna;
	}

	public void setCanna(int canna) {
		this.canna = canna;
	}
	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
	public String getCabina() {
		return cabina;
	}

	public void setCabina(String cabina) {
		this.cabina = cabina;
	}
	public String getC_con() {
		return c_con;
	}

	public void setC_con(String c_con) {
		this.c_con = c_con;
	}
	public String getQuadro() {
		return quadro;
	}

	public void setQuadro(String quadro) {
		this.quadro = quadro;
	}
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSottotipo() {
		return sottotipo;
	}

	public void setSottotipo(int sottotipo) {
		this.sottotipo = sottotipo;
	}
	public int getStato() {
		return stato;
	}

	public void setStato(int stato) {
		this.stato = stato;
	}
	
	public Allarme getAllarme() {
		return allarme;
	}

	public void setAllarme(Allarme allarme) {
		this.allarme = allarme;
	}
	@Override
	public String toString() {
		return "Elemento [tipo=" + tipo + ", prog=" + prog + ", canna=" + canna + ", km=" + km + ", cabina=" + cabina
				+ ", c_con=" + c_con + ", quadro=" + quadro + ", descrizione=" + descrizione + ", nome=" + nome
				+ ", sottotipo=" + sottotipo + ", stato=" + stato + ", allarme=" + allarme + "]";
	}
	
}
