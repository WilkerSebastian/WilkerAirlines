package controller;

import java.io.IOException;
import java.util.List;

import application.Main;
import model.CompanhiaAerea;
import view.CompanhiaAereaView;

public class CompanhiaAereaController {
    
    public static void show() throws IOException, InterruptedException {

        int op = CompanhiaAereaView.menu();

        Main.clear();

        switch (op) {
            case 1:
                
                salvar(CompanhiaAereaView.cadastrar());

                break;
            case 2:
                
                atualizar(CompanhiaAereaView.cadastrar());

                break;
            case 3:

                remover(CompanhiaAereaView.remover());
                
                break;
            case 4:

                CompanhiaAereaView.listar();
                
                break;
            case 0:
                return;
            default:
                System.out.println("Opção invalida");
                break;
        }

        show();

    }

    public static void salvar(CompanhiaAerea companhia) {

        List<CompanhiaAerea> semelhantes = Main.companhias.stream().filter(cp -> cp.getCodCompan().equals(companhia.getCodCompan())).toList();

        if (semelhantes.size() > 0) {
            
            System.out.println("Não é permitido um companhia ter mesmo código");
            return;

        }       

        Main.companhias.add(companhia);

    }

    public static void atualizar(CompanhiaAerea companhia) {

        List<CompanhiaAerea> semelhantes = Main.companhias.stream().filter(cp -> cp.getCodCompan().equals(companhia.getCodCompan())).toList();

        if (semelhantes.size() == 0) {
            
            System.out.println("Não foi encontrado código deste companhia");
            return;

        }       

        int index = Main.companhias.indexOf(semelhantes.get(0));

        Main.companhias.set(index, companhia);

    }

    public static void remover(String codCompan) {

        List<CompanhiaAerea> semelhantes = Main.companhias.stream().filter(cp -> cp.getCodCompan().equals(codCompan)).toList();

        if (semelhantes.size() == 0) {
            
            System.out.println("Não foi encontrado código deste companhia");
            return;

        }       

        int index = Main.companhias.indexOf(semelhantes.get(0));

        Main.companhias.remove(index);

    }

    public static CompanhiaAerea buscar(String codCompan) {

        for (CompanhiaAerea cp : Main.companhias) {

            if (cp.getCodCompan().equals(codCompan)) {
                
                return cp;

            }
            
        }

        return null;

    }

}
