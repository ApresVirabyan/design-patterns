package structural;

import lombok.Getter;

/**
 *   Используется для определения интерфейса высокого уровня
 *   который упрощает испоьзование подсистемы
 */
public class Facade {

    private final Job job = new Job();
    private final BugTracker bugTracker = new BugTracker();
    private final IosDeveloper iosDeveloper = new IosDeveloper();

    public void solveProblems(){
        job.doJob();
        bugTracker.startSprint();
        iosDeveloper.doJobBeforeDeadline(bugTracker);
    }

    public void learning(){
        bugTracker.finishSprint();
        iosDeveloper.doJobBeforeDeadline(bugTracker);
    }

}

class Client{
    public static void main(String[] args) {
//        Job job = new Job();
//        job.doJob();
//        BugTracker bugTracker = new BugTracker();
//        bugTracker.startSprint();
//        IosDeveloper iosDeveloper = new IosDeveloper();
//        iosDeveloper.doJobBeforeDeadline(bugTracker);
//
//        bugTracker.finishSprint();
//        iosDeveloper.doJobBeforeDeadline(bugTracker);

        Facade facade = new Facade();
        facade.solveProblems();

        facade.learning();
    }
}

class Job{
    public void doJob(){
        System.out.println("Job in progress...");
    }
}

@Getter
class BugTracker{
    private boolean activeSprint;

    public void startSprint(){
        System.out.println("Sprint is active...");
        activeSprint = true;
    }

    public void finishSprint(){
        System.out.println("Sprint is finished...");
        activeSprint = false;
    }
}

class IosDeveloper{
    public void doJobBeforeDeadline(BugTracker bugTracker){
        if(bugTracker.isActiveSprint()){
            System.out.println("Developer is solving problems");
        } else {
            System.out.println("Developer is learning");
        }
    }
}
