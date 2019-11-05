package br.com.coretecnologia.cliente;

import java.util.List;
import java.util.Scanner;

public class ClienteApp {

	public static void main(String[] args) {
		try {
			Scanner entrada = new Scanner(System.in);
			int opcao = 0;
			long cpf;
			String nome, email;

			ClienteDAO dao = new ClienteDAO();

			while(opcao != 6) {
				System.out.println("Sistema de Gerenciamento de Clientes");
				System.out.println("====================================");
				System.out.println("Digite [1] para consultar todos os clientes");
				System.out.println("Digite [2] para consultar um cliente específico");
				System.out.println("Digite [3] para cadastrar um cliente");
				System.out.println("Digite [4] para alterar um cliente");
				System.out.println("Digite [5] para excluir um cliente");
				System.out.println("Digite [6] para sair");

				opcao = entrada.nextInt();

				switch(opcao) {
				case 1:// consultar todos
				{
					System.out.println("[1] Consultar Todos");
					List<Cliente> clientes = dao.findAll();					
					clientes.forEach(System.out::println); 
					break;
				}
				case 2:// consultar um cliente específico
				{
					System.out.println("[2] consultar um cliente específico");
					System.out.println("Favor Informar o CPF >>>>>>");
					cpf = entrada.nextLong();
					System.out.println(dao.find(cpf));
					break;	
				}
				case 3:// cadastrar um cliente
				{
					System.out.println("[3] cadastrar um cliente");
					System.out.println("Favor Informar o CPF >>>>>>");
					cpf = entrada.nextLong();
					entrada.nextLine();
					System.out.println("Favor Informar o Nome >>>>>>");
					nome = entrada.nextLine();
					System.out.println("Favor Informar o Email >>>>>>");
					email = entrada.nextLine();
					Cliente cliente = new Cliente(cpf, nome, email);
					dao.persist(cliente);
					break;
				}
				case 4:// alterar um cliente
				{	
					System.out.println("[4] alterar um cliente");
					System.out.println("Favor Informar o CPF >>>>>>");
					cpf = entrada.nextLong();
					entrada.nextLine();
					System.out.println("Favor Informar o Nome >>>>>>");
					nome = entrada.nextLine();
					System.out.println("Favor Informar o Email >>>>>>");
					email = entrada.nextLine();

					Cliente cliente = new Cliente(cpf, nome, email);
					dao.merge(cliente);
					break;
				}
				case 5:// excluir um cliente
				{
					System.out.println("[5] excluir um cliente");
					System.out.println("Favor Informar o CPF >>>>>>");
					cpf = entrada.nextLong();
					Cliente cliente = dao.find(cpf);
					dao.delete(cliente);
					break;	
				}
				case 6:// encerrar programa
				{
					System.out.println("Encerrando o sistema");
					break;
				}
				}
				//entrada.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
