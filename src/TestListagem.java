import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Calendar;

public class TestListagem extends TestCase{
	public void testContactosDeUmCliente(){
		DBContacto c=new DBContacto();
		Database x=new Database();
		Cliente a1=new Cliente("Joao", "Bairro", "98");
		Cliente a2=new Cliente("Joao2", "Bairro2", "982");
		Cliente a3=new Cliente("Joao3", "Bairro3", "983");
		Contacto co1=new Contacto("chefe", 1);
		Contacto co2=new Contacto("chefe1", 11);
		Contacto co3=new Contacto("chefe3", 13);

		x.add(a1);
		x.add(a2);
		x.add(a3);
			
		co1.setCliente("Joao2", "name", x);
		co1.setAtitude("Rude");
		co1.setDesc("tinha a cabeça partida");
		co1.setMotivo("doía-lhe o crânio");
		co1.endContact();
		
		co2.setCliente("Joao2", "name", x);
		co2.setAtitude("Simpático");
		co2.setDesc("tinha a cabeça partid1a");
		co2.setMotivo("doía-lhe o crânio1");
		co2.endContact();		
		
		co3.setCliente("Joao3", "name", x);
		co3.setAtitude("Simpático");
		co3.setDesc("tinha a cabeça partida3");
		co3.setMotivo("doía-lhe o crânio3");
		co3.endContact();
		
		c.add(co1);
		c.add(co2);
		c.add(co3);
		ArrayList<Contacto> toTest=c.listContacts("Joao3");
		ArrayList<Contacto> temporary=new ArrayList<Contacto>();
		temporary.add(co3);
		String emTeste=toTest.toString();
		String correct=temporary.toString();
		Boolean a=false;
		a=emTeste.equals(correct);
		assertTrue(a);
		
	}
	
	public void testClientesComMais(){
		
		DBContacto c=new DBContacto();
		Database x=new Database();
		Cliente a1=new Cliente("Joao", "Bairro", "98");
		Cliente a2=new Cliente("Joao2", "Bairro2", "982");
		Cliente a3=new Cliente("Joao3", "Bairro3", "983");
		Contacto co1=new Contacto("chefe", 1);
		Contacto co2=new Contacto("chefe1", 11);
		Contacto co3=new Contacto("chefe3", 13);

		x.add(a1);
		x.add(a2);
		x.add(a3);
			
		co1.setCliente("Joao2", "name", x);
		co1.setAtitude("Rude");
		co1.setDesc("tinha a cabeça partida");
		co1.setMotivo("doía-lhe o crânio");
		co1.endContact();
		
		co2.setCliente("Joao2", "name", x);
		co2.setAtitude("Simpático");
		co2.setDesc("tinha a cabeça partid1a");
		co2.setMotivo("doía-lhe o crânio1");
		co2.endContact();		
		
		co3.setCliente("Joao3", "name", x);
		co3.setAtitude("Simpático");
		co3.setDesc("tinha a cabeça partida3");
		co3.setMotivo("doía-lhe o crânio3");
		co3.endContact();
		
		c.add(co1);
		c.add(co2);
		c.add(co3);
		
		
		Cliente[] toTest=c.listMostContacts(x);
		Cliente[] temporary=new Cliente[3];
		temporary[0]=a2;
		temporary[1]=a3;
		temporary[2]=a3;
		Boolean a=false;
		for(int i=0; i<toTest.length; i++)
			if(temporary[i].toString().equals(toTest[i].toString()))
				a=true;
		
		
		
		System.out.println(a);
		
		assertTrue(a);
		
	}
	
	public void testmalEducado(){
		
		DBContacto c=new DBContacto();
		Database x=new Database();
		Cliente a1=new Cliente("Joao", "Bairro", "98");
		Cliente a2=new Cliente("Joao2", "Bairro2", "982");
		Cliente a3=new Cliente("Joao3", "Bairro3", "983");
		Contacto co1=new Contacto("chefe", 1);
		Contacto co2=new Contacto("chefe1", 11);
		Contacto co3=new Contacto("chefe3", 13);

		x.add(a1);
		x.add(a2);
		x.add(a3);
			
		co1.setCliente("Joao2", "name", x);
		co1.setAtitude("Rude");
		co1.setDesc("tinha a cabeça partida");
		co1.setMotivo("doía-lhe o crânio");
		co1.endContact();
		
		co2.setCliente("Joao2", "name", x);
		co2.setAtitude("Rude");
		co2.setDesc("tinha a cabeça partid1a");
		co2.setMotivo("doía-lhe o crânio1");
		co2.endContact();		
		
		co3.setCliente("Joao3", "name", x);
		co3.setAtitude("Simpático");
		co3.setDesc("tinha a cabeça partida3");
		co3.setMotivo("doía-lhe o crânio3");
		co3.endContact();
		
		c.add(co1);
		c.add(co2);
		c.add(co3);
		
		
		String toTest=c.listRudeContact("Joao2");
		ArrayList<Contacto> temporary= new ArrayList<Contacto>();
		temporary.add(co1);
		temporary.add(co2);
		String correcto=temporary.toString();
		
		Boolean a=toTest.equals(correcto);		
		
		assertTrue(a);
	}
	
