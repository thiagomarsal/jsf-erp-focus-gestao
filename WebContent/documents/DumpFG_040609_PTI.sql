--
-- PostgreSQL database dump
--

-- Started on 2009-06-04 17:44:52

SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 2104 (class 0 OID 0)
-- Dependencies: 1577
-- Name: caracteristica_idcaracteristica_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('caracteristica_idcaracteristica_seq', 12, true);


--
-- TOC entry 2105 (class 0 OID 0)
-- Dependencies: 1579
-- Name: cargo_idcargo_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('cargo_idcargo_seq', 6, true);


--
-- TOC entry 2106 (class 0 OID 0)
-- Dependencies: 1581
-- Name: cidade_idcidade_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('cidade_idcidade_seq', 1, false);


--
-- TOC entry 2107 (class 0 OID 0)
-- Dependencies: 1583
-- Name: cliente_idcliente_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('cliente_idcliente_seq', 1, false);


--
-- TOC entry 2108 (class 0 OID 0)
-- Dependencies: 1585
-- Name: compra_idcompra_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('compra_idcompra_seq', 1, false);


--
-- TOC entry 2109 (class 0 OID 0)
-- Dependencies: 1589
-- Name: condicaopagamento_idcondicaopagamento_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('condicaopagamento_idcondicaopagamento_seq', 1, false);


--
-- TOC entry 2110 (class 0 OID 0)
-- Dependencies: 1591
-- Name: contapagar_idcontapagar_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('contapagar_idcontapagar_seq', 1, false);


--
-- TOC entry 2111 (class 0 OID 0)
-- Dependencies: 1593
-- Name: contareceber_idcontareceber_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('contareceber_idcontareceber_seq', 1, false);


--
-- TOC entry 2112 (class 0 OID 0)
-- Dependencies: 1595
-- Name: cor_idcor_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('cor_idcor_seq', 7, true);


--
-- TOC entry 2113 (class 0 OID 0)
-- Dependencies: 1597
-- Name: estado_idestado_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('estado_idestado_seq', 1, false);


--
-- TOC entry 2114 (class 0 OID 0)
-- Dependencies: 1599
-- Name: formapagamento_idformapagamento_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('formapagamento_idformapagamento_seq', 1, false);


--
-- TOC entry 2115 (class 0 OID 0)
-- Dependencies: 1601
-- Name: fornecedor_idfornecedor_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('fornecedor_idfornecedor_seq', 1, false);


--
-- TOC entry 2116 (class 0 OID 0)
-- Dependencies: 1603
-- Name: funcionario_idfuncionario_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('funcionario_idfuncionario_seq', 1, false);


--
-- TOC entry 2117 (class 0 OID 0)
-- Dependencies: 1605
-- Name: grupo_idgrupo_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('grupo_idgrupo_seq', 3, true);


--
-- TOC entry 2118 (class 0 OID 0)
-- Dependencies: 1607
-- Name: lentebloco_idlentebloco_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('lentebloco_idlentebloco_seq', 1, false);


--
-- TOC entry 2119 (class 0 OID 0)
-- Dependencies: 1610
-- Name: linha_idlinha_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('linha_idlinha_seq', 3, true);


--
-- TOC entry 2120 (class 0 OID 0)
-- Dependencies: 1612
-- Name: marca_idmarca_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('marca_idmarca_seq', 3, true);


--
-- TOC entry 2121 (class 0 OID 0)
-- Dependencies: 1614
-- Name: material_idmaterial_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('material_idmaterial_seq', 4, true);


--
-- TOC entry 2122 (class 0 OID 0)
-- Dependencies: 1616
-- Name: ordemservico_idordemservico_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('ordemservico_idordemservico_seq', 1, false);


--
-- TOC entry 2123 (class 0 OID 0)
-- Dependencies: 1620
-- Name: pais_idpais_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('pais_idpais_seq', 5, true);


--
-- TOC entry 2124 (class 0 OID 0)
-- Dependencies: 1622
-- Name: perfil_idperfil_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('perfil_idperfil_seq', 5, true);


--
-- TOC entry 2125 (class 0 OID 0)
-- Dependencies: 1624
-- Name: perfilacesso_idperfilacesso_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('perfilacesso_idperfilacesso_seq', 1, false);


--
-- TOC entry 2126 (class 0 OID 0)
-- Dependencies: 1626
-- Name: produto_idproduto_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('produto_idproduto_seq', 1, false);


--
-- TOC entry 2127 (class 0 OID 0)
-- Dependencies: 1628
-- Name: produtosselecionados_idprodutosselecionados_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('produtosselecionados_idprodutosselecionados_seq', 1, false);


