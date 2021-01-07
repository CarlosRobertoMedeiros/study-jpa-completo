insert into App.Tb_Produto (id,nome, preco, descricao) values (1,'Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into App.Tb_Produto (id,nome, preco, descricao) values (3,'Câmera GoPro Hero 7', 1400.0, 'Desempenho 2 vezes melhor.');

insert into App.Tb_Cliente(id,nome) values (1, 'Fernando Marinho de Souza');
insert into App.Tb_Cliente(id,nome) values (2, 'Marcos Mariano');

insert into App.Tb_Pedido (id, cliente_id, data_pedido, total, status) values (1, 1, sysdate, 100.0, 'AGUARDANDO');

insert into App.Tb_ItemPedido (id, pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 1, 5.0, 2);

insert into App.Tb_Categoria (id, nome) values (1, 'Eletrônicos');
