package br.com.coretecnologia.pagamento;

import java.util.List;
import java.util.Scanner;

import br.com.coretecnologia.cliente.Cliente;

public class PagamentoApp {

	public static void main(String[] args) {
		try {
			Scanner entrada = new Scanner(System.in);
			int opcao = 0;
			long cpf, cdcurso;
			String datainscricao;
			
			PagamentoDAO dao = new PagamentoDAO();
			
			while(opcao != 6) {
				System.out.println("Sistema de Gerenciamento de Pagamentos");
				System.out.println("====================================");
				System.out.println("Digite [1] para consultar todos os Pagamentos");
				System.out.println("Digite [2] para consultar um Pagamento específico");
				System.out.println("Digite [3] para cadastrar um Pagamento");
				System.out.println("Digite [4] para alterar um Pagamento");
				System.out.println("Digite [5] para excluir um Pagamento");
				System.out.println("Digite [6] para sair");

				opcao = entrada.nextInt();

				switch(opcao) {
				case 1:// consultar todos
				{
					System.out.println("[1] Consultar Todos");
					dao.findAll();
					
					List<Pagamento> pagamentos = dao.findAll();					
					pagamentos.forEach(System.out::println);
					break;
				}
				case 2:// consultar um Pagamento específico
				{
					System.out.println("[2] consultar um Pagamento específico");
					cpf = entrada.nextLong();
					System.out.println("Favor Informar o Código do Curso >>>>>>");
					cdcurso = entrada.nextLong();
					
					PagamentoId pgtoId = new PagamentoId(cpf, cdcurso);
					
					System.out.println(dao.find(pgtoId));
					
					break;	
				}
				case 3:// cadastrar um Pagamento
				{
					System.out.println("[3] cadastrar um Novo Pagamento");
					System.out.println("Favor Informar o CPF >>>>>>");
					cpf = entrada.nextLong();
					System.out.println("Favor Informar o Código do Curso >>>>>>");
					cdcurso = entrada.nextLong();
					entrada.nextLine();
					PagamentoId pgtoId = new PagamentoId(cpf, cdcurso);
					
					System.out.println("Favor Informar a Data de Inscrição >>>>>>");
					datainscricao = entrada.nextLine();
					
					Pagamento pagamento = new Pagamento(pgtoId, datainscricao);
					dao.persist(pagamento);
					break;
				}
				case 4:// alterar um Pagamento
				{	
					System.out.println("[3] cadastrar um Novo Pagamento");
					System.out.println("Favor Informar o CPF >>>>>>");
					cpf = entrada.nextLong();
					System.out.println("Favor Informar o Código do Curso >>>>>>");
					cdcurso = entrada.nextLong();
					entrada.nextLine();
					PagamentoId pgtoId = new PagamentoId(cpf, cdcurso);
					
					System.out.println("Favor Informar a Data de Inscrição >>>>>>");
					datainscricao = entrada.nextLine();
					
					Pagamento pagamento = new Pagamento(pgtoId, datainscricao);
					dao.merge(pagamento);
					break;
				}
				case 5:// excluir um cliente
				{
					System.out.println("[2] consultar um Pagamento específico");
					cpf = entrada.nextLong();
					System.out.println("Favor Informar o Código do Curso >>>>>>");
					cdcurso = entrada.nextLong();
					
					PagamentoId pgtoId = new PagamentoId(cpf, cdcurso);
					
					System.out.println(dao.find(pgtoId));
					Pagamento pagamento = dao.find(pgtoId);
					dao.delete(pagamento);
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
