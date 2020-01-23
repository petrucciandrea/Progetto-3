package it.andreapetrucci.fileparser.classi;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ContainerFile extends ReentrantLock {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<File> list = new ArrayList<File>();
	private File dir;
	
	public ContainerFile(String path) {
		this.dir = new File(path);
		add();
	}
	
	/**
	 * Aggiunge n. elementi alla lista
	 */
	public void add() {
		FilenameFilter filtro = new FilenameFilter() {
			
			@Override
			public boolean accept(File arg0, String arg1) {
				
				return arg1.endsWith("xml");
			}
		};
		
		lock();
		
		try{
			for(File f : this.dir.listFiles(filtro)) {
				if(!list.contains(f) && f.isFile()) {
					list.add(f);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		unlock();
	}
	
	/**
	 * Il metodo aggiunge un nuovo elemento alla lista
	 * @param newF
	 */
	public void add(File newF) {
		lock();
		try {
			list.add(newF);
		}catch(Exception e) {
			e.printStackTrace();
		}
		unlock();
	}
	
	/**
	 * Il metodo rimuove il primo elememento della lista
	 * @return File
	 */
	public File remove() {
		lock();
		File f = null;
		try{
			f = list.remove(0);
		}catch(Exception e) {
			e.printStackTrace();
		}
		unlock();
		return f;
	}
	
	/**
	 * Il metodo restituisce la lista dei file
	 * @return ArrayList
	 */
	public ArrayList<File> getList() {
		lock();
		ArrayList<File> listFile= null;
		try{
			listFile = list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		unlock();
		return listFile;
	}
	
	/**
	 * Stampa a video tutta la lista
	 */
	public void print() {
		lock();
		try {
			for(int i=0; i < list.size();i++) {
				System.out.println(list.get(i));
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
			r = list.size();
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
			r = list.isEmpty();
		}catch(Exception e) {
			e.printStackTrace();
		}
		unlock();
		return r;
	}
	
}