--
-- PostgreSQL database dump
--

SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- Name: cargo_idcargo_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('cargo_idcargo_seq', 7, true);


--
-- Name: cidade_idcidade_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('cidade_idcidade_seq', 5, true);


--
-- Name: cliente_idcliente_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('cliente_idcliente_seq', 2, true);


--
-- Name: compra_idcompra_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('compra_idcompra_seq', 1, false);


--
-- Name: condicaopagamento_idcondicaopagamento_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('condicaopagamento_idcondicaopagamento_seq', 4, true);


--
-- Name: contapagar_idcontapagar_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('contapagar_idcontapagar_seq', 1, false);


--
-- Name: contareceber_idcontareceber_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('contareceber_idcontareceber_seq', 1, false);


--
-- Name: cor_idcor_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('cor_idcor_seq', 13, true);


--
-- Name: estado_idestado_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('estado_idestado_seq', 7, true);


--
-- Name: formapagamento_idformapagamento_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('formapagamento_idformapagamento_seq', 6, true);


--
-- Name: fornecedor_idfornecedor_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('fornecedor_idfornecedor_seq', 1, true);


--
-- Name: funcionario_idfuncionario_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('funcionario_idfuncionario_seq', 1, true);


--
-- Name: grupo_idgrupo_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('grupo_idgrupo_seq', 9, true);


--
-- Name: linha_idlinha_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('linha_idlinha_seq', 9, true);


--
-- Name: marca_idmarca_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('marca_idmarca_seq', 12, true);


--
-- Name: material_idmaterial_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('material_idmaterial_seq', 14, true);


--
-- Name: modelo_idmodelo_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('modelo_idmodelo_seq', 7, true);


--
-- Name: ordemservico_idordemservico_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('ordemservico_idordemservico_seq', 1, false);


--
-- Name: pais_idpais_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('pais_idpais_seq', 3, true);


--
-- Name: perfilacesso_idperfilacesso_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('perfilacesso_idperfilacesso_seq', 4, true);


--
-- Name: produto_idproduto_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('produto_idproduto_seq', 5, true);


--
-- Name: produtosselecionados_idprodutosselecionados_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('produtosselecionados_idprodutosselecionados_seq', 1, false);


--
-- Name: receita_idreceita_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('receita_idreceita_seq', 1, true);


--
-- Name: servico_idservico_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('servico_idservico_seq', 15, true);


--
-- Name: servicosselecionados_idservicosselecionados_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('servicosselecionados_idservicosselecionados_seq', 3, true);


--
-- Name: tipo_idtipo_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('tipo_idtipo_seq', 5, true);


--
-- Name: unidade_idunidade_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('unidade_idunidade_seq', 4, true);


--
-- Name: usuario_idusuario_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('usuario_idusuario_seq', 5, true);


--
-- Name: venda_idvenda_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('venda_idvenda_seq', 1, false);


--
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE cargo DISABLE TRIGGER ALL;

