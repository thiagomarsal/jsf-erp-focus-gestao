
INSERT INTO pais (idpais, ddi, nome, sigla) VALUES (1, '55', 'Brasil', 'BR');
INSERT INTO pais (idpais, ddi, nome, sigla) VALUES (2, '21', 'Paraguai', 'PY');
INSERT INTO pais (idpais, ddi, nome, sigla) VALUES (3, '22', 'Argentina', 'AR');

INSERT INTO estado (idestado, nome, sigla, idpais) VALUES (1, 'Paraná', 'PR', 1);
INSERT INTO estado (idestado, nome, sigla, idpais) VALUES (2, 'Santa Catarina', 'SC', 1);
INSERT INTO estado (idestado, nome, sigla, idpais) VALUES (3, 'Rio Grande do Sul', 'RS', 1);
INSERT INTO estado (idestado, nome, sigla, idpais) VALUES (4, 'São Paulo', 'SP', 1);
INSERT INTO estado (idestado, nome, sigla, idpais) VALUES (5, 'Rio de Janeiro', 'RJ', 1);
INSERT INTO estado (idestado, nome, sigla, idpais) VALUES (6, 'Mato Grosso do Sul', 'MS', 1);
INSERT INTO estado (idestado, nome, sigla, idpais) VALUES (7, 'Mato Grosso', 'MT', 1);

INSERT INTO cidade (idcidade, ddd, nome, idestado) VALUES (1, '45', 'Foz do Iguaçu', 1);
INSERT INTO cidade (idcidade, ddd, nome, idestado) VALUES (2, '45', 'Santa Teresinha de Itaipu', 1);
INSERT INTO cidade (idcidade, ddd, nome, idestado) VALUES (3, '45', 'Cascavel', 1);
INSERT INTO cidade (idcidade, ddd, nome, idestado) VALUES (4, '41', 'Curitiba', 1);
INSERT INTO cidade (idcidade, ddd, nome, idestado) VALUES (5, '51', 'Porto Alegre', 3);

