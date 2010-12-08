import java.util.Calendar;

public class Contacto {
	String tipo;
	String motivo;
	String descricao;
	String duracao;
	String atitude;
	Cliente c;
	//Esta string só serve para simplificar o método de pesquisa de contactos de um determinado cliente.
	String nomeClienteToCompare;
	int numFuncionario;
	String unregContacto;
	String unregContactoRel;
	Calendar startData;
	Calendar endData;
	
	public Contacto(String ti, int nfunc){
	this.tipo=ti;
	numFuncionario=nfunc;
	startData=Calendar.getInstance();
	}
	
	public void setMotivo(String m){
		this.motivo=m;
	}
	
	public void setDesc(String d){
		this.descricao=d;
	}
	
	public void setDuracao(String d){
		this.duracao=d;
	}
	
	public void setCliente(String value, String tipo, Database x)//email ou telefone
	{
		this.c=x.search(value, tipo).get(0);
		nomeClienteToCompare=c.getNome();
	}
	
	public void setAtitude(String a){
		this.atitude=a;
	}
	
	public void setunReg(String contNome, String contRelacao){
		this.unregContacto=contNome;
		this.unregContactoRel=contRelacao;
	}
	
	public void endContact(){
		endData=Calendar.getInstance();
		long ini=this.startData.getTimeInMillis();
		long fin=endData.getTimeInMillis();
		long diff=fin-ini;
		int segundos=(int)diff/1000;
		int horas=segundos/3600;
		int resto=segundos%3600;
		int minutos=resto/60;
		segundos=resto%60;
		duracao=((horas<10 ? "0": "")+horas+":"+(minutos<10 ? "0":"")+minutos+":"+(segundos<10 ? "0":"")+segundos);
	}
	
	public String toString(){
		//caso seja um email, usar N/A na duração
		String s="";
		
		if(unregContacto==null)
			s="Funcionario Numero "+numFuncionario+"; "+"Tipo: "+tipo+"; "+"Data de Inicio: "
			+startData.getTime()+"; "+ "Motivo: "+motivo+"; Nome do Cliente: "+nomeClienteToCompare+
			"; Descrição: "+descricao+"; duracao: "+duracao+"; Atitude do Cliente: "+atitude ; 
		else
			s="Funcionario Numero "+numFuncionario+"; "+"Tipo: "+tipo+"; "+"Data de Inicio: "
			+startData.getTime()+"; "+ "Motivo: "+motivo+"; Descrição: "+descricao+
			"; duracao: "+duracao+"; Nome do Cliente: "+nomeClienteToCompare+"; Atitude do Cliente: "
			+atitude +"; Nome da pessoa que efectuou o contacto: "+unregContacto+
			"; Relação com o Cliente: "+unregContactoRel;
		
		return s;
	}

	
}
