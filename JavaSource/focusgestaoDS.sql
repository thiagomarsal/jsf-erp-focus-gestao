--
-- PostgreSQL database dump
--

-- Started on 2009-07-07 17:43:10

SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 2102 (class 0 OID 0)
-- Dependencies: 1577
-- Name: cargo_idcargo_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('cargo_idcargo_seq', 1, false);


--
-- TOC entry 2103 (class 0 OID 0)
-- Dependencies: 1579
-- Name: cidade_idcidade_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('cidade_idcidade_seq', 1, false);


--
-- TOC entry 2104 (class 0 OID 0)
-- Dependencies: 1581
-- Name: cliente_idcliente_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('cliente_idcliente_seq', 1, false);


--
-- TOC entry 2105 (class 0 OID 0)
-- Dependencies: 1583
-- Name: compra_idcompra_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('compra_idcompra_seq', 1, false);


--
-- TOC entry 2106 (class 0 OID 0)
-- Dependencies: 1587
-- Name: condicaopagamento_idcondicaopagamento_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('condicaopagamento_idcondicaopagamento_seq', 1, false);


--
-- TOC entry 2107 (class 0 OID 0)
-- Dependencies: 1589
-- Name: contapagar_idcontapagar_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('contapagar_idcontapagar_seq', 1, false);


--
-- TOC entry 2108 (class 0 OID 0)
-- Dependencies: 1591
-- Name: contareceber_idcontareceber_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('contareceber_idcontareceber_seq', 1, false);


--
-- TOC entry 2109 (class 0 OID 0)
-- Dependencies: 1593
-- Name: cor_idcor_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('cor_idcor_seq', 1, true);


--
-- TOC entry 2110 (class 0 OID 0)
-- Dependencies: 1595
-- Name: estado_idestado_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('estado_idestado_seq', 1, false);


--
-- TOC entry 2111 (class 0 OID 0)
-- Dependencies: 1597
-- Name: formapagamento_idformapagamento_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('formapagamento_idformapagamento_seq', 1, false);


--
-- TOC entry 2112 (class 0 OID 0)
-- Dependencies: 1599
-- Name: fornecedor_idfornecedor_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('fornecedor_idfornecedor_seq', 1, false);


--
-- TOC entry 2113 (class 0 OID 0)
-- Dependencies: 1601
-- Name: funcionario_idfuncionario_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('funcionario_idfuncionario_seq', 1, false);


--
-- TOC entry 2114 (class 0 OID 0)
-- Dependencies: 1603
-- Name: grupo_idgrupo_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('grupo_idgrupo_seq', 1, true);


--
-- TOC entry 2115 (class 0 OID 0)
-- Dependencies: 1605
-- Name: linha_idlinha_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('linha_idlinha_seq', 1, true);


--
-- TOC entry 2116 (class 0 OID 0)
-- Dependencies: 1607
-- Name: marca_idmarca_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('marca_idmarca_seq', 1, true);


--
-- TOC entry 2117 (class 0 OID 0)
-- Dependencies: 1609
-- Name: material_idmaterial_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('material_idmaterial_seq', 1, true);


--
-- TOC entry 2118 (class 0 OID 0)
-- Dependencies: 1611
-- Name: modelo_idmodelo_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('modelo_idmodelo_seq', 1, true);


--
-- TOC entry 2119 (class 0 OID 0)
-- Dependencies: 1613
-- Name: ordemservico_idordemservico_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('ordemservico_idordemservico_seq', 1, false);


--
-- TOC entry 2120 (class 0 OID 0)
-- Dependencies: 1617
-- Name: pais_idpais_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('pais_idpais_seq', 1, false);


--
-- TOC entry 2121 (class 0 OID 0)
-- Dependencies: 1619
-- Name: perfilacesso_idperfilacesso_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('perfilacesso_idperfilacesso_seq', 1, false);


--
-- TOC entry 2122 (class 0 OID 0)
-- Dependencies: 1621
-- Name: produto_idproduto_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('produto_idproduto_seq', 1, true);