INSERT INTO cargo (idcargo, descricao, status) VALUES (1, 'Gerente', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (2, 'Vendedor', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (3, 'Caixa', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (4, 'Zelador', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (5, 'Seguran??a', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (7, 'Est??giario', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (6, 'Assistente', NULL);


ALTER TABLE cargo ENABLE TRIGGER ALL;

--
-- Data for Name: cidade; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE cidade DISABLE TRIGGER ALL;

INSERT INTO cidade (idcidade, ddd, nome, idestado) VALUES (1, '45', 'Foz do Igua??u', 1);
INSERT INTO cidade (idcidade, ddd, nome, idestado) VALUES (2, '45', 'Santa Teresinha de Itaipu', 1);
INSERT INTO cidade (idcidade, ddd, nome, idestado) VALUES (3, '45', 'Cascavel', 1);
INSERT INTO cidade (idcidade, ddd, nome, idestado) VALUES (4, '41', 'Curitiba', 1);
INSERT INTO cidade (idcidade, ddd, nome, idestado) VALUES (5, '51', 'Porto Alegre', 3);


ALTER TABLE cidade ENABLE TRIGGER ALL;

--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE cliente DISABLE TRIGGER ALL;

INSERT INTO cliente (idcliente, apelidonomefantasia, celular, cpfcnpj, dataatualizacao, datacadastro, email, bairro, cep, complemento, logradouro, numeropredial, fax, nomerazaosocial, obs, rginscricao, site, telefone, contato, datanascimento, estadocivil, sexo, idcidade) VALUES (2, NULL, '99496507', '02898478938', '2009-07-08', '2009-07-08', '', 'vila Portes', '85865010', 'Casa', 'rua Portinari', '658', NULL, 'Marciana Ramirez Silva', '', '69341861', NULL, '30256247', NULL, '1959-06-12', 'Casado', 'Feminino', 1);
INSERT INTO cliente (idcliente, apelidonomefantasia, celular, cpfcnpj, dataatualizacao, datacadastro, email, bairro, cep, complemento, logradouro, numeropredial, fax, nomerazaosocial, obs, rginscricao, site, telefone, contato, datanascimento, estadocivil, sexo, idcidade) VALUES (1, NULL, '99380635', '02898478938', '2009-07-08', '2009-07-08', 'izaiza_iza@hotmail.com', 'Centro', '85865010', 'Edificio Fontane Blue apto. 1201', 'Rua Almirante Barroso', '123', NULL, 'Izaura Giroldo', 'Pr??ximo ao Fisk', '69341861', NULL, '35729384', NULL, '1967-11-21', 'Uni??o Estavel', 'Feminino', 1);


ALTER TABLE cliente ENABLE TRIGGER ALL;

--
-- Data for Name: compra; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE compra DISABLE TRIGGER ALL;



ALTER TABLE compra ENABLE TRIGGER ALL;

--
-- Data for Name: compra_contapagar; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE compra_contapagar DISABLE TRIGGER ALL;



ALTER TABLE compra_contapagar ENABLE TRIGGER ALL;

--
-- Data for Name: compra_produtosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE compra_produtosselecionados DISABLE TRIGGER ALL;



ALTER TABLE compra_produtosselecionados ENABLE TRIGGER ALL;

--
-- Data for Name: condicaopagamento; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE condicaopagamento DISABLE TRIGGER ALL;

INSERT INTO condicaopagamento (idcondicaopagamento, descricao, parcelas) VALUES (1, 'A vista', 0);
INSERT INTO condicaopagamento (idcondicaopagamento, descricao, parcelas) VALUES (2, '1 + 1', 2);
INSERT INTO condicaopagamento (idcondicaopagamento, descricao, parcelas) VALUES (3, '1 + 2', 3);
INSERT INTO condicaopagamento (idcondicaopagamento, descricao, parcelas) VALUES (4, '1 + 5', 6);


ALTER TABLE condicaopagamento ENABLE TRIGGER ALL;

--
-- Data for Name: contapagar; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE contapagar DISABLE TRIGGER ALL;



ALTER TABLE contapagar ENABLE TRIGGER ALL;

--
-- Data for Name: contareceber; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE contareceber DISABLE TRIGGER ALL;



ALTER TABLE contareceber ENABLE TRIGGER ALL;

--
-- Data for Name: cor; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE cor DISABLE TRIGGER ALL;

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


ALTER TABLE cor ENABLE TRIGGER ALL;

--
-- Data for Name: estado; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE estado DISABLE TRIGGER ALL;

INSERT INTO estado (idestado, nome, sigla, idpais) VALUES (1, 'Paran??', 'PR', 1);
INSERT INTO estado (idestado, nome, sigla, idpais) VALUES (2, 'Santa Catarina', 'SC', 1);
INSERT INTO estado (idestado, nome, sigla, idpais) VALUES (3, 'Rio Grande do Sul', 'RS', 1);
INSERT INTO estado (idestado, nome, sigla, idpais) VALUES (4, 'S??o Paulo', 'SP', 1);
INSERT INTO estado (idestado, nome, sigla, idpais) VALUES (5, 'Rio de Janeiro', 'RJ', 1);
INSERT INTO estado (idestado, nome, sigla, idpais) VALUES (6, 'Mato Grosso do Sul', 'MS', 1);
INSERT INTO estado (idestado, nome, sigla, idpais) VALUES (7, 'Mato Grosso', 'MT', 1);


ALTER TABLE estado ENABLE TRIGGER ALL;

--
-- Data for Name: formapagamento; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE formapagamento DISABLE TRIGGER ALL;

INSERT INTO formapagamento (idformapagamento, descricao) VALUES (1, 'Dinheiro');
INSERT INTO formapagamento (idformapagamento, descricao) VALUES (2, 'Cheque');
INSERT INTO formapagamento (idformapagamento, descricao) VALUES (3, 'Cart??o D??bito');
INSERT INTO formapagamento (idformapagamento, descricao) VALUES (4, 'Cart??o Cr??dito');
INSERT INTO formapagamento (idformapagamento, descricao) VALUES (6, 'Boleto Banc??rio');
INSERT INTO formapagamento (idformapagamento, descricao) VALUES (5, 'Promiss??ria');


ALTER TABLE formapagamento ENABLE TRIGGER ALL;

--
-- Data for Name: fornecedor; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE fornecedor DISABLE TRIGGER ALL;

INSERT INTO fornecedor (idfornecedor, apelidonomefantasia, celular, cpfcnpj, dataatualizacao, datacadastro, email, bairro, cep, complemento, logradouro, numeropredial, fax, nomerazaosocial, obs, rginscricao, site, telefone, contato, idcidade) VALUES (1, 'Visolux', '', '07904134000186', '2009-07-08', '2009-07-08', '', 'Juveve', '80040310', '', 'rua Augusto Stresser', '1350', '', '??tica Visolux', '', 'Isento', '', '33624440', 'Augusto', 4);


ALTER TABLE fornecedor ENABLE TRIGGER ALL;

--
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE funcionario DISABLE TRIGGER ALL;

INSERT INTO funcionario (idfuncionario, apelidonomefantasia, celular, cpfcnpj, dataatualizacao, datacadastro, email, bairro, cep, complemento, logradouro, numeropredial, fax, nomerazaosocial, obs, rginscricao, site, telefone, comissao, ctps, dataadmissao, datademissao, datanascimento, estadocivil, salario, sexo, idcargo, idcidade, idusuario) VALUES (1, NULL, '99380635', '02898478938', '2009-07-08', '2009-07-08', 'jose@gmail.com', 'vila Portes', '85865010', '', 'rua Portinari', '658', NULL, 'Jos?? Arnildo Silva Neto', '', '69341861', NULL, '30256247', 0, '12345678919', '2008-06-02', NULL, '1980-02-11', 'Uni??o Estavel', 2000, 'Masculino', 6, 1, 1);


ALTER TABLE funcionario ENABLE TRIGGER ALL;

--
-- Data for Name: grupo; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE grupo DISABLE TRIGGER ALL;

INSERT INTO grupo (idgrupo, descricao, status) VALUES (1, 'Lentes', NULL);
INSERT INTO grupo (idgrupo, descricao, status) VALUES (2, 'Arma????es', NULL);
INSERT INTO grupo (idgrupo, descricao, status) VALUES (3, '??culos', NULL);
INSERT INTO grupo (idgrupo, descricao, status) VALUES (4, 'Parafusos', NULL);
INSERT INTO grupo (idgrupo, descricao, status) VALUES (7, 'J??ias', NULL);
INSERT INTO grupo (idgrupo, descricao, status) VALUES (8, 'Rel??gios', NULL);
INSERT INTO grupo (idgrupo, descricao, status) VALUES (9, 'Bloco', NULL);


ALTER TABLE grupo ENABLE TRIGGER ALL;

--
-- Data for Name: linha; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE linha DISABLE TRIGGER ALL;

INSERT INTO linha (idlinha, descricao, status) VALUES (1, 'Infantil', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (2, 'Solar Masculino', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (3, 'Solar Feminino', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (4, 'Masculino', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (5, 'Feminino', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (6, 'Unissex', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (7, 'Esporte', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (8, 'Receitu??rio', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (9, 'Solar', NULL);


ALTER TABLE linha ENABLE TRIGGER ALL;

--
-- Data for Name: marca; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE marca DISABLE TRIGGER ALL;

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


ALTER TABLE marca ENABLE TRIGGER ALL;

--
-- Data for Name: material; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE material DISABLE TRIGGER ALL;

INSERT INTO material (idmaterial, descricao, status) VALUES (1, 'Metal', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (2, 'Acetato', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (3, 'Nylon', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (4, 'Fibra', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (5, 'A??o', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (6, 'Clypon', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (7, 'Orma', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (8, 'Descart??vel', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (9, 'CR39', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (10, 'Policarbonato', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (11, 'Cristal', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (12, 'Cristal Alto ??ndice', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (13, 'Resina M??dio ??ndice', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (14, 'Resina Alto ??ndice', NULL);


ALTER TABLE material ENABLE TRIGGER ALL;

--
-- Data for Name: modelo; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE modelo DISABLE TRIGGER ALL;

INSERT INTO modelo (idmodelo, descricao, status) VALUES (1, 'Acabada', NULL);
INSERT INTO modelo (idmodelo, descricao, status) VALUES (7, 'Acabada - Anti Reflexo', NULL);
INSERT INTO modelo (idmodelo, descricao, status) VALUES (6, 'Acabada e Surfassada', NULL);
INSERT INTO modelo (idmodelo, descricao, status) VALUES (5, 'Fotocrom??tica', NULL);
INSERT INTO modelo (idmodelo, descricao, status) VALUES (3, 'Sufassada', NULL);
INSERT INTO modelo (idmodelo, descricao, status) VALUES (2, 'Anti Reflexo', NULL);


ALTER TABLE modelo ENABLE TRIGGER ALL;

--
-- Data for Name: ordemservico; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE ordemservico DISABLE TRIGGER ALL;



ALTER TABLE ordemservico ENABLE TRIGGER ALL;

--
-- Data for Name: ordemservico_contareceber; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE ordemservico_contareceber DISABLE TRIGGER ALL;



ALTER TABLE ordemservico_contareceber ENABLE TRIGGER ALL;

--
-- Data for Name: ordemservico_servicosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE ordemservico_servicosselecionados DISABLE TRIGGER ALL;



ALTER TABLE ordemservico_servicosselecionados ENABLE TRIGGER ALL;

--
-- Data for Name: pais; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE pais DISABLE TRIGGER ALL;

INSERT INTO pais (idpais, ddi, nome, sigla) VALUES (1, '55', 'Brasil', 'BR');
INSERT INTO pais (idpais, ddi, nome, sigla) VALUES (2, '21', 'Paraguai', 'PY');
INSERT INTO pais (idpais, ddi, nome, sigla) VALUES (3, '22', 'Argentina', 'AR');


ALTER TABLE pais ENABLE TRIGGER ALL;

--
-- Data for Name: perfilacesso; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE perfilacesso DISABLE TRIGGER ALL;

INSERT INTO perfilacesso (idperfilacesso, descricao, status) VALUES (1, 'Gerente', NULL);
INSERT INTO perfilacesso (idperfilacesso, descricao, status) VALUES (2, 'Vendedor', NULL);
INSERT INTO perfilacesso (idperfilacesso, descricao, status) VALUES (3, 'Caixa', NULL);
INSERT INTO perfilacesso (idperfilacesso, descricao, status) VALUES (4, 'Administrador', NULL);


ALTER TABLE perfilacesso ENABLE TRIGGER ALL;

--
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE produto DISABLE TRIGGER ALL;

INSERT INTO produto (idproduto, acrescimo, descricao, estoque, obs, precocusto, precovenda, referencia, idcor, idgrupo, idlinha, idmarca, idmaterial, idmodelo, idtipo, idunidade) VALUES (3, 40, 'Lente vis??o simples CR39 Acabada e Surfassada', 0, 'Lente pronta', 0, 0, 'LVSCR39-AS', 2, 1, 8, 9, 9, 6, 2, 1);
INSERT INTO produto (idproduto, acrescimo, descricao, estoque, obs, precocusto, precovenda, referencia, idcor, idgrupo, idlinha, idmarca, idmaterial, idmodelo, idtipo, idunidade) VALUES (4, 40, 'Lente vis??o simples CR39 Anti Reflexo - Acabada', 0, '', 0, 0, 'LVSCR39-ARA', 2, 1, 8, 9, 9, 7, 2, 1);
INSERT INTO produto (idproduto, acrescimo, descricao, estoque, obs, precocusto, precovenda, referencia, idcor, idgrupo, idlinha, idmarca, idmaterial, idmodelo, idtipo, idunidade) VALUES (5, 40, 'Lentes vis??o simples Transitions - Acabada e Surfassada', NULL, '', NULL, 0, 'LVST-AS', 2, 1, 8, 10, 10, 6, 2, 1);


ALTER TABLE produto ENABLE TRIGGER ALL;

--
-- Data for Name: produtosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE produtosselecionados DISABLE TRIGGER ALL;



ALTER TABLE produtosselecionados ENABLE TRIGGER ALL;

--
-- Data for Name: receita; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE receita DISABLE TRIGGER ALL;

INSERT INTO receita (idreceita, curva, descricao, diametro, eixo, espessura, obs, olho, precovenda, totalservicos) VALUES (1, 1, 'Receita Jo??o', 2.5, 1.5, 1, 'Doutor: Fulano de Tal
Cliente: Jo??o da Silva', 'N??o Considerar', 650, 650);


ALTER TABLE receita ENABLE TRIGGER ALL;

--
-- Data for Name: receita_servicosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE receita_servicosselecionados DISABLE TRIGGER ALL;

INSERT INTO receita_servicosselecionados (receita_idreceita, servicosselecionados_idservicosselecionados) VALUES (1, 1);
INSERT INTO receita_servicosselecionados (receita_idreceita, servicosselecionados_idservicosselecionados) VALUES (1, 2);
INSERT INTO receita_servicosselecionados (receita_idreceita, servicosselecionados_idservicosselecionados) VALUES (1, 3);


ALTER TABLE receita_servicosselecionados ENABLE TRIGGER ALL;

--
-- Data for Name: servico; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE servico DISABLE TRIGGER ALL;

INSERT INTO servico (idservico, descricao, obs, preco) VALUES (1, 'Troca de Hastes', 'sem a haste', 5);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (2, 'Troca de ponteiras', '', 5);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (3, 'Troca de Plaquetas', '', 5);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (4, 'Solda', '', 10);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (5, 'Ajuste de Arma????o', '', 50);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (6, 'Surfa??agem', '', 100);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (7, 'Montagem', '', 50);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (8, 'Anti-Reflexo', '', 250);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (9, 'Colora????o', '', 80);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (10, 'Anti-Risco', '', 150);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (11, 'Video-Filter', 'Para usu??rios de Computador', 300);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (12, 'UV-400', 'Prote????o de Raios UltraVioleta', 500);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (13, 'Flash', 'Um leve toque espelhado na lente colorida.', 300);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (14, 'Blue Black', 'Para pessoas com degenera????o macular.', 450);
INSERT INTO servico (idservico, descricao, obs, preco) VALUES (15, 'Hard Coating', 'Anti-risco face interna e externa', 600);


ALTER TABLE servico ENABLE TRIGGER ALL;

--
-- Data for Name: servicosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE servicosselecionados DISABLE TRIGGER ALL;

INSERT INTO servicosselecionados (idservicosselecionados, descricao, preco, servico_idservico) VALUES (1, 'Anti-Reflexo', 250, 8);
INSERT INTO servicosselecionados (idservicosselecionados, descricao, preco, servico_idservico) VALUES (2, 'Surfa??agem', 100, 6);
INSERT INTO servicosselecionados (idservicosselecionados, descricao, preco, servico_idservico) VALUES (3, 'Video-Filter', 300, 11);


ALTER TABLE servicosselecionados ENABLE TRIGGER ALL;

--
-- Data for Name: tipo; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE tipo DISABLE TRIGGER ALL;

INSERT INTO tipo (idtipo, descricao, status) VALUES (1, 'Monofocal', NULL);
INSERT INTO tipo (idtipo, descricao, status) VALUES (5, 'Monofocal Solar', NULL);
INSERT INTO tipo (idtipo, descricao, status) VALUES (4, 'Multifocal', NULL);
INSERT INTO tipo (idtipo, descricao, status) VALUES (3, 'Bifocal', NULL);
INSERT INTO tipo (idtipo, descricao, status) VALUES (2, 'Vis??o Simples', NULL);


ALTER TABLE tipo ENABLE TRIGGER ALL;

--
-- Data for Name: unidade; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE unidade DISABLE TRIGGER ALL;

INSERT INTO unidade (idunidade, descricao, status, sigla) VALUES (1, 'Unidade', NULL, 'UN');
INSERT INTO unidade (idunidade, descricao, status, sigla) VALUES (2, 'Pe??a', NULL, 'P??');
INSERT INTO unidade (idunidade, descricao, status, sigla) VALUES (3, 'Par', NULL, 'PR');
INSERT INTO unidade (idunidade, descricao, status, sigla) VALUES (4, 'D??zia', NULL, 'DZ');


ALTER TABLE unidade ENABLE TRIGGER ALL;

--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE usuario DISABLE TRIGGER ALL;

INSERT INTO usuario (idusuario, login, senha, idperfilacesso) VALUES (1, 'jose', '81dc9bdb52d04dc20036dbd8313ed055', 4);
INSERT INTO usuario (idusuario, login, senha, idperfilacesso) VALUES (2, 'edinelson', '81dc9bdb52d04dc20036dbd8313ed055', 1);
INSERT INTO usuario (idusuario, login, senha, idperfilacesso) VALUES (3, 'edna', '81dc9bdb52d04dc20036dbd8313ed055', 1);
INSERT INTO usuario (idusuario, login, senha, idperfilacesso) VALUES (4, 'paulo', '81dc9bdb52d04dc20036dbd8313ed055', 2);
INSERT INTO usuario (idusuario, login, senha, idperfilacesso) VALUES (5, 'carla', '81dc9bdb52d04dc20036dbd8313ed055', 3);


ALTER TABLE usuario ENABLE TRIGGER ALL;

--
-- Data for Name: venda; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE venda DISABLE TRIGGER ALL;



ALTER TABLE venda ENABLE TRIGGER ALL;

--
-- Data for Name: venda_contareceber; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE venda_contareceber DISABLE TRIGGER ALL;



ALTER TABLE venda_contareceber ENABLE TRIGGER ALL;

--
-- Data for Name: venda_produtosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--

ALTER TABLE venda_produtosselecionados DISABLE TRIGGER ALL;



ALTER TABLE venda_produtosselecionados ENABLE TRIGGER ALL;

--
-- PostgreSQL database dump complete
--

