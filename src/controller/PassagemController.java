package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import model.Passagem;
import view.PassagemView;

public class PassagemController {
    
    public static void show() throws IOException, InterruptedException {

        int op = PassagemView.menu();

        Main.clear();

        switch (op) {
            case 1:
                
                salvar(PassagemView.cadastrar());

                break;
            case 2:
                
                atualizar(PassagemView.cadastrar());

                break;
            case 3:

                remover(PassagemView.remover());
                
                break;
            case 4:

                PassagemView.listar();
                
                break;
            case 0:
                return;
            default:
                System.out.println("Opção invalida");
                break;
        }

        show();

    }

    public static void salvar(Passagem passagem) {

        List<Passagem> semelhantes = Main.passagens.stream().filter(ps -> ps.getNumero().equals(passagem.getNumero())).toList();

        if (semelhantes.size() > 0) {
            
            System.out.println("Não é permitido uma passagem ter mesmo número");
            return;

        }       

        if (passagem.verificarCapacidade()) {
            
            Main.passagens.add(passagem);

        }

    }

    public static void atualizar(Passagem passagem) {

        List<Passagem> semelhantes = Main.passagens.stream().filter(ps -> ps.getNumero().equals(passagem.getNumero())).toList();

        if (semelhantes.size() == 0) {
            
            System.out.println("Não foi encontrado número desta passagem");
            return;

        }       

        int index = Main.passagens.indexOf(semelhantes.get(0));

        Main.passagens.set(index, passagem);

    }

    public static void remover(String numPassagem) {

        List<Passagem> semelhantes = Main.passagens.stream().filter(ps -> ps.getNumero().equals(numPassagem)).toList();

        if (semelhantes.size() == 0) {
            
            System.out.println("Não foi encontrado número desta passagem");
            return;

        }       

        int index = Main.passagens.indexOf(semelhantes.get(0));

        Main.passagens.remove(index);

    }

    public static Passagem buscar(String numPassagem) {

        for (Passagem pa : Main.passagens) {

            if (pa.getNumero().equals(numPassagem)) {
                
                return pa;

            }
            
        }

        return null;

    }

     public static List<Passagem> buscarTodos(String numsPassagem) {

        List<Passagem> passagens = new ArrayList<>();

        // regex para separar somente os valores entre as virgulas
        String [] numeros =  numsPassagem.split(",\\s*");

        for (String num : numeros) {

            Passagem pa =  buscar(num);

            if (pa == null) {
                
                System.out.println("AVISO: número de passporte " + num + ", não encontrado mas o processo continua!");

            } else {

                passagens.add(pa);

            }
            
        }

        return passagens;

    }

}
