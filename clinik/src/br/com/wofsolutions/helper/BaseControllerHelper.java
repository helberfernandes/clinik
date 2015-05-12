package br.com.wofsolutions.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

import br.com.wofsolutions.controller.BaseController;
import br.com.wofsolutions.interfaces.HibernateDAO;
import br.com.wofsolutions.interfaces.ObjectBase;
import br.com.wofsolutions.mensagens.FacesMessages;
import br.com.wofsolutions.util.FacesUtil;
import br.com.wofsolutions.util.HibernateUtil;
import br.com.wofsolutions.vo.Usuario;

/**
 * Esta classe serve para ajudar em funcoes que geralmente sao comuns a todos os
 * controllers
 * 
 * @author Helber
 * 
 * @param <A>
 *            geralmente um objeto ex. Usuario, Atendimento, etc...
 * @param <B>
 *            classe DAO
 */
public class BaseControllerHelper<A extends ObjectBase, B extends HibernateDAO<A, ?, ?>>
		extends BaseController<A, B> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID      = 1L;
	@Deprecated
	protected static String PARAMMETER_KEY          = "objectId";
	protected static final int FINDALL_COM_EMPRESA  = 0;
	protected static final int FINDALL_SEM_EMPRESA  = 1;
	protected static final int NAO_EXECUTA_FIND_ALL = 2;
	protected FacesUtil facesUtil                   = new FacesUtil();
	private int tipo;
	//-------------------------------------------------------------------//
	//                           Excel                                   //
	//-------------------------------------------------------------------//
	protected HSSFWorkbook wb;// planilha
	protected HSSFSheet sheet;// aba da planilha
	protected  HSSFRow header ;// pegando a primeira linha

	@Override
	@PostConstruct
	public void init() {
		HibernateUtil.getCurrentSession();
		init(FINDALL_COM_EMPRESA);
	}

	/**
	 * Metodo inicial, sempre e chamado nas classe. Para atender diversos tipos
	 * de controllers ele posue para cada caso uma abordagem:
	 * 
	 * @param tipo
	 *            pode ser um dos seguintes parametros:<br/>
	 *            FINDALL_COM_EMPRESA - faz uma busca considerando a empresa
	 *            geralmente a mesma do usuario logado.<br/>
	 *            FINDALL_SEM_EMPRESA - faz uma busca desconsiderando a empresa
	 *            geralmente a mesma do usuario logado.<br/>
	 *            NAO_EXECUTA_FIND_ALL - inicia o controller sem nenhuma busca<br/>
	 */
	public void init(int tipo) {
		log.info("Executando o ini de " + obj.getClass());
		this.tipo = tipo;
		carregaFindAll(tipo);
		carregaParammter();
	}

	private void carregaFindAll(int tipo) {
		switch (tipo) {
		case FINDALL_COM_EMPRESA:
			lista = dao.findAll(getUsuarioOnline().getEmpresa());
			break;
		case FINDALL_SEM_EMPRESA:
			lista = dao.findAll();
			break;
		case NAO_EXECUTA_FIND_ALL:
			break;
		}
	}

	public void carregaParammter() {
		if (facesUtil.getParammeter(PARAMMETER_KEY) != null) {
			obj.setId(facesUtil.getParammeterASInteger(PARAMMETER_KEY));
			if (lista.contains(obj)) {
				obj = lista.get(lista.indexOf(obj));
			}
		}
	}

	@Override
	public void salvar() {
		obj.setEmpresa(getUsuarioOnline().getEmpresa());
		boolean resp = dao.salvar(obj);
		novoObjeto();
		FacesMessages.setMessageSuccessOrFailure(resp);
		carregaFindAll(tipo);
	}

	/**
	 * Este metodo deve ser mudado para se ajustar ao JSF 2.2 onde podemos
	 * passar o objeto diretamente e não só o ID, assim evitamos ir novamente ao
	 * banco, uma vez que temos o objeto já carregado.
	 */
	@Deprecated
	@Override
	public void editar(String GO_PAGE) {
		novoObjeto();
		FacesUtil.redirect(GO_PAGE + facesUtil.getParammeter(PARAMMETER_KEY)
				+ "/");
	}

	@Override
	public void excluir() {
		// TODO Auto-generated method stub
	}

	/**
	 * Retorna o usuario que esta logado no momento *
	 * 
	 * @return usuairo
	 */
	public Usuario getUsuarioSessao() {
		return (Usuario) FacesUtil.getAttribute(Usuario.USUARIO_KEY);
	}

	@Deprecated
	public static String getPARAMMETER_KEY() {
		return PARAMMETER_KEY;
	}

	@Deprecated
	public static void setPARAMMETER_KEY(String pARAMMETER_KEY) {
		PARAMMETER_KEY = pARAMMETER_KEY;
	}
	
	
	
	public void initProcessXLS(Object document) {
		     wb = (HSSFWorkbook) document;// Criando a planilha
	         sheet = wb.getSheetAt(0);// aba da planilha
	         header = sheet.getRow(0);// pegando a primeira linha
	         
	}
	
	
	/**
	 *  Este medoto exporta uma dataTable para excel
	 *  Os cabeçalhos devem ser implementados por cada 
	 * @param document
	 */
	public void postProcessXLS(Object document) {
       
       
        
        
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index); 
        Font font = wb.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        cellStyle.setFont(font);
        
        //add logo da empresa
        
      //FileInputStream obtains input bytes from the image file
        InputStream inputStream;
		try {
			
			String logo = FacesUtil.getCaminho(getUsuarioOnline().getEmpresa().getRelLogo()); 
			inputStream = new FileInputStream(logo);
			 //Get the contents of an InputStream as a byte[].
	        byte[] bytes = IOUtils.toByteArray(inputStream);
	        //Adds a picture to the workbook
	        int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
	        //close the input stream
	        inputStream.close();
	        //Creates the top-level drawing patriarch.
	        Drawing drawing = sheet.createDrawingPatriarch();
	        
	        //Returns an object that handles instantiating concrete classes
	        CreationHelper helper = wb.getCreationHelper();
	        
	        //Create an anchor that is attached to the worksheet
	        ClientAnchor anchor = helper.createClientAnchor();
	        
	        //set top-left corner for the image
	        anchor.setCol1(2);
	        anchor.setRow1(0);
	        
	        Picture pict = drawing.createPicture(anchor, pictureIdx);
	        //Reset the image to the original size	        
	        pict.resize();
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		 
        
        
         
        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
            HSSFCell cell = header.getCell(i);
             
            cell.setCellStyle(cellStyle);
            sheet.autoSizeColumn(i); //ajustando a largura das colunas automaticamente
        }
        
        
    }
}