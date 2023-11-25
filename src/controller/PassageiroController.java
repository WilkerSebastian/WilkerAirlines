package controller;

import java.io.IOException;
import java.util.List;

import application.Main;
import model.Passageiro;
import view.PassageiroView;

public class PassageiroController {
    
    public static void show() throws IOException, InterruptedException {

        int op = PassageiroView.menu();

        Main.clear();

        switch (op) {
            case 1:
                
                salvar(PassageiroView.cadastrar());

                break;
            case 2:
                
                atualizar(PassageiroView.cadastrar());

                break;
            case 3:

                remover(PassageiroView.remover());
                
                break;
            case 4:

                PassageiroView.listar();
                
                break;
            case 0:
                return;
            default:
                System.out.println("Opção invalida");
                break;
        }

        show();

    }

    public static void salvar(Passageiro passageiro) {

        List<Passageiro> semelhantes = Main.passageiros.stream().filter(ps -> ps.getNumPassaporte().equals(passageiro.getNumPassaporte())).toList();

        if (semelhantes.size() > 0) {
            
            System.out.println("Não é permitido um passageiro ter mesmo passaporte");
            return;

        }       

        Main.passageiros.add(passageiro);

    }

    public static void atualizar(Passageiro passageiro) {

        List<Passageiro> semelhantes = Main.passageiros.stream().filter(ps -> ps.getNumPassaporte().equals(passageiro.getNumPassaporte())).toList();

        if (semelhantes.size() == 0) {
            
            System.out.println("Não foi encontrado passaporte deste passageiro");
            return;

        }       

        int index = Main.passageiros.indexOf(semelhantes.get(0));

        Main.passageiros.set(index, passageiro);

    }

    public static void remover(String numVoo) {

        List<Passageiro> semelhantes = Main.passageiros.stream().filter(ps -> ps.getNumPassaporte().equals(numVoo)).toList();

        if (semelhantes.size() == 0) {
            
            System.out.println("Não foi encontrado passaporte deste passageiro");
            return;

        }       

        int index = Main.passageiros.indexOf(semelhantes.get(0));

        Main.passageiros.remove(index);

    }

    public static Passageiro buscar(String numPassaporte) {

        for (Passageiro ps : Main.passageiros) {

            if (ps.getNumPassaporte().equals(numPassaporte)) {
                
                return ps;

            }
            
        }

        return null;

    }
    
}
