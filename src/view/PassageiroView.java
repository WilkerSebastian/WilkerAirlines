package view;

import application.Main;
import model.Endereco;
import model.Passageiro;

public class PassageiroView {
    
    public static int menu() {

        int op;

        try {

            System.out.print(
            "---------- Passageiro ---------\n" +
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

    public static Passageiro cadastrar() {

        String rg, nome, cpf, celular, dtNascim, numPassaporte;
        Endereco endereco;

        try {

            System.out.print("Nome: ");
            nome = Main.in.nextLine();

            System.out.print("RG: ");
            rg = Main.in.nextLine();

            System.out.print("CPF: ");
            cpf = Main.in.nextLine();

            endereco = EnderecoView.cadastrar();

            System.out.print("Celular: ");
            celular = Main.in.nextLine();

            System.out.print("Data Nascimento(dd/MM/yyyy): ");
            dtNascim = Main.in.nextLine();

            System.out.print("Número do Passaporte: ");
            numPassaporte = Main.in.nextLine();

        } catch (Exception e) {
            
            return cadastrar();

        }

        return new Passageiro(nome, cpf, rg, endereco, celular, dtNascim, numPassaporte);

    }

    public static String remover() {

        String numPass;

        try {

            System.out.print("Número do passaporte que deseja remover: ");
            numPass = Main.in.nextLine();

        } catch (Exception e) {
            
            return remover();

        }

        return numPass;

    }

    public static void listar() {

        System.out.println("------ Passageiros ------\n");

        for (Passageiro ps : Main.passageiros) {

            System.out.println(ps + " : Número Passaporte = " + ps.getNumPassaporte());
            
        }

        System.out.println();

    }

}
