
public class Funcionario {
	String nome,categoria,contacto;
	int numUnico;
	double salario;
	
	
	public Funcionario(String n,String cat,String c,int num,double s){
		this.nome=n;
		this.categoria=cat;
		this.contacto=c;
		this.numUnico=num;
		this.salario=s;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getCategoria(){
		return categoria;
	}
	
	public int getNumUnico(){
		return numUnico;
	}
	
	public double getSalario(){
		return salario;
	}
	
	public void setNome(String a){
		nome=a;
	}
	public void setCategoria(String b){
		categoria=b;
	}
	
	public void setNumUnico(int c){
		numUnico=c;
	}
	public void setSalario(double d){
		salario=d;
	}
	
	public String toString(){
		return "Nome Funcionario: "+nome+"; "+"Numero Unico: "+numUnico+"; "+"Categoria: "+categoria+"; "+"Contacto: "+contacto+"; "+"Salario: "+salario+"; ";
		}
}
