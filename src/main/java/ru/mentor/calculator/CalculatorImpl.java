package ru.mentor.calculator;


public class CalculatorImpl extends ArabicRomanConverterImpl implements Calculator {




    @Override
    public String solve(String expression) {
        String exp = expression;
        String firstEL;
        String secondEL;
        int opInx;//индекс оператора


        for(int i = 0 ; i < exp.length(); i++){
            if (exp.charAt(i) == ' '){//чистим от пробелов

                String newExp = exp.substring(0, i);
                newExp += exp.substring(i + 1);
                exp = newExp;
            }
        }

        for(int i = 0 ; i < exp.length(); i++){

            if ((exp.charAt(i) == '*')||(exp.charAt(i) == '/')||(exp.charAt(i) == '+')||(exp.charAt(i) == '-')){

                opInx = i;

                firstEL = exp.substring(0,opInx);
                secondEL = exp.substring(opInx+1);


                if((firstEL.length()!=0)&&(secondEL.length()!=0)) {

                    if (exp.charAt(opInx) == '*') {//операция умножения

                        return mul(firstEL, secondEL);

                    } else if (exp.charAt(opInx) == '/') {//операция деления

                        return div(firstEL, secondEL);

                    } else if (exp.charAt(opInx) == '+') { // операция сложения

                        return add(firstEL, secondEL);

                    } else if (exp.charAt(opInx) == '-') { //операция вычитания

                        return sub(firstEL, secondEL);

                    }
                }
            }
        }

        // TODO: 7 При вводе пользователем строки не соответствующей одной из вышеописанных
        //  арифметических операций приложение выбрасывает исключение и завершает свою работу.
        throw new IllegalArgumentException("неверное выражение");


    }

    //TODO: 1 Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами:
    // a + b, a - b, a * b, a / b.
    //TODO: 2 Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) цифрами.
    //TODO: 3 Калькулятор умеет работать с цифрами от 1 до 10 включительно.
    //TODO: 4 Калькулятор умеет работать только с целыми числами.
    //TODO: 5 Калькулятор умеет работать только с арабскими или римскими цифрами одновременно,
    // при вводе пользователем строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
    //TODO: 6 При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.

    private String mul(String firstElement,String secondElement) throws IllegalArgumentException {

        int first;
        int second;

        try {
            // пробуем получить арабские цифры и перемножить их
            first = Integer.parseInt(firstElement);
            second = Integer.parseInt(secondElement);

            if ((first > 0)&&(first < 11)&&(second > 0)&&(second < 11)) {
                return Integer.toString( first * second );
            }
            System.out.println(" один из элементов < 0 или > 10");
            throw new IllegalArgumentException();
        }
        catch(IllegalArgumentException e){

            // несумев получить арабские числа, пробуем получить римские и перемножить их
            return arabicToRoman(romanToArabic(firstElement) * romanToArabic(secondElement));
        }

    }

    private String div(String firstElement,String secondElement) throws IllegalArgumentException {
        int first;
        int second;

        try {
            // пробуем получить арабские цифры и разделить их
            first = Integer.parseInt(firstElement);
            second = Integer.parseInt(secondElement);
            if ((first > 0)&&(first < 11)&&(second > 0)&&(second < 11)) {
                return Integer.toString((int)Math.ceil((double)first / second));
            }
            System.out.println(" один из элементов < 0 или > 10");
            throw new IllegalArgumentException();
        }
        catch(IllegalArgumentException e){

            // несумев получить арабские числа, пробуем получить римские и разделить их
            return arabicToRoman((int)Math.ceil((double)romanToArabic(firstElement) / romanToArabic(secondElement)));
        }
    }

    private String add(String firstElement,String secondElement)throws IllegalArgumentException  {
        int first;
        int second;

        try {
            // пробуем получить арабские цифры и сложить их
            first = Integer.parseInt(firstElement);
            second = Integer.parseInt(secondElement);
            if ((first > 0)&&(first < 11)&&(second > 0)&&(second < 11)) {
                return Integer.toString( first + second );
            }
            System.out.println(" один из элементов < 0 или > 10");
            throw new IllegalArgumentException();
        }
        catch(IllegalArgumentException e){

            // несумев получить арабские числа, пробуем получить римские и сложить их
            return arabicToRoman(romanToArabic(firstElement) + romanToArabic(secondElement));

        }
    }

    private String sub(String firstElement,String secondElement)throws IllegalArgumentException  {
        int first;
        int second;

        try {
            // пробуем получить арабские цифры и вычесть их
            first = Integer.parseInt(firstElement);
            second = Integer.parseInt(secondElement);
            if ((first > 0)&&(first < 11)&&(second > 0)&&(second < 11)) {
                return Integer.toString( first - second );
            }
            System.out.println(" один из элементов < 0 или > 10");
            throw new IllegalArgumentException();
        }
        catch(IllegalArgumentException e){

            // несумев получить арабские числа, пробуем получить римские и вычесть их
            return arabicToRoman(romanToArabic(firstElement) - romanToArabic(secondElement));

        }
    }
}
