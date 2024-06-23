package structural;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Используется для минимизации потребления памяти
 *  путем повторного использования уже существующих объектов вместо создания новых
 */
public class Flyweight {
    private static final Map<String, Engineer> engineers = new HashMap<>();

    public Engineer getEngineerBySpeciality(String speciality) {
        Engineer engineer = engineers.get(speciality);

        if(engineer == null) {
            switch (speciality){
                case "java":
                    System.out.println("Hiring Java Engineer");
                    engineer = new JavaEngineer();
                    break;
                case "c++":
                    System.out.println("Hiring C++ Engineer");
                    engineer = new CppEngineer();
            }
            engineers.put(speciality, engineer);
        }

        return engineer;
    }
}


class ProjectRunner{
    public static void main(String[] args) {
        Flyweight flyweight = new Flyweight();
        List<Engineer> engineers = new ArrayList<>();

        engineers.add(flyweight.getEngineerBySpeciality("java"));
        engineers.add(flyweight.getEngineerBySpeciality("java"));
        engineers.add(flyweight.getEngineerBySpeciality("java"));
        engineers.add(flyweight.getEngineerBySpeciality("java"));
        engineers.add(flyweight.getEngineerBySpeciality("java"));
        engineers.add(flyweight.getEngineerBySpeciality("java"));
        engineers.add(flyweight.getEngineerBySpeciality("c++"));
        engineers.add(flyweight.getEngineerBySpeciality("c++"));
        engineers.add(flyweight.getEngineerBySpeciality("c++"));
        engineers.add(flyweight.getEngineerBySpeciality("c++"));
        engineers.add(flyweight.getEngineerBySpeciality("c++"));
        engineers.add(flyweight.getEngineerBySpeciality("c++"));
        engineers.add(flyweight.getEngineerBySpeciality("c++"));

        for (Engineer engineer : engineers) {
            engineer.writeCode();
        }
    }
}

interface Engineer{
    void writeCode();
}

class CppEngineer implements Engineer{

    @Override
    public void writeCode() {
        System.out.println("Cpp Engineer Writing C++ code");
    }
}


class JavaEngineer implements Engineer{

    @Override
    public void writeCode() {
        System.out.println("Java Engineer Writing Java code");
    }
}
