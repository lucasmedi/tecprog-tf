package persistence.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializeDb {
	
    public static void initialize() throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
    }
    
    public static void createDb() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/cadastro;create=true");
        Statement statement = connection.createStatement();
        
        createAutores(statement);
        createEditoras(statement);
        createLivros(statement);
        createLivrosAutores(statement);
        createVendas(statement);
        createItensVenda(statement);
        
        statement.close();
        connection.close();
    }
    
    private static void createAutores(Statement statement) throws SQLException {
    	String sql = "CREATE TABLE AUTORES" +
    	"(" +
    		"CODIGO int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
    		"PRIMEIRONOME varchar(100) NOT NULL," +
    		"ULTIMONOME varchar(100) NOT NULL," +
    		"CONSTRAINT PK_AUTORES PRIMARY KEY (CODIGO)" +
    	")";
    	
    	statement.executeUpdate(sql);
    }

    private static void createEditoras(Statement statement) throws SQLException {
    	String sql = "CREATE TABLE EDITORAS" +
    	"(" +
    		"CODIGO int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
    		"NOME varchar(100) NOT NULL," +
    		"CONSTRAINT PK_EDITORAS PRIMARY KEY (CODIGO)" +
    	")";
    	
    	statement.executeUpdate(sql);
    }

    private static void createLivros(Statement statement) throws SQLException {
    	String sql = "CREATE TABLE LIVROS" +
    	"(" +
    		"CODIGO int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
    		"TITULO varchar(100) NOT NULL," +
    		"ANO int NOT NULL," +
    		"CODEDITORA int NOT NULL," +
    		"CONSTRAINT PK_LIVROS PRIMARY KEY (CODIGO)," +
    		"CONSTRAINT FK_LIVROS_EDITORAS FOREIGN KEY (CODEDITORA) REFERENCES EDITORAS(CODIGO)" +
    	")";
    	
    	statement.executeUpdate(sql);
    }

	private static void createLivrosAutores(Statement statement) throws SQLException {
    	String sql = "CREATE TABLE LIVROSAUTORES" +
    	"(" +
    		"CODLIVRO int NOT NULL," +
    		"CODAUTOR int NOT NULL," +
    		"CONSTRAINT PK_LIVROSAUTORES PRIMARY KEY (CODLIVRO,CODAUTOR)," +
    		"CONSTRAINT FK_LIVROSAUTORES_LIVROS FOREIGN KEY (CODLIVRO) REFERENCES LIVROS(CODIGO)," +
    		"CONSTRAINT FK_LIVROSAUTORES_AUTORES FOREIGN KEY (CODAUTOR) REFERENCES AUTORES(CODIGO)" +
    	")";

    	statement.executeUpdate(sql);
    }
    	
	private static void createVendas(Statement statement) throws SQLException {
    	String sql = "CREATE TABLE VENDAS" +
    	"(" +
    		"CODIGO int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)," +
    		"NOMECLIENTE varchar(200) NOT NULL," +
    		"CPFCLIENTE char(11)," +
    		"CNPJCLIENTE char(14)," +
    		"DATA date NOT NULL," +
    		"CONSTRAINT PK_VENDAS PRIMARY KEY (CODIGO)" +
    	")";

    	statement.executeUpdate(sql);
    }
    	
	private static void createItensVenda(Statement statement) throws SQLException {
    	String sql = "CREATE TABLE ITENSVENDA" +
    	"(" +
    		"CODVENDA int NOT NULL," +
    		"CODLIVRO int NOT NULL," +
    		"QUANTIDADE int NOT NULL," +
    		"CONSTRAINT PK_ITENSVENDA PRIMARY KEY (CODVENDA,CODLIVRO)," +
    		"CONSTRAINT FK_ITENSVENDA_LIVROS FOREIGN KEY (CODLIVRO) REFERENCES LIVROS(CODIGO)," +
    		"CONSTRAINT FK_ITENSVENDA_VENDAS FOREIGN KEY (CODVENDA) REFERENCES VENDAS(CODIGO)" +
    	")";
    	
    	statement.executeUpdate(sql);
    }
	
	public static void PopulateDb() throws Exception {
		Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/cadastro");
		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		
		try {
			delete(statement);
			
			insertEditoras(statement);
			insertAutores(statement);
			insertLivros(statement);
			insertLivrosAutores(statement);
		} catch (Exception ex) {
			connection.rollback();
			throw ex;
		}
		
		connection.commit();
	}
	
	private static void delete(Statement statement) throws SQLException {
		String query = null;
		
		query = "delete from LivrosAutores";
		statement.executeUpdate(query);
		
		query = "delete from Livros";
		statement.executeUpdate(query);
		
		query = "delete from Autores";
		statement.executeUpdate(query);
		
		query = "delete from Editoras";
		statement.executeUpdate(query);
	}
	
	private static void insertEditoras(Statement statement) throws SQLException {
		String query = null;
		
		query = "insert into Editoras (Nome) values ('Martins Fontes Ltda')";
		statement.executeUpdate(query);
		
		query = "insert into Editoras (Nome) values ('Rocco Ltda')";
		statement.executeUpdate(query);
		
		query = "insert into Editoras (Nome) values ('L&PM Pocket')";
		statement.executeUpdate(query);
		
		query = "insert into Editoras (Nome) values ('Ponto de Leitura')";
		statement.executeUpdate(query);
		
		query = "insert into Editoras (Nome) values ('Aleph')";
		statement.executeUpdate(query);
		
		query = "insert into Editoras (Nome) values ('Sextante')";
		statement.executeUpdate(query);
	}
	
	private static void insertAutores(Statement statement) throws SQLException {
		String query = null;
		
		query = "insert into Autores (PrimeiroNome, UltimoNome) values ('John', 'Tolkien')";
		statement.executeUpdate(query);
		
		query = "insert into Autores (PrimeiroNome, UltimoNome) values ('Joanne', 'Rowling')";
		statement.executeUpdate(query);
		
		query = "insert into Autores (PrimeiroNome, UltimoNome) values ('Friedrich', 'Nietzsche')";
		statement.executeUpdate(query);
		
		query = "insert into Autores (PrimeiroNome, UltimoNome) values ('Frank', 'Herbert')";
		statement.executeUpdate(query);
		
		query = "insert into Autores (PrimeiroNome, UltimoNome) values ('Philip', 'Pullman')";
		statement.executeUpdate(query);
		
		query = "insert into Autores (PrimeiroNome, UltimoNome) values ('Douglas', 'Adams')";
		statement.executeUpdate(query);	
	}

	private static void insertLivros(Statement statement) throws SQLException {
		String query = null;
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('O Senhor dos Anéis: A Sociedade do Anel', 2001, (select Codigo from Editoras where Nome = 'Martins Fontes Ltda'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('O Senhor dos Anéis: As Duas Torres', 2002, (select Codigo from Editoras where Nome = 'Martins Fontes Ltda'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('O Senhor dos Anéis: O Retorno do Rei', 2003, (select Codigo from Editoras where Nome = 'Martins Fontes Ltda'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('Harry Potter e a Pedra Filosofal', 1997, (select Codigo from Editoras where Nome = 'Rocco Ltda'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('Harry Potter e a Câmara Secreta', 1998, (select Codigo from Editoras where Nome = 'Rocco Ltda'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('Harry Potter e o Prisioneiro de Azkaban', 1999, (select Codigo from Editoras where Nome = 'Rocco Ltda'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('Harry Potter e o Cálice de Fogo', 2000, (select Codigo from Editoras where Nome = 'Rocco Ltda'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('Harry Potter e a Ordem da Fênix', 2003, (select Codigo from Editoras where Nome = 'Rocco Ltda'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('Harry Potter e o Enigma do Príncipe', 2005, (select Codigo from Editoras where Nome = 'Rocco Ltda'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('Harry Potter e as Relíquias da Morte', 2007, (select Codigo from Editoras where Nome = 'Rocco Ltda'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('O Anticristo', 2008, (select Codigo from Editoras where Nome = 'L&PM Pocket'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('A Bússola Dourada', 2010, (select Codigo from Editoras where Nome = 'Ponto de Leitura'))";
		statement.executeUpdate(query);

		query = "insert into Livros (Titulo, Ano, CodEditora) values ('A Faca Sutil', 2010, (select Codigo from Editoras where Nome = 'Ponto de Leitura'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('A Luneta Âmbar', 2010, (select Codigo from Editoras where Nome = 'Ponto de Leitura'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('Duna', 2010, (select Codigo from Editoras where Nome = 'Aleph'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('O Messias de Duna', 2010, (select Codigo from Editoras where Nome = 'Aleph'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('Os Filhos de Duna', 2010, (select Codigo from Editoras where Nome = 'Aleph'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('O Imperador-Deus de Duna', 2010, (select Codigo from Editoras where Nome = 'Aleph'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('Os Hereges de Duna', 2010, (select Codigo from Editoras where Nome = 'Aleph'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('As Herdeiras de Duna', 2010, (select Codigo from Editoras where Nome = 'Aleph'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('O Guia do Mochileiro das Galáxias', 2010, (select Codigo from Editoras where Nome = 'Sextante'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('O Restaurante no Fim do Universo', 2010, (select Codigo from Editoras where Nome = 'Sextante'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('A Vida, o Universo e Tudo Mais', 2010, (select Codigo from Editoras where Nome = 'Sextante'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('Até Mais, e Obrigado Pelos Peixes!', 2010, (select Codigo from Editoras where Nome = 'Sextante'))";
		statement.executeUpdate(query);
		
		query = "insert into Livros (Titulo, Ano, CodEditora) values ('Praticamente Inofensiva', 2010, (select Codigo from Editoras where Nome = 'Sextante'))";
		statement.executeUpdate(query);
	}

	private static void insertLivrosAutores(Statement statement) throws SQLException {
		String query = null;
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'John'), (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'John'), (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'John'), (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Joanne'), (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Joanne'), (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Joanne'), (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Joanne'), (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Joanne'), (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Joanne'), (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Joanne'), (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Friedrich'), (select Codigo from Livros where Titulo = 'O Anticristo'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Philip'), (select Codigo from Livros where Titulo = 'A Bússola Dourada'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Philip'), (select Codigo from Livros where Titulo = 'A Faca Sutil'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Philip'), (select Codigo from Livros where Titulo = 'A Luneta Âmbar'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Frank'), (select Codigo from Livros where Titulo = 'Duna'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Frank'), (select Codigo from Livros where Titulo = 'O Messias de Duna'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Frank'), (select Codigo from Livros where Titulo = 'Os Filhos de Duna'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Frank'), (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Frank'), (select Codigo from Livros where Titulo = 'Os Hereges de Duna'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Frank'), (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Douglas'), (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Douglas'), (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Douglas'), (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Douglas'), (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'))";
		statement.executeUpdate(query);
		
		query = "insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Douglas'), (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'))";
		statement.executeUpdate(query);
	}
}