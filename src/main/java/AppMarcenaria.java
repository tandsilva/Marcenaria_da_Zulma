import java.util.Scanner;

public class AppMarcenaria {

    public  static  void  main ( String [] args ) {
        EncomendasMateriais a =  new EncomendasMateriais ();
        Scanner sc = new Scanner(System.in);
        EncomendasDB   b = new EncomendasDB();
        String teste = null;






        System.out.println("Entre com um número entre 1 para criar uma tabela 2 para inserir informaçoes 3 para realizar uma consulta ou 4 para deletar:");
        int num = sc.nextInt();
        switch (num) {
            case 1:
                System.out.println("Tabela criada");

                b.createDB();


                break;
            case 2:
                System.out.println("Dado inserido");
                b.insertDB();
                break;
            case 3:
                System.out.println("Lista de dados");
                b.selectDB();
                break;
            case 4:
                System.out.println("Atualizaçao dos dados");
                b.updateDB();

                break;
            case 5:
                System.out.println("Você escolheu 4");
                b.deleteDB();

                break;
            default:
                System.out.println("Número inválido");
        }
    }













    }









