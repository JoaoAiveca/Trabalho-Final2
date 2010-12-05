import java.util.*;

public class MenuCallCenter {
	Scanner s = new Scanner(System.in);
	SystemCallCenter c = new SystemCallCenter();
	int option,option2;
	
	public void MainMenuCC(){
		
		System.out.println("Seleccione uma opcao: ");
		System.out.println("1 - Novo Registo; 0 - Sair");
		option = s.nextInt();
		
		if(option==0){
			return;
		}
		
		if(option==1){
		
			System.out.println("Tipo de Contacto:");
			System.out.println("1 - Chamada; 2 - Email;");
			option2 = s.nextInt();
		
			if(option2==1){
				c.MenuChamada();
			}
			if(option2==2){
				c.MenuEmail();
			}
		}
		
	}
	
	
	
	
}
