package view;

import java.io.IOException;

import application.Main;
import controller.PassageiroController;
import controller.VooController;
import model.Passageiro;
import model.Passagem;
import model.Voo;

public class PassagemView {
    
    public static int menu() {

        int op;

        try {

            System.out.print(
            "---------- Passagem ---------\n" +
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

    public static Passagem cadastrar() {

        String assento, numero;
        Passageiro passageiro;
        Voo ida, volta;

        try {

            System.out.print("Número: ");
            numero = Main.in.nextLine();

            System.out.print("Voo ida(Número do voo): ");
            ida = VooController.buscar(Main.in.nextLine());

            if (ida == null) {
                
                System.out.println("Voo de ida não encontrado");
                throw new IOException();

            }

            System.out.print("Voo volta(Número do voo): ");
            volta = VooController.buscar(Main.in.nextLine());

            if (volta == null) {
                
                System.out.println("Voo de volta não encontrado, deseja refazer(1-sim/0-não): ");
                int refazer = Integer.parseInt(Main.in.nextLine());

                if (refazer == 1) {
                 
                    throw new IOException();

                }

            }

            if (volta.equals(ida)) {
                
                System.out.println("Os voos de ida e volta não podem ser mesmo");
                throw new IOException();

            }

            System.out.print("Passageiro(Número do passaporte): ");
            passageiro = PassageiroController.buscar(Main.in.nextLine());

            if (passageiro == null) {
                
                System.out.println("Passageiro não encontrado");
                throw new IOException();

            }

            System.out.print("Assento: ");
            assento = Main.in.nextLine();


        } catch (Exception e) {
            
            return cadastrar();

        }

        return new Passagem(numero, ida, passageiro, assento);

    }

    public static String remover() {

        String num;

        try {

            System.out.print("Número da passagem que deseja remover: ");
            num = Main.in.nextLine();

        } catch (Exception e) {
            
            return remover();

        }

        return num;

    }

    public static void listar() {

        System.out.println("------ Passagens ------\n");

        for (Passagem pa : Main.passagens) {

            System.out.println(pa);
            
        }

        System.out.println();

    }

}