--
-- TOC entry 2123 (class 0 OID 0)
-- Dependencies: 1623
-- Name: produtosselecionados_idprodutosselecionados_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('produtosselecionados_idprodutosselecionados_seq', 1, false);


--
-- TOC entry 2124 (class 0 OID 0)
-- Dependencies: 1625
-- Name: receita_idreceita_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('receita_idreceita_seq', 1, true);


--
-- TOC entry 2125 (class 0 OID 0)
-- Dependencies: 1628
-- Name: servico_idservico_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('servico_idservico_seq', 1, true);


--
-- TOC entry 2126 (class 0 OID 0)
-- Dependencies: 1630
-- Name: servicosselecionados_idservicosselecionados_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('servicosselecionados_idservicosselecionados_seq', 1, true);


--
-- TOC entry 2127 (class 0 OID 0)
-- Dependencies: 1632
-- Name: tipo_idtipo_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('tipo_idtipo_seq', 1, true);


--
-- TOC entry 2128 (class 0 OID 0)
-- Dependencies: 1634
-- Name: unidade_idunidade_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('unidade_idunidade_seq', 1, true);


--
-- TOC entry 2129 (class 0 OID 0)
-- Dependencies: 1636
-- Name: usuario_idusuario_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('usuario_idusuario_seq', 1, false);


--
-- TOC entry 2130 (class 0 OID 0)
-- Dependencies: 1638
-- Name: venda_idvenda_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('venda_idvenda_seq', 1, false);


--
-- TOC entry 2064 (class 0 OID 17494)
-- Dependencies: 1578
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY cargo (idcargo, descricao, status) FROM stdin;
\.


--
-- TOC entry 2065 (class 0 OID 17505)
-- Dependencies: 1580
-- Data for Name: cidade; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY cidade (idcidade, ddd, nome, idestado) FROM stdin;
\.


--
-- TOC entry 2066 (class 0 OID 17513)
-- Dependencies: 1582
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY cliente (idcliente, apelidonomefantasia, celular, cpfcnpj, dataatualizacao, datacadastro, email, bairro, cep, complemento, logradouro, numeropredial, fax, nomerazaosocial, obs, rginscricao, site, telefone, contato, datanascimento, estadocivil, sexo, idcidade) FROM stdin;
\.


--
-- TOC entry 2067 (class 0 OID 17524)
-- Dependencies: 1584
-- Data for Name: compra; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY compra (idcompra, baseicms, baseicmssubstituicao, dataemissao, dataentrada, desconto, numero, obs, outrasdespesas, serie, statuspedido, totalcompra, totalprodutos, valorfrete, valoricms, valoricmssubstituicao, valorseguro, valortotalipi, idcondicaopagamento, idfornecedor, idusuario) FROM stdin;
\.


--
-- TOC entry 2068 (class 0 OID 17530)
-- Dependencies: 1585
-- Data for Name: compra_contapagar; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY compra_contapagar (compra_idcompra, contaspagar_idcontapagar) FROM stdin;
\.


--
-- TOC entry 2069 (class 0 OID 17535)
-- Dependencies: 1586
-- Data for Name: compra_produtosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY compra_produtosselecionados (compra_idcompra, produtosselecionados_idprodutosselecionados) FROM stdin;
\.


--
-- TOC entry 2070 (class 0 OID 17542)
-- Dependencies: 1588
-- Data for Name: condicaopagamento; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY condicaopagamento (idcondicaopagamento, descricao, parcelas) FROM stdin;
\.


--
-- TOC entry 2071 (class 0 OID 17550)
-- Dependencies: 1590
-- Data for Name: contapagar; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY contapagar (idcontapagar, dataquitacao, datavencimento, desconto, juros, multa, numerodocumento, obs, statuscontas, valor, valorrecebido, compra_idcompra, idformapagamento, idfornecedor) FROM stdin;
\.


