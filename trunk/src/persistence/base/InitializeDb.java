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
        //dropTables(statement);
        createVendas(statement);
        createItensVenda(statement);
        
        statement.close();
        connection.close();
    }
    
    private static void dropTables(Statement statement) throws SQLException {
    	String sqlItensVendas = "DROP TABLE ItensVenda";
		statement.executeUpdate(sqlItensVendas);
		
    	String sqlVendas = "DROP TABLE Vendas";
		statement.executeUpdate(sqlVendas);
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
			//delete(statement);
			
			//insertEditoras(statement);
			//insertAutores(statement);
			//insertLivros(statement);
			//insertLivrosAutores(statement);
			insertVendas(statement);
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

	private static void insertVendas(Statement statement) throws SQLException {
		insertVenda1(statement);
		insertVenda2(statement);
		insertVenda3(statement);
		insertVenda4(statement);
		insertVenda5(statement);
		
		insertVenda6(statement);
		insertVenda7(statement);
		insertVenda8(statement);
		insertVenda9(statement);
		insertVenda10(statement);
		
		insertVenda11(statement);
		insertVenda12(statement);
		insertVenda13(statement);
		insertVenda14(statement);
		insertVenda15(statement);
		
		insertVenda16(statement);
		insertVenda17(statement);
		insertVenda18(statement);
		insertVenda19(statement);
		insertVenda20(statement);
		
		insertVenda21(statement);
		insertVenda22(statement);
		insertVenda23(statement);
		insertVenda24(statement);
		insertVenda25(statement);
		
		insertVenda26(statement);
		insertVenda27(statement);
		insertVenda28(statement);
		insertVenda29(statement);
		insertVenda30(statement);
		
		insertVenda31(statement);
		insertVenda32(statement);
		insertVenda33(statement);
		insertVenda34(statement);
		insertVenda35(statement);
		
		insertVenda36(statement);
		insertVenda37(statement);
		insertVenda38(statement);
		insertVenda39(statement);
		insertVenda40(statement);
		
		insertVenda41(statement);
		insertVenda42(statement);
		insertVenda43(statement);
		insertVenda44(statement);
		insertVenda45(statement);
		
		insertVenda46(statement);
		insertVenda47(statement);
		insertVenda48(statement);
		insertVenda49(statement);
		insertVenda50(statement);
	}
	
	
	private static void insertVenda1(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Lucas Cunha', '05746388294', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (1, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (1, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (1, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (1, (select Codigo from Livros where Titulo = 'O Anticristo'), 1)";
		statement.executeUpdate(query);
	}
	
	private static void insertVenda2(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Giovanni Carlos', '84635158467', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (2, (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (2, (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (2, (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda3(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Professor James Moriarty', '6548738565', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (3, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (3, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (3, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (3, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (3, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda4(Statement statement) throws SQLException {
		String query = null;
		
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Sherlock Holmes', '76378297424', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (4, (select Codigo from Livros where Titulo = 'Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (4, (select Codigo from Livros where Titulo = 'O Messias de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (4, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (4, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (4, (select Codigo from Livros where Titulo = 'Os Hereges de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (4, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda5(Statement statement) throws SQLException {
		String query = null;
		
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('John Locke', '14796427853', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (5, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (5, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (5, (select Codigo from Livros where Titulo = 'A Luneta Âmbar'), 1)";
		statement.executeUpdate(query);
	}


	private static void insertVenda6(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Kurosaki Ichigo', '90874296545', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (6, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (6, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (6, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda7(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Uzumaki Naruto', '79092387261', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (7, (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (7, (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (7, (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (7, (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (7, (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (7, (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (7, (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda8(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Monkey D. Luffy', '98700773186', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (8, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda9(Statement statement) throws SQLException {
		String query = null;
		
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Roronoa Zoro', '95365654682', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (9, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (9, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (9, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (9, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda10(Statement statement) throws SQLException {
		String query = null;

		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Hanauta no Brook', '28249457585', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (10, (select Codigo from Livros where Titulo = 'Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (10, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (10, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (10, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 1)";
		statement.executeUpdate(query);
	}


	private static void insertVenda11(Statement statement) throws SQLException {
		String query = null;
		
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Marca Diabo Ltda.', null, '56834534834008', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (11, (select Codigo from Livros where Titulo = 'O Anticristo'), 150)";
		statement.executeUpdate(query);
	}

	private static void insertVenda12(Statement statement) throws SQLException {
		String query = null;
		
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('CHE Enterprise', null, '27847164896742', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (12, (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (12, (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (12, (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (12, (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (12, (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (12, (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (12, (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'), 15)";
		statement.executeUpdate(query);
	}

	private static void insertVenda13(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Três Diamantes', null, '74538307475247', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (13, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 20)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (13, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 20)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (13, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 20)";
		statement.executeUpdate(query);
	}

	private static void insertVenda14(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Furd S.A.', null, '97846138008874', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (14, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 5)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (14, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 5)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (14, (select Codigo from Livros where Titulo = 'A Luneta Âmbar'), 5)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (14, (select Codigo from Livros where Titulo = 'O Anticristo'), 10)";
		statement.executeUpdate(query);
	}

	private static void insertVenda15(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Chronos', null, '45920047976536', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (15, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 30)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (15, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 30)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (15, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 30)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (15, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 30)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (15, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 30)";
		statement.executeUpdate(query);
	}


	private static void insertVenda16(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Odebrecht', null, '70075953345607', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (16, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 20)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (16, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 20)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (16, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 20)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (16, (select Codigo from Livros where Titulo = 'Duna'), 20)";
		statement.executeUpdate(query);
	}

	private static void insertVenda17(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Terra Networks', null, '46576656376657', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (17, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 60)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (17, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 60)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (17, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 60)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (17, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 60)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (17, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 60)";
		statement.executeUpdate(query);
	}

	private static void insertVenda18(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Hewlett-Packard', null, '84697558624590', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (18, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 10)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (18, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 10)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (18, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 10)";
		statement.executeUpdate(query);
	}

	private static void insertVenda19(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Dell Computers Inc.', null, '38547443846739', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (19, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (19, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (19, (select Codigo from Livros where Titulo = 'A Luneta Âmbar'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (19, (select Codigo from Livros where Titulo = 'O Anticristo'), 15)";
		statement.executeUpdate(query);
	}

	private static void insertVenda20(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Texxon Chemicals Inc.', null, '75366758765789', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (20, (select Codigo from Livros where Titulo = 'Duna'), 25)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (20, (select Codigo from Livros where Titulo = 'O Messias de Duna'), 25)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (20, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 25)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (20, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 25)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (20, (select Codigo from Livros where Titulo = 'Os Hereges de Duna'), 25)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (20, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 25)";
		statement.executeUpdate(query);
	}


	private static void insertVenda21(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Lucas Cunha', '05746388294', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (21, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (21, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (21, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (21, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (21, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda22(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Giovanni Carlos', '84635158467', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (22, (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (22, (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (22, (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (22, (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda23(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Professor James Moriarty', '6548738565', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (23, (select Codigo from Livros where Titulo = 'Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (23, (select Codigo from Livros where Titulo = 'O Messias de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (23, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (23, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (23, (select Codigo from Livros where Titulo = 'Os Hereges de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (23, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda24(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Sherlock Holmes', '76378297424', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (24, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (24, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (24, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda25(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('John Locke', '14796427853', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (25, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (25, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (25, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (25, (select Codigo from Livros where Titulo = 'O Anticristo'), 1)";
		statement.executeUpdate(query);
	}


	private static void insertVenda26(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Kurosaki Ichigo', '90874296545', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (26, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda27(Statement statement) throws SQLException {
		String query = null;
		
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Uzumaki Naruto', '79092387261', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (27, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (27, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (27, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (27, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda28(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Monkey D. Luffy', '98700773186', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (28, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (28, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (28, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda29(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Roronoa Zoro', '95365654682', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (29, (select Codigo from Livros where Titulo = 'Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (29, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (29, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (29, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda30(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Hanauta no Brook', '28249457585', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (30, (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (30, (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (30, (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (30, (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (30, (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (30, (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (30, (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'), 1)";
		statement.executeUpdate(query);
	}


	private static void insertVenda31(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Marca Diabo Ltda.', null, '56834534834008', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (31, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 20)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (31, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 20)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (31, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 20)";
		statement.executeUpdate(query);
	}

	private static void insertVenda32(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('CHE Enterprise', null, '27847164896742', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (32, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 5)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (32, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 5)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (32, (select Codigo from Livros where Titulo = 'A Luneta Âmbar'), 5)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (32, (select Codigo from Livros where Titulo = 'O Anticristo'), 10)";
		statement.executeUpdate(query);
	}

	private static void insertVenda33(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Três Diamantes', null, '74538307475247', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (33, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 30)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (33, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 30)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (33, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 30)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (33, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 30)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (33, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 30)";
		statement.executeUpdate(query);
	}

	private static void insertVenda34(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Furd S.A.', null, '97846138008874', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (34, (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (34, (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (34, (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (34, (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (34, (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (34, (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (34, (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'), 15)";
		statement.executeUpdate(query);
	}

	private static void insertVenda35(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Chronos', null, '45920047976536', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (35, (select Codigo from Livros where Titulo = 'O Anticristo'), 150)";
		statement.executeUpdate(query);
	}


	private static void insertVenda36(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Odebrecht', null, '70075953345607', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (36, (select Codigo from Livros where Titulo = 'Duna'), 25)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (36, (select Codigo from Livros where Titulo = 'O Messias de Duna'), 25)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (36, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 25)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (36, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 25)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (36, (select Codigo from Livros where Titulo = 'Os Hereges de Duna'), 25)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (36, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 25)";
		statement.executeUpdate(query);
	}

	private static void insertVenda37(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Terra Networks', null, '46576656376657', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (37, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 60)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (37, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 60)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (37, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 60)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (37, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 60)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (37, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 60)";
		statement.executeUpdate(query);
	}

	private static void insertVenda38(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Hewlett-Packard', null, '84697558624590', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (38, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (38, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (38, (select Codigo from Livros where Titulo = 'A Luneta Âmbar'), 15)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (38, (select Codigo from Livros where Titulo = 'O Anticristo'), 15)";
		statement.executeUpdate(query);
	}

	private static void insertVenda39(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Dell Computers Inc.', null, '38547443846739', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (39, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 20)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (39, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 20)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (39, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 20)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (39, (select Codigo from Livros where Titulo = 'Duna'), 20)";
		statement.executeUpdate(query);
	}

	private static void insertVenda40(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Texxon Chemicals Inc.', null, '75366758765789', CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (40, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 10)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (40, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 10)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (40, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 10)";
		statement.executeUpdate(query);
	}


	private static void insertVenda41(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Lucas Cunha', '05746388294', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (41, (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (41, (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (41, (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (41, (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (41, (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (41, (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (41, (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda42(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Giovanni Carlos', '84635158467', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (42, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (42, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (42, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (42, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (42, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda43(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Professor James Moriarty', '6548738565', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (43, (select Codigo from Livros where Titulo = 'O Anticristo'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (43, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (43, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (43, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda44(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Sherlock Holmes', '76378297424', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (44, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (44, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (44, (select Codigo from Livros where Titulo = 'A Luneta Âmbar'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda45(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('John Locke', '14796427853', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (45, (select Codigo from Livros where Titulo = 'Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (45, (select Codigo from Livros where Titulo = 'O Messias de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (45, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (45, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (45, (select Codigo from Livros where Titulo = 'Os Hereges de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (45, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 1)";
		statement.executeUpdate(query);
	}


	private static void insertVenda46(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Thomas Edison', '', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (46, (select Codigo from Livros where Titulo = 'Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (46, (select Codigo from Livros where Titulo = 'O Messias de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (46, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (46, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (46, (select Codigo from Livros where Titulo = 'Os Hereges de Duna'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (46, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda47(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Jean-Jacques Rousseau', '', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (47, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (47, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (47, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda48(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Charles-Louis de Secondat', '', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (48, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (48, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (48, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (48, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (48, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda49(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('François Marie Arouet', '', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (49, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (49, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (49, (select Codigo from Livros where Titulo = 'A Luneta Âmbar'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (49, (select Codigo from Livros where Titulo = 'O Anticristo'), 1)";
		statement.executeUpdate(query);
	}

	private static void insertVenda50(Statement statement) throws SQLException {
		String query = null;
	
		query = "insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Benjamin Franklin', '', null, CURRENT_DATE)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (50, (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (50, (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (50, (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (50, (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (50, (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (50, (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'), 1)";
		statement.executeUpdate(query);
		query = "insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (50, (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'), 1)";
		statement.executeUpdate(query);
	}
}