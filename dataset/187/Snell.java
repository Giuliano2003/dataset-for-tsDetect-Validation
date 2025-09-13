
public class Pet {
	private String especie;
    private String nome;
    private int idade;
    
    public Pet(String nome, String especie, int idade) {
    	this.nome = nome;

    	this.especie = especie;
    	this.idade = idade;
    }
    public  String getNome() {
        
        return nome;
    }

    public void setNome(String nome) {
    	
        this.nome = nome;
    }
    
    public  String getEspecie() {
       
        return especie;
    }

    public void setEspecie(String especie) {
    	
        this.especie = especie;
    }
    
    public  int getIdade() {
        
        return this.idade;
    }

    public void setIdade(int idade) {
    	
        this.idade = idade;
    }
}