--
-- TOC entry 2072 (class 0 OID 17561)
-- Dependencies: 1592
-- Data for Name: contareceber; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY contareceber (idcontareceber, dataquitacao, datavencimento, desconto, juros, multa, numerodocumento, obs, statuscontas, valor, valorrecebido, idcliente, idformapagamento, ordemservico_idordemservico, venda_idvenda) FROM stdin;
\.


--
-- TOC entry 2073 (class 0 OID 17572)
-- Dependencies: 1594
-- Data for Name: cor; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY cor (idcor, descricao, status) FROM stdin;
1	Transparente	\N
\.


--
-- TOC entry 2074 (class 0 OID 17583)
-- Dependencies: 1596
-- Data for Name: estado; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY estado (idestado, nome, sigla, idpais) FROM stdin;
\.


--
-- TOC entry 2075 (class 0 OID 17591)
-- Dependencies: 1598
-- Data for Name: formapagamento; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY formapagamento (idformapagamento, descricao) FROM stdin;
\.


--
-- TOC entry 2076 (class 0 OID 17599)
-- Dependencies: 1600
-- Data for Name: fornecedor; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY fornecedor (idfornecedor, apelidonomefantasia, celular, cpfcnpj, dataatualizacao, datacadastro, email, bairro, cep, complemento, logradouro, numeropredial, fax, nomerazaosocial, obs, rginscricao, site, telefone, contato, idcidade) FROM stdin;
\.


--
-- TOC entry 2077 (class 0 OID 17610)
-- Dependencies: 1602
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY funcionario (idfuncionario, apelidonomefantasia, celular, cpfcnpj, dataatualizacao, datacadastro, email, bairro, cep, complemento, logradouro, numeropredial, fax, nomerazaosocial, obs, rginscricao, site, telefone, comissao, ctps, dataadmissao, datademissao, datanascimento, estadocivil, salario, sexo, idcargo, idcidade, idusuario) FROM stdin;
\.


--
-- TOC entry 2078 (class 0 OID 17621)
-- Dependencies: 1604
-- Data for Name: grupo; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY grupo (idgrupo, descricao, status) FROM stdin;
1	Grupo	\N
\.


--
-- TOC entry 2079 (class 0 OID 17632)
-- Dependencies: 1606
-- Data for Name: linha; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY linha (idlinha, descricao, status) FROM stdin;
1	Linha	\N
\.


--
-- TOC entry 2080 (class 0 OID 17643)
-- Dependencies: 1608
-- Data for Name: marca; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY marca (idmarca, descricao, status) FROM stdin;
1	Marca	\N
\.


--
-- TOC entry 2081 (class 0 OID 17654)
-- Dependencies: 1610
-- Data for Name: material; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY material (idmaterial, descricao, status) FROM stdin;
1	Material	\N
\.


--
-- TOC entry 2082 (class 0 OID 17665)
-- Dependencies: 1612
-- Data for Name: modelo; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY modelo (idmodelo, descricao, status) FROM stdin;
1	Modelo	\N
\.


--
-- TOC entry 2083 (class 0 OID 17676)
-- Dependencies: 1614
-- Data for Name: ordemservico; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY ordemservico (idordemservico, dataemissao, desconto, obs, statuspedido, totalservicos, totalvenda, idcliente, idcondicaopagamento, idusuario) FROM stdin;
\.


--
-- TOC entry 2084 (class 0 OID 17682)
-- Dependencies: 1615
-- Data for Name: ordemservico_contareceber; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY ordemservico_contareceber (ordemservico_idordemservico, contasreceber_idcontareceber) FROM stdin;
\.


--
-- TOC entry 2085 (class 0 OID 17687)
-- Dependencies: 1616
-- Data for Name: ordemservico_servicosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY ordemservico_servicosselecionados (ordemservico_idordemservico, servicosselecionados_idservicosselecionados) FROM stdin;
\.


