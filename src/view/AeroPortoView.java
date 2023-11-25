package view;

import model.Aeroporto;
import model.Endereco;
import application.Main;

public class AeroPortoView {

    public static int menu() {

        int op;

        try {

            System.out.print(
            "------- Aeroporto -------\n" +
            "1) Cadastrar\n" +
            "2) Atualizar\n" +
            "3) Remover\n" +
            "4) Listar\n" +
            "0) Voltar\n" +
            "-------------------------------\n" +
            "\nOpção: ");

            op = Integer.parseInt(Main.in.nextLine());
            
        } catch (Exception e) {
            
            System.out.println("Opção invalida");
            return menu();

        }

        return op;

    }

    public static Aeroporto cadastrar() {

        String cod;
        Endereco endereco;

        try {

            System.out.print("Código do aeroporto: ");
            cod = Main.in.nextLine();

            endereco = EnderecoView.cadastrar();

        } catch (Exception e) {
            
            return cadastrar();

        }

        return new Aeroporto(cod, endereco);

    }

    public static String remover() {

        String cod;

        try {

            System.out.print("Código do aeroporto que deseja remover: ");
            cod = Main.in.nextLine();

        } catch (Exception e) {
            
            return remover();

        }

        return cod;

    }

    public static void listar() {

        System.out.println("------- Aeroportos ------\n");

        for (Aeroporto ap : Main.aeroPortos) {

            System.out.println(ap);
            
        }

        System.out.println();

    }

}
