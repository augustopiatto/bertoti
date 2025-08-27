package composite.pattern;

public class CompositePatternDemo {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Alice");
        Developer dev2 = new Developer("Bob");

        Team team = new Team("Development Team");
        team.addEmployee(dev1);
        team.addEmployee(dev2);

        team.showDetails();
    }
}
