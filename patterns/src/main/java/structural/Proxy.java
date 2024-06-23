package structural;

/**
 * Для замещения обьекта и контроля доступа к нему
 * с целью контроля доступа, кэширования, логирования, отложенной инициализации ...
 */
public class Proxy {

}

class ProjRunner{
    public static void main(String[] args) {
        Project project = new ProxyProject("https://www.github.com/realProject");

        //project.run();
    }
}

interface Project{
    void run();
}

class ProxyProject implements Project{

    private String url;
    private RealProject realProject;

    public ProxyProject(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        if(realProject == null){
            realProject = new RealProject(url);
        }
        realProject.run();
    }
}

class RealProject implements Project{

    private String url;

    public RealProject(String url) {
        this.url = url;
        load();
    }

    public void load(){
        System.out.println("Loading project from " + url);
    }


    @Override
    public void run() {
        System.out.println("Running project " + url);
    }
}