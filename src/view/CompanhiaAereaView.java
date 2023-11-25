package view;

import application.Main;
import model.CompanhiaAerea;

public class CompanhiaAereaView {
    
    public static int menu() {

        int op;

        try {

            System.out.print(
            "------- Companhia Aerea -------\n" +
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

    public static CompanhiaAerea cadastrar() {

        String cod, nomeCompan;

        try {

            System.out.print("Código da companhia aerea: ");
            cod = Main.in.nextLine();

            System.out.print("Nome da companhia aerea: ");
            nomeCompan = Main.in.nextLine();

        } catch (Exception e) {
            
            return cadastrar();

        }

        return new CompanhiaAerea(cod, nomeCompan);

    }

    public static String remover() {

        String cod;

        try {

            System.out.print("Código da companhia aerea que deseja remover: ");
            cod = Main.in.nextLine();

        } catch (Exception e) {
            
            return remover();

        }

        return cod;

    }

    public static void listar() {

        System.out.println("------- Companhias ------\n");

        for (CompanhiaAerea ap : Main.companhias) {

            System.out.println(ap);
            
        }

        System.out.println();

    }

}
