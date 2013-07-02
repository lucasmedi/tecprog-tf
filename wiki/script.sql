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

-- 50 Vendas - 200 Itens
insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Lucas Cunha', '05746388294', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (1, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (1, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (1, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (1, (select Codigo from Livros where Titulo = 'O Anticristo'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Giovanni Carlos', '84635158467', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (2, (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (2, (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (2, (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Professor James Moriarty', '6548738565', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (3, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (3, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (3, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (3, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (3, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Sherlock Holmes', '76378297424', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (4, (select Codigo from Livros where Titulo = 'Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (4, (select Codigo from Livros where Titulo = 'O Messias de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (4, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (4, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (4, (select Codigo from Livros where Titulo = 'Os Hereges de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (4, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('John Locke', '14796427853', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (5, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (5, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (5, (select Codigo from Livros where Titulo = 'A Luneta Âmbar'), 1);


insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Kurosaki Ichigo', '90874296545', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (6, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (6, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (6, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Uzumaki Naruto', '79092387261', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (7, (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (7, (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (7, (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (7, (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (7, (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (7, (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (7, (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Monkey D. Luffy', '98700773186', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (8, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Roronoa Zoro', '95365654682', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (9, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (9, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (9, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (9, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Hanauta no Brook', '28249457585', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (10, (select Codigo from Livros where Titulo = 'Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (10, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (10, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (10, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 1);


insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Marca Diabo Ltda.', null, '56834534834008', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (11, (select Codigo from Livros where Titulo = 'O Anticristo'), 150);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('CHE Enterprise', null, '27847164896742', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (12, (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (12, (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (12, (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (12, (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (12, (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (12, (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (12, (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'), 15);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Três Diamantes', null, '74538307475247', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (13, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 20);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (13, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 20);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (13, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 20);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Furd S.A.', null, '97846138008874', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (14, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 5);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (14, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 5);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (14, (select Codigo from Livros where Titulo = 'A Luneta Âmbar'), 5);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (14, (select Codigo from Livros where Titulo = 'O Anticristo'), 10);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Chronos', null, '45920047976536', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (15, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 30);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (15, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 30);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (15, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 30);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (15, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 30);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (15, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 30);


insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Odebrecht', null, '70075953345607', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (16, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 20);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (16, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 20);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (16, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 20);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (16, (select Codigo from Livros where Titulo = 'Duna'), 20);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Terra Networks', null, '46576656376657', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (17, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 60);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (17, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 60);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (17, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 60);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (17, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 60);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (17, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 60);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Hewlett-Packard', null, '84697558624590', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (18, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 10);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (18, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 10);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (18, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 10);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Dell Computers Inc.', null, '38547443846739', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (19, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (19, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (19, (select Codigo from Livros where Titulo = 'A Luneta Âmbar'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (19, (select Codigo from Livros where Titulo = 'O Anticristo'), 15);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Texxon Chemicals Inc.', null, '75366758765789', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (20, (select Codigo from Livros where Titulo = 'Duna'), 25);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (20, (select Codigo from Livros where Titulo = 'O Messias de Duna'), 25);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (20, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 25);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (20, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 25);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (20, (select Codigo from Livros where Titulo = 'Os Hereges de Duna'), 25);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (20, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 25);


insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Lucas Cunha', '05746388294', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (21, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (21, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (21, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (21, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (21, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Giovanni Carlos', '84635158467', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (22, (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (22, (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (22, (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (22, (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Professor James Moriarty', '6548738565', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (23, (select Codigo from Livros where Titulo = 'Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (23, (select Codigo from Livros where Titulo = 'O Messias de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (23, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (23, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (23, (select Codigo from Livros where Titulo = 'Os Hereges de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (23, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Sherlock Holmes', '76378297424', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (24, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (24, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (24, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('John Locke', '14796427853', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (25, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (25, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (25, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (25, (select Codigo from Livros where Titulo = 'O Anticristo'), 1);


insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Kurosaki Ichigo', '90874296545', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (26, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Uzumaki Naruto', '79092387261', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (27, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (27, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (27, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (27, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Monkey D. Luffy', '98700773186', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (28, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (28, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (28, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Roronoa Zoro', '95365654682', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (29, (select Codigo from Livros where Titulo = 'Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (29, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (29, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (29, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Hanauta no Brook', '28249457585', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (30, (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (30, (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (30, (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (30, (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (30, (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (30, (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (30, (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'), 1);


insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Marca Diabo Ltda.', null, '56834534834008', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (31, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 20);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (31, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 20);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (31, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 20);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('CHE Enterprise', null, '27847164896742', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (32, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 5);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (32, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 5);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (32, (select Codigo from Livros where Titulo = 'A Luneta Âmbar'), 5);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (32, (select Codigo from Livros where Titulo = 'O Anticristo'), 10);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Três Diamantes', null, '74538307475247', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (33, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 30);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (33, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 30);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (33, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 30);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (33, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 30);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (33, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 30);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Furd S.A.', null, '97846138008874', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (34, (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (34, (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (34, (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (34, (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (34, (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (34, (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (34, (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'), 15);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Chronos', null, '45920047976536', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (35, (select Codigo from Livros where Titulo = 'O Anticristo'), 150);


insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Odebrecht', null, '70075953345607', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (36, (select Codigo from Livros where Titulo = 'Duna'), 25);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (36, (select Codigo from Livros where Titulo = 'O Messias de Duna'), 25);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (36, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 25);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (36, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 25);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (36, (select Codigo from Livros where Titulo = 'Os Hereges de Duna'), 25);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (36, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 25);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Terra Networks', null, '46576656376657', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (37, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 60);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (37, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 60);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (37, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 60);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (37, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 60);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (37, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 60);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Hewlett-Packard', null, '84697558624590', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (38, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (38, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (38, (select Codigo from Livros where Titulo = 'A Luneta Âmbar'), 15);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (38, (select Codigo from Livros where Titulo = 'O Anticristo'), 15);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Dell Computers Inc.', null, '38547443846739', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (39, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 20);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (39, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 20);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (39, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 20);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (39, (select Codigo from Livros where Titulo = 'Duna'), 20);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Texxon Chemicals Inc.', null, '75366758765789', SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (40, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 10);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (40, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 10);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (40, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 10);


insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Lucas Cunha', '05746388294', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (41, (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (41, (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (41, (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (41, (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (41, (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (41, (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (41, (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Giovanni Carlos', '84635158467', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (42, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (42, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (42, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (42, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (42, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Professor James Moriarty', '6548738565', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (43, (select Codigo from Livros where Titulo = 'O Anticristo'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (43, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (43, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (43, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Sherlock Holmes', '76378297424', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (44, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (44, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (44, (select Codigo from Livros where Titulo = 'A Luneta Âmbar'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('John Locke', '14796427853', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (45, (select Codigo from Livros where Titulo = 'Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (45, (select Codigo from Livros where Titulo = 'O Messias de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (45, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (45, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (45, (select Codigo from Livros where Titulo = 'Os Hereges de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (45, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 1);


insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Thomas Edison', '', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (46, (select Codigo from Livros where Titulo = 'Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (46, (select Codigo from Livros where Titulo = 'O Messias de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (46, (select Codigo from Livros where Titulo = 'Os Filhos de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (46, (select Codigo from Livros where Titulo = 'O Imperador-Deus de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (46, (select Codigo from Livros where Titulo = 'Os Hereges de Duna'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (46, (select Codigo from Livros where Titulo = 'As Herdeiras de Duna'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Jean-Jacques Rousseau', '', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (47, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: A Sociedade do Anel'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (47, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: As Duas Torres'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (47, (select Codigo from Livros where Titulo = 'O Senhor dos Anéis: O Retorno do Rei'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Charles-Louis de Secondat', '', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (48, (select Codigo from Livros where Titulo = 'O Guia do Mochileiro das Galáxias'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (48, (select Codigo from Livros where Titulo = 'O Restaurante no Fim do Universo'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (48, (select Codigo from Livros where Titulo = 'A Vida, o Universo e Tudo Mais'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (48, (select Codigo from Livros where Titulo = 'Até Mais, e Obrigado Pelos Peixes!'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (48, (select Codigo from Livros where Titulo = 'Praticamente Inofensiva'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('François Marie Arouet', '', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (49, (select Codigo from Livros where Titulo = 'A Bússola Dourada'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (49, (select Codigo from Livros where Titulo = 'A Faca Sutil'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (49, (select Codigo from Livros where Titulo = 'A Luneta Âmbar'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (49, (select Codigo from Livros where Titulo = 'O Anticristo'), 1);

insert into Vendas (NomeCliente, CpfCliente, CnpjCliente, Data) values ('Benjamin Franklin', '', null, SYSDATE);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (50, (select Codigo from Livros where Titulo = 'Harry Potter e a Pedra Filosofal'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (50, (select Codigo from Livros where Titulo = 'Harry Potter e a Câmara Secreta'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (50, (select Codigo from Livros where Titulo = 'Harry Potter e o Prisioneiro de Azkaban'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (50, (select Codigo from Livros where Titulo = 'Harry Potter e o Cálice de Fogo'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (50, (select Codigo from Livros where Titulo = 'Harry Potter e a Ordem da Fênix'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (50, (select Codigo from Livros where Titulo = 'Harry Potter e o Enigma do Príncipe'), 1);
insert into ItensVenda (CodVenda, CodLivro, Quantidade) values (50, (select Codigo from Livros where Titulo = 'Harry Potter e as Relíquias da Morte'), 1);