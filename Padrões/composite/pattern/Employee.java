package composite.pattern;

abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract void showDetails();
}
