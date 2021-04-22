abstract class Phone implements Electronic{

    abstract void makeCall(String number);

    public static void testCall(String number){
        System.out.println("Testing call function");
    }

    public void plugin(){
        System.out.println("Electronic device is charging");
    }

    public void on(){
        System.out.println("Device is on");
    }

    public void off(){
        System.out.println("Device is off");
    }
}
