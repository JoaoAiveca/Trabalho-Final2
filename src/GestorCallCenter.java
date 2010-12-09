

public class GestorCallCenter {
	public static void main(String args []){
		MenuCallCenter mn = new MenuCallCenter();
		boolean exit = false;
		do{
		mn.MainMenuCC();
		Contacto c = mn.sys.c;
		if(mn.option ==0){
			exit=true;
		}
		}while(exit!=true);
	}
	
}
