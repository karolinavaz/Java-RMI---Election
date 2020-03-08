import java.awt.List;
import java.rmi.*;
import java.util.ArrayList;


public interface Election extends Remote{
	public void candidates() throws java.rmi.RemoteException;
	public void vote(String candidate, int number) throws java.rmi.RemoteException;
	public void result() throws java.rmi.RemoteException;
}
