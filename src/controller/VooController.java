package controller;

import java.io.IOException;
import java.util.List;

import application.Main;
import model.Voo;
import view.VooView;

public class VooController {

    public static void show() throws IOException, InterruptedException {

        int op = VooView.menu();

        Main.clear();

        switch (op) {
            case 1:
                
                salvar(VooView.cadastrar());

                break;
            case 2:
                
                atualizar(VooView.cadastrar());

                break;
            case 3:

                remover(VooView.remover());
                
                break;
            case 4:

                VooView.listar();
                
                break;
            case 0:
                return;
            default:
                System.out.println("Opção invalida");
                break;
        }

        show();

    }

    public static void salvar(Voo voo) {

        List<Voo> semelhantes = Main.voos.stream().filter(v -> v.getNumVoo().equals(voo.getNumVoo())).toList();

        if (semelhantes.size() > 0) {
            
            System.out.println("Não é permitido um voo ter mesmo número");
            return;

        }       

        Main.voos.add(voo);

    }

    public static void atualizar(Voo voo) {

        List<Voo> semelhantes = Main.voos.stream().filter(v -> v.getNumVoo().equals(voo.getNumVoo())).toList();

        if (semelhantes.size() == 0) {
            
            System.out.println("Não foi encontrado número deste voo");
            return;

        }       

        int index = Main.voos.indexOf(semelhantes.get(0));

        Main.voos.set(index, voo);

    }

    public static void remover(String numVoo) {

        List<Voo> semelhantes = Main.voos.stream().filter(v -> v.getNumVoo().equals(numVoo)).toList();

        if (semelhantes.size() == 0) {
            
            System.out.println("Não foi encontrado número deste voo");
            return;

        }       

        int index = Main.voos.indexOf(semelhantes.get(0));

        Main.voos.remove(index);

    } 

    public static Voo buscar(String numVoo) {

        for (Voo v : Main.voos) {

            if (v.getNumVoo().equals(numVoo)) {
                
                return v;

            }
            
        }

        return null;

    }

}
