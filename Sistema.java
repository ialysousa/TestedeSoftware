public class Sistema implements FuncionalidadesIF {

  private float resultadoAtual = 0;

  public Usuario cadastraUsuario(String nome, String email, String senha){return null;}

  public Raizes calculaFuncaoSegundoGrau(double a, double b, double c){return null;}

  public boolean ehTriangulo(double angulo1, double angulo2, double angulo3){return false;}

  public boolean ehTrianguloRetangulo(double lado1, double lado2, double lado3){return false;}

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

  public String classificaTriangulo(double angulo1, double angulo2, double angulo3) {return null;}

  public double perimetroRetangulo(double lado1, double lado2){
    double perimetro = lado1 + lado2; //+ lado3 + lado4;
    return perimetro;
  }

  public double areaRetangulo(double lado1, double lado2){return 0;}

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

  public double areaCirculo(double raio){return 0;}

  public double perimetroCirculo(double raio){return 0;}

  public double distanciaEntreDoisPontos(double x1, double y1, double x2, double y2){return 0;}
  
}