package it.andreapetrucci.fileparser.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.*;
import java.net.URISyntaxException;

public class DataJAXB {
	
	public Data parse(File file) throws URISyntaxException, JAXBException {     //cerca il file nel classpath
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();               //effettua il parse del contenuto del file all'interno di una istanza della classe
        Data Data = (Data) jaxbUnmarshaller.unmarshal(file);
        return Data;
    }
    public void format() throws JAXBException{
        
        JAXBContext jaxbContext = JAXBContext.newInstance(Data.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        File file = new File("/test.xml");
        jaxbMarshaller.marshal( new Data(), file );        
    }
}