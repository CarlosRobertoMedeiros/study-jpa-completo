insert into App.Tb_Produto (id,nome, preco,data_criacao,descricao) values (1,'Kindle', 499.0, sysdate-1,'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into App.Tb_Produto (id,nome, preco, data_criacao,descricao) values (3,'Câmera GoPro Hero 7', 1400.0,sysdate-2, 'Desempenho 2 vezes melhor.');

insert into App.Tb_Cliente(id,nome,cpf,sexo) values (1, 'Fernando Marinho de Souza','123456789','MASCULINO');
insert into App.Tb_Cliente(id,nome,cpf,sexo) values (2, 'Marcos Mariano','987654321','MASCULINO');

insert into App.Tb_Pedido (id, cliente_id, data_criacao, total, status) values (1, 1, sysdate, 998.0, 'AGUARDANDO');
insert into App.Tb_Pedido (id, cliente_id, data_criacao, total, status) values (2, 1, sysdate, 499.0, 'AGUARDANDO');

insert into App.Tb_ItemPedido (pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 449, 2);
insert into App.Tb_ItemPedido (pedido_id, produto_id, preco_produto, quantidade) values (2, 1, 449, 1);

--insert into App.TB_Pagamento_Cartao(pedido_id, status, numeroCartao)  values (2,'PROCESSANDO','123');

insert into App.Tb_Categoria (id, nome) values (1, 'Eletrônicos');
