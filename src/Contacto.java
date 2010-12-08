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
	Calendar data;
	
	public Contacto(String ti, int nfunc){
	this.tipo=ti;
	numFuncionario=nfunc;
	data=Calendar.getInstance();
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
	
	public String toString(){
		//caso seja um email, usar N/A na duração
		String s="";
		
		if(unregContacto==null)
			s="Funcionario Numero "+numFuncionario+"; "+"Tipo: "+tipo+"; "+"Data: "
			+data.getTime()+"; "+ "Motivo: "+motivo+"; Nome do Cliente: "+nomeClienteToCompare+
			"; Descrição: "+descricao+"; duracao: "+duracao+"; Atitude do Cliente: "+atitude ; 
		else
			s="Funcionario Numero "+numFuncionario+"; "+"Tipo: "+tipo+"; "+"Data: "
			+data.getTime()+"; "+ "Motivo: "+motivo+"; Descrição: "+descricao+
			"; duracao: "+duracao+"; Atitude do Cliente: "+atitude +
			"; Nome da pessoa que efectuou o contacto: "+unregContacto+
			"; Relação com o Cliente: "+unregContactoRel;
		return s;
	}
}
