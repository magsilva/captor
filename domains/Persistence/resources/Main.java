
import connection.PConnection;
import pessoa.Pessoa;

public class Main  {

    public static void main(String[] args)  {
        System.out.println("\nIniciando o aplicativo!\n");          

        if ( args.length != 1 )  {
            System.out.println("Use: Main dbPropertiesPath");
            System.exit(0);
        }
        
        PConnection con = new PConnection(args[0]);
        
        //criando e utilizando uma classe persistente
        Pessoa p = new Pessoa(con);
        
        //Criar uma pessoa
        System.out.println("\nCriar uma pessoa com id igual a '1'.");
        p.setId(1);
        p.setNome("foo");
        p.setIdade(25);
        
        //salvando os dados na tabela
        System.out.println("\nSalvando os dados dessa pessoa no banco de dados.");
        p.save();
        
        //criando um novo objeto
        p = new Pessoa(con);
        
        //recuperando os dados da tabela
        System.out.println("\nRecuperando os dados dessa pessoa na base de dados.");
        
        p.getById(1);
        System.out.println("Pessoa");
        System.out.println("    ID: " + p.getId());
        System.out.println("  Nome: " + p.getNome());
        System.out.println(" Idade: " + p.getIdade());
        
        System.out.println("\nRemovendo essa pessoa.");
        p.delete();

    }
}