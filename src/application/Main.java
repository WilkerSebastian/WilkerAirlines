package application;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import controller.AeroPortoController;
import controller.BilheteController;
import controller.CompanhiaAereaController;
import controller.PassageiroController;
import controller.PassagemController;
import controller.VooController;
import model.Aeroporto;
import model.Bilhete;
import model.CompanhiaAerea;
import model.Endereco;
import model.Passageiro;
import model.Passagem;
import model.Voo;

public class Main {

    public static Scanner in;

    // Arrays para salvar os dados da aplicação
    public static ArrayList<Aeroporto> aeroPortos = new ArrayList<>();
    public static ArrayList<CompanhiaAerea> companhias = new ArrayList<>();
    public static ArrayList<Voo> voos = new ArrayList<>();
    public static ArrayList<Bilhete<String>> bilhetes = new ArrayList<>();
    public static ArrayList<Passageiro> passageiros = new ArrayList<>();
    public static ArrayList<Passagem> passagens = new ArrayList<>();
    
    public static void main(String[] args) throws IOException, InterruptedException {

        /* AVISOS 

            Tentei seguir o padrão MVC, então nesse no package Model vão estar as classes modelo do PDF.
            No View vão estar as "interfaces", menus, entrada e saída para refenrete classes modelo. No controller
            vai está lógica que redireciona a interface referente a entrada do usuario e manipulaa os arrays de data.
        
            nas classes controller uso essa expressão:

            onde nela pego um array uso método de stream para ter acesso aos métodos como o filter,
            para assim eu possa usar lambda para pecorrer o array e pegar os elementos com mesma "chaves primarias" 
            assim facilitando minha verificição de elementos repetido.

            Main.aeroPortos.stream().filter(ap -> ap.getCodAeroporto().equals(aeroporto.getCodAeroporto())).toList()

        */

        // pré cadastrados para fins de teste
        AeroPortoController.salvar(new Aeroporto("GRJ", new Endereco("Rio janeiro")));
        AeroPortoController.salvar(new Aeroporto("VSP", new Endereco("Campinas")));

        CompanhiaAereaController.salvar(new CompanhiaAerea("2FC", "Azul"));

        VooController.salvar(new Voo("23", AeroPortoController.buscar("GRJ"), AeroPortoController.buscar("VSP"), Calendar.getInstance(), Calendar.getInstance(), 120));
        VooController.salvar(new Voo("45", AeroPortoController.buscar("CTSA"), AeroPortoController.buscar("HDE"), Calendar.getInstance(), Calendar.getInstance(), 80));

        PassageiroController.salvar(new Passageiro("wilker", "428.123.097-17", "36.553.351-8", new Endereco("Petrópolis"), "(24) 98809-6725", "21/05/1969", "2C"));
     
        PassagemController.salvar(new Passagem("34", VooController.buscar("23"), VooController.buscar("45"), PassageiroController.buscar("2C"), "4F"));

        in = new Scanner(System.in);

        int op;

        try {

            do {

                clear();

                op = menuInicial();

                clear();
                
                switch (op) {
                    case 1:
                        
                        AeroPortoController.show();

                        break;
                    case 2:

                        CompanhiaAereaController.show();
                        
                        break;
                    case 3:

                        VooController.show();
                        
                        break;
                    case 4:

                        PassageiroController.show();
                        
                        break;
                    case 5:

                        PassagemController.show();                        
                        
                        break;
                    case 6:

                        BilheteController.show();
                        
                        break;
                    case 0:
                        in.close();
                        return;
                    default:
                        System.out.println("Opção invalida");
                        break;
                }

            } while (op != 0);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            in.close();

        }

    }

    public static int menuInicial() {

        int op;

        try {

            System.out.print(
            "------- Wilker Airlines -------\n" +
            "1) Aeroporto\n" +
            "2) Companhia Area\n" +
            "3) Voo\n" +
            "4) Passageiro\n" +
            "5) Passagem\n" +
            "6) Bilhete\n" +
            "0) SAIR\n" +
            "-------------------------------\n" +
            "\nOpção: ");

            op = Integer.parseInt(in.nextLine());
            
        } catch (Exception e) {
            
            System.out.println("Opção invalida");
            return menuInicial();

        }

        return op;

    }

    // função para limpar o terminal
    public static void clear() throws IOException, InterruptedException {

        // se o sistema operacional for Windows vai ser cls o comando, senão clear
        String os = System.getProperty("os.name").toLowerCase();
        String command = (os.contains("win")) ? "cmd /c cls" : "clear";
    
        // executa o comando para limpar o terminal como um novo processo e redireciona para saída do atual
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.inheritIO();
    
        try {
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }    

}
