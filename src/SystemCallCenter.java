import java.util.*;

public class SystemCallCenter {
	Scanner scan = new Scanner(System.in);
	String motivo,descricao,atitude,srccont,emailcont,srcemail,id;
	double duracao;
	
	
	
	public void MenuChamada(){
		System.out.println("N�mero do Contacto:");
		srccont=scan.next();
		
		System.out.println("Identifica��o da pessoa que fez o contacto:");
		id=scan.nextLine();

		System.out.println("Motivo do Contacto:");
		motivo = scan.next();
		
		System.out.println("Atitude do Cliente:");
		atitude=scan.next();
	}
	
	public void MenuEmail(){
		System.out.println("Email do Contacto:");
		srcemail=scan.next();
		
		System.out.println("Identifica��o da pessoa que fez o contacto:");
		id=scan.nextLine();
		
		System.out.println("Descri��o da Conversa:");
		descricao = scan.nextLine();
	
		System.out.println("Atitude do Cliente:");
		atitude=scan.next();
	}
	
	
	
}
