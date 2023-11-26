package view;

import application.Main;
import model.Endereco;

public class EnderecoView {
    
    public static Endereco cadastrar() {

        System.out.print("Rua: ");
        String rua = Main.in.nextLine();

        System.out.print("Número: ");
        int num = Integer.parseInt(Main.in.nextLine());

        System.out.print("Bairro: ");
        String bairro = Main.in.nextLine();

        System.out.print("Cidade: ");
        String cidade = Main.in.nextLine();

        System.out.print("CEP: ");
        String CEP = Main.in.nextLine();

        return new Endereco(rua, num, bairro, cidade, CEP);

    }

}
