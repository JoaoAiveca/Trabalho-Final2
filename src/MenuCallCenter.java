import java.util.*;

public class MenuCallCenter {
	Scanner s = new Scanner(System.in);
	int option;
	String motivo;
	String descricao;
	String data;
	double duracao;
	String atitude;
	
	public MenuCallCenter(){
		option = 0;
		motivo="";
		descricao="";
		data="";
		duracao=0.0;
		atitude="";
	}
	
	public void MainMenuCC(){
		System.out.println("Tipo de Contacto:");
		System.out.println("1 - Chamada; 2 - Email; 0 - Sair;");
		option = s.nextInt();
		
		if(option == 0){
			return;
		}
		if(option==1){
			
		}
		if(option==2){
			
		}
	}
	
	public void MenuChamada(){
		System.out.println("Motivo do Contacto:");
		motivo = s.next();
		
		System.out.println("Descrição da Conversa:");
	}
	
	
}
