package entities;

public class Employee {

    private Integer id;
    private String name;
    private double salary;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // construtores_____________________________________________________

    public Employee() {

    }

    public Employee(Integer id, String name, double salary) { // É aqui que acontece a atribuição de valores.
        // os dados que entrarem pelo scanner são armazenados em id, nome e salary. e
        // aqui eu mando armazenar esses valores na variável que está na
        // propriedade da classe

        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void increaseSalary(double percent) {

        this.salary = ((salary * (percent / 100)) + salary);
    }

    @Override
    public String toString() {

        return "id: " + id + "," + "name: " + name + "," + "salary: " + String.format("%.2f", salary);
    }
}
