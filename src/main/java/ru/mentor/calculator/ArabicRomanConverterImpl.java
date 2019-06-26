package ru.mentor.calculator;

public class ArabicRomanConverterImpl implements ArabicRomanConverter{


    @Override
    public int romanToArabic(String element){
        switch(element){
            case "I":  return 1;

            case "II":  return 2;

            case "III":  return 3;

            case "IV":  return 4;

            case "V":  return 5;

            case "VI":  return 6;

            case "VII":  return 7;

            case "VIII":  return 8;

            case "IX":  return 9;

            case "X":  return 10;

            default: throw new IllegalArgumentException("элемент нельзя перевести в арабские цифры");

        }
    }

    @Override
    public String arabicToRoman(int element){

        String result = "";

        if((element > 0)&&(element < 101)) {


            int tens = element / 10;

            switch (tens) {

                case 0:
                    result += "";
                    break;

                case 1:
                    result += "X";
                    break;

                case 2:
                    result +=  "XX";
                    break;
                case 3:
                    result +=  "XXX";
                    break;
                case 4:
                    result +=  "XL";
                    break;
                case 5:
                    result +=  "L";
                    break;
                case 6:
                    result +=  "LX";
                    break;
                case 7:
                    result +=  "LXX";
                    break;
                case 8:
                    result +=  "LXXX";
                    break;
                case 9:
                    result +=  "XC";
                    break;
                case 10:
                    result +=  "C";
                    break;
                default:
                    throw new IllegalArgumentException("элемент нельзя перевести в римское число");

            }

            int ones = element % 10;

            switch (ones) {

                case 0:
                    result += "";
                    break;
                case 1:
                    result += "I";
                    break;
                case 2:
                    result +=  "II";
                    break;
                case 3:
                    result +=  "III";
                    break;
                case 4:
                    result +=  "IV";
                    break;
                case 5:
                    result +=  "V";
                    break;
                case 6:
                    result +=  "VI";
                    break;
                case 7:
                    result +=  "VII";
                    break;
                case 8:
                    result +=  "VIII";
                    break;
                case 9:
                    result +=  "IX";
                    break;

                default:
                    throw new IllegalArgumentException("элемент нельзя перевести в римское число");

            }

            return result;
        }

        throw new IllegalArgumentException();
    }

}
