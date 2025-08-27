package composite.pattern;

class Developer extends Employee {
    public Developer(String name) {
        super(name);
    }

    @Override
    public void showDetails() {
        System.out.println("Developer: " + name);
    }
}
