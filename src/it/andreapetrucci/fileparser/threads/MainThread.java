package it.andreapetrucci.fileparser.threads;

import it.andreapetrucci.fileparser.classi.*;

public class MainThread extends Thread{
		
	public MainThread() {
		System.out.println(this.getName() + ", " + this.getState());
	}
	
	public void run() {
		
		ContainerFile containerFile = new ContainerFile("files/new");
		ContainerThread containerThread = new ContainerThread(5);
		
		System.out.println("Ci sono " + containerFile.size() + " file nella lista");
		
		while(!MainThread.currentThread().isInterrupted()) {
			
			containerFile.add();
			
			assignFile(containerFile, containerThread);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}

	public void assignFile(ContainerFile containerFile,ContainerThread containerThread) {
		
		if(!containerFile.isEmpty() && !containerThread.isEmpty()) {
			containerThread.remove().execute(containerFile.remove(), containerThread);
		}
	}
}
