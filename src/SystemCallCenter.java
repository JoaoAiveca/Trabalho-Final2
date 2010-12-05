import java.util.*;

public class SystemCallCenter {
	Scanner scan = new Scanner(System.in);
	String motivo,descricao,data,atitude,srccont,emailcont,srcemail;
	double duracao;
	
	
	
	public void MenuChamada(){
		System.out.println("Número do Contacto:");
		srccont=scan.next();
		
		
		//ID cliente;
		
		System.out.println("Motivo do Contacto:");
		motivo = scan.next();
		
		System.out.println("Data e hora do contacto:");
	}
	
	public void MenuEmail(){
		System.out.println("Email do Contacto:");
		srcemail=scan.next();
		
		System.out.println("Descrição da Conversa:");
		descricao = scan.nextLine();
	}
	
	
	
}
