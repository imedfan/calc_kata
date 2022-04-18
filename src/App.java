import java.util.Scanner;


public class App {
    static int number1, number2, result; // вынес из майна, чтоб на всех
    static char symbol;

    public static void main(String[] args) throws CalcException {
        Scanner console = new Scanner(System.in);
        String inputConsole = console.nextLine(); // снимем ввод для начала
        char[] inputConsoleMass = inputConsole.toCharArray();
        String inputConsoleMassStr = String.valueOf(inputConsoleMass);
        //char[] symsalabim = {'*', '/', '+', '-'};
        int ii=0;
        for (int i=0; i<inputConsoleMassStr.length(); i+=1){ //проверяем на несколько операторов
            char c = inputConsoleMassStr.charAt(i);
            if(c=='/' || c=='*' || c=='+' || c=='-'){
                ii+=1;
                if(ii>=2){
                    //System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    throw new CalcException("Формат математической операции не удовлетворяет заданию");
                    //System.exit(1);
                }
            }
        }

        if(ii<=0){
            throw new CalcException("Строка не является математической операцией");
        }

        String[] inputConsoleMassStrMass = inputConsoleMassStr.split("[ ]"); // на питоне с таким проще
        number1 = RomatoAraba(inputConsoleMassStrMass[0]);
        number2 = RomatoAraba(inputConsoleMassStrMass[2]);
        if (number1<0 && number2<0){ // если не римские
            result=0;
            number1 = Integer.parseInt(inputConsoleMassStrMass[0]);
            number2 = Integer.parseInt(inputConsoleMassStrMass[2]);
            symbol = inputConsoleMassStrMass[1].charAt(0);
            result=calca(number1, number2, symbol);
            System.out.println(result); //на арабской мове
        }else if(number1<0 || number2<0){ // проверка на римскоарабскую 
            //System.out.println("Используются одновременно разные системы счисления");
            throw new CalcException("Ввод не удовлетворяет требованиям");
        }else{ // если арабские
                symbol = inputConsoleMassStrMass[1].charAt(0);
                result=calca(number1, number2, symbol);
                if(result>0){
                    String  resultRoman = convertNumToRoman(result);
                    System.out.println(resultRoman); //на римской мове
                }else if(result<=0){
                    //System.out.println("В римской системе нет отрицательных чисел");
                    throw new CalcException("В римской системе нет отрицательных чисел и нуля");
                }
                
            }
            
        }
        
    

    public static int calca(int n1, int n2, char sym) throws CalcException { // калькуляция
        int res = 0;
        if (n1 <= 10 && n2 <= 10 && n1 != 0 && n2 != 0) {
            switch (sym) {
                case '*':
                    res = n1 * n2;
                    return res;
                    //System.out.println(res);
                   // break;
                case '/':
                    if (n2 == 0) {
                        //System.out.println("На ноль делить нельзя!");
                        throw new CalcException("На ноль делить нельзя!");
                        
                    } else {
                        res = n1 / n2;
                        return res;
                        //System.out.println(res);
                        //break;
                    }

                case '+':
                    res = n1 + n2;
                    return res;
                    //System.out.println(res);
                    //break;
                case '-':
                    res = n1 - n2;
                    return res;
                    //System.out.println(res);
                    //break;
                default:
                //System.out.println("Отсутствует оператор");
                throw new CalcException("Отсутствует оператор");
                    
            }
        } else {
            //System.out.println("Калькулятор принимает на вход числа от 1 до 10 включительно, не более.");
            //System.exit(1);
            throw new CalcException("Калькулятор принимает на вход числа от 1 до 10 включительно, не более.");
        }

        //return res;
    }

    public static int RomatoAraba(String roman) { //спасибо кто все это писал ручками 
        int s = 0;

        if (roman.equals("I")) {
            s = 1;
            return s;
        } else if (roman.equals("II")) {
            s = 2;
            return s;
        } else if (roman.equals("III")) {
            s = 3;
            return s;
        } else if (roman.equals("IV")) {
            s = 4;
            return s;
        } else if (roman.equals("V")) {
            s = 5;
            return s;
        } else if (roman.equals("VI")) {
            s = 6;
            return s;
        } else if (roman.equals("VII")) {
            s = 7;
            return s;
        } else if (roman.equals("VIII")) {
            s = 8;
            return s;
        } else if (roman.equals("IX")) {
            s = 9;
            return s;
        } else if (roman.equals("X")) {
            s = 10;
            return s;
        }
        return -1;

    }

    private static String convertNumToRoman (int numArabian) { //парень сток старался грех не воспользоватся его работой =)
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }

}


