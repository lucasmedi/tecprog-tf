-- 3 editoras
-- 10 autores
-- 15 livros
-- 50 vendas com pelo menos 200 itens de venda

-- 3 Editoras
insert into Editoras (Nome) values ('Martins Fontes Ltda');
insert into Editoras (Nome) values ('Rocco Ltda');
insert into Editoras (Nome) values ('L&PM Pocket');
insert into Editoras (Nome) values ('Ponto de Leitura');
insert into Editoras (Nome) values ('Aleph');
insert into Editoras (Nome) values ('Sextante');

-- 10 Autores
insert into Autores (PrimeiroNome, UltimoNome) values ('John', 'Tolkien');
insert into Autores (PrimeiroNome, UltimoNome) values ('Joanne', 'Rowling');
insert into Autores (PrimeiroNome, UltimoNome) values ('Friedrich', 'Nietzsche');
insert into Autores (PrimeiroNome, UltimoNome) values ('Frank', 'Herbert');
insert into Autores (PrimeiroNome, UltimoNome) values ('Philip', 'Pullman');
insert into Autores (PrimeiroNome, UltimoNome) values ('Douglas', 'Adams');

-- 15 Livros
insert into Livros (Titulo, Ano, CodEditora) values ('O Senhor dos Anéis: A Sociedade do Anel', 2001, (select Codigo from Editoras where Nome = 'Martins Fontes Ltda'));
insert into Livros (Titulo, Ano, CodEditora) values ('O Senhor dos Anéis: As Duas Torres', 2002, (select Codigo from Editoras where Nome = 'Martins Fontes Ltda'));
insert into Livros (Titulo, Ano, CodEditora) values ('O Senhor dos Anéis: O Retorno do Rei', 2003, (select Codigo from Editoras where Nome = 'Martins Fontes Ltda'));
insert into Livros (Titulo, Ano, CodEditora) values ('Harry Potter e a Pedra Filosofal', 1997, (select Codigo from Editoras where Nome = 'Rocco Ltda'));
insert into Livros (Titulo, Ano, CodEditora) values ('Harry Potter e a Câmara Secreta', 1998, (select Codigo from Editoras where Nome = 'Rocco Ltda'));
insert into Livros (Titulo, Ano, CodEditora) values ('Harry Potter e o Prisioneiro de Azkaban', 1999, (select Codigo from Editoras where Nome = 'Rocco Ltda'));
insert into Livros (Titulo, Ano, CodEditora) values ('Harry Potter e o Cálice de Fogo', 2000, (select Codigo from Editoras where Nome = 'Rocco Ltda'));
insert into Livros (Titulo, Ano, CodEditora) values ('Harry Potter e a Ordem da Fênix', 2003, (select Codigo from Editoras where Nome = 'Rocco Ltda'));
insert into Livros (Titulo, Ano, CodEditora) values ('Harry Potter e o Enigma do Príncipe', 2005, (select Codigo from Editoras where Nome = 'Rocco Ltda'));
insert into Livros (Titulo, Ano, CodEditora) values ('Harry Potter e as Relíquias da Morte', 2007, (select Codigo from Editoras where Nome = 'Rocco Ltda'));
insert into Livros (Titulo, Ano, CodEditora) values ('O Anticristo', 2008, (select Codigo from Editoras where Nome = 'L&PM Pocket'));
insert into Livros (Titulo, Ano, CodEditora) values ('A Bússola Dourada', 2010, (select Codigo from Editoras where Nome = 'Ponto de Leitura'));
insert into Livros (Titulo, Ano, CodEditora) values ('A Faca Sutil', 2010, (select Codigo from Editoras where Nome = 'Ponto de Leitura'));
insert into Livros (Titulo, Ano, CodEditora) values ('A Luneta Âmbar', 2010, (select Codigo from Editoras where Nome = 'Ponto de Leitura'));
insert into Livros (Titulo, Ano, CodEditora) values ('Duna', 2010, (select Codigo from Editoras where Nome = 'Aleph'));
insert into Livros (Titulo, Ano, CodEditora) values ('O Messias de Duna', 2010, (select Codigo from Editoras where Nome = 'Aleph'));
insert into Livros (Titulo, Ano, CodEditora) values ('Os Filhos de Duna', 2010, (select Codigo from Editoras where Nome = 'Aleph'));
insert into Livros (Titulo, Ano, CodEditora) values ('O Imperador-Deus de Duna', 2010, (select Codigo from Editoras where Nome = 'Aleph'));
insert into Livros (Titulo, Ano, CodEditora) values ('Os Hereges de Duna', 2010, (select Codigo from Editoras where Nome = 'Aleph'));
insert into Livros (Titulo, Ano, CodEditora) values ('As Herdeiras de Duna', 2010, (select Codigo from Editoras where Nome = 'Aleph'));
insert into Livros (Titulo, Ano, CodEditora) values ('O Guia do Mochileiro das Galáxias', 2010, (select Codigo from Editoras where Nome = 'Sextante'));
insert into Livros (Titulo, Ano, CodEditora) values ('O Restaurante no Fim do Universo', 2010, (select Codigo from Editoras where Nome = 'Sextante'));
insert into Livros (Titulo, Ano, CodEditora) values ('A Vida, o Universo e Tudo Mais', 2010, (select Codigo from Editoras where Nome = 'Sextante'));
insert into Livros (Titulo, Ano, CodEditora) values ('Até Mais, e Obrigado Pelos Peixes!', 2010, (select Codigo from Editoras where Nome = 'Sextante'));
insert into Livros (Titulo, Ano, CodEditora) values ('Praticamente Inofensiva', 2010, (select Codigo from Editoras where Nome = 'Sextante'));

-- LivrosAutores
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'John'), (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'John'), (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'John'), (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Joanne'), (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Joanne'), (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Joanne'), (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Joanne'), (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Joanne'), (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Joanne'), (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Joanne'), (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Friedrich'), (select Codigo from Livros where Titulo = 'O Anticristo'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Philip'), (select Codigo from Livros where Titulo = 'A Bússola Dourada'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Philip'), (select Codigo from Livros where Titulo = 'A Faca Sutil'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Philip'), (select Codigo from Livros where Titulo = 'A Luneta Âmbar'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Frank'), (select Codigo from Livros where Titulo = 'Duna'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Frank'), (select Codigo from Livros where Titulo = 'O Messias de Duna'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Frank'), (select Codigo from Livros where Titulo = 'Os Filhos de Duna'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Frank'), (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Frank'), (select Codigo from Livros where Titulo = 'Os Hereges de Duna'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Frank'), (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Douglas'), (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Douglas'), (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Douglas'), (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Douglas'), (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'));
insert into LivrosAutores (CodAutor, CodLivro) values ((select Codigo from Autores where PrimeiroNome = 'Douglas'), (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'));

-- 50 Vendas
insert into Vendas () values ();

-- 200 ItensVenda
insert into ItensVenda () values ();