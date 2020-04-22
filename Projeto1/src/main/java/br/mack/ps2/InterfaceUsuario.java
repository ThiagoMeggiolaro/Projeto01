package br.mack.ps2;

import br.mack.ps2.Entidades.Produto;
import br.mack.ps2.Persistencias.ProdutoDAO;
import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    ProdutoDAO dao;
    Scanner in;

    public InterfaceUsuario(ProdutoDAO dao) {
        this.dao = dao;
        this.in = new Scanner(System.in);

    }

    public void iniciar(){
        imprimirMenu();
    }

    public void imprimirMenu() {
        int opcao;
        do {
            System.out.println("\n==============");
            System.out.println("==== Menu ====");
            System.out.println("==============");
            System.out.println("\t1. Create");
            System.out.println("\t2. Read");
            System.out.println("\t3. Update");
            System.out.println("\t4. Delete");
            System.out.println("\t5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = in.nextInt();


            in.nextLine();


            switch (opcao) {
                case 1:
                    this.create();
                    break;
                case 2:
                    this.read();
                    break;
                case 3:
                    this.update();
                    break;
                case 4:
                    this.delete();
                    break;
                case 5:
                    System.out.println("tchau :)");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        } while (opcao != 5);
    }

    private void create() {
        Produto Produtos = new Produto();

        System.out.println("\nInforme a descrição do produto: ");
        Produtos.setDescricao(in.nextLine());
        System.out.println("\nInforme a marca do produto: ");
        Produtos.setMarca(in.nextLine());
        System.out.println("\nInforme o preço do produto:");
        Produtos.setPreco(in.nextDouble());

        in.nextLine();

        if (dao.create(Produtos)) {
            System.out.println("Dados adicionados");
        }
        else {
            System.out.println("Ops: problema ao adicionar os dados");
        }
    }

    private void read() {
        List<Produto> Produtos = dao.read();

        for (Produto produtos : Produtos) {
            System.out.println(produtos);
        }
    }
    private void update() {
        Produto controle = new Produto();
        System.out.println("**** Atualizar um produto****");
        System.out.println("Insira o código do produto que deseja alterar: ");
        controle.setId(in.nextInt());
        System.out.println("Altere a descrição do produto: ");
        controle.setDescricao(in.nextLine());
        System.out.println("Altere a marca do produto: ");
        controle.setMarca(in.nextLine());
        System.out.println("Altere o preço do produto: ");
        controle.setPreco(in.nextDouble());

        System.out.println("Produto alterado com sucesso");
    }

    private void delete() {
        List<Produto> produtos = dao.read();
        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Produtos Cadastrados ***");
            System.out.println("***********************************");
            int i = 1;
            for (Produto produto : produtos) {
                System.out.println(i + " - " + produto);
                i++;
            }
            System.out.println(i + " - Cancelar operação");
            System.out.print("Qual produto deseja remover? ");
            int opc = in.nextInt();
            in.nextLine();
            if (opc == i) {
                break;
            }
            if (opc >= produtos.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao.delete(produtos.get(opc))) {
                    System.out.println("Produto removido com sucesso");
                } else {
                    System.out.println("OPS: falha ao tentar remover");
                }
                break;
            }
        }
    }
}


