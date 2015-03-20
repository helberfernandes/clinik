package br.com.wofsolutions.dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.wofsolutions.model.LinhaDataSet;
import br.com.wofsolutions.model.LinhaModel;
import br.com.wofsolutions.model.RadarModel;
import br.com.wofsolutions.model.cockpit.QTDCategoriaValor;
import br.com.wofsolutions.model.cockpit.QtdMes;
import br.com.wofsolutions.util.ConexaoUtil;

public class CockpitDAO implements Serializable {
	private ConexaoUtil conexaoUtil = new ConexaoUtil();
	
	
	
	public LinhaModel getTotalProcedimentosRealizadosPorMes(){
		LinhaModel model = new LinhaModel("\"Janeiro\", \"Fevereiro\", \"Marco\", \"Abril\", \"Maio\", \"Junho\",\"Julho\", \"Agosto\", \"Setembro\", \"Outubro\", \"Novembro\", \"Dezembro\"");
		List<String> cores = new ArrayList<String>();
		cores.add("rgba(189,83,107");
		cores.add("rgba(154,205,50");
		cores.add("rgba(107,142,35");
		cores.add("rgba(34,139,34");
		cores.add("rgba(0,128,128");
		cores.add("rgba(95,158,160");
		cores.add("rgba(128,0,128");
		cores.add("rgba(139,0,139");
		cores.add("rgba(199,21,133");
		cores.add("rgba(220,20,60");
		cores.add("rgba(255,0,0");
		cores.add("rgba(255,140,0");
		cores.add("rgba(255,165,0");
		cores.add("rgba(255,215,0");
		cores.add("rgba(255,255,0");
		
		try {
			PreparedStatement ps = conexaoUtil.getCon().prepareStatement("select exame, count(case when mes =1 then atendimento_id end) as janeiro, count(case when mes =2 then atendimento_id end) as fevereiro, count(case when mes =3 then atendimento_id end) as marco, count(case when mes =4 then atendimento_id end) as abril, count(case when mes =5 then atendimento_id end) as maio, count(case when mes =6 then atendimento_id end) as junho, count(case when mes =7 then atendimento_id end) as julho, count(case when mes =8 then atendimento_id end) as agosto, count(case when mes =9 then atendimento_id end) as setembro, count(case when mes =10 then atendimento_id end) as outubro, count(case when mes =11 then atendimento_id end) as novembro, count(case when mes =12 then atendimento_id end) as dezembro from(SELECT month(data_lancamento) mes, atendimento_id, e.nome as exame FROM wof_atendimento a join wof_exames e on e.exame_id=a.exame_id where (( a.exame_id=0) or (0=0))  and deletado=false ) sql1 group by exame");
			ResultSet rs = ps.executeQuery();
			//select exame, count(case when mes =1 then atendimento_id end) as janeiro, count(case when mes =2 then atendimento_id end) as fevereiro, count(case when mes =3 then atendimento_id end) as marco, count(case when mes =4 then atendimento_id end) as abril, count(case when mes =5 then atendimento_id end) as maio, count(case when mes =6 then atendimento_id end) as junho, count(case when mes =7 then atendimento_id end) as julho, count(case when mes =8 then atendimento_id end) as agosto, count(case when mes =9 then atendimento_id end) as setembro, count(case when mes =10 then atendimento_id end) as outubro, count(case when mes =11 then atendimento_id end) as novembro, count(case when mes =12 then atendimento_id end) as dezembro from(SELECT month(data_lancamento) mes, atendimento_id, e.nome as exame FROM wof_atendimento a join wof_exames e on e.exame_id=a.exame_id where (( a.exame_id=0) or (0=0)) and DATE_FORMAT(data_lancamento, '%X')=DATE_FORMAT(CURRENT_DATE, '%X')  and deletado=false ) sql1 group by exame
			int i =0;
			while(rs.next()){
				model.getDataSets().add(
						new LinhaDataSet(rs.getString("exame"), 
						rs.getInt("janeiro")+"," +rs.getInt("fevereiro")+"," + 
						rs.getInt("marco")+"," + rs.getInt("abril")+"," + rs.getInt("maio")+"," + 
						rs.getInt("junho")+"," + rs.getInt("julho")+"," + rs.getInt("agosto")+"," + rs.getInt("setembro")+"," +
						rs.getInt("outubro")+"," + rs.getInt("novembro")+"," + rs.getInt("dezembro"), cores.get(i)));
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
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
	
	
	public RadarModel getQtdProcedimentosExame(){
		
		try {
			PreparedStatement ps = conexaoUtil.getCon().prepareStatement("SELECT  s1.exame, s1.qtd_atual, s2.qtd_ant from ( SELECT e.nome exame,   count(*) qtd_atual FROM wof_atendimento w  join wof_exames e on w.exame_id=e.exame_id where  (( w.exame_id=0) or (0=0)) and deletado=false and data_lancamento between '2013-02-20' and '2013-03-20' group by exame ) s1 join( SELECT e.nome exame,   count(*) qtd_ant FROM wof_atendimento w  join wof_exames e on w.exame_id=e.exame_id where  (( w.exame_id=0) or (0=0)) and deletado=false and data_lancamento between '2013-02-20' and '2013-03-20' group by exame )s2 on s1.exame=s2.exame group by s1.exame");
			ResultSet rs = ps.executeQuery();
			String label="";
			String data1 ="";
			String data2 ="";
			
			
			while(rs.next()){
				label+=",\""+rs.getString("exame")+"\"";
				data1+=","+rs.getInt("qtd_atual");
				data2+=","+rs.getInt("qtd_ant");
				
				
			}
			
			return new RadarModel(label.substring(1), data1.substring(1), data2.substring(1));
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}
	
public RadarModel getQtdProcedimentosMedico(){
		
		try {
			PreparedStatement ps = conexaoUtil.getCon().prepareStatement("SELECT  s1.medico, s1.qtd_atual, s2.qtd_ant from ( SELECT m.nome medico,   count(*) qtd_atual FROM wof_atendimento w  join wof_medicos m on w.medico_id=m.medico_id where  (( w.medico_id=0) or (0=0)) and deletado=false and data_lancamento between '2013-02-20' and '2013-03-20' group by medico ) s1 join( SELECT m.nome medico,   count(*) qtd_ant FROM wof_atendimento w  join wof_medicos m on w.medico_id=m.medico_id where  (( w.medico_id=0) or (0=0)) and deletado=false and data_lancamento between '2013-02-20' and '2013-03-20' group by medico )s2 on s1.medico=s2.medico group by s1.medico");
			ResultSet rs = ps.executeQuery();
			String label="";
			String data1 ="";
			String data2 ="";
			
			
			while(rs.next()){
				label+=",\""+rs.getString("medico")+"\"";
				data1+=","+rs.getInt("qtd_atual");
				data2+=","+rs.getInt("qtd_ant");
				
				
			}
			
			return new RadarModel(label.substring(1), data1.substring(1), data2.substring(1));
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
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
	
public int getQtdProcedimentosMedicos(int medicoId){
		
		try {
			PreparedStatement ps = conexaoUtil.getCon().prepareStatement("SELECT   count(*) qtd FROM wof_atendimento where medico_id= "+medicoId);
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
	
	
public int getQtdProcedimentosFaltaGuia(){
		
		try {
			PreparedStatement ps = conexaoUtil.getCon().prepareStatement("SELECT   count(*) qtd FROM wof_atendimento where falta_guia=true ");
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
