package it.andreapetrucci.fileparser.threads;

import it.andreapetrucci.fileparser.classi.*;
import it.andreapetrucci.fileparser.xml.Data;
import it.andreapetrucci.fileparser.xml.DataJAXB;

import java.io.File;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBException;

public class SingleFileParser extends Thread {
	
	private boolean works, anomalia;
	private File d;
	private ContainerThread cThread;
	
	public SingleFileParser(int i) {
		System.out.println(this.getName() + ", " + this.getState());
	}
	
	public void run() {
		
		while(!SingleFileParser.currentThread().isInterrupted()) {
			
			anomalia=false;
			
			if(this.works) {
								
				DataJAXB parse = new DataJAXB();
				Data data;
				
				try {
					data = parse.parse(d);
					
					for(int i=0; i < data.getSottosistema().size(); i++){
						for(int j=0; j < data.getSottosistema().get(i).getElemento().size(); j++){
							if(!data.getSottosistema().get(i).getElemento().get(j).getAllarme().getDescrizione().equals("OK")) {
								anomalia=true;
								System.out.println(data.getSottosistema().get(i).getElemento().get(j).getAllarme().getDescrizione() + " nel " + i + "' sottosistema " + j + "' elemento");
							}
						}
					}
						
					if(anomalia)
						this.moveFile(d, "files/WARNING/");
					else
						this.moveFile(d, "files/BACKUP/");
					
				} catch (URISyntaxException | JAXBException e) {
					e.printStackTrace();
				}
				
				this.cThread.add(this);
				this.works = false;
				
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
	
	public void execute(File f, ContainerThread cThread) {
		this.cThread = cThread;
		this.works = true;
		d = new File(f.getAbsolutePath());
	}
	
	public void moveFile(File d, String dest) {
		
		try {
			d.renameTo(new File(dest + "\\" + d.getName()));
		} 
		catch(Exception e) {
			e.getStackTrace();
		}
		System.out.println(d.getName() + "spostato");
	}
}
