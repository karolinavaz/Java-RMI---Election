
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class ElectionClient {
	public static void main(String[] args) {
		String servidor = "rmi://localhost:3003/";
		String nome = "ElectionService";
		try {
			//System.setProperty("java.rmi.server.hostname","10.224.39.131");
			Election c = (Election) Naming.lookup(servidor + nome);
			Client client = new Client("Karol");
			System.out.println("Objeto remoto \'"+ nome + "\' encontrado no servidor.");
			c.candidates();
			c.vote("Henrique", client.getId());
			
			Client client2 = new Client("Rodrigo");
			c.vote("Roberto", client2.getId());
			c.result();
			//c.result("tese", '2');
			

		} catch (MalformedURLException e) {
			System.out.println("URL \'" + servidor + nome + "\' mal formatada.");
		} catch (RemoteException e) {
			System.out.println("Erro na invoca��o remota.");
			e.printStackTrace();
		} catch (NotBoundException e) {
			System.out.println("Objeto remoto \'" + nome + "\' n�o est� dispon�vel.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
