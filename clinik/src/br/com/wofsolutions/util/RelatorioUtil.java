package br.com.wofsolutions.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperRunManager;

public class RelatorioUtil {

	// public void imprimeChamados() {
	//
	// String relatorio =
	// FacesUtil.getServletContext().getRealPath("admin/relatorios/notasmensalcentrodecusto.jasper");
	// System.out.println("Rel="+relatorio);
	//
	// Connection con;
	// try {
	// Class.forName("com.mysql.jdbc.Driver");
	// con = DriverManager.getConnection("jdbc:mysql://192.168.0.74/chamados",
	// "root", "st1215");
	// Map parametros = new HashMap();
	// parametros.put("dataDe", new Date());
	// parametros.put("dataAte", new Date());
	//
	// // parametros.put("atribuidoa", umbs.getUsuarioLogado().getUsuarioId());
	// // parametros.put("logo",
	// FacesUtil.getServletContext().getRealPath("imagens/logoMaia.png"));
	//
	//
	//
	//
	// File file = new File(relatorio);
	// if (file.exists()) {
	// JasperPrint impressao = JasperFillManager.fillReport(relatorio, null,
	// con);
	// JasperExportManager.exportReportToPdfFile(impressao,
	// FacesUtil.getServletContext().getRealPath("admin/relatorios/") +
	// "notasmensalcentrodecusto.pdf");
	// JasperExportManager.exportReportToHtmlFile(impressao,
	// FacesUtil.getServletContext().getRealPath("admin/relatorios/") +
	// "/notasmensalcentrodecusto.html");
	// JasperRunManager.runReportToHtmlFile(relatorio, parametros);
	//
	// //writeBytesAsAttachedTextFile(bytes, "chamados.pdf");
	// }
	// //JasperFillManager.fillReportToFile(relatorio, parametros, con);
	//
	//
	//
	// //JasperPrint impressao = JasperFillManager.fillReport(relatorio,
	// parametros, con);
	// //System.out.println(impressao);
	//
	// // JasperViewer viewer = new JasperViewer(impressao, true);
	//
	// // viewer.show();
	// } catch (ClassNotFoundException ex) {
	// // TODO Auto-generated catch block
	// ex.printStackTrace();
	//
	// } catch (SQLException ex) {
	// // TODO Auto-generated catch block
	// ex.printStackTrace();
	// } catch (JRException ex) {
	// // TODO Auto-generated catch block
	// ex.printStackTrace();
	// } catch (Exception ex) {
	// ex.printStackTrace();
	// // Logger.getLogger(ChamadoMBSession.class.getName()).log(Level.SEVERE,
	// null, ex);
	// }
	// }

	private static String ERRO_MENSAGEM_REPORT = "Um erro ocorreu quando o relatório estava sendo executado.";

	// executa o relatório através de um JRBeanCollectionDataSource
	public static void executarRelatorio(String caminhoRelatorio,
			Map<String, Object> parametros, String nomeRel,
			JRBeanCollectionDataSource fonteDados) {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();

		// pega o caminho do arquivo .jasper da aplicação
		InputStream reportStream = context.getExternalContext()
				.getResourceAsStream(caminhoRelatorio);

		/*
		 * //envia a resposta com o MIME Type
		 * if(tipoFormatoRelatorio.equals(TipoFormatoRelatorio.ACROBAT_PDF)){
		 * response.setContentType("application/pdf"); }else
		 * if(tipoFormatoRelatorio.equals(TipoFormatoRelatorio.PAGINA_HTML)){
		 * response.setContentType("application/html"); }
		 */
		response.setHeader("Content-Disposition", "attachment; filename="
				+ nomeRel + ".pdf");
		response.setContentType("application/download");
		response.setHeader("Pragma", "no-cache");
		try {
			ServletOutputStream servletOutputStream = response
					.getOutputStream();

			// envia parametros para o relatório
			if (parametros == null) {
				parametros = new HashMap<String, Object>();
			}

			// envia para o navegador o PDF gerado
			JasperRunManager.runReportToPdfStream(reportStream,
					servletOutputStream, parametros, fonteDados);
			servletOutputStream.flush();
			servletOutputStream.close();

		} catch (JRException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			context.responseComplete();
		}
	}

	// executa o relatorio através de uma Connection
	public static void executarRelatorio(String caminhoRelatorio, Map parametros) {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) context
				.getExternalContext().getResponse();

		// pega o caminho do arquivo .jasper da aplicação
		InputStream reportStream = context.getExternalContext()
				.getResourceAsStream(caminhoRelatorio);

		// envia a resposta com o MIME Type
		// if(tipoFormatoRelatorio.equals(TipoFormatoRelatorio.ACROBAT_PDF)){
		response.setContentType("application/pdf");
		// }else
		// if(tipoFormatoRelatorio.equals(TipoFormatoRelatorio.PAGINA_HTML)){
		// response.setContentType("application/html");
		// }

		try {
			ServletOutputStream servletOutputStream = response
					.getOutputStream();

			// envia parametros para o relatorio
			if (parametros == null) {
				parametros = new HashMap();
			}

			
			// JasperPrint impressao =
			// JasperFillManager.fillReport(caminhoRelatorio,
			// parametros,getConnection());
			//
			// envia para o navegador o PDF gerado
			JasperRunManager.runReportToPdfStream(reportStream,
					servletOutputStream, parametros, getConnection());
			servletOutputStream.flush();
			servletOutputStream.close();

			 response.addHeader("Content-disposition",
			 "attachment; filename=\"nota.pdf\"");
			 JasperPrint impressao =
			 JasperFillManager.fillReport(caminhoRelatorio,
			 parametros,getConnection());
			 JasperExportManager.exportReportToPdfStream(impressao,
			 response.getOutputStream());
			 context.getApplication().getStateManager().saveView(context);
			 context.responseComplete();

		} catch (JRException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			context.responseComplete();
		}
	}

	public static void teste(String caminhoRelatorio,
			HashMap parametros) {
		try {

			FacesContext facesContext = FacesContext.getCurrentInstance();

			facesContext.responseComplete();

			ServletContext scontext = (ServletContext) facesContext
					.getExternalContext().getContext();


			JasperPrint jasperPrint = JasperFillManager
					.fillReport(
							scontext.getRealPath("admin/relatorios/"+caminhoRelatorio),
							parametros, getConnection());

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			JRPdfExporter exporter = new JRPdfExporter();

			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);

			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

			exporter.exportReport();

			byte[] bytes = baos.toByteArray();

			if (bytes != null && bytes.length > 0) {

				HttpServletResponse response = (HttpServletResponse) facesContext
						.getExternalContext().getResponse();

				response.setContentType("application/download");

				response.setHeader("Content-disposition",
						"inline; filename=\"relatorio.pdf\"");
				
				
				

				response.setContentLength(bytes.length);

				ServletOutputStream outputStream = response.getOutputStream();

				outputStream.write(bytes, 0, bytes.length);

				outputStream.flush();

				outputStream.close();

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	private static Connection getConnection() {
		Connection connection = null;
		try {
			// cria a conexão com o banco de dados
			Class.forName("com.mysql.jdbc.Driver");
			String db = "jdbc:mysql://localhost:3306/clinik";
			connection = DriverManager.getConnection(db, "root", "st1215");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return connection;

	}

	

}
