import java.util.Scanner;

public class Menu {

    Sistema sistema = new Sistema();
    public void menu(){
        System.out.println("\tMenu:");
        System.out.println("0. Encerrar");
        System.out.println("1. Calcular raizes de uma função de segundo grau.");
        System.out.println("2. Verificar se 3 valores formam um triângulo.");
        System.out.println("3. Classificar o triangulo de acordo com os valores recebidos");
        System.out.println("4. Verificar se é triângulo retângulo");
        System.out.println("5. Verificar se os valores representam um retângulo");
        System.out.println("6. Calcular área do retângulo");
        System.out.println("7. Calcular perímetro do retângulo");
        System.out.println("8. Calculadora");
        System.out.println("9. Calcular área do circulo");
        System.out.println("10. Calcular perímetro do circulo");
        System.out.println("11. Calcular distância entre dois pontos");
        System.out.println("Opcao:");

        int opcao;
        double valor1 = 0, valor2 = 0, valor3 = 0, valor4 = 0;
        String expressao = null;

        Scanner entrada = new Scanner(System.in);

        do{
            menu();
            opcao = entrada.nextInt();
            Scanner valores = new Scanner(System.in);

            if((opcao == 1) || (opcao == 2) || (opcao == 3) || (opcao == 5)){

                System.out.println("Por favor informe o primeiro valor:");
                valor1 = valores.nextDouble();
                System.out.println("Por favor informe o segundo valor:");
                valor2 = valores.nextDouble();
                System.out.println("Por favor informe o terceiro valor:");
                valor3 = valores.nextDouble();

            } else if ((opcao == 4) || (opcao == 11)) {

                System.out.println("Por favor informe o primeiro valor:");
                valor1 = valores.nextDouble();
                System.out.println("Por favor informe o segundo valor:");
                valor2 = valores.nextDouble();
                System.out.println("Por favor informe o terceiro valor:");
                valor3 = valores.nextDouble();
                System.out.println("Por favor informe o quarto valor:");
                valor4 = valores.nextDouble();

            } else if ((opcao == 6) || (opcao == 7)) {

                System.out.println("Por favor informe o primeiro valor:");
                valor1 = valores.nextDouble();
                System.out.println("Por favor informe o segundo valor:");
                valor2 = valores.nextDouble();

            } else if ( (opcao == 9) || (opcao == 10)) {
                System.out.println("Por favor informe o valor:");
                valor1 = valores.nextDouble();
            } else{

                System.out.println("Por favor informe a expressao:");
                expressao = valores.nextLine();

            }

            switch(opcao){
                case 1:

                    sistema.calculaFuncaoSegundoGrau(valor1, valor2, valor3);
                    break;

                case 2:

                    sistema.ehTriangulo(valor1, valor2, valor3);
                    break;

                case 3:

                    sistema.ehTrianguloRetangulo(valor1, valor2, valor3);
                    break;

                case 4:
                    sistema.ehRetangulo(valor1, valor2,valor3,valor4);
                    break;

                case 5:
                    sistema.classificaTriangulo(valor1, valor2, valor3);
                    break;

                case 6:
                    sistema.perimetroRetangulo(valor1, valor2);
                    break;

                case 7:
                    sistema.areaRetangulo(valor1, valor2);
                    break;

                case 8:
                    sistema.calculadora(expressao);
                    break;

                case 9:
                    sistema.areaCirculo(valor1);
                    break;

                case 10:
                    sistema.perimetroCirculo(valor1);
                    break;

                case 11:
                    sistema.distanciaEntreDoisPontos(valor1, valor2, valor3, valor4);
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while(opcao != 0);

    }
}