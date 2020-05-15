package com.example.job.schedulerjob;

import java.util.Arrays;

public class JobDetails2 extends Thread {

	public static void main(String[] args) {	
		Jobs2 job1 = new Jobs2(1,"Importação de arquivos de fundos",   "2019-11-10 12:00:00", 2);
		Jobs2 job2 = new Jobs2(2,"Importação de dados da Base Legada", "2019-11-11 12:00:00", 4);
		Jobs2 job3 = new Jobs2(3,"Importação de dados de integração",  "2019-11-11 08:00:00", 6);

		System.out.println("INICIANDO JANELA DE EXECUÇÃO");
		System.out.println("---------------------------------------------------------------");
		
		Arrays.asList(job1, job2, job3)
		.stream()
		.sorted()//ordena os items
		.forEach(job->job.processar());//job->job.processar() é um lambda que representa um Consumer. 

		System.out.println("CONCLUÍDO COM SUCESSO!");

	}
}
