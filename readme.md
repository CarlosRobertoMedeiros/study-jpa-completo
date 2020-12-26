Evoluindo em Conceitos Avançados de JPA com Hibernate

    

		 ██████████                     █████                        
	░░███░░░░███                   ░░███                         
	 ░███   ░░███  ██████   ██████  ░███ █████  ██████  ████████ 
	 ░███    ░███ ███░░███ ███░░███ ░███░░███  ███░░███░░███░░███
	 ░███    ░███░███ ░███░███ ░░░  ░██████░  ░███████  ░███ ░░░ 
	 ░███    ███ ░███ ░███░███  ███ ░███░░███ ░███░░░   ░███     
	 ██████████  ░░██████ ░░██████  ████ █████░░██████  █████    
	░░░░░░░░░░    ░░░░░░   ░░░░░░  ░░░░ ░░░░░  ░░░░░░  ░░░░░  


    - Para Subir o Container docker é necessário seguir os seguintes passos
       1) Execute o build da imagem
       		docker build .
       2) Execute o docker-compose para subir a stack
            docker-compose up
       3) Copie os scripts da Pasta Script para dentro do inicializador
       		${PWD}/oracle/init/sh_sql_dmp_files/
       4) Para o docker-compose
       		docker-compose down
       5) Reinicialize o Container
        	Assim vai ser criado o usuário App com a senha 12345 para utilização do banco
        	Novos scripts devem seguir a sequência numérica para utilização
       		docker-compose up
