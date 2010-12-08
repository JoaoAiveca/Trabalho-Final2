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
	
	public ArrayList<Contacto> listContacts(String nomeCliente){//A ideia e isto listar os contactos de um dado cliente.
		//falta info da classe Contacto para por isto a funcionar.
		ArrayList<Contacto> temp = new ArrayList<Contacto>();
		for(int i = 0;i<db.size();i++){
			if(db.get(i).nomeClienteToCompare.equals(nomeCliente)==true){
				temp.add(db.get(i));
			}
		}
		return temp;
	}
	
	public Cliente[] listMostContacts(Database x){
		
		ArrayList<Contacto> temp;
		//número de clientes existentes na empresa
		int numClientes=x.data.size();
		//Array de inteiros que indica o número de contactos dos clientes. há uma correspondência
		//directa entre arrayT e t; numa posição em que correspondam (i=0, por exemplo), indica que
		//o cliente cujo nome é t[0] tem x contactos efectuados (corresponde a arrayT[0]).
		int[] arrayT=new int[numClientes];
		
		Cliente[] t=new Cliente[numClientes];	
		//t tem os nomes de todos os clientes da empresa
		for(int i=0; i<numClientes; i++)
			t[i]=x.getCliente(i);
		for(int i=0; i<numClientes; i++)
			{
			temp=new ArrayList<Contacto>();
			//t já tem valores. Vamos popular arrayT.
			for(int j=0; j<this.db.size(); j++)
				if(db.get(j).nomeClienteToCompare.equals(t[i].getNome()))
					temp.add(db.get(j));
			arrayT[i]=temp.size();
			}
		//Neste ponto, temos os nomes dos clientes e o número de contactos, em t e arrayT.
		//Será necessário ordená-los de forma descendente.
		for(int j=1; j<numClientes; j++)
			while(arrayT[j]>arrayT[j-1])
			{
			int tempInt=arrayT[j-1];
			Cliente tempC=t[j-1];
			arrayT[j-1]=arrayT[j];
			arrayT[j]=tempInt;
			t[j-1]=t[j];
			t[j]=tempC;
			if(j>1)
			j--;
			}
		
		return t;
	}
	
	
	public String listContactsDate(Calendar date){
		ArrayList<Contacto>tmp = new ArrayList <Contacto>();
		for(int q = 0;q<db.size();q++){
			if(db.get(q).startData.equals(date)==true){
				tmp.add(db.get(q));
			}
		}
		return tmp.toString();
	}

	public String listContactsDate(Calendar startdate, Calendar endDate){
			ArrayList<Contacto>tmp = new ArrayList <Contacto>();
			for(int q = 0;q<db.size();q++){
		if((db.get(q).startData.before(endDate)==true||db.get(q).startData.equals(endDate)==true)&&(db.get(q).startData.after(startdate)==true||db.get(q).startData.equals(startdate)==true)){
					tmp.add(db.get(q));}
			}
			return tmp.toString();}

	
	/*public String listRudeContact(String cont){ //Listar clientes mal-educados.
		//falta info da classe Contacto para por isto a funcionar.
		ArrayList<Contacto> temp = new ArrayList<Contacto>();
		for(int i = 0;i<db.size();i++){
			if(db.get(i).nomeClienteToCompare.equals(cont)==true){
				temp.add(db.get(i));
			}
		}
		return temp.toString();
	}*/
	
}
