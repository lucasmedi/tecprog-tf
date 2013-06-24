import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class ConnectionTest {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Inicializando driver...");
        inicializar();
        
        //Utilize o seguinte c—digo somente a primeira vez que executar
        System.out.println("Criando BD...");
        criarBd();
	}


    public static void inicializar() throws Exception {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    }
    
    public static void criarBd() throws Exception{
        Connection con = DriverManager.getConnection("jdbc:derby:cadastroLivraria;create=true");
        Statement sta = con.createStatement();
        String sqlAutor = "CREATE TABLE AUTORES("
                        + "CODIGO int PRIMARY KEY NOT NULL,"
                        + "PRIMEIRONOME varchar(100) NOT NULL,"
                        + "ULTIMONOME varchar(100) NOT NULL)";
        sta.executeUpdate(sqlAutor);
        String sqlEditora = "CREATE TABLE EDITORAS("
                          + "CODIGO int PRIMARY KEY NOT NULL,"
                          + "NOME varchar(100) NOT NULL)";
        sta.executeUpdate(sqlEditora);
        String sqlLivro = "CREATE TABLE LIVROS("
                        + "CODIGO int PRIMARY KEY NOT NULL,"
                        + "TITULO varchar(100) NOT NULL,"
                        + "ANO int NOT NULL,"
                        + "CODEDITORA int NOT NULL,"
                        + "CONSTRAINT FK_EDITORAS FOREIGN KEY (CODEDITORA) REFERENCES EDITORAS(CODIGO))";
        sta.executeUpdate(sqlLivro);
        String sqlLivroAutor = "CREATE TABLE LIVROSAUTORES("
                             + "CODLIVRO int NOT NULL,"
                             + "CODAUTOR int NOT NULL,"
                             + "CONSTRAINT PK_LIVROSAUTORES PRIMARY KEY (CODLIVRO,CODAUTOR),"
                             + "CONSTRAINT FK_LIVROS FOREIGN KEY (CODLIVRO) REFERENCES LIVROS(CODIGO),"
                             + "CONSTRAINT FK_AUTORES FOREIGN KEY (CODAUTOR) REFERENCES AUTORES(CODIGO))";
        sta.executeUpdate(sqlLivroAutor);
        String sqlVenda = "CREATE TABLE VENDAS("
                        + "CODIGO int PRIMARY KEY NOT NULL,"
                        + "NOMECLIENTE varchar(200) NOT NULL,"
                        + "CPFCLIENTE char(11),"
                        + "CNPJCLIENTE char(14),"
                        + "DATA date NOT NULL)";
        sta.executeUpdate(sqlVenda);
        String sqlItenVenda = "CREATE TABLE ITENSVENDA("
                            + "CODVENDA int NOT NULL,"
                            + "CODLIVRO int NOT NULL,"
                            + "QUANTIDADE int NOT NULL,"
                            + "CONSTRAINT PK_ITENSVENDA PRIMARY KEY (CODVENDA,CODLIVRO),"
                            + "CONSTRAINT FK_ITENSVENDA_LIVROS FOREIGN KEY (CODLIVRO) REFERENCES LIVROS(CODIGO),"
                            + "CONSTRAINT FK_ITENSVENDA_VENDAS FOREIGN KEY (CODVENDA) REFERENCES VENDAS(CODIGO))";
        sta.executeUpdate(sqlItenVenda);
        sta.close();
        con.close();
    }
    

}
