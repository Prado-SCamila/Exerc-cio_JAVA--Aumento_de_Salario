package application;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Employee;

public class App {
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BRIGHT_BLACK = "\u001B[90m";
    public static final String ANSI_BRIGHT_RED = "\u001B[91m";
    public static final String ANSI_BRIGHT_GREEN = "\u001B[92m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BRIGHT_BLUE = "\u001B[94m";
    public static final String ANSI_BRIGHT_PURPLE = "\u001B[95m";
    public static final String ANSI_BRIGHT_CYAN = "\u001B[96m";
    public static final String ANSI_BRIGHT_WHITE = "\u001B[97m";

    public static void main(String[] args) {
        System.out.println("**************************************");

        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>(); // crio uma lista, pergunto o numero de registros e insiro um for de
                                                 // acordo com o numero de registror

        System.out.println("How many employees will be registered?");
        int n = sc.nextInt();

        for (Integer i = 0; i < n; i++) {
            System.out.println("Employee _" + (i + 1) + "_");
            System.out.println("id: ");
            Integer id = sc.nextInt();
            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.next();
            System.out.println("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary); // peço para o usuario inserir as infos para criar a lista e
                                                           // crio um objeto emp
                                                           // que vai receber essas infos e ser adicionado na lista com
                                                           // todas as
                                                           // informações.

            list.add(emp);

        }

        System.out.println("Enter the id of the employee that will have the salary increased");
        int idSalary = sc.nextInt();
        // preciso dar um nome diferente pra esse if pq vou compara-lo com o id no
        // objeto na expressao lambda abaixo

        Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
        // Encontra um objeto emp fazendo a busca através do seu id. se seu id for igual
        // ao id que eu inseri agora ( idSalary), ele armazena esse
        // objeto encontrado com esse id igual nesse objeto emp. Assim ele se torna
        // específico.

        if (emp == null) {
            System.out.println("This id does not exist");// se não houver emp com esse id, ele retorna nulo

        } else {// se houver, ele faz essas ações:

            System.out.println(ANSI_BRIGHT_CYAN + "Enter the percentage: " + ANSI_RESET);

            double percent = sc.nextDouble();

            System.out.println("The percentage that will be added is: " + percent + "%");

            emp.increaseSalary(percent); // chamo a função de aumento de salário pro
            // objeto emp que a expressao lambda selecionou pelo id.

            // imprimir lista de empregados
            System.out.println();
            System.out.println(ANSI_BRIGHT_GREEN + "List of employees:" + ANSI_RESET);

            for (int i = 0; i < n;) {// contador de acordo com o numero de registros para numerar a lista que eu vou
                                     // criar com o for.
                for (Employee e : list) { // para cada elemento da lista employee, ele faz 1 ação.
                    System.out.println((i + 1) + "__" + ANSI_BRIGHT_BLUE + "id: " + e.getId() + "," + ANSI_RESET +
                            ANSI_BRIGHT_PURPLE + "name : " + e.getName() + "," + ANSI_RESET +
                            ANSI_BRIGHT_YELLOW + "salary : " + e.getSalary() + "," + ANSI_RESET);
                    i++;// o incremento vem depois da ação se não ele nao conta individualmente, mas
                        // coloca os dois registros em uma "rodada" só
                    // aí a lista fica multiplicada pelo numero de registros.
                }
            }
            sc.close();
        }
    }
}
