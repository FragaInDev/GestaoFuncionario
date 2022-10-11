import java.time.LocalDate;
import java.util.Scanner;

public class GestaoFuncionario {
    private int indice = 0;
    private Funcionario[] funcionarios = new Funcionario[50];
    Scanner scan = new Scanner(System.in);

    public void criar(){
        Funcionario a = new Funcionario();

        System.out.println("***Registro de Funcionário***");
        a.setID(0);
        System.out.println("Digite o Nro de MATRÍCULA do funcionário: ");
        a.setMatricula(scan.nextLine());

        System.out.println("Digite o NOME do funcionário: ");
        a.setNome(scan.nextLine());

        System.out.println("Digite a DATA DE ADMISSÃO do funcionário: (Digite na ordem: YYYY<ENTER> MM<ENTER> DD<ENTER>)");
        a.setAdmissao(LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt()));

        System.out.println("Digite a DATA DE DEMISSÃO do funcionário: (Digite na ordem: YYYY<ENTER> MM<ENTER> DD<ENTER>)");
        a.setDemissao(LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt()));

        System.out.println("Qual o salário desse funcionário? ");
        a.setSalario(scan.nextFloat());

        System.out.println("Qual o horário de trabalho desse funcionário? (Digite: XXhrs às XXhrs)");
        a.setHorario(scan.nextLine());

        this.funcionarios[this.indice] = a;
        this.indice += 1;

        System.out.println("** Funcionário criado com sucesso! :D **");
        System.out.println("Pressione <ENTER> para continuar.");
        scan.nextLine();
    }

    public void exibir() {
        System.out.println("Digite o Nro de MATRÍCULA do funcionário:");
        String matricula = scan.nextLine();

        int i = 0;
        while(i < funcionarios.length){
            Funcionario fun = funcionarios[i];
            if(fun != null && fun.getMatricula().contains(matricula)){
                fun.exibir();
            }
            i+= 1;
        }

        System.out.println("Pressione <ENTER> para continuar.");
        scan.nextLine();
    }

    public void remover(){
        System.out.println("Digite o Nro de MATRÍCULA completo do funcionário que deseja excluir: ");
        String matricula = scan.nextLine();

        for(int i = 0; i < this.funcionarios.length; i++){
            Funcionario fun = this.funcionarios[i];
            if(fun != null && fun.getMatricula().equals(matricula)){
                this.funcionarios[i] = null;
                System.out.println("** Funcionário removido com sucesso! :D **");
            }
        }
        System.out.println("Pressione <ENTER> para continuar.");
        scan.nextLine();
    }

    public void alterar() {
        System.out.println("Digite o Nro de MATRÍCULA completo do funcionário que deseja alterar: ");
        String matricula = scan.nextLine();

        for(Funcionario a : this.funcionarios) {
            if(a != null && a.getMatricula().equals(matricula)){
                a.exibir();
                
                //pular linha
                for(int i = 0; i < 3; i++) System.out.println();

                System.out.println("Selecione o item que deseja alterar: ");
                System.out.println("(T)udo \t\t (N)ome \t (M)atrícula \t\t (H)orário");
                System.out.println("(A)dmissão \t (D)emissão \t (S)alário");
                String txtUC = scan.nextLine().toUpperCase();
                char op = txtUC.charAt(0);

                if(op == 'T'){
                    System.out.println("Digite o novo Nro de MATRÍCULA do funcionário: ");
                    a.setMatricula(scan.nextLine());
            
                    System.out.println("Digite o novo NOME do funcionário: ");
                    a.setNome(scan.nextLine());
            
                    System.out.println("Digite a nova DATA DE ADMISSÃO do funcionário: (Digite na ordem: YYYY<ENTER> MM<ENTER> DD<ENTER>)");
                    a.setAdmissao(LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt()));
            
                    System.out.println("Digite a nova DATA DE DEMISSÃO do funcionário: (Digite na ordem: YYYY<ENTER> MM<ENTER> DD<ENTER>)");
                    a.setDemissao(LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt()));
            
                    System.out.println("Qual o novo salário desse funcionário? ");
                    a.setSalario(scan.nextFloat());
            
                    System.out.println("Qual o novo horário de trabalho desse funcionário? (Digite: XXhrs às XXhrs)");
                    a.setHorario(scan.nextLine());
                } else if(op == 'N'){
                    System.out.println("Digite o novo NOME do funcionário: ");
                    a.setNome(scan.nextLine());
                } else if(op == 'M'){
                    System.out.println("Digite o novo Nro de MATRÍCULA do funcionário: ");
                    a.setMatricula(scan.nextLine());
                } else if(op == 'H'){
                    System.out.println("Qual o novo horário de trabalho desse funcionário? (Digite: XXhrs às XXhrs)");
                    a.setHorario(scan.nextLine());
                } else if(op == 'A'){
                    System.out.println("Digite a nova DATA DE ADMISSÃO do funcionário: (Digite na ordem: YYYY<ENTER> MM<ENTER> DD<ENTER>)");
                    a.setAdmissao(LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt()));
                } else if(op == 'D'){
                    System.out.println("Digite a nova DATA DE DEMISSÃO do funcionário: (Digite na ordem: YYYY<ENTER> MM<ENTER> DD<ENTER>)");
                    a.setDemissao(LocalDate.of(scan.nextInt(), scan.nextInt(), scan.nextInt()));
                } else if(op == 'S'){
                    System.out.println("Qual o novo salário desse funcionário? ");
                    a.setSalario(scan.nextFloat());
                }

                System.out.println("** Atualização de Funcionário feita com sucesso! :D");
                break;
            }
        }
        System.out.println("Pressione <ENTER> para continuar.");
        scan.nextLine();
    }


    public void menu(){
        while(true) {
            //limpar console
            for(int i = 0; i < 30; i++) System.out.println();

            System.out.println("======| Gestão de Funcionários |======");
            System.out.println("Selecione uma opção: ");
            System.out.println("(C)riar \t\t (E)xibir\t\t (R)emover");
            System.out.println("(A)tualizar \t\t (S)air");
            String txtUC = scan.nextLine().toUpperCase();
            char letra = txtUC.charAt(0);

            if(letra == 'C'){
                criar();
            }else if (letra == 'E'){
                exibir();
            }else if(letra == 'R'){
                remover();
            }else if(letra == 'A'){
                alterar();
            }else if(letra == 'S'){
                System.out.println("Fechando Gestão de Funcionários.......... \n Até logo! :D");
                System.exit(0);
            }


        }
    }    
}
