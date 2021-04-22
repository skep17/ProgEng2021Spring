public class Number {

    private int arabic;
    private String roman;

    public Number(int x){
        setValue(x);
    }

    public Number(String y){
        setValue(y);
    }

    public int toArabic(){
        return arabic;
    }

    public String toRoman(){
        return roman;
    }

    private int char2int(char ch){
        int result = 0;

        switch (ch) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;

            default: throw new NumberFormatException("Invalid Number");
        }
    }

    private  String int2string( int x){
        String result = "";
        for(int j = 0; j < x/1000; j++){
            result+="M";
        }
        x = x%1000;
        int temp = x/100;
        if(temp == 4){
            result += "CD";
            temp = 0;
        } else if(temp >= 5) {
            result += "D";
            temp-=5;
        }
        for(int j = 0; j< temp; j++){
            result += "C";
        }
        x = x%100;
        temp = x/10;
        if(temp == 4){
            result += "XL";
            temp = 0;
        } else if(temp >= 5) {
            result += "L";
            temp-=5;
        }
        for(int j = 0; j< temp; j++){
            result += "X";
        }
        x = x%10;
        if(x == 4){
            result += "IV";
            x = 0;
        } else if(x >= 5) {
            result += "V";
            x-=5;
        }
        for(int j = 0; j< x; j++){
            result += "I";
        }
        return result;
    }

    public void setValue(int x){
        if(x < 1 || x > 3999)
            throw new NumberFormatException("Number should be between 1 - 3999");
        arabic = x;

        roman = int2string(x);
    }
    public void setValue(String y){
        roman = y;

        int j = 0;
        int num = 0;
        while (j < y.length()){
            char curC = y.charAt(j);
            int curV = char2int(curC);
            if(j+1<y.length() && char2int(y.charAt(j+1))>curV){
                num-= curV;
            } else {
                num += curV;
            }
            j++;
        }
        arabic = num;
    }

}
