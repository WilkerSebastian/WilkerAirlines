package view;

import java.io.IOException;
import java.util.List;

import application.Main;
import controller.CompanhiaAereaController;
import controller.PassagemController;
import model.Bilhete;
import model.CompanhiaAerea;
import model.Passagem;

public class BilheteView {
    
    public static int menu() {

        int op;

        try {

            System.out.print(
            "----------- Bilhete -----------\n" +
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

    public static Bilhete<String> cadastrar() {

        String numBilhete;
        List<Passagem> passagens;
        double preco;
        CompanhiaAerea comp;

        try {

            System.out.print("Número do bilhete: ");
            numBilhete = Main.in.nextLine();

            System.out.print("Informe o numéro das passagens deste bilhte(separados por virgula): ");
            passagens = PassagemController.buscarTodos(Main.in.nextLine());

            System.out.print("Preço: $");
            preco = Double.parseDouble(Main.in.nextLine());

            System.out.print("Companhia Aerea: ");
            comp = CompanhiaAereaController.buscar(Main.in.nextLine());

            if (comp == null) {
                
                System.out.println("Compahia Aerea não encontrado");
                throw new IOException();

            }


        } catch (Exception e) {
            
            return cadastrar();

        }

        return new Bilhete<String>(numBilhete, passagens, preco, comp);

    }

    public static String remover() {

        String num;

        try {

            System.out.print("Número do bilhete que deseja remover: ");
            num = Main.in.nextLine();

        } catch (Exception e) {
            
            return remover();

        }

        return num;

    }

    public static void listar() {

        System.out.println("----------- Bilhetes ---------\n");

        for (Bilhete<String> b : Main.bilhetes) {

            b.imprimirBilhete();
            
        }

        System.out.println();

    }

}
