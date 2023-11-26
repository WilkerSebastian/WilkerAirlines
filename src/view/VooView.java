package view;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import application.Main;
import controller.AeroPortoController;
import model.Aeroporto;
import model.Voo;

public class VooView {
    
    public static int menu() {

        int op;

        try {

            System.out.print(
            "-------------- Voo ------------\n" +
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

    public static Voo cadastrar() {

        String numVoo, origem, destino;
        Calendar dataOrigem, dataDestiono;
        int capacidade;
        Aeroporto apOrigem, apDestino;

        try {

            System.out.print("Número do voo: ");
            numVoo = Main.in.nextLine();

            System.out.print("Aeroporto de origem(código do aeroporto): ");
            origem = Main.in.nextLine();

            apOrigem = AeroPortoController.buscar(origem);

            if (apOrigem == null) {
                
                System.out.println("Aeroporto de origem não encontrado");
                throw new IOException();

            }

            System.out.print("Aeroporto de destino(código do aeroporto): ");
            destino = Main.in.nextLine();

            apDestino = AeroPortoController.buscar(destino);

            if (apDestino == null) {
                
                System.out.println("Aeroporto de destino não encontrado");
                throw new IOException();

            }

            if (apDestino.equals(apOrigem)) {
                
                System.out.println("Aeroporto de destino e origem não podem ser mesmo");
                throw new IOException();

            }

            dataOrigem = dataInput("Data hora da origem(dd/MM/yyyy HH:mm:ss): ");

            dataDestiono = dataInput("Data hora do destino(dd/MM/yyyy HH:mm:ss): ");

            if (dataOrigem.compareTo(dataDestiono) >= 0) {
                
                System.out.println("Data de origem está depos ou ao mesmo tempo que data de destino");
                throw new IOException();

            }

            System.out.print("Capacidade do Voo: ");
            capacidade = Integer.parseInt(Main.in.nextLine());


        } catch (Exception e) {
            
            return cadastrar();

        }

        return new Voo(numVoo, apOrigem, apDestino, dataOrigem, dataDestiono, capacidade);

    }

    public static String remover() {

        String num;

        try {

            System.out.print("Número do voo que deseja remover: ");
            num = Main.in.nextLine();

        } catch (Exception e) {
            
            return remover();

        }

        return num;

    }

    public static void listar() {

        System.out.println("----------- Voos ---------\n");

        for (Voo v : Main.voos) {

            System.out.println(v);
            
        }

        System.out.println();

    }

    public static Calendar dataInput(String output) {

        Calendar data = Calendar.getInstance();

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            System.out.print(output);
            Date date = dateFormat.parse(Main.in.nextLine());

            data.setTime(date);
            
        } catch (ParseException e) {

            System.out.println("Informe um data em formato dd/MM/yyyy HH:mm:ss");
            return dataInput(output);

        }

        return data;

    }

}
