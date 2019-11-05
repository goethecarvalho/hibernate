package br.com.coretecnologia.curso;

import java.util.List;
import java.util.Scanner;

public class CursoApp {
	
	public static void main(String[] args) {
		try {
			Scanner entrada = new Scanner(System.in);
			int opcao = 0;
			long cdcurso, valor;
			String nome, url;
			
			CursoDAO dao = new CursoDAO();
			
			while(opcao != 6) {
				System.out.println("Sistema de Gerenciamento de Cursos");
				System.out.println("====================================");
				System.out.println("Digite [1] para consultar todos os Cursos");
				System.out.println("Digite [2] para consultar um Curso específico");
				System.out.println("Digite [3] para cadastrar um Curso");
				System.out.println("Digite [4] para alterar um Curso");
				System.out.println("Digite [5] para excluir um Curso");
				System.out.println("Digite [6] para sair");

				opcao = entrada.nextInt();

				switch(opcao) {
				case 1:// consultar todos
				{
					System.out.println("[1] Consultar Todos");
					List<Curso> cursos = dao.findAll();					
					cursos.forEach(System.out::println); 
					break;
				}
				case 2:// consultar um Curso específico
				{
					System.out.println("[2] consultar um Curso específico");
					System.out.println("Favor Informar o cdcurso >>>>>>");
					cdcurso = entrada.nextLong();
					System.out.println(dao.find(cdcurso));
					break;	
				}
				case 3:// cadastrar um Curso
				{
					System.out.println("[3] cadastrar um Curso");
					System.out.println("Favor Informar o Código do Curso >>>>>>");
					cdcurso = entrada.nextLong();
					entrada.nextLine();
					System.out.println("Favor Informar o Nome >>>>>>");
					nome = entrada.nextLine();
					System.out.println("Favor Informar o Valor >>>>>>");
					valor = entrada.nextLong();
					entrada.nextLine();
					System.out.println("Favor Informar a URL >>>>>>");
					url = entrada.nextLine();
					
					Curso curso = new Curso(cdcurso, nome, valor, url);
					
					dao.persist(curso);
					break;
				}
				case 4:// alterar um Curso
				{	
					System.out.println("[4] alterar um Curso");
					System.out.println("Favor Informar o cdcurso >>>>>>");
					cdcurso = entrada.nextLong();
					entrada.nextLine();
					System.out.println("Favor Informar o Nome >>>>>>");
					nome = entrada.nextLine();
					System.out.println("Favor Informar o Valor >>>>>>");
					valor = entrada.nextLong();
					entrada.nextLine();
					System.out.println("Favor Informar a URL >>>>>>");
					url = entrada.nextLine();

					Curso Curso = new Curso(cdcurso, nome, valor, url);
					dao.merge(Curso);
					break;
				}
				case 5:// excluir um Curso
				{
					System.out.println("[5] excluir um Curso");
					System.out.println("Favor Informar o cdcurso >>>>>>");
					cdcurso = entrada.nextLong();
					Curso Curso = dao.find(cdcurso);
					dao.delete(Curso);
					break;	
				}
				case 6:// encerrar programa
				{
					System.out.println("Encerrando o sistema");
					break;
				}
				}
//				entrada.close();
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
