import java.util.*;

public class DBContacto {
	ArrayList <Contacto> db;
	
	public DBContacto(){
		db=new ArrayList<Contacto>();
	}
	
	public void add(Contacto x){
		db.add(x);
	}
	
	public ArrayList<Contacto> getDBC(){
		return this.db;
	}
	
	public Contacto getContacto(int cont){
		Contacto x = db.get(cont);
		return x;
	}
	
	public String listContacts(String cont){//A ideia e isto listar os contactos de um dado cliente.
		//falta info da classe Contacto para por isto a funcionar.
		ArrayList<Contacto> temp = new ArrayList<Contacto>();
		
		for(int i =0;i<db.size();i++){
			if(db.getDBC(i).get()){        //Se o contacto inserido corresponder ao de um cliente que se encontra na DB, o programa copia-o para a arraylist temp.
				temp.add(db.getDBC(i));
			}
		}
		return temp.toString();
	}
	
	public String listRudeContact(String cont){ //Listar clientes mal-educados.
		//falta info da classe Contacto para por isto a funcionar.
		ArrayList<Contacto> temp = new ArrayList<Contacto>();
		for(int i = 0;i<db.size();i++){
			if((db.getDBC.getAtitude()).equals("mal-educado")){
				temp.add(db.getDBC(i));
			}
		}
		return temp.toString();
	}
	
}
