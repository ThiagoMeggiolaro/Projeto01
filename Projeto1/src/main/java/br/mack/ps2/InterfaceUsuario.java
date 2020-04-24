package br.mack.ps2;

import br.mack.ps2.Entidades.Produto;
import br.mack.ps2.Entidades.Carro;
import br.mack.ps2.Entidades.País;
import br.mack.ps2.Persistencias.CarroDAO;
import br.mack.ps2.Persistencias.ProdutoDAO;
import br.mack.ps2.Persistencias.PaísDAO;
import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    ProdutoDAO dao;
    CarroDAO dao2;
    PaísDAO dao3;
    Scanner in;

    public InterfaceUsuario(ProdutoDAO dao, CarroDAO dao2, PaísDAO dao3) {
        this.dao = dao;
        this.dao2= dao2;
        this.dao3 = dao3;
        this.in = new Scanner(System.in);

    }

    public void iniciar(){
        imprimirMenu();
    }

    public void imprimirMenu() {
        int opcao;
        do {
            System.out.println("\n");
            System.out.println("\t================= Menu ========================");
            System.out.println("\t===============================================");
            System.out.println("\t|  1. Criar novas colunas na tabela => Produto |");
            System.out.println("\t|  2. Criar novas colunas na tabela => Carro   |");
            System.out.println("\t|  3. Criar novas colunas na tabela => País    |\t");
            System.out.println("\t|  4. Ler tabela => Produto                    |");
            System.out.println("\t|  5. Ler tabela => Carro                      |");
            System.out.println("\t|  6. Ler tabela => País                       |");
            System.out.println("\t|  7. Update na tabela => Produto              |");
            System.out.println("\t|  8. Update na tabela => Carro                |");
            System.out.println("\t|  9. Update na tabela => País                 |");
            System.out.println("\t| 10. Delete na tabela => Produto              |");
            System.out.println("\t| 11. Delete na tabela => Carro                |");
            System.out.println("\t| 12. Delete na tabela => País                 |");
            System.out.println("\t| 13. Sair                                     |");
            System.out.println("\t===============================================");
            System.out.print("\tEscolha uma opção: ");
            opcao = in.nextInt();

            in.nextLine();


            switch (opcao) {
                case 1:
                    this.createProduto();
                    break;
                case 2:
                    this.createCarro();
                    break;
                case 3:
                    this.createPaís();
                    break;
                case 4:
                    this.readProduto();
                    break;
                case 5:
                    this.readCarro();
                    break;
                case 6:
                    this.readPaís();
                    break;
                case 7:
                    this.updateProduto();
                    break;
                case 8:
                    this.updateCarro();
                    break;
                case 9:
                    this.updatePaís();
                    break;
                case 10:
                    this.deleteProduto();
                    break;
                case 11:
                    this.deleteCarro();
                    break;
                case 12:
                    this.deletePaís();
                    break;
                case 13:
                    System.out.println("\tAté mais usuário!");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        } while (opcao!=13);
    }

    private void createProduto() {
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
    private void createCarro() {
        Carro Carros = new Carro();

        System.out.println("\nInforme o modelo do carro: ");
        Carros.setModelo(in.nextLine());
        System.out.println("\nInforme a marca do carro: ");
        Carros.setMarca(in.nextLine());
        System.out.println("\nInforme o ano do carro: ");
        Carros.setAno(in.nextInt());
        System.out.println("\nInforme a categoria do carro: ");
        Carros.setCategoria(in.next());

        in.nextLine();

        if (dao2.create(Carros)) {
            System.out.println("Dados adicionados");
        }
        else {
            System.out.println("Ops: problema ao adicionar os dados");
        }
    }
    private void createPaís() {
        País Paises = new País();

        System.out.println("\nInforme o nome do País: ");
        Paises.setNome(in.nextLine());
        System.out.println("\nInforme o continente desse País: ");
        Paises.setContinente(in.nextLine());
        System.out.println("\nInforme a população do País: ");
        Paises.setPopulacao(in.nextInt());

        in.nextLine();

        if (dao3.create(Paises)) {
            System.out.println("Dados adicionados");
        }
        else {
            System.out.println("Ops: problema ao adicionar os dados");
        }
    }



    private void readProduto() {
        List<Produto> Produtos = dao.read();

        for (Produto produtos : Produtos) {
            System.out.println(produtos);
            System.out.println("====================================================");
        }
    }
    private void readCarro() {
        List<Carro> Carros = dao2.read();

        for (Carro carros : Carros) {
            System.out.println(carros);
            System.out.println("====================================================");
        }
    }
    private void readPaís() {
        List<País> Paises = dao3.read();

        for (País paises : Paises) {
            System.out.println(paises);
            System.out.println("====================================================");
        }
    }


    private void updateProduto() {
        Produto produto = new Produto();
        System.out.println("**** Atualizar um produto****");
        System.out.println("Digite o id do produto que deseja alterar: ");
        produto.setId(in.nextInt());
        in.nextLine();
        System.out.println("Digite a nova descrição do produto: ");
        produto.setDescricao(in.nextLine());
        System.out.println("Digite a nova marca do produto: ");
        produto.setMarca(in.nextLine());
        System.out.println("Digite o novo  preço do produto: ");
        produto.setPreco(in.nextDouble());

        if (dao.update(produto)) {
            System.out.println("Produto alterado com sucesso!");
        }
        else {
            System.out.println("Ops: problema na alteração dos dados");
        }
    }
    private void updateCarro() {
        Carro carro = new Carro();
        System.out.println("**** Atualizar um Carro****");
        System.out.println("Digite o id do carro que deseja alterar: ");
        carro.setId(in.nextInt());
        in.nextLine();
        System.out.println("Digite o novo modelo do  carro: ");
        carro.setModelo(in.nextLine());
        System.out.println("Digite a nova marca do carro: ");
        carro.setMarca(in.nextLine());
        System.out.println("Digite o novo ano do carro:  ");
        carro.setAno(in.nextInt());
        System.out.println("Digite a nova categoria do carro: ");
        carro.setCategoria(in.next());
        if (dao2.update(carro)) {
            System.out.println("Carro alterado com sucesso!");
        }
        else {
            System.out.println("Ops: problema na alteração dos dados");
        }
    }
    private void updatePaís() {
        País pais= new País();
        System.out.println("**** Atualizar um País****");
        System.out.println("Digite o id do País que deseja alterar: ");
        pais.setId(in.nextInt());
        in.nextLine();
        System.out.println("Digite o novo nome do País: ");
        pais.setNome(in.nextLine());
        System.out.println("Digite o novo continente desse País: ");
        pais.setContinente(in.nextLine());
        System.out.println("Digite a novo número da população do País: ");
        pais.setPopulacao(in.nextInt());

        if (dao3.update(pais)) {
            System.out.println("País alterado com sucesso!");
        }
        else {
            System.out.println("Ops: problema na alteração dos dados");
        }
    }


    private void deleteProduto() {
        List<Produto> produtos = dao.read();
        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Produtos Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
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
    private void deleteCarro() {
        List<Carro> carros = dao2.read();
        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Carros Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Carro carro : carros) {
                System.out.println(i + " - " + carro);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual carro deseja remover? ");
            int opc = in.nextInt();
            in.nextLine();
            if (opc == i) {
                break;
            }
            if (opc >= carros.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao2.delete(carros.get(opc))) {
                    System.out.println("Carro removido com sucesso");
                } else {
                    System.out.println("OPS: falha ao tentar remover");
                }
                break;
            }
        }
    }
    private void deletePaís() {
        List<País> paises = dao3.read();
        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Países Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (País pais : paises) {
                System.out.println(i + " - " + pais);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual País deseja remover? ");
            int opc = in.nextInt();
            in.nextLine();
            if (opc == i) {
                break;
            }
            if (opc >= paises.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao3.delete(paises.get(opc))) {
                    System.out.println("País removido com sucesso");
                } else {
                    System.out.println("OPS: falha ao tentar remover");
                }
                break;
            }
        }
    }
}


