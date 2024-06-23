package structural;

import java.util.ArrayList;
import java.util.List;

/** Скомпонировать обьекты в структуры по типу дерева
 * для группировки мелких компонентов в более крупные.
 * используется например в GUI Java*/
public class Composite {

    public static void main(String[] args) {

        Team team = new Team();

        Programmer javaProgrammer = new JavaProgrammer();
        Programmer javaProgrammer2 = new JavaProgrammer();
        Programmer cppProgrammer = new CppProgrammer();

        team.addProgrammer(javaProgrammer);
        team.addProgrammer(javaProgrammer2);
        team.addProgrammer(cppProgrammer);

        team.createProject();

    }
}

class Team{

    private List<Programmer> programmers = new ArrayList<>();

    void addProgrammer(Programmer programmer){
         programmers.add(programmer);
    }

    void deleteProgrammers(Programmer programmer){
        programmers.remove(programmer);
    }

    public void createProject(){
        System.out.println("Creating project");
        for (Programmer programmer : programmers) {
            programmer.writeCode();
        }
    }
}

interface Programmer{
    void writeCode();
}

class JavaProgrammer implements Programmer{

    @Override
    public void writeCode() {
        System.out.println("Java Programmer write code...");
    }
}

class CppProgrammer implements Programmer{
    @Override
    public void writeCode() {
        System.out.println("C++ Programmer write code...");
    }
}


