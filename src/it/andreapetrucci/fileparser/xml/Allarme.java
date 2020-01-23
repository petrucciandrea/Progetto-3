package it.andreapetrucci.fileparser.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //(name="allarme")
public class Allarme {
	
	@XmlAttribute
	private String descrizione;
	@XmlAttribute
	private int codice;
	
	public Allarme(String descrizione, int codice) {
		super();
		this.descrizione=descrizione;
		this.codice=codice;
	}
	public Allarme(Allarme allarme) {
		super();
		this.descrizione=allarme.descrizione;
		this.codice=allarme.codice;
	}
	public Allarme() {
		super();
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	@Override
	public String toString() {
		return "Allarme [descrizione=" + descrizione + ", codice=" + codice + "]";
	}
	
}
