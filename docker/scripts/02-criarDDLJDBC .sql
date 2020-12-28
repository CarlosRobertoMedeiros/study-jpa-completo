--Criação da Sequence
CREATE SEQUENCE APP.eventos_seq
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;


--Criação da Tabela(DDL)
CREATE TABLE APP.TB_Eventos
( id_evento   number(10) NOT NULL,
  nome varchar2(50) NOT NULL,
  data date not null,
  CONSTRAINT id_pk PRIMARY KEY (id_evento)
);

--Inserção dos Dados(DML)
INSERT INTO APP.Tb_Eventos(id_evento,nome,data) values(APP.eventos_seq.nextval,'Carlos Roberto', sysdate);
INSERT INTO APP.Tb_Eventos(id_evento,nome,data) values(APP.eventos_seq.nextval,'Luciene Alves', sysdate);
INSERT INTO APP.Tb_Eventos(id_evento,nome,data) values(APP.eventos_seq.nextval,'Paulo de Tarso', sysdate);
INSERT INTO APP.Tb_Eventos(id_evento,nome,data) values(APP.eventos_seq.nextval,'Alane Costa', sysdate);