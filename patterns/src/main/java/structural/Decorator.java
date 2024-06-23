package structural;

/** Динамическое добавление новых обязанностей обьекту
 *  в качестве альтернативы наследованию. */
public class Decorator {
    public static void main(String[] args) {
        Coder senior = new SeniorJavaCoder(new JavaCoder());
        System.out.println(senior.makeJob());

        Coder lead = new JavaTeamLead(new SeniorJavaCoder(new JavaCoder()));
        System.out.println(lead.makeJob());
    }
}

class CoderDecorator implements Coder{

    private Coder coder;

    public CoderDecorator(Coder coder) {
        this.coder = coder;
    }

    @Override
    public String makeJob() {
        return coder.makeJob();
    }
}

interface Coder{
    String makeJob();
}

class JavaCoder implements Coder{
    public String makeJob(){
        return "Write Java code...";
    }
}

class SeniorJavaCoder extends CoderDecorator{

    public SeniorJavaCoder(Coder coder) {
        super(coder);
    }

    public String makeCodeReview(){
        return "Make code review...";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + makeCodeReview();
    }
}

class JavaTeamLead extends CoderDecorator{

    public JavaTeamLead(Coder coder){
        super(coder);
    }

    public String manageTeam(){
        return "Manage team...";
    }

    @Override
    public String makeJob() {
        return super.makeJob() + manageTeam();
    }

}



