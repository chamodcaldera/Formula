

import java.util.Random;

class Test {

        static Random randomGenerator = new Random();
        static String operators = "+-*/";
        static int opeatorStringLength = operators.length();



        public static char getRandomOperator() {
            return operators.charAt(randomGenerator.nextInt(opeatorStringLength));
        }



    public static int getRandomNumber() {

            Random ranNum=new Random();
            return 1+ranNum.nextInt(20);
        }

        public static String appendToEquation(String equation, String value1, String value2) {
            String temp = equation;
            temp += value1;
            temp += value2;
            return temp;
        }

        public static String createEquation(int numOfOperators) {
            String equation = "";
            char operator;
            int operand;
            int openParenCounter = 0;
            for (int i = 0; i < numOfOperators; i++) {
                operator = getRandomOperator();
                operand = getRandomNumber();
                if (operator == ' ') {
                    openParenCounter++;
                    equation = appendToEquation(equation, Character.toString(operator), Integer.toString(operand));
                } else if (operator == ' ') {
                    if (openParenCounter == 0) { //Can't start off with a close parenthesis
                        openParenCounter++;
                        equation = appendToEquation(equation, "(", Integer.toString(operand));
                    } else {
                        openParenCounter--;
                        equation = appendToEquation(equation, Integer.toString(operand), Character.toString(operator));
                    }
                } else {
                    equation = appendToEquation(equation, Integer.toString(operand), Character.toString(operator));
                }
            }
            equation += getRandomNumber();
//            while (openParenCounter > 0) {
//                equation += ")";
//                openParenCounter--;
//            }

            return equation;
        }

        public static void main(String[] args) {


            String equation1;
            String equation2;
            Random randit= new Random();
            int anser=randit.nextInt(3);
            equation1 = createEquation(anser); //The argument passed is the number of operators to use
            System.out.println(equation1);

            equation2 = createEquation(anser); //The argument passed is the number of operators to use
            System.out.println(equation2);



//            equation = createEquation(3);
//            System.out.println(equation);
        }
    }

