import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class SystemCallCenter {
	Scanner s = new Scanner(System.in);
	String motivo,descricao,atitude,srccont,emailcont,srcemail,id,relacao,duracao;
	int option2,num,option,option3;
	DBContacto db = new DBContacto();
	Contacto c;
	//MenuCallCenter mn = new MenuCallCenter();
	
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
			System.out.println("Opcoes: proprio,conjuge, sócio, filho, pai, etc.");
			relacao = s.next();
			c.setunReg(id, relacao);
			
			System.out.println("Motivo do Contacto:");
			System.out.println("Opcoes: Avaria, reclamacao, sugestao,etc");
			motivo = s.next();
			c.setMotivo(motivo);
			
			System.out.println("Atitude do Cliente:");
			System.out.println("Opcoes: simpático, agressivo, mal-educado, etc.");
			atitude=s.next();
			c.setAtitude(atitude);
			
			c.endContact();
			duracao = c.duracao;
			
			db.add(c);
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
			System.out.println("Opcoes: proprio,conjuge, sócio, filho, pai, etc.");
			relacao = s.next();
			
			c.setunReg(id, relacao);
			
			System.out.println("Motivo do Contacto:");
			System.out.println("Opcoes: Avaria, reclamacao, sugestao,etc");
			motivo = s.next();
			c.setMotivo(motivo);
			
			System.out.println("Descrição da Conversa:");
			descricao = s.nextLine();
			s.nextLine();
			c.setDesc(descricao);
			
			System.out.println("Atitude do Cliente:");
			System.out.println("Opcoes: simpático, agressivo, mal-educado, etc.");
			atitude=s.next();
			c.setAtitude(atitude);
		
			c.duracao = "N/A";
			db.add(c);
		}
	}
	public Database simul(){ //Simula a criacao de uma base de dados de clientes.
		Cliente c1 = new Cliente("Joao Aiveca","Cano","1234567");
		Cliente c2 = new Cliente("Pedro Mateus","Faro","9876543");
		Cliente c3 = new Cliente("Marlene Oliveira","Escoural","3456789");
		Cliente c4 = new Cliente("Joana Valerio","Vila Nova de Milfontes","1356890");
		
		Database x = new Database();
		
		c1.addEmail("joao@gmail.com");
		c2.addEmail("pedro@hotmail.com");
		c3.addEmail("marlene@gmail.com");
		c4.addEmail("joana@hotmail.com");
		
		x.add(c1);
		x.add(c2);
		x.add(c3);
		x.add(c4);
		
		return x;
	}
	
	public void consultar(){
		do{
			System.out.println("Escolha uma opcao: ");
			System.out.println("1 - Listar os contactos de um cliente;");
			System.out.println("2 - Listar os clientes com mais contactos;");
			System.out.println("3 - Listar os contactos onde o cliente foi mal-educado;");
			System.out.println("4 - Listar os clientes que nunca contactaram o call-center;");
			System.out.println("5 - Pesquisa de clientes que fizeram contactos numa determinada data;");
			System.out.println("6 - pesquisa de clientes que fizeram contactos num intervalo de datas");
			System.out.println("0 - Regressar ao menu inicial;");
			option3 = s.nextInt();
		}while(option3!=0&&option3!=1&&option3!=2&&option3!=3&&option3!=4&&option3!=5&&option3!=6);

		if(option3 ==0){
			//mn.MainMenuCC();
		}
		if(option3==1){
			System.out.println("Insira o nome do cliente:");
			String name = s.nextLine();
			s.nextLine();
			System.out.println(db.listContacts(name).toString()); //Todos os Returns estao a dar porcaria.
		}
		if(option3==2){
			System.out.println("Clientes com mais contactos: ");
			System.out.println(db.listMostContacts(simul()).toString());
		}
		if(option3==3){
			System.out.println("Contactos em que o cliente foi mal-educado: ");
			//String name ="";
			//db.listRudeContact(name);
		}
		if(option3==4){
			System.out.println("Clientes que nunca contactaram o call-center: ");
			System.out.println(db.listNeverContact(simul()));
		}
		if(option3==5){
			System.out.println("Por favor insira a data pela qual se deve pesquisar: ");
			Calendar cal = Calendar.getInstance();
			try {
				String data = s.next();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				cal.setTime(sdf.parse(data));
			} catch (ParseException e) {
				e.printStackTrace();
			} 
			
			if(db.listContactsDate(cal)==null){
				System.out.println("Não há resultados!");
			}
			else{
				System.out.println(db.listContactsDate(cal));
			}
		}
		
		if(option3==6){
			
			System.out.println("Por favor insira a data de inicio: ");
			Calendar cal1 = Calendar.getInstance();
			try {
				String data = s.next();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				cal1.setTime(sdf.parse(data));
			} catch (ParseException e) {
				e.printStackTrace();
			} 
			
			System.out.println("Por favor insira a data de fim: ");
			Calendar cal2 = Calendar.getInstance();
			try {
				String data = s.next();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				cal2.setTime(sdf.parse(data));
			} catch (ParseException e) {
				e.printStackTrace();
			} 
			
			System.out.println("Lista de Clientes: ");
			if(db.listContactsDate(cal1, cal2)==null){
				System.out.println("Não há resultados!");
			}
			else{
				System.out.println(db.listContactsDate(cal1,cal2).toString());
			}
		}
		
	}
}