--
-- TOC entry 2128 (class 0 OID 0)
-- Dependencies: 1630
-- Name: servico_idservico_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('servico_idservico_seq', 1, false);


--
-- TOC entry 2129 (class 0 OID 0)
-- Dependencies: 1632
-- Name: servicosselecionados_idservicosselecionados_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('servicosselecionados_idservicosselecionados_seq', 1, false);


--
-- TOC entry 2130 (class 0 OID 0)
-- Dependencies: 1634
-- Name: tipo_idtipo_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('tipo_idtipo_seq', 4, true);


--
-- TOC entry 2131 (class 0 OID 0)
-- Dependencies: 1636
-- Name: usuario_idusuario_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('usuario_idusuario_seq', 1, false);


--
-- TOC entry 2132 (class 0 OID 0)
-- Dependencies: 1638
-- Name: venda_idvenda_seq; Type: SEQUENCE SET; Schema: public; Owner: focususer
--

SELECT pg_catalog.setval('venda_idvenda_seq', 1, false);


--
-- TOC entry 2066 (class 0 OID 16399)
-- Dependencies: 1578
-- Data for Name: caracteristica; Type: TABLE DATA; Schema: public; Owner: focususer
--

INSERT INTO caracteristica (idcaracteristica, descricao, status) VALUES (1, 'Característica', NULL);
INSERT INTO caracteristica (idcaracteristica, descricao, status) VALUES (2, 'c2', NULL);
INSERT INTO caracteristica (idcaracteristica, descricao, status) VALUES (3, 'c3', NULL);
INSERT INTO caracteristica (idcaracteristica, descricao, status) VALUES (4, 'c4', NULL);
INSERT INTO caracteristica (idcaracteristica, descricao, status) VALUES (5, 'c5', NULL);
INSERT INTO caracteristica (idcaracteristica, descricao, status) VALUES (6, 'c6', NULL);
INSERT INTO caracteristica (idcaracteristica, descricao, status) VALUES (7, 'c7', NULL);
INSERT INTO caracteristica (idcaracteristica, descricao, status) VALUES (8, 'c8', NULL);
INSERT INTO caracteristica (idcaracteristica, descricao, status) VALUES (9, 'c9', NULL);
INSERT INTO caracteristica (idcaracteristica, descricao, status) VALUES (10, 'c10', NULL);
INSERT INTO caracteristica (idcaracteristica, descricao, status) VALUES (12, 'c11', NULL);


--
-- TOC entry 2067 (class 0 OID 16410)
-- Dependencies: 1580
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: focususer
--

