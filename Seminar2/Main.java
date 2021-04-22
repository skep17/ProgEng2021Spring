public class Main {

    public static void main(String[] args){
        Number nm1 = new Number(1542);
        System.out.println(nm1.toArabic());
        System.out.println(nm1.toRoman());
        nm1.setValue("MCDI");
        System.out.println(nm1.toRoman());
        System.out.println(nm1.toArabic());
    }
}
