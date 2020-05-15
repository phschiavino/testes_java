package com.example.job.schedulerjob;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Jobs2 implements Comparable<Jobs2>{
	
	private Integer id;
	private String descricao;
	private String dataExecucao;
	private LocalDateTime ldtDataExecucao; 
	private Integer tempoEstimado;
	
	public Jobs2(Integer id, String descricao, String dataExecucao, Integer tempoEstimado) {
		this.id = id;
		this.descricao = descricao;
		this.tempoEstimado = tempoEstimado;
		this.dataExecucao = dataExecucao;
		this.ldtDataExecucao = descricaoParaLocalDate(dataExecucao);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDataExecucao() {
		return dataExecucao;
	}
	public void setDataExecucao(String dataExecucao) {
		this.dataExecucao = dataExecucao;
	}
	public Integer getTempoEstimado() {
		return tempoEstimado;
	}
	public void setTempoEstimado(Integer tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}	
	
	public void processar() {
		System.out.println("INICIANDO JOB " + id + "\n" + descricao + "\nPROGRAMADO " +dataExecucao + "\nEXECUTADO EM " + tempoEstimado + " HORAS");
		System.out.println("---------------------------------------------------------------");
		/*System.out.println("Execuntado Job: " + toString() + " às:" + LocalDateTime.now() + "EXECUTADO EM " + tempoEstimado + " HORAS");*/
		try {
			Thread.sleep(tempoEstimado * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "EXECUTANDO ID=" + id + "," + descricao + ", PROGRAMADO ÀS:" + dataExecucao;				
		/*
		 * "Jobs [id=" + id + ", descricao=" + descricao + ", dataExecucao=" +
		 * dataExecucao + ", tempoEstimado=" + tempoEstimado + "]";
		 */
	}
	
	private LocalDateTime descricaoParaLocalDate(String descDataExecucao) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.parse(descDataExecucao, formatter);		
	}
	
	@Override
	public int compareTo(Jobs2 outroJob) {
		return ldtDataExecucao.compareTo(outroJob.ldtDataExecucao);
	} 
	

}
