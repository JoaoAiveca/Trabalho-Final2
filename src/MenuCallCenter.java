import java.util.*;

public class MenuCallCenter {
	Scanner s = new Scanner(System.in);
	Database db = simul();
	int option,option2,num;
	String motivo,descricao,atitude,srccont,emailcont,srcemail,id,relacao,duracao;
	Contacto c;
	
	public void MainMenuCC(){
		
		do{
			System.out.println("Seleccione uma opcao: ");
			System.out.println("1 - Novo Registo; 0 - Sair");
			option = s.nextInt();
		}while(option!=1&&option!=0);
		
		if(option==0){
			return;
		}
		
		if(option==1){
			createContact();
		}
		
		
	}
	
	public void createContact(){
		
		do{
		System.out.println("Tipo de Contacto:");
		System.out.println("1 - Chamada; 2 - Email;");
		option2 = s.nextInt();
		}while(option2!=1&&option2!=2);
	
		System.out.println("Por favor insira o numero de funcionario: ");
		num=s.nextInt();
		
		if(option2==1){
			c = new Contacto("chamada",num);
			
			System.out.println("Número do Contacto:");
			srccont=s.next();
			
			c.setCliente(srccont, "mainPhone", simul());

			
			System.out.println("Identificação da pessoa que fez o contacto:");
			id=s.nextLine();
			s.nextLine();
			
			System.out.println("Relacao com o cliente:");
			relacao = s.next();
			c.setunReg(id, relacao);
			
			System.out.println("Motivo do Contacto:");
			motivo = s.next();
			c.setMotivo(motivo);
			
			System.out.println("Atitude do Cliente:");
			atitude=s.next();
			c.setAtitude(atitude);
			
			c.endContact();
			duracao = c.duracao;
			
		}
		
		if(option2==2){
			c = new Contacto("email",num);
			
			System.out.println("Email do Contacto:");
			srcemail=s.next();
			c.setCliente(srcemail, "email", simul());
			
			System.out.println("Identificação da pessoa que fez o contacto:");
			s.nextLine();
			id=s.nextLine();
			
			System.out.println("Relacao com o cliente:");
			relacao = s.next();
			
			c.setunReg(id, relacao);
			
			System.out.println("Descrição da Conversa:");
			descricao = s.nextLine();
			s.nextLine();
			c.setDesc(descricao);
			
			System.out.println("Atitude do Cliente:");
			atitude=s.next();
			c.setAtitude(atitude);
			
		}
	}
	
	public void consultar(){
		

		
	}
	
	public Database simul(){
		Cliente c1 = new Cliente("Joao Aiveca","Cano","1234567");
		Cliente c2 = new Cliente("Pedro Mateus","Faro","9876543");
		Cliente c3 = new Cliente("Marlene Oliveira","Escoural","3456789");
		Cliente c4 = new Cliente("Joana Valerio","Vila Nova de Milfontes","1356890");
		
		Database x = new Database();
		
		c1.addEmail("joaiveca@gmail.com");
		c2.addEmail("pedro@hotmail.com");
		c3.addEmail("marlene@gmail.com");
		c4.addEmail("joana@hotmail.com");
		
		x.add(c1);
		x.add(c2);
		x.add(c3);
		x.add(c4);
		
		return x;
	}
	
	public static void main(String args []){
		MenuCallCenter mn = new MenuCallCenter();
		mn.MainMenuCC();
		Contacto c = mn.c;
		System.out.println(c.toString());
	}
	
	
	
}
