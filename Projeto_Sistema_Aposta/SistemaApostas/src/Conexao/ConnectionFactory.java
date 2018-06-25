package Conexao;
	import java.sql.Connection;
	import java.sql.DriverManager;

	public class ConnectionFactory {
	    
	    private String url = "jdbc:postgresql://localhost:5432/Apostas";

        private String name = "postgres";

        private String psw = "slip123";
	    
	    private Connection con;
	    
	    public Connection getConnection() {
	    	try {
                // Registrando o driver
                Class.forName("org.postgresql.Driver");

                // Fazendo uma conexão teste
                con = DriverManager.getConnection(url, name, psw);
              //  System.out.println("Conectado");
                return con;
            } catch (Exception e) {
            
            //	System.out.println("Erro ao conectar");
                System.out.println(e.getLocalizedMessage());
                e.printStackTrace();
            }
	    return con;
	}
}
	