--
-- TOC entry 2086 (class 0 OID 17694)
-- Dependencies: 1618
-- Data for Name: pais; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY pais (idpais, ddi, nome, sigla) FROM stdin;
\.


--
-- TOC entry 2087 (class 0 OID 17708)
-- Dependencies: 1620
-- Data for Name: perfilacesso; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY perfilacesso (idperfilacesso, descricao, status) FROM stdin;
\.


--
-- TOC entry 2088 (class 0 OID 17719)
-- Dependencies: 1622
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY produto (idproduto, acrescimo, descricao, estoque, obs, precocusto, precovenda, referencia, idcor, idgrupo, idlinha, idmarca, idmaterial, idmodelo, idtipo, idunidade) FROM stdin;
1	0	produto	0	produto Teste	0	0	234	1	1	1	1	1	1	1	1
\.


--
-- TOC entry 2089 (class 0 OID 17727)
-- Dependencies: 1624
-- Data for Name: produtosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY produtosselecionados (idprodutosselecionados, aliquotaicms, aliquotaipi, classificacaofiscal, descricao, precototal, precounitario, quantidade, situacaotributaria, unidade, produto_idproduto, receita_idproduto) FROM stdin;
\.


--
-- TOC entry 2090 (class 0 OID 17735)
-- Dependencies: 1626
-- Data for Name: receita; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY receita (idreceita, curva, descricao, diametro, eixo, espessura, obs, olho, precovenda, totalservicos) FROM stdin;
1	1	tetetetet	1	1	1	dfsdfsdf	Direito	45	45
\.


--
-- TOC entry 2091 (class 0 OID 17741)
-- Dependencies: 1627
-- Data for Name: receita_servicosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY receita_servicosselecionados (receita_idreceita, servicosselecionados_idservicosselecionados) FROM stdin;
1	1
\.


--
-- TOC entry 2092 (class 0 OID 17748)
-- Dependencies: 1629
-- Data for Name: servico; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY servico (idservico, descricao, obs, preco) FROM stdin;
1	sdsdsdsdsd	dsdsdsd	45
\.


--
-- TOC entry 2093 (class 0 OID 17756)
-- Dependencies: 1631
-- Data for Name: servicosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY servicosselecionados (idservicosselecionados, descricao, preco, servico_idservico) FROM stdin;
1	sdsdsdsdsd	45	1
\.


--
-- TOC entry 2094 (class 0 OID 17764)
-- Dependencies: 1633
-- Data for Name: tipo; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY tipo (idtipo, descricao, status) FROM stdin;
1	Tipo	\N
\.


--
-- TOC entry 2095 (class 0 OID 17775)
-- Dependencies: 1635
-- Data for Name: unidade; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY unidade (idunidade, descricao, status, sigla) FROM stdin;
1	Unidade	\N	\N
\.


--
-- TOC entry 2096 (class 0 OID 17786)
-- Dependencies: 1637
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY usuario (idusuario, login, senha, idperfilacesso) FROM stdin;
\.


--
-- TOC entry 2097 (class 0 OID 17794)
-- Dependencies: 1639
-- Data for Name: venda; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY venda (idvenda, dataemissao, desconto, obs, statuspedido, totalprodutos, totalvenda, idcliente, idcondicaopagamento, idusuario) FROM stdin;
\.


--
-- TOC entry 2098 (class 0 OID 17800)
-- Dependencies: 1640
-- Data for Name: venda_contareceber; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY venda_contareceber (venda_idvenda, contasreceber_idcontareceber) FROM stdin;
\.


--
-- TOC entry 2099 (class 0 OID 17805)
-- Dependencies: 1641
-- Data for Name: venda_produtosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--

COPY venda_produtosselecionados (venda_idvenda, produtosselecionados_idprodutosselecionados) FROM stdin;
\.


-- Completed on 2009-07-07 17:43:11

--
-- PostgreSQL database dump complete
--

