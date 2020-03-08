import java.awt.List;
import java.rmi.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.swing.JOptionPane;

public class ElectionServant extends java.rmi.server.UnicastRemoteObject implements Election{
	Map<String,Integer> Candidates = new HashMap<String,Integer>();
	ArrayList codeClient = new ArrayList();
	public ElectionServant() throws java.rmi.RemoteException {
		super();
	}
	
	public void candidates() throws java.rmi.RemoteException{
		Candidates.put( "Henrique", 0);
		Candidates.put( "Roberto", 0);
		Candidates.put( "Ludmila", 0);
		int i = 0;
		  String nameList[] = null;
		for(Map.Entry<String, Integer> name : Candidates.entrySet()){
            System.out.print(name.getKey());
        }
		 JOptionPane.showInternalMessageDialog(null,  nameList,
         		"Candidatos", JOptionPane.INFORMATION_MESSAGE);
	}
	public void vote(String candidate, int number) throws java.rmi.RemoteException{
		if(!codeClient.contains(number)) {
			codeClient.add(number);
		   if ( Candidates.containsKey( candidate ) ) {
			   var oldValue = Candidates.get(candidate);
			   Candidates.put(candidate, oldValue + 1);           
	       }else
	            System.err.println("Candidato não existe");
		}
		else
			System.out.println("O usuário pode realizar o voto somente uma vez");
		
	}
	public void result() throws java.rmi.RemoteException{
		System.out.println(Candidates);
	}
}
