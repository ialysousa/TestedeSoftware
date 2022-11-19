import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem vindo ao sistema:");

        primeiroAcesso();

        cadastroCompleto();
    }

    public static void primeiroAcesso(){

        System.out.println("Selecione a opção desejada:");
        Scanner entrada = new Scanner(System.in);

        System.out.println("1. Realizar login");
        System.out.println("2. Realizar cadastro");

        int opcao;
        opcao = entrada.nextInt();
        switch (opcao){
            case 1:
                login();
                break;

            case 2:
                cadastroDeUsuario();
                break;
            default:
                System.out.println("Opção inválida.");

        }

    }

    public static String cadastroDeUsuario(){
        Scanner dados = new Scanner(System.in);

        System.out.println("Por favor informe o seu Nome:");
        String nome = dados.nextLine();

        cadastraEmail();

        return nome;
    }

    public static String cadastraEmail(){

        boolean verificaEmail = false;
        String email;

        do {
            Scanner in = new Scanner(System.in);

            System.out.println("Por favor informe o seu E-mail:");
            email = in.nextLine();

            verificaEmail = verificaEmail(email);


        } while (verificaEmail == false);

        cadastraSenha();

        return email;
    }

    public static String cadastraSenha(){

       boolean verificaSenha = false;
       String senha;

       System.out.println("A senha deve conter no mínimo 8 caracteres e 2 números, caractere especial, letras maiúsculas e minúsculas.");

        do {
            Scanner in = new Scanner(System.in);

            System.out.println("Por favor informe a sua Senha:");
            senha = in.nextLine();

            verificaSenha = verificaSenha(senha);

        } while (verificaSenha == false);

        System.out.println("Cadastro realizado com sucesso.");

        primeiroAcesso();

        return senha;

    }

    public static void cadastroCompleto(){

        Sistema sistema = new Sistema();
        sistema.cadastraUsuario(cadastroDeUsuario(), cadastraEmail(), cadastraSenha());
    }

    public static boolean verificaEmail(String email){
        boolean verificaEmail = false;

        verificaEmail = email.matches("\\S+@\\S+\\.\\S+");

        if(verificaEmail == false){
            System.out.println("O email informado está inválido");
        }

        return verificaEmail;
    }

    public static boolean verificaSenha(String senha){
        boolean verificaSenha = false;

        verificaSenha = senha.matches("^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$");

        if(verificaSenha == false){
            System.out.println("A senha informada está inválida");
        }

        return verificaSenha;

    }

    public static void login(){
        Scanner dados = new Scanner(System.in);

        boolean verificaEmail = false;
        boolean verificaSenha = false;
        String email, senha;

        do {

            System.out.println("Informe o seu email:");
            email = dados.nextLine();
            verificaEmail = verificaEmail(email);


        } while (verificaEmail == false);

        do {

            System.out.println("Informe a sua senha:");
            senha = dados.nextLine();
            verificaSenha = verificaSenha(senha);

        } while (verificaSenha == false);


        List<Usuario> arrayUsuarios = new ArrayList<Usuario>();
        Menu menu = new Menu();
        System.out.println("Cheguei aqui...");

        for (Usuario usuario : arrayUsuarios) {
            if(usuario.getEmail().equals(email)){
                if(usuario.getSenha().equals(senha)){
                    System.out.println("Login realizado com sucesso");
                    menu.menu();
                }
            }else{
                System.out.println("E-mail não encontrado, deseja realizar um cadastro ?");
                int opcao;
                Scanner entrada = new Scanner(System.in);

                System.out.println("1. Sim");
                System.out.println("2. Não");

                opcao = entrada.nextInt();
                switch (opcao){
                    case 1:
                        cadastroDeUsuario();
                        break;

                    case 2:
                        login();
                        break;
                    default:
                        System.out.println("Opção inválida.");

                }

            }

        }

    }

}
