package controller;

import java.io.IOException;
import java.util.List;

import application.Main;
import model.Aeroporto;
import view.AeroPortoView;

public class AeroPortoController {

    public static void show() throws IOException, InterruptedException {

        int op = AeroPortoView.menu();

        Main.clear();

        switch (op) {
            case 1:
                
                salvar(AeroPortoView.cadastrar());

                break;
            case 2:
                
                atualizar(AeroPortoView.cadastrar());

                break;
            case 3:

                remover(AeroPortoView.remover());
                
                break;
            case 4:

                AeroPortoView.listar();
                
                break;
            case 0:
                return;
            default:
                System.out.println("Opção invalida");
                break;
        }

        show();

    }

    public static void salvar(Aeroporto aeroporto) {

        List<Aeroporto> semelhantes = Main.aeroPortos.stream().filter(ap -> ap.getCodAeroporto().equals(aeroporto.getCodAeroporto())).toList();

        if (semelhantes.size() > 0) {
            
            System.out.println("Não é permitido um aeroporto ter mesmo código");
            return;

        }       

        Main.aeroPortos.add(aeroporto);

    }

    public static void atualizar(Aeroporto aeroporto) {

        List<Aeroporto> semelhantes = Main.aeroPortos.stream().filter(ap -> ap.getCodAeroporto().equals(aeroporto.getCodAeroporto())).toList();

        if (semelhantes.size() == 0) {
            
            System.out.println("Não foi encontrado código deste aeroporto");
            return;

        }       

        int index = Main.aeroPortos.indexOf(semelhantes.get(0));

        Main.aeroPortos.set(index, aeroporto);

    }

    public static void remover(String codAeroporto) {

        List<Aeroporto> semelhantes = Main.aeroPortos.stream().filter(ap -> ap.getCodAeroporto().equals(codAeroporto)).toList();

        if (semelhantes.size() == 0) {
            
            System.out.println("Não foi encontrado código deste aeroporto");
            return;

        }       

        int index = Main.aeroPortos.indexOf(semelhantes.get(0));

        Main.aeroPortos.remove(index);

    }

    public static Aeroporto buscar(String codAeroporto) {

        for (Aeroporto ap : Main.aeroPortos) {

            if (ap.getCodAeroporto().equals(codAeroporto)) {
                
                return ap;

            }
            
        }

        return null;

    }

}