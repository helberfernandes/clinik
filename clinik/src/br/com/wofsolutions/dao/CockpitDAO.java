package br.com.wofsolutions.dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.wofsolutions.model.cockpit.QTDCategoriaValor;
import br.com.wofsolutions.model.cockpit.QtdMes;
import br.com.wofsolutions.util.ConexaoUtil;

public class CockpitDAO implements Serializable {
	private ConexaoUtil conexaoUtil = new ConexaoUtil();
	
	
	
	public List<QtdMes> getTotalProcedimentosRealizadosPorMes(){
		List<QtdMes> list = new ArrayList<QtdMes>();
		try {
			PreparedStatement ps = conexaoUtil.getCon().prepareStatement("select exame, count(case when mes =1 then atendimento_id end) as janeiro, count(case when mes =2 then atendimento_id end) as fevereiro, count(case when mes =3 then atendimento_id end) as marco, count(case when mes =4 then atendimento_id end) as abril, count(case when mes =5 then atendimento_id end) as maio, count(case when mes =6 then atendimento_id end) as junho, count(case when mes =7 then atendimento_id end) as julho, count(case when mes =8 then atendimento_id end) as agosto, count(case when mes =9 then atendimento_id end) as setembro, count(case when mes =10 then atendimento_id end) as outubro, count(case when mes =11 then atendimento_id end) as novembro, count(case when mes =12 then atendimento_id end) as dezembro from(SELECT month(data_lancamento) mes, atendimento_id, e.nome as exame FROM wof_atendimento a join wof_exames e on e.exame_id=a.exame_id where (( a.exame_id=0) or (0=0))  and deletado=false ) sql1 group by exame");
			ResultSet rs = ps.executeQuery();
			//select exame, count(case when mes =1 then atendimento_id end) as janeiro, count(case when mes =2 then atendimento_id end) as fevereiro, count(case when mes =3 then atendimento_id end) as marco, count(case when mes =4 then atendimento_id end) as abril, count(case when mes =5 then atendimento_id end) as maio, count(case when mes =6 then atendimento_id end) as junho, count(case when mes =7 then atendimento_id end) as julho, count(case when mes =8 then atendimento_id end) as agosto, count(case when mes =9 then atendimento_id end) as setembro, count(case when mes =10 then atendimento_id end) as outubro, count(case when mes =11 then atendimento_id end) as novembro, count(case when mes =12 then atendimento_id end) as dezembro from(SELECT month(data_lancamento) mes, atendimento_id, e.nome as exame FROM wof_atendimento a join wof_exames e on e.exame_id=a.exame_id where (( a.exame_id=0) or (0=0)) and DATE_FORMAT(data_lancamento, '%X')=DATE_FORMAT(CURRENT_DATE, '%X')  and deletado=false ) sql1 group by exame
			while(rs.next()){
				list.add(new QtdMes(rs.getString("exame"), rs.getInt("janeiro"), rs.getInt("fevereiro"), 
						rs.getInt("marco"), rs.getInt("abril"), rs.getInt("maio"), 
						rs.getInt("junho"), rs.getInt("julho"), rs.getInt("agosto"), rs.getInt("setembro"),
						rs.getInt("outubro"), rs.getInt("novembro"), rs.getInt("dezembro")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<QTDCategoriaValor> getQtdGeralProcedimentos(){
		List<QTDCategoriaValor> list = new ArrayList<QTDCategoriaValor>();
		try {
			PreparedStatement ps = conexaoUtil.getCon().prepareStatement("SELECT  e.nome exame, count(*) qtd,  (sum(w.valor)) valor FROM wof_atendimento w join wof_exames e on w.exame_id=e.exame_id where   (( w.exame_id=0) or (0=0)) and deletado=false group by exame");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				list.add(new QTDCategoriaValor(rs.getString("exame"), rs.getInt("qtd"), rs.getDouble("valor")) 
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	public List<QTDCategoriaValor> getQtdProcedimentosSolicitante(){
		List<QTDCategoriaValor> list = new ArrayList<QTDCategoriaValor>();
		try {
			PreparedStatement ps = conexaoUtil.getCon().prepareStatement("SELECT m.nome medico,   count(*) qtd,  sum(w.valor) valor FROM wof_atendimento w  join wof_medicos m on w.solicitante_id=m.medico_id where  (( w.solicitante_id=0) or (0=0)) and deletado=false group by medico");
			ResultSet rs = ps.executeQuery();
			int outros =0;
			while(rs.next()){
				if(rs.getInt("qtd")<=180){
					outros+=rs.getInt("qtd");
					list.add(new QTDCategoriaValor("Outros", outros, rs.getDouble("valor")) 
							);
				}else{
					list.add(new QTDCategoriaValor(rs.getString("medico"), rs.getInt("qtd"), rs.getDouble("valor")) 
							);
				}
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<QTDCategoriaValor> getQtdProcedimentosConvenio(){
		List<QTDCategoriaValor> list = new ArrayList<QTDCategoriaValor>();
		try {
			PreparedStatement ps = conexaoUtil.getCon().prepareStatement("SELECT c.nome convenio,  count(*) qtd,  (sum(w.valor)) valor FROM wof_atendimento w join wof_convenios c on w.convenio_id=c.convenio_id where  (( w.exame_id=0) or (0=0)) and deletado=false and (( w.convenio_id=0) or (0=0)) group by convenio");
			ResultSet rs = ps.executeQuery();
			int outros=0;
			
			while(rs.next()){
			if(rs.getInt("qtd")<600){
				outros+=rs.getInt("qtd");
				list.add(new QTDCategoriaValor("Outros", outros, rs.getDouble("valor")) 
						);
			}else{
				list.add(new QTDCategoriaValor(rs.getString("convenio"), rs.getInt("qtd"), rs.getDouble("valor")) 
						);
			}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	public int getQtdProcedimentos(){
		
		try {
			PreparedStatement ps = conexaoUtil.getCon().prepareStatement("SELECT   count(*) qtd FROM wof_atendimento ");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				return rs.getInt("qtd");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	

	
	
	
}
