import java.time.LocalDate;

public class Funcionario {
    private long id;
    private String nome;
    private String matricula;
    private LocalDate admissao;
    private LocalDate demissao;
    private float salario;
    private String horario;

 //=========Get and Setters ==========   

    public void setID(long id){
        this.id = id;
    }
    public long getID(){
        return this.id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public String getMatricula(){
        return this.matricula;
    }

    public void setAdmissao(LocalDate admi){
        this.admissao = admi;
    }
    public LocalDate getAdmissao(){
        return this.admissao;
    }

    public void setDemissao(LocalDate demi){
        this.demissao = demi;
    }
    public LocalDate getDemissao(){
        return this.demissao;
    }

    public void setSalario(float sal){
        this.salario = sal;
    }
    public float getSalario(){
        return this.salario;
    }

    public void setHorario(String horario){
        this.horario = horario;
    }
    public String getHorario(){
        return this.horario;
    }

 //======== Methods =========
    public void exibir(){
        System.out.println("======| Dados do Funcionário |======");
        System.out.println(toString());
    }   

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\tMatrícula: " + getMatricula() + "\t\tHorário: " + getHorario() +
             "\nAdmissão: " + getAdmissao() + "\tDemissão: " + getDemissao() + "\tSalário: " + getSalario();
            
    }
}