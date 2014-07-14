package br.com.wofsolutions.mensagens;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import br.com.wofsolutions.util.FacesUtil;

import com.sun.istack.internal.NotNull;

public class FacesMessages implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SUCESSO = "sucesso";
	public static final String FALHOU = "falhou";
	public static final String PAGE_REQUIRED = "javax.faces.component.UIInput.REQUIRED";
	public static final String PAGE_MAXIMUN = "javax.faces.validator.LengthValidator.MAXIMUM";
	public static final String PAGE_MINIMUN = "javax.faces.validator.LengthValidator.MINIMUM";
	public static final String PAGE_PAGINACAO = "app.page.dataScrolling.outputFormat.text";
	public static final String PAGE_SUCESSO = "page.sucesso.msg";
	public static final String PAGE_FALHA = "page.falha.msg";
	public static final String PAGE_EXCLUIR_ROOT = "page.excluir.root.msg";

	private static Properties props = new Properties();
	private static Properties propsEn = new Properties();

	private ResourceBundle resourceBundle = null;
	private static FacesMessages messages = new FacesMessages();

	public void mudaIdioma(ActionEvent e) {
		setResourceBundle(new Locale("en"));
	}

	public void setResourceBundle(Locale locale) {
		resourceBundle = ResourceBundle.getBundle(
				"br.com.wofsolutions.mensagens.mensagem_pt_BR", locale);
	}

	public ResourceBundle getResourceBundle() {
		if (resourceBundle == null) {
			setResourceBundle(new Locale("pt_br"));
		}
		return resourceBundle;
	}

	public static void setFieldMessageError(String fieldId, String idMessage) {
		FacesUtil.getContext().addMessage(
				fieldId,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, messages
						.getResourceBundle().getString(idMessage), messages
						.getResourceBundle().getString(idMessage)));
	}

	public static void setFeedbackMessage(String idMessage) {
		FacesUtil.getContext().addMessage(
				null,
				new FacesMessage(messages.getResourceBundle().getString(
						idMessage)));
	}

	public static String getMessage(MensagensKey idMessage) {
		return messages.getResourceBundle().getString(
						idMessage.toString());
	}
	
	
	public static void addMessage(MensagensKey idMessage) {

		FacesUtil.getContext().addMessage(
				null,
				new FacesMessage(messages.getResourceBundle().getString(
						idMessage.toString())));
		
	}
	
	public static void addMessageWarning(MensagensKey idMessage) {

		FacesUtil.getContext().addMessage(
				null,
				new FacesMessage( FacesMessage.SEVERITY_WARN,messages.getResourceBundle().getString(
						idMessage.toString()),messages.getResourceBundle().getString(
								idMessage.toString())));
	}
	

	public static void addMessageWarning(@NotNull MensagensKey idMessage, @NotNull String [] param) {

		
		
		
		
		
		 String  msgValue = messages.getResourceBundle().getString(
					idMessage.toString());
		    MessageFormat   messageFormat = new MessageFormat(msgValue);
		    Object[] args = {param};
		    
		    FacesUtil.getContext().addMessage(
					null, new FacesMessage( FacesMessage.SEVERITY_WARN,messageFormat.format(param),messageFormat.format(param)));
		
	}
	public static void addMessageWarning(String fieldId,MensagensKey idMessage) {

		FacesUtil.getContext().addMessage(
				fieldId,
				new FacesMessage( FacesMessage.SEVERITY_WARN,messages.getResourceBundle().getString(
						idMessage.toString()),messages.getResourceBundle().getString(
								idMessage.toString())));
	}

	
	
	

	
	public static void addMessage(String severity, String idMessage) {
		FacesUtil.getContext().addMessage(
				severity,
				new FacesMessage(idMessage));
	}

	public static void addMessage(String severity, FacesMessage fm) {
		FacesUtil.getContext().addMessage(severity, fm);
	}

	public static void setMessageSuccessOrFailure(boolean resp) {
		if (resp) {
			FacesUtil.getContext().addMessage(null,
					new FacesMessage(messages.getResourceBundle().getString(MensagensKey.WOF_MSG_SUCESSO.toString())));
		} else {
			FacesUtil.getContext().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							messages.getResourceBundle().getString(MensagensKey.WOF_MSG_FALHA.toString()),
									messages.getResourceBundle().getString(MensagensKey.WOF_MSG_FALHA.toString())));
		}
	}

	public static Properties getArquivoPtBR() {
		// o arquivo encontra-se no mesmo diretório //da aplicação
		File file = new File(
				FacesUtil
						.getCaminho("WEB-INF/classes/br/com/supermaia/menssagens/menssagens_pt_BR.properties"));

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			// lê os dados que estão no arquivo
			props.load(fis);
			fis.close();
		} catch (IOException ex) {
		//	System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return props;
	}

	public static void gravarArquivoPtBR() {
		// o arquivo encontra-se no mesmo diretório //da aplicação
		File file = new File(
				FacesUtil
						.getCaminho("WEB-INF/classes/br/com/supermaia/menssagens/menssagens_pt_BR.properties"));

		FileOutputStream fis = null;
		try {
			fis = new FileOutputStream(file);
			// lê os dados que estão no arquivo
			props.store(fis, "Mensagens");
			fis.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	public static Properties getArquivoEn() {
		// o arquivo encontra-se no mesmo diretório //da aplicação
		File file = new File(
				FacesUtil
						.getCaminho("WEB-INF/classes/br/com/supermaia/menssagens/menssagens_en.properties"));

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			// lê os dados que estão no arquivo
			propsEn.load(fis);
			fis.close();
		} catch (IOException ex) {
		//	System.out.println(ex.getMessage());
			ex.printStackTrace();
		}

		return propsEn;
	}

	public static void gravarArquivoEn() {
		// o arquivo encontra-se no mesmo diretório //da aplicação
		File file = new File(
				FacesUtil
						.getCaminho("WEB-INF/classes/br/com/supermaia/menssagens/menssagens_en.properties"));

		FileOutputStream fis = null;
		try {
			fis = new FileOutputStream(file);
			// lê os dados que estão no arquivo
			propsEn.store(fis, "Mensagens");
			fis.close();
		} catch (IOException ex) {
		//	System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

}
