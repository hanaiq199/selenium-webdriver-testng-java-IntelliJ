package javaTester.basic;

public class Topic_03_Parameter {
    public static void main (String[] args){
        Topic_03_Parameter topic = new Topic_03_Parameter();
        topic.showCarName();
        topic.showCarName("Hyundai");
        topic.showCarName("Honda");
        topic.showCarName("Yamaha");

        topic.showCarName("Hyundai","5");
        topic.showCarName("Honda","3");
    }

    public void showCarName(){
        System.out.println("No param");
    }

    public void showCarName(String carName){
        System.out.println("One param" + carName);
    }

    /**
     * Show car name with two parameter
     * @author Hana
     * @param carName
     * @param carNumber
     * @return void
     */
    public void showCarName(String carName, String carNumber){
        System.out.println("Two parameter" + carName + "-" + carNumber);
    }
}
