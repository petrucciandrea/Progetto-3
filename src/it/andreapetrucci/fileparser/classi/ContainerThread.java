package it.andreapetrucci.fileparser.classi;

//import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import it.andreapetrucci.fileparser.threads.SingleFileParser;

public class ContainerThread extends ReentrantLock{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<SingleFileParser> lista = new ArrayList<SingleFileParser>();

	public ContainerThread(int nThread) {
		createPoolThread(nThread);
	}
	
	/**
	 * Il metodo inizializza e lancia il numero di thread richiesto
	 * @param singleFileParser
	 */
	private void createPoolThread(int nThread ) {
		lock();
		for(int index=0;index<nThread;index++) {
			SingleFileParser singleFileParser = new SingleFileParser(index);
			singleFileParser.start();
			lista.add(singleFileParser);
		}
		unlock();
	}
	
	/**
	 * Aggiunge l'elemento alla lista
	 * @param nuovoT
	 */
	public void add(SingleFileParser nuovoT) {
		lock();
		try {
			lista.add(nuovoT);
		}catch(Exception e) {
			e.printStackTrace();
		}
		unlock();
	}
	
	/**
	 * Rimuove il primo elemento dalla lista e lo restituisce
	 * @return SingleFileParser
	 */
	public SingleFileParser remove() {
		SingleFileParser t = null;
		try {
			lock();
			t = lista.remove(0);
			unlock();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	/**
	 * Stampa a video tutta la lista
	 */
	public void print() {
		lock();
		try {
			for(int i=0; i < lista.size();i++) {
				System.out.println(lista.get(i));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		unlock();
	}
	
	/**
	 * Il metodo ritorna il numero degli elementi presenti nella lista
	 * @return integer
	 */
	public int size() {
		lock();
		int r = -1;
		try {
			r = lista.size();
		}catch(Exception e) {
			e.printStackTrace();
		}
		unlock();
		return r;
	}
	
	/**
	 * Il metodo controlla se la lista è vuota
	 * @return boolean
	 */
	public boolean isEmpty() {
		lock();
		boolean r = true;
		try {
			r = lista.isEmpty();
		}catch(Exception e) {
			e.printStackTrace();
		}
		unlock();
		return r;
	}
}
