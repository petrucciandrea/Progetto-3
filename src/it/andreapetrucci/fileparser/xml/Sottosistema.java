package it.andreapetrucci.fileparser.xml;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement //(name="sottosistema")
@XmlAccessorType(XmlAccessType.FIELD)

public class Sottosistema {
	
	@XmlAttribute
	private String id;
	@XmlElement
	public List<Elemento> elemento;
	
	
	public Sottosistema(String id, List<Elemento> elemento) {
		super();
		this.id = id;
		this.elemento = elemento;
	}
	public Sottosistema(Sottosistema sottosistema) {
		super();
		this.id = sottosistema.id;
		this.elemento = sottosistema.elemento;
	}
	public Sottosistema() {
		super();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Elemento> getElemento() {
		return elemento;
	}
	public void setElemento(List<Elemento> elemento) {
		this.elemento = elemento;
	}
	@Override
	public String toString() {
		return "Sottosistema [id=" + id + ", elemento=" + elemento + "]";
	}
	
}