	public void testNuncaContactou(){
		DBContacto c=new DBContacto();
		Database x=new Database();
		Cliente a1=new Cliente("Joao", "Bairro", "98");
		Cliente a2=new Cliente("Joao2", "Bairro2", "982");
		Cliente a3=new Cliente("Joao3", "Bairro3", "983");
		Contacto co1=new Contacto("chefe", 1);
		Contacto co2=new Contacto("chefe1", 11);
		Contacto co3=new Contacto("chefe3", 13);

		x.add(a1);
		x.add(a2);
		x.add(a3);
			
		co1.setCliente("Joao2", "name", x);
		co1.setAtitude("Rude");
		co1.setDesc("tinha a cabeça partida");
		co1.setMotivo("doía-lhe o crânio");
		co1.endContact();
		
		co2.setCliente("Joao2", "name", x);
		co2.setAtitude("Simpático");
		co2.setDesc("tinha a cabeça partid1a");
		co2.setMotivo("doía-lhe o crânio1");
		co2.endContact();		
		
		co3.setCliente("Joao2", "name", x);
		co3.setAtitude("Simpático");
		co3.setDesc("tinha a cabeça partida3");
		co3.setMotivo("doía-lhe o crânio3");
		co3.endContact();
		
		c.add(co1);
		c.add(co2);
		c.add(co3);

		
		Cliente[] toTest=c.listNeverContact(x);
		Cliente[] temp=new Cliente[1];
		temp[0]=a1;
		boolean a=false;
		int counter=0;
		for(int i=0; i<3; i++)
			{
			//System.out.println(i);
			if(counter>0)
				break;
			if(toTest[i]!=null){
				a=toTest[i].toString().equals(temp[i].toString());
				//if(a==false)			
				//		counter++;
				}
			//System.out.println(temp[i]);
			//System.out.println(toTest[i]);
			}
		assertTrue(a);
	}
	public void testDatas(){

		Calendar data=Calendar.getInstance();
		DBContacto c=new DBContacto();
		Database x=new Database();
		Cliente a1=new Cliente("Joao", "Bairro", "98");
		Cliente a2=new Cliente("Joao2", "Bairro2", "982");
		Cliente a3=new Cliente("Joao3", "Bairro3", "983");
		Contacto co1=new Contacto("chefe", 1);
		Contacto co2=new Contacto("chefe1", 11);
		Contacto co3=new Contacto("chefe3", 13);

		x.add(a1);
		x.add(a2);
		x.add(a3);

		
		co1.setCliente("Joao2", "name", x);
		co1.setAtitude("Rude");
		co1.setDesc("tinha a cabeça partida");
		co1.setMotivo("doía-lhe o crânio");
		co1.endContact();
		
		co2.setCliente("Joao2", "name", x);
		co2.setAtitude("Simpático");
		co2.setDesc("tinha a cabeça partid1a");
		co2.setMotivo("doía-lhe o crânio1");
		co2.endContact();		


		
		co3.setCliente("Joao2", "name", x);
		co3.setAtitude("Simpático");
		co3.setDesc("tinha a cabeça partida3");
		co3.setMotivo("doía-lhe o crânio3");
		co3.endContact();
		
		c.add(co1);
		c.add(co2);
		c.add(co3);
		
		ArrayList<Contacto>tmp = new ArrayList <Contacto>();
		tmp.add(co1);
		tmp.add(co2);
		tmp.add(co3);

		Calendar data2=Calendar.getInstance();
		boolean a=false;
		String toTest=c.listContactsDate(data, data2);
		String correct=tmp.toString();
		if(toTest.equals(correct)==true)
			a=true;
		assertTrue(a);
	}
}
