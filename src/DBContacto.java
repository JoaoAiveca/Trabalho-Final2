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
	
	public ArrayList<Contacto> listContacts(String nomeCliente){// Listar os contactos de um dado cliente.
		
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
		//directa entre numContactos e nomeClientes; numa posição em que correspondam (i=0, por exemplo), indica que
		//o cliente cujo nome é t[0] tem x contactos efectuados (corresponde a arrayT[0]).
		int[] numContactos=new int[numClientes];
		
		Cliente[] nomeClientes=new Cliente[numClientes];	
		//nomeClientes tem os nomes de todos os clientes da empresa
		for(int i=0; i<numClientes; i++)
			nomeClientes[i]=x.getCliente(i);
		for(int i=0; i<numClientes; i++)
			{
			temp=new ArrayList<Contacto>();
			//nomeClientes já tem valores. Vamos popular numContactos.
			for(int j=0; j<this.db.size(); j++)
				if(db.get(j).nomeClienteToCompare.equals(nomeClientes[i].getNome()))
					temp.add(db.get(j));
			numContactos[i]=temp.size();
			}
		//Neste ponto, temos os nomes dos clientes e o número de contactos, em nomeClientes e numContactos.
		//Será necessário ordená-los de forma descendente.
		for(int j=1; j<numClientes; j++)
			while(numContactos[j]>numContactos[j-1])
			{
			int tempInt=numContactos[j-1];
			Cliente tempC=nomeClientes[j-1];
			numContactos[j-1]=numContactos[j];
			numContactos[j]=tempInt;
			nomeClientes[j-1]=nomeClientes[j];
			nomeClientes[j]=tempC;
			if(j>1)
			j--;
			}
		
		return nomeClientes;
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

	
	public String listRudeContact(String nomeCliente){ //Listar clientes mal-educados.
		
		ArrayList<Contacto> temp = new ArrayList<Contacto>();
		for(int i = 0;i<db.size();i++){
			if(db.get(i).nomeClienteToCompare.equals(nomeCliente)==true){
				temp.add(db.get(i));
			}
		}
		return temp.toString();
	}
	public Cliente[] listNeverContact(Database x){
		
		ArrayList<Contacto> temp;
		//número de clientes existentes na empresa
		int numClientes=x.data.size();
		//Array de inteiros que indica o número de contactos dos clientes. há uma correspondência
		//directa entre numContactos e nomeClientes; numa posição em que correspondam (i=0, por exemplo), indica que
		//o cliente cujo nome é t[0] tem x contactos efectuados (corresponde a arrayT[0]).
		int[] numContactos=new int[numClientes];
		
		Cliente[] nomeClientes=new Cliente[numClientes];
		Cliente[] toReturn=new Cliente[numClientes];
		//nomeClientes tem os nomes de todos os clientes da empresa
		for(int i=0; i<numClientes; i++)
			nomeClientes[i]=x.getCliente(i);
		for(int i=0; i<numClientes; i++)
			{
			temp=new ArrayList<Contacto>();
			//nomeClientes já tem valores. Vamos popular numContactos.
			for(int j=0; j<this.db.size(); j++)
				if(db.get(j).nomeClienteToCompare.equals(nomeClientes[i].getNome()))
					temp.add(db.get(j));
			numContactos[i]=temp.size();
			}
		//Neste ponto, temos os nomes dos clientes e o número de contactos, em nomeClientes e numContactos.
		//Será necessário ordená-los de forma descendente.
		
		int k=0;
		for(int j=0; j<numClientes; j++)
			{int tempInt=numContactos[j];
				if(tempInt==0)
					{toReturn[k]=nomeClientes[j];
					 k++;}
			}
		
		return toReturn;
	}
}