INSERT INTO cargo (idcargo, descricao, status) VALUES (1, 'Cargo', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (2, 'c2', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (3, 'c3', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (4, 'c4', NULL);
INSERT INTO cargo (idcargo, descricao, status) VALUES (6, 'c5', NULL);


--
-- TOC entry 2068 (class 0 OID 16421)
-- Dependencies: 1582
-- Data for Name: cidade; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2069 (class 0 OID 16429)
-- Dependencies: 1584
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2070 (class 0 OID 16440)
-- Dependencies: 1586
-- Data for Name: compra; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2071 (class 0 OID 16446)
-- Dependencies: 1587
-- Data for Name: compra_contapagar; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2072 (class 0 OID 16451)
-- Dependencies: 1588
-- Data for Name: compra_produtosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2073 (class 0 OID 16458)
-- Dependencies: 1590
-- Data for Name: condicaopagamento; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2074 (class 0 OID 16466)
-- Dependencies: 1592
-- Data for Name: contapagar; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2075 (class 0 OID 16477)
-- Dependencies: 1594
-- Data for Name: contareceber; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2076 (class 0 OID 16488)
-- Dependencies: 1596
-- Data for Name: cor; Type: TABLE DATA; Schema: public; Owner: focususer
--

INSERT INTO cor (idcor, descricao, status) VALUES (1, 'Branco', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (2, 'c2', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (3, 'c3', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (4, 'c4', NULL);
INSERT INTO cor (idcor, descricao, status) VALUES (5, 'c5', NULL);


--
-- TOC entry 2077 (class 0 OID 16499)
-- Dependencies: 1598
-- Data for Name: estado; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2078 (class 0 OID 16507)
-- Dependencies: 1600
-- Data for Name: formapagamento; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2079 (class 0 OID 16515)
-- Dependencies: 1602
-- Data for Name: fornecedor; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2080 (class 0 OID 16526)
-- Dependencies: 1604
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2081 (class 0 OID 16537)
-- Dependencies: 1606
-- Data for Name: grupo; Type: TABLE DATA; Schema: public; Owner: focususer
--

INSERT INTO grupo (idgrupo, descricao, status) VALUES (1, 'Grupo', NULL);
INSERT INTO grupo (idgrupo, descricao, status) VALUES (2, 'g2', NULL);


--
-- TOC entry 2082 (class 0 OID 16548)
-- Dependencies: 1608
-- Data for Name: lentebloco; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2083 (class 0 OID 16554)
-- Dependencies: 1609
-- Data for Name: lentebloco_servicosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2084 (class 0 OID 16561)
-- Dependencies: 1611
-- Data for Name: linha; Type: TABLE DATA; Schema: public; Owner: focususer
--

INSERT INTO linha (idlinha, descricao, status) VALUES (1, 'Linha', NULL);
INSERT INTO linha (idlinha, descricao, status) VALUES (2, 'l2', NULL);


--
-- TOC entry 2085 (class 0 OID 16572)
-- Dependencies: 1613
-- Data for Name: marca; Type: TABLE DATA; Schema: public; Owner: focususer
--

INSERT INTO marca (idmarca, descricao, status) VALUES (1, 'Marca', NULL);
INSERT INTO marca (idmarca, descricao, status) VALUES (2, 'm2', NULL);


--
-- TOC entry 2086 (class 0 OID 16583)
-- Dependencies: 1615
-- Data for Name: material; Type: TABLE DATA; Schema: public; Owner: focususer
--

INSERT INTO material (idmaterial, descricao, status) VALUES (1, 'Material', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (2, 'm1', NULL);
INSERT INTO material (idmaterial, descricao, status) VALUES (3, 'm2', NULL);


--
-- TOC entry 2087 (class 0 OID 16594)
-- Dependencies: 1617
-- Data for Name: ordemservico; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2088 (class 0 OID 16600)
-- Dependencies: 1618
-- Data for Name: ordemservico_contareceber; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2089 (class 0 OID 16605)
-- Dependencies: 1619
-- Data for Name: ordemservico_servicosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2090 (class 0 OID 16612)
-- Dependencies: 1621
-- Data for Name: pais; Type: TABLE DATA; Schema: public; Owner: focususer
--

INSERT INTO pais (idpais, ddi, nome, sigla) VALUES (1, '55', 'Brasil', 'BR');
INSERT INTO pais (idpais, ddi, nome, sigla) VALUES (2, '21', 'Paraguai', 'PY');


--
-- TOC entry 2091 (class 0 OID 16626)
-- Dependencies: 1623
-- Data for Name: perfil; Type: TABLE DATA; Schema: public; Owner: focususer
--

INSERT INTO perfil (idperfil, descricao, status) VALUES (1, 'Perfil', NULL);
INSERT INTO perfil (idperfil, descricao, status) VALUES (2, 'p1', NULL);
INSERT INTO perfil (idperfil, descricao, status) VALUES (3, 'p2', NULL);


--
-- TOC entry 2092 (class 0 OID 16637)
-- Dependencies: 1625
-- Data for Name: perfilacesso; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2093 (class 0 OID 16648)
-- Dependencies: 1627
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2094 (class 0 OID 16656)
-- Dependencies: 1629
-- Data for Name: produtosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2095 (class 0 OID 16664)
-- Dependencies: 1631
-- Data for Name: servico; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2096 (class 0 OID 16672)
-- Dependencies: 1633
-- Data for Name: servicosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2097 (class 0 OID 16680)
-- Dependencies: 1635
-- Data for Name: tipo; Type: TABLE DATA; Schema: public; Owner: focususer
--

INSERT INTO tipo (idtipo, descricao, status) VALUES (1, 'Tipo', NULL);
INSERT INTO tipo (idtipo, descricao, status) VALUES (2, 't2', NULL);


--
-- TOC entry 2098 (class 0 OID 16691)
-- Dependencies: 1637
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2099 (class 0 OID 16699)
-- Dependencies: 1639
-- Data for Name: venda; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2100 (class 0 OID 16705)
-- Dependencies: 1640
-- Data for Name: venda_contareceber; Type: TABLE DATA; Schema: public; Owner: focususer
--



--
-- TOC entry 2101 (class 0 OID 16710)
-- Dependencies: 1641
-- Data for Name: venda_produtosselecionados; Type: TABLE DATA; Schema: public; Owner: focususer
--



-- Completed on 2009-06-04 17:44:53

--
-- PostgreSQL database dump complete
--