INSERT INTO cargo (idcargo, descricao, status) VALUES (1, 'Gerente', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (2, 'Vendedor', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (3, 'Caixa', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (4, 'Zelador', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (5, 'Segurança', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (7, 'Estágiario', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (6, 'Assistente', NULL);

INSERT INTO condicaopagamento (idcondicaopagamento, descricao, parcelas) VALUES (1, 'A vista', 0);
INSERT INTO condicaopagamento (idcondicaopagamento, descricao, parcelas) VALUES (2, '1 + 1', 2);
INSERT INTO condicaopagamento (idcondicaopagamento, descricao, parcelas) VALUES (3, '1 + 2', 3);
INSERT INTO condicaopagamento (idcondicaopagamento, descricao, parcelas) VALUES (4, '1 + 5', 6);

INSERT INTO cor (idcor, descricao, status) VALUES (1, 'Preto', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (2, 'Transparente', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (3, 'Azul', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (4, 'Verde', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (5, 'Amarelo', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (6, 'Cinza', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (7, 'Vermelho', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (8, 'Roxo', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (9, 'Rosa', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (10, 'Laranjado', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (11, 'Dourado', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (12, 'Cromado', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (13, 'Prata', NULL);

INSERT INTO formapagamento (idformapagamento, descricao) VALUES (1, 'Dinheiro');
INSERT INTO formapagamento (idformapagamento, descricao) VALUES (2, 'Cheque');
INSERT INTO formapagamento (idformapagamento, descricao) VALUES (3, 'Cartão Débito');
INSERT INTO formapagamento (idformapagamento, descricao) VALUES (4, 'Cartão Crédito');
INSERT INTO formapagamento (idformapagamento, descricao) VALUES (6, 'Boleto Bancário');
INSERT INTO formapagamento (idformapagamento, descricao) VALUES (5, 'Promissória');

INSERT INTO grupo (idgrupo, descricao, status) VALUES (1, 'Lentes', NULL);
INSERT INTO grupo (idgrupo, descricao, status) VALUES (2, 'Armações', NULL);
INSERT INTO grupo (idgrupo, descricao, status) VALUES (3, 'Óculos', NULL);
INSERT INTO grupo (idgrupo, descricao, status) VALUES (4, 'Parafusos', NULL);
INSERT INTO grupo (idgrupo, descricao, status) VALUES (7, 'Jóias', NULL);
INSERT INTO grupo (idgrupo, descricao, status) VALUES (8, 'Relógios', NULL);
INSERT INTO grupo (idgrupo, descricao, status) VALUES (9, 'Bloco', NULL);

INSERT INTO linha (idlinha, descricao, status) VALUES (1, 'Infantil', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (2, 'Solar Masculino', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (3, 'Solar Feminino', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (4, 'Masculino', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (5, 'Feminino', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (6, 'Unissex', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (7, 'Esporte', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (8, 'Receituário', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (9, 'Solar', NULL);

INSERT INTO marca (idmarca, descricao, status) VALUES (1, 'Arnette', NULL);
INSERT INTO marca (idmarca, descricao, status) VALUES (2, 'Blue Ray', NULL);
INSERT INTO marca (idmarca, descricao, status) VALUES (3, 'Carrera', NULL);
INSERT INTO marca (idmarca, descricao, status) VALUES (4, 'Christian Dior', NULL);
INSERT INTO marca (idmarca, descricao, status) VALUES (5, 'Emporio Armani', NULL);
INSERT INTO marca (idmarca, descricao, status) VALUES (6, 'Hugo Boos', NULL);
INSERT INTO marca (idmarca, descricao, status) VALUES (7, 'Prada', NULL);
INSERT INTO marca (idmarca, descricao, status) VALUES (8, 'Ray Ban', NULL);
INSERT INTO marca (idmarca, descricao, status) VALUES (9, 'Sferoflex', NULL);
INSERT INTO marca (idmarca, descricao, status) VALUES (10, 'Transitions', NULL);
INSERT INTO marca (idmarca, descricao, status) VALUES (11, 'Solamax', NULL);
INSERT INTO marca (idmarca, descricao, status) VALUES (12, 'Varilux', NULL);

INSERT INTO material (idmaterial, descricao, status) VALUES (1, 'Metal', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (2, 'Acetato', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (3, 'Nylon', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (4, 'Fibra', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (5, 'Aço', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (6, 'Clypon', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (7, 'Orma', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (8, 'Descartável', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (9, 'CR39', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (10, 'Policarbonato', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (11, 'Cristal', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (12, 'Cristal Alto Índice', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (13, 'Resina Médio Índice', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (14, 'Resina Alto Índice', NULL);

INSERT INTO modelo (idmodelo, descricao, status) VALUES (1, 'Acabada', NULL);
INSERT INTO modelo (idmodelo, descricao, status) VALUES (7, 'Acabada - Anti Reflexo', NULL);
INSERT INTO modelo (idmodelo, descricao, status) VALUES (6, 'Acabada e Surfassada', NULL);
INSERT INTO modelo (idmodelo, descricao, status) VALUES (5, 'Fotocromática', NULL);
INSERT INTO modelo (idmodelo, descricao, status) VALUES (3, 'Sufassada', NULL);
INSERT INTO modelo (idmodelo, descricao, status) VALUES (2, 'Anti Reflexo', NULL);

INSERT INTO perfilacesso (idperfilacesso, descricao, status) VALUES (1, 'Gerente', NULL);
INSERT INTO perfilacesso (idperfilacesso, descricao, status) VALUES (2, 'Vendedor', NULL);
INSERT INTO perfilacesso (idperfilacesso, descricao, status) VALUES (3, 'Caixa', NULL);
INSERT INTO perfilacesso (idperfilacesso, descricao, status) VALUES (4, 'Administrador', NULL);

INSERT INTO servico (idservico, descricao, obs, preco) VALUES (1, 'Troca de Hastes', 'sem a haste', 5);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (2, 'Troca de ponteiras', '', 5);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (3, 'Troca de Plaquetas', '', 5);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (4, 'Solda', '', 10);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (5, 'Ajuste de Armação', '', 50);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (6, 'Surfaçagem', '', 100);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (7, 'Montagem', '', 50);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (8, 'Anti-Reflexo', '', 250);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (9, 'Coloração', '', 80);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (10, 'Anti-Risco', '', 150);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (11, 'Video-Filter', 'Para usuários de Computador', 300);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (12, 'UV-400', 'Proteção de Raios UltraVioleta', 500);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (13, 'Flash', 'Um leve toque espelhado na lente colorida.', 300);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (14, 'Blue Black', 'Para pessoas com degeneração macular.', 450);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (15, 'Hard Coating', 'Anti-risco face interna e externa', 600);

INSERT INTO tipo (idtipo, descricao, status) VALUES (1, 'Monofocal', NULL);
INSERT INTO tipo (idtipo, descricao, status) VALUES (5, 'Monofocal Solar', NULL);
INSERT INTO tipo (idtipo, descricao, status) VALUES (4, 'Multifocal', NULL);
INSERT INTO tipo (idtipo, descricao, status) VALUES (3, 'Bifocal', NULL);
INSERT INTO tipo (idtipo, descricao, status) VALUES (2, 'Visão Simples', NULL);

INSERT INTO unidade (idunidade, descricao, status, sigla) VALUES (1, 'Unidade', NULL, 'UN');
INSERT INTO unidade (idunidade, descricao, status, sigla) VALUES (2, 'Peça', NULL, 'PÇ');
INSERT INTO unidade (idunidade, descricao, status, sigla) VALUES (3, 'Par', NULL, 'PR');
INSERT INTO unidade (idunidade, descricao, status, sigla) VALUES (4, 'Dúzia', NULL, 'DZ');

INSERT INTO usuario (idusuario, login, senha, idperfilacesso) VALUES (1, 'jose', '81dc9bdb52d04dc20036dbd8313ed055', 4);
INSERT INTO usuario (idusuario, login, senha, idperfilacesso) VALUES (2, 'edinelson', '81dc9bdb52d04dc20036dbd8313ed055', 1);
INSERT INTO usuario (idusuario, login, senha, idperfilacesso) VALUES (3, 'edna', '81dc9bdb52d04dc20036dbd8313ed055', 1);
INSERT INTO usuario (idusuario, login, senha, idperfilacesso) VALUES (4, 'paulo', '81dc9bdb52d04dc20036dbd8313ed055', 2);
INSERT INTO usuario (idusuario, login, senha, idperfilacesso) VALUES (5, 'carla', '81dc9bdb52d04dc20036dbd8313ed055', 3);

INSERT INTO cliente (idcliente, apelidonomefantasia, celular, cpfcnpj, dataatualizacao, datacadastro, email, bairro, cep, complemento, logradouro, numeropredial, fax, nomerazaosocial, obs, rginscricao, site, telefone, contato, datanascimento, estadocivil, sexo, idcidade) VALUES (2, NULL, '99496507', '02898478938', '2009-07-08', '2009-07-08', '', 'vila Portes', '85865010', 'Casa', 'rua Portinari', '658', NULL, 'Marciana Ramirez Silva', '', '69341861', NULL, '30256247', NULL, '1959-06-12', 'Casado', 'Feminino', 1);
INSERT INTO cliente (idcliente, apelidonomefantasia, celular, cpfcnpj, dataatualizacao, datacadastro, email, bairro, cep, complemento, logradouro, numeropredial, fax, nomerazaosocial, obs, rginscricao, site, telefone, contato, datanascimento, estadocivil, sexo, idcidade) VALUES (1, NULL, '99380635', '02898478938', '2009-07-08', '2009-07-08', 'izaiza_iza@hotmail.com', 'Centro', '85865010', 'Edificio Fontane Blue apto. 1201', 'Rua Almirante Barroso', '123', NULL, 'Izaura Giroldo', 'Próximo ao Fisk', '69341861', NULL, '35729384', NULL, '1967-11-21', 'União Estavel', 'Feminino', 1);

INSERT INTO fornecedor (idfornecedor, apelidonomefantasia, celular, cpfcnpj, dataatualizacao, datacadastro, email, bairro, cep, complemento, logradouro, numeropredial, fax, nomerazaosocial, obs, rginscricao, site, telefone, contato, idcidade) VALUES (1, 'Visolux', '', '07904134000186', '2009-07-08', '2009-07-08', '', 'Juveve', '80040310', '', 'rua Augusto Stresser', '1350', '', 'Ótica Visolux', '', 'Isento', '', '33624440', 'Augusto', 4);

INSERT INTO funcionario (idfuncionario, apelidonomefantasia, celular, cpfcnpj, dataatualizacao, datacadastro, email, bairro, cep, complemento, logradouro, numeropredial, fax, nomerazaosocial, obs, rginscricao, site, telefone, comissao, ctps, dataadmissao, datademissao, datanascimento, estadocivil, salario, sexo, idcargo, idcidade, idusuario) VALUES (1, NULL, '99380635', '02898478938', '2009-07-08', '2009-07-08', 'jose@gmail.com', 'vila Portes', '85865010', '', 'rua Portinari', '658', NULL, 'José Arnildo Silva Neto', '', '69341861', NULL, '30256247', 0, '12345678919', '2008-06-02', NULL, '1980-02-11', 'União Estavel', 2000, 'Masculino', 6, 1, 1);

INSERT INTO produto (idproduto, acrescimo, descricao, estoque, obs, precocusto, precovenda, referencia, idcor, idgrupo, idlinha, idmarca, idmaterial, idmodelo, idtipo, idunidade) VALUES (4, 40, 'Lente visão simples CR39 Anti Reflexo - Acabada', 10, '', 100, 140, 'LVSCR39-ARA', 2, 1, 8, 9, 9, 7, 2, 1);
INSERT INTO produto (idproduto, acrescimo, descricao, estoque, obs, precocusto, precovenda, referencia, idcor, idgrupo, idlinha, idmarca, idmaterial, idmodelo, idtipo, idunidade) VALUES (5, 40, 'Lentes visão simples Transitions - Acabada e Surfassada', 10, '', 100, 140, 'LVST-AS', 2, 1, 8, 10, 10, 6, 2, 1);
INSERT INTO produto (idproduto, acrescimo, descricao, estoque, obs, precocusto, precovenda, referencia, idcor, idgrupo, idlinha, idmarca, idmaterial, idmodelo, idtipo, idunidade) VALUES (3, 40, 'Lente visão simples CR39 Acabada e Surfassada', 10, 'Lente pronta', 100, 140, 'LVSCR39-AS', 2, 1, 8, 9, 9, 6, 2, 1);

INSERT INTO receita (idreceita, curva, descricao, diametro, eixo, espessura, obs, olho, precovenda, totalservicos) VALUES (1, 1, 'Receita João', 2.5, 1.5, 1, 'Doutor: Fulano de Tal
Cliente: João da Silva', 'Não Considerar', 650, 650);

INSERT INTO compra (idcompra, baseicms, baseicmssubstituicao, dataemissao, dataentrada, desconto, numero, obs, outrasdespesas, serie, statuspedido, totalcompra, totalprodutos, valorfrete, valoricms, valoricmssubstituicao, valorseguro, valortotalipi, idcondicaopagamento, idfornecedor, idusuario) VALUES (2, 0, 0, '2009-07-09', '2009-07-09', 0, '123', '', 0, 'B1', 'CONCLUIDO', 1750, 1750, 0, 0, 0, 0, 0, 1, 1, 1);
INSERT INTO compra (idcompra, baseicms, baseicmssubstituicao, dataemissao, dataentrada, desconto, numero, obs, outrasdespesas, serie, statuspedido, totalcompra, totalprodutos, valorfrete, valoricms, valoricmssubstituicao, valorseguro, valortotalipi, idcondicaopagamento, idfornecedor, idusuario) VALUES (3, 0, 0, '2009-07-09', '2009-07-09', 0, '1234', '', 0, '1', 'CONCLUIDO', 5550, 5550, 0, 0, 0, 0, 0, 1, 1, 1);

INSERT INTO contapagar (idcontapagar, dataquitacao, datavencimento, desconto, juros, multa, numerodocumento, obs, statuscontas, valor, valorrecebido, compra_idcompra, idformapagamento, idfornecedor) VALUES (2, NULL, '2009-07-09 00:00:00', NULL, NULL, NULL, '123/1', NULL, 'ABERTO', 1750, NULL, NULL, NULL, 1);
INSERT INTO contapagar (idcontapagar, dataquitacao, datavencimento, desconto, juros, multa, numerodocumento, obs, statuscontas, valor, valorrecebido, compra_idcompra, idformapagamento, idfornecedor) VALUES (3, NULL, '2009-07-09 00:00:00', NULL, NULL, NULL, '1234/1', NULL, 'ABERTO', 5550, NULL, NULL, NULL, 1);
INSERT INTO contapagar (idcontapagar, dataquitacao, datavencimento, desconto, juros, multa, numerodocumento, obs, statuscontas, valor, valorrecebido, compra_idcompra, idformapagamento, idfornecedor) VALUES (5, NULL, '2009-07-09 00:00:00', 0, NULL, 0, '987', '', 'ABERTO', 1000, 0, NULL, 1, 1);

INSERT INTO produtosselecionados (idprodutosselecionados, aliquotaicms, aliquotaipi, classificacaofiscal, descricao, identificador, precototal, precounitario, quantidade, situacaotributaria, unidade, produto_idproduto, receita_idreceita) VALUES (4, 0, 0, '', 'Lente visão simples CR39 Acabada e Surfassada', NULL, NULL, 55, 10, '', 'UN', 3, NULL);
INSERT INTO produtosselecionados (idprodutosselecionados, aliquotaicms, aliquotaipi, classificacaofiscal, descricao, identificador, precototal, precounitario, quantidade, situacaotributaria, unidade, produto_idproduto, receita_idreceita) VALUES (5, 0, 0, '', 'Lentes visão simples Transitions - Acabada e Surfassada', NULL, NULL, 80, 15, '', 'UN', 5, NULL);
INSERT INTO produtosselecionados (idprodutosselecionados, aliquotaicms, aliquotaipi, classificacaofiscal, descricao, identificador, precototal, precounitario, quantidade, situacaotributaria, unidade, produto_idproduto, receita_idreceita) VALUES (6, 0, 0, '', 'Lente visão simples CR39 Acabada e Surfassada', NULL, NULL, 555, 10, '', 'UN', 3, NULL);
INSERT INTO produtosselecionados (idprodutosselecionados, aliquotaicms, aliquotaipi, classificacaofiscal, descricao, identificador, precototal, precounitario, quantidade, situacaotributaria, unidade, produto_idproduto, receita_idreceita) VALUES (7, 0, 0, '', 'Lente visão simples CR39 Anti Reflexo - Acabada', NULL, NULL, 100, 10, '', 'UN', 4, NULL);
INSERT INTO produtosselecionados (idprodutosselecionados, aliquotaicms, aliquotaipi, classificacaofiscal, descricao, identificador, precototal, precounitario, quantidade, situacaotributaria, unidade, produto_idproduto, receita_idreceita) VALUES (8, 0, 0, '', 'Lente visão simples CR39 Acabada e Surfassada', NULL, NULL, 100, 10, '', 'UN', 3, NULL);

INSERT INTO compra_contapagar (compra_idcompra, contaspagar_idcontapagar) VALUES (2, 2);
INSERT INTO compra_contapagar (compra_idcompra, contaspagar_idcontapagar) VALUES (3, 3);

INSERT INTO compra_produtosselecionados (compra_idcompra, produtosselecionados_idprodutosselecionados) VALUES (2, 4);
INSERT INTO compra_produtosselecionados (compra_idcompra, produtosselecionados_idprodutosselecionados) VALUES (2, 5);
INSERT INTO compra_produtosselecionados (compra_idcompra, produtosselecionados_idprodutosselecionados) VALUES (3, 6);

INSERT INTO servicosselecionados (idservicosselecionados, descricao, preco, servico_idservico) VALUES (1, 'Anti-Reflexo', 250, 8);
INSERT INTO servicosselecionados (idservicosselecionados, descricao, preco, servico_idservico) VALUES (2, 'Surfaçagem', 100, 6);
INSERT INTO servicosselecionados (idservicosselecionados, descricao, preco, servico_idservico) VALUES (3, 'Video-Filter', 300, 11);

INSERT INTO receita_servicosselecionados (receita_idreceita, servicosselecionados_idservicosselecionados) VALUES (1, 1);
INSERT INTO receita_servicosselecionados (receita_idreceita, servicosselecionados_idservicosselecionados) VALUES (1, 2);
INSERT INTO receita_servicosselecionados (receita_idreceita, servicosselecionados_idservicosselecionados) VALUES (1, 3);

