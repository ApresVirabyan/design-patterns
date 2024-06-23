package structural;

import java.util.ArrayList;
import java.util.List;

/**
 * Отделить абстракцию от ее реализации таким образом что-бы мы могли
 * изменять независимо друг от друга и то и другое
 */
public class Bridge {
    public static void main(String[] args) {
        List<Program> list = new ArrayList<>();
        list.add(new BankSystem(new JavaDeveloper()));
        list.add(new StockExchange(new CppDeveloper()));
        list.forEach(Program::developProgram);

        System.out.println();

        List<Program> list2= new ArrayList<>();
        list2.add(new BankSystem(new CppDeveloper()));
        list2.add(new StockExchange(new JavaDeveloper()));
        list2.forEach(Program::developProgram);

    }
}

abstract class Program {
    protected Developer developer;

    protected Program(Developer developer) {
        this.developer = developer;
    }

    public abstract void developProgram();
}

class BankSystem extends Program {


    protected BankSystem(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Bank System development");
        developer.writeCode();
    }
}

class StockExchange extends Program {
    protected StockExchange(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Stock Exchange development");
        developer.writeCode();
    }
}

interface Developer {
    void writeCode();
}

class JavaDeveloper implements Developer {
    public void writeCode() {
        System.out.println("Java developer");
    }
}

class CppDeveloper implements Developer {
    public void writeCode() {
        System.out.println("C++ developer");
    }
}