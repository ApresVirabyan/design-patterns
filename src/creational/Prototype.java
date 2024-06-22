package creational;


/** https://medium.com/@thecodebean/prototype-design-pattern-implementation-in-java-b4b900f1ad9a */
public class Prototype {

    public static void main(String[] args) {
        // Create prototype sheep
        Sheep blackPrototype = new BlackSheep("Baa Baa");
        Sheep whitePrototype = new WhiteSheep("Fleecy");

        // Clone sheep as needed
        Sheep clonedBlackSheep = blackPrototype.clone();
        Sheep clonedWhiteSheep = whitePrototype.clone();

        // Customize cloned sheep
        clonedBlackSheep.setName("Midnight");
        clonedWhiteSheep.setName("Snowball");

        // Your sheep farm is thriving!
        System.out.println("Black sheep: " + clonedBlackSheep.getName());
        System.out.println("White sheep: " + clonedWhiteSheep.getName());
    }
}

interface Sheep {
    Sheep clone();
    String getName();
    void setName(String name);

}

class BlackSheep implements Sheep{

    private String name;

    public BlackSheep(String name) {
        this.name = name;
    }

    @Override
    public Sheep clone() {
        return new BlackSheep(this.name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}


class WhiteSheep implements Sheep {
    private String name;

    public WhiteSheep(String name) {
        this.name = name;
    }

    public Sheep clone() {
        return new WhiteSheep(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

