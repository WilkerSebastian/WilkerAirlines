package controller;

import java.io.IOException;
import java.util.List;

import application.Main;
import model.Bilhete;
import view.BilheteView;

public class BilheteController {
    
    public static void show() throws IOException, InterruptedException {

        int op = BilheteView.menu();

        Main.clear();

        switch (op) {
            case 1:
                
                salvar(BilheteView.cadastrar());

                break;
            case 2:
                
                atualizar(BilheteView.cadastrar());

                break;
            case 3:

                remover(BilheteView.remover());
                
                break;
            case 4:

                BilheteView.listar();
                
                break;
            case 0:
                return;
            default:
                System.out.println("Opção invalida");
                break;
        }

        show();

    }

    public static void salvar(Bilhete<String> bilhete) {

        List<Bilhete<String>> semelhantes = Main.bilhetes.stream().filter(b -> b.getNumBilhete().equals(bilhete.getNumBilhete())).toList();

        if (semelhantes.size() > 0) {
            
            System.out.println("Não é permitido um bilhete ter mesmo número");
            return;

        }       

        Main.bilhetes.add(bilhete);

    }

    public static void atualizar(Bilhete<String> bilhete) {

        List<Bilhete<String>> semelhantes = Main.bilhetes.stream().filter(b -> b.getNumBilhete().equals(bilhete.getNumBilhete())).toList();

        if (semelhantes.size() == 0) {
            
            System.out.println("Não foi encontrado número deste bilhete");
            return;

        }       

        int index = Main.bilhetes.indexOf(semelhantes.get(0));

        Main.bilhetes.set(index, bilhete);

    }

    public static void remover(String numVoo) {

        List<Bilhete<String>> semelhantes = Main.bilhetes.stream().filter(b -> b.getNumBilhete().equals(numVoo)).toList();

        if (semelhantes.size() == 0) {
            
            System.out.println("Não foi encontrado número deste bilhete");
            return;

        }       

        int index = Main.bilhetes.indexOf(semelhantes.get(0));

        Main.bilhetes.remove(index);

    }

}
