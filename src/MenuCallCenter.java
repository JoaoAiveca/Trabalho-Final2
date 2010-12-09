import java.util.*;
import java.text.*;

public class MenuCallCenter {
	Scanner s = new Scanner(System.in);
	SystemCallCenter sys = new SystemCallCenter();
	int option;
	public void MainMenuCC(){
		
		do{
			System.out.println("Seleccione uma opcao: ");
			System.out.println("1 - Novo Registo; 2 - Listar Clientes; 0 - Sair");
			option = s.nextInt();
		}while(option!=1&&option!=0&&option!=2);
		
		if(option==0){
			return;
		}
		
		if(option==1){
			sys.createContact();
		}
		if(option==2){
			sys.consultar();
		}
	}
	
}
