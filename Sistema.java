import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.RootPaneContainer;

public class Sistema implements FuncionalidadesIF {

  private float resultadoAtual = 0;
  Usuario usuario;
  Main main;
  List<Usuario> arrayUsuarios = new ArrayList<Usuario>();
  Menu menu = new Menu();


  public Usuario cadastraUsuario(String nome, String email, String senha){

    usuario = new Usuario(nome, email, senha);
    arrayUsuarios.add(usuario);

    return usuario;
  
  }

  public Raizes calculaFuncaoSegundoGrau(double a, double b, double c) {
        double dis = b * b - 4.0 * a * c;  
        if(a < 0 || dis < 0.0) {
          return null;
        }
          
        if (dis> 0.0){  
            double x1 = (-b + Math.pow(dis, 0.5)) / (2.0 * a);  
            double x2 = (-b - Math.pow(dis, 0.5)) / (2.0 * a);  
            //System.out.println("As raizes são " + x1 + " and " + x2);  
            return new Raizes(x1,x2); 
        }else if (dis == 0.0){  
            double x1 = -b / (2.0 * a);  
            //System.out.println("Raiz eh " + x1);
            return new Raizes(x1,x1);
        }   
        else {
          return null;  //aqui não tem raizes reais.
        }   
    

    } 
  
  public boolean ehTriangulo(double angulo1, double angulo2, double angulo3){
      if(angulo1 <= 0 || angulo2 <= 0 || angulo3 <= 0) return false;
      else if(angulo1 > 180 || angulo2 > 180 || angulo3 > 180) return false;
      else if(angulo1 + angulo2 >= 180 || angulo1 + angulo3 >= 180 || angulo2 + angulo3 >= 180 || angulo1 + angulo2 + angulo3 > 180) return false;
      else if (angulo1 + angulo2 + angulo3 == 180 && angulo1 != 0 && angulo2 != 0 && angulo3 != 0)
          return true;
      else
          return false;
      }

  public boolean ehTrianguloRetangulo(double lado1, double lado2, double lado3){
      boolean isTrue = false;
      if((lado1+lado2+lado3 > 180) || lado1 <= 0 || lado2 <= 0 || lado3 <= 0 || (lado1+lado2+lado3 < 0 )){
          isTrue= false;
      }
      else{
          // retângulo
          if(lado1+lado2+lado3 == 180){ 
              //soma dos 3 ângulos tem que ser igual a 180
              if(lado1 == 90 && lado2+lado3 == 90){
                  System.out.println("É um triangulo retângulo");
                  isTrue= true;
              }
              else if(lado2 == 90 && lado1+lado3 == 90) {
                  System.out.println("É um triangulo retângulo");
                  isTrue= true;
              }
              else if(lado3 == 90 && lado1+lado2 == 90){
                  System.out.println("É um triangulo retângulo");
                  isTrue= true;
              }
          }
          // acutângulo
          else if(lado1 < 90 && lado2 < 90 && lado3 < 90){
              System.out.println("É um triangulo acutângulo");    
              isTrue= true;
          }

          //obtusângulo
          else if(lado1+lado2+lado3 <= 180){
              if(lado1 > 90 && lado2 + lado3 < 90){
                  System.out.println("É um triangulo obtusângulo");    
                  isTrue= true;
              }
              else if(lado2 > 90 && lado1 + lado3 < 90){
                  System.out.println("É um triangulo obtusângulo"); 
                  isTrue= true;
              }
              else if(lado3 > 90 && lado2 + lado1 < 90){
                  System.out.println("É um triangulo obtusângulo");     
                  isTrue= true;
              }
          }
          
      }
      return isTrue;
  }

  public boolean ehRetangulo(double angulo1, double angulo2, double angulo3, double angulo4){
    if ((angulo1 == angulo2 && angulo1 == angulo3 && angulo1 == angulo4) && (angulo1 != 0)) {
      return true;
    }
    if ((angulo1 == angulo2 && angulo3 == angulo4) || (angulo1 == angulo3 && angulo2 == angulo4) || (angulo1 == angulo4 && angulo2 == angulo3)) {
      if (angulo1 != 0 && angulo2 != 0 && angulo3 != 0 && angulo4 != 0) {
        return true;
      }
    }
    return false;
  }

  public String classificaTriangulo(double angulo1, double angulo2, double angulo3) {
      // triangulo retângulo
      double hipotenusa = 0;
      if(angulo1 + angulo2 + angulo3 < 0 || angulo1 + angulo2 + angulo3  > 180 || angulo1 < 0 || angulo2 < 0 || angulo3 < 0){
          return "Não é um retângulo";
      }else{
          if(angulo1 > angulo2 && angulo1 > angulo3){
              hipotenusa = angulo1;
              if(hipotenusa*hipotenusa ==  (angulo2*angulo2+angulo3*angulo3)){
                  return "é um triângulo retângulo";
              }
          }
          if( angulo2 > angulo1 && angulo2 > angulo3){
              hipotenusa = angulo2;
              if(hipotenusa *hipotenusa ==  (angulo1*angulo1 + angulo3*angulo3)){
                  return "é um triângulo retângulo";
              }
          }
          if( angulo3 > angulo1 && angulo3 > angulo2){
              hipotenusa = angulo3;
              if(hipotenusa *hipotenusa ==  (angulo1*angulo1 + angulo2*angulo2)){
                  return "é um triângulo retângulo";
              }
          } 
          return "Não é um triângulo retângulo";
      }
  }
  
  public double perimetroRetangulo(double lado1, double lado2){
    double perimetro = lado1 + lado2; //+ lado3 + lado4;
    return perimetro;
  }

  public double areaRetangulo(double lado1, double lado2){
    
    double area = lado1 * lado2;
    return area;
  }

  public double calculadora(String expressao){

      String[] tokens = expressao.split(" ");
      if (tokens.length == 3) {
        float op1 = Float.parseFloat(tokens[0]);
        float op2 = Float.parseFloat(tokens[2]);
        this.executaOperacao(op1, op2, tokens[1]);
      } else {
        System.out.println("Expressão não reconhecida");
      }

      return resultadoAtual;

  }

  private void executaOperacao(float op1, float op2, String op) {
    switch (op) {
      case "+":
        this.resultadoAtual = op1 + op2;
        break;
      case "-":
        this.resultadoAtual = op1 - op2;
        break;
      case "*":
        this.resultadoAtual = op1 * op2;
        break;
      case "/":
        this.resultadoAtual = op1 / op2;
        break;
      case "**":
        this.resultadoAtual = (float) Math.pow(op1, (int)op2);
        break;
    }
  }

  public double areaCirculo(double raio){
      double pi = 3.14;
      double area = 0;

      if(raio <= 0) return 0;
      else area=pi*(Math.pow(raio,2));

      return area;
  }

  public double perimetroCirculo(double raio){
      double pi = 3.14;
      double perimetro;
      
      if(raio <= 0) return 0;
      else perimetro=2*pi*raio;
      
      return perimetro;
  }

  public double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2){
        double ans = 0;
        double sum = 0;
        if(x1 <= 0 && x2 <= 0 && y1 <= 0 && y2 <= 0) return 0;
        else{
            sum = Math.pow(x1 - x2,2) + Math.pow(y2 - y1,2); 
            ans = Math.sqrt(sum);
        }
        return ans;
    }
}
  
