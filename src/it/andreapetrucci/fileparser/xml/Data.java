package it.andreapetrucci.fileparser.xml;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement //(name="data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
	
	@XmlAttribute(name = "timestamp")
	private String timestamp;
	@XmlElement
	private List<Sottosistema> sottosistema;
	@XmlAttribute(name = "scadaurl")
	private String scadaurl;
	
	public Data(String timestamp, String scadaurl, List<Sottosistema> sottosistema) {
		super();
		this.timestamp = timestamp;
		this.scadaurl = scadaurl;
		this.sottosistema = sottosistema;
	}
	public Data(Data data) {
		super();
		this.timestamp = data.timestamp;
		this.scadaurl = data.scadaurl;
		this.sottosistema = data.sottosistema;
	}
	public Data() {
		super();
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getScadaurl() {
		return scadaurl;
	}
	public void setScadaurl(String scadaurl) {
		this.scadaurl = scadaurl;
	}
	public List<Sottosistema> getSottosistema() {
		return sottosistema;
	}
	public void setSottosistema(List<Sottosistema> sottosistema) {
		this.sottosistema = sottosistema;
	}
	
	
}
