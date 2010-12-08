

public class temp {
	public static void main(String[]args){
		DBContacto c=new DBContacto();
		Database x=new Database();
		Cliente a1=new Cliente("Joao", "Bairro", "98");
		Cliente a2=new Cliente("Joao2", "Bairro2", "982");
		Cliente a3=new Cliente("Joao3", "Bairro3", "983");
		x.add(a1);
		x.add(a2);
		x.add(a3);
		
		Contacto co1=new Contacto("chefe", 1);
		co1.setCliente("Joao2", "name", x);
		co1.setAtitude("rude");
		co1.setDesc("tinha a cabeça partida");
		co1.setMotivo("doía-lhe o crânio");
		co1.endContact();
		
		Contacto co2=new Contacto("chefe1", 11);
		co2.setCliente("Joao2", "name", x);
		co2.setAtitude("rude1");
		co2.setDesc("tinha a cabeça partid1a");
		co2.setMotivo("doía-lhe o crânio1");
		co2.endContact();		
		
		Contacto co3=new Contacto("chefe3", 13);
		co3.setCliente("Joao3", "name", x);
		co3.setAtitude("rude3");
		co3.setDesc("tinha a cabeça partida3");
		co3.setMotivo("doía-lhe o crânio3");
		co3.endContact();
		
		c.add(co1);
		c.add(co2);
		c.add(co3);
		
		for(int i=0; i<c.listNeverContact(x).length; i++)
			if(c.listNeverContact(x)[i]!=null)
					System.out.println(c.listNeverContact(x)[i]);
		System.out.println("DIVISION");
		for(int i=0; i<c.listMostContacts(x).length; i++)
			System.out.println(c.listMostContacts(x)[i]);
	}
}
