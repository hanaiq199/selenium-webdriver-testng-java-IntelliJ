package javaTester.basic;

public class Topic_01_System_Property {
    public static void main(String[] args){
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        String osName = System.getProperty("os.name");
        System.out.println(osName);
    }
}
