package br.com.wofsolutions.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.wofsolutions.vo.Usuario;

public class MaiaUtil {
	public static int ARREDONDAR_PARA_CIMA = 0;
	public static int ARREDONDAR_PARA_BAIXO = 1;
	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	private static SimpleDateFormat simpleDateFormatData = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat simpleDateFormatHora = new SimpleDateFormat("hh:mm:ss");
	private static SimpleDateFormat dateFormatAnoSomente = new SimpleDateFormat("yyyy");
	private static Usuario usuario;
	
	/**
	 * Função para preencher um código EAN até o total de 13
	 * 
	 * @param codigoEan
	 *            a ser preenchido
	 * @return codigoEan contendo 0 a direita até o tamanho de 13
	 */
	public static String preencheCodigoEANComZero(String codigoEan) {
		for (int i = 0; 13 > codigoEan.length(); i++) {
			codigoEan = "0" + codigoEan;
		}
		return codigoEan;
	}

	/**
	 * Função para arredondar um valor em 2 casas decimais
	 * 
	 * @param valor
	 * @return valor arredondado
	 */
	@Deprecated
	public static double arredondaValorParaDuasCasasDecimais(double valor) {
		double result = (Math.round((valor * 100.0))) / 100.0;
		return result;
	}

	/**
	 * Função para arredondar as um valor em uma determinada quantidade de casas
	 * decimais
	 * 
	 * @param valor
	 *            a ser arredondado
	 * @param casas
	 *            numero de casas
	 * @param ceilOrFloor
	 *            tipo de arredondamento usa-se : ARREDONDAR_PARA_CIMA ou
	 *            ARREDONDAR_PARA_BAIXO
	 * @return valor com as casas
	 */

	public static double arredondar(double valor, int casas, int ceilOrFloor) {

		BigDecimal arredondado = new BigDecimal(valor);

		if (ceilOrFloor == ARREDONDAR_PARA_CIMA) {
			arredondado = arredondado.setScale(casas, BigDecimal.ROUND_HALF_UP);
		} else {
			arredondado = arredondado.setScale(casas, BigDecimal.ROUND_DOWN);
		}
		return arredondado.doubleValue();
	}

	/**
	 * Calcula a diferença de duas datas em dias <br>
	 * <b>Importante:</b> Quando realiza a diferença em dias entre duas datas,
	 * este método considera as horas restantes e as converte em fração de dias.
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return quantidade de dias existentes entre a dataInicial e dataFinal.
	 */
	public static double diferencaEmDias(Date dataInicial, Date dataFinal) {
		double result = 0;
		long diferenca = dataFinal.getTime() - dataInicial.getTime();
		
	//	System.out.println(dataFinal+"---"+ dataInicial);
		double diferencaEmDias = (diferenca / 1000) / 60 / 60 / 24; // resultado
																	// é
																	// diferença
																	// entre as
																	// datas em
																	// dias
		long horasRestantes = (diferenca / 1000) / 60 / 60 % 24; // calcula as
																	// horas
																	// restantes
		result = diferencaEmDias + (horasRestantes / 24d); // transforma as
															// horas restantes
															// em fração de
															// dias

		return result;
	}

	/**
	 * Calcula a diferença de duas datas em horas <br>
	 * <b>Importante:</b> Quando realiza a diferença em horas entre duas datas,
	 * este método considera os minutos restantes e os converte em fração de
	 * horas.
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return quantidade de horas existentes entre a dataInicial e dataFinal.
	 */
	public static double diferencaEmHoras(Date dataInicial, Date dataFinal) {
		double result = 0;
		long diferenca = dataFinal.getTime() - dataInicial.getTime();
		long diferencaEmHoras = (diferenca / 1000) / 60 / 60;
		long minutosRestantes = (diferenca / 1000) / 60 % 60;
		double horasRestantes = minutosRestantes / 60d;
		result = diferencaEmHoras + (horasRestantes);

		return result;
	}

	/**
	 * Calcula a diferença de duas datas em minutos <br>
	 * <b>Importante:</b> Quando realiza a diferença em minutos entre duas
	 * datas, este método considera os segundos restantes e os converte em
	 * fração de minutos.
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return quantidade de minutos existentes entre a dataInicial e dataFinal.
	 */
	public static double diferencaEmMinutos(Date dataInicial, Date dataFinal) {
		double result = 0;
		long diferenca = dataFinal.getTime() - dataInicial.getTime();
		double diferencaEmMinutos = (diferenca / 1000) / 60; // resultado é
																// diferença
																// entre as
																// datas em
																// minutos
		long segundosRestantes = (diferenca / 1000) % 60; // calcula os segundos
															// restantes
		result = diferencaEmMinutos + (segundosRestantes / 60d); // transforma
																	// os
																	// segundos
																	// restantes
																	// em
																	// minutos

		return result;
	}

	public static String soNumero(String sonumero) {
		String strSoNumero = "";
		char[] texto = strSoNumero.toCharArray();
		for (int i = 0; i < texto.length; i++) {
			if (texto[i] >= '0' && texto[i] <= '9') {
				strSoNumero = strSoNumero + texto[i];
			}
		}
		return strSoNumero;
	}

	
	public static int diffData(Date dataFim, Date dataInicio) {
		return (int) (dataFim.getTime() / 86400000)
				- (int) (dataInicio.getTime() / 86400000);
	}

	public static Date hoje() {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return d;
	}
	
	
	/**
	 * Converte uma String para data
	 * @param data String a ser convertida
	 * @return Retorna uma data no seguinte formato exmplo: Fri Apr 27 00:23:06 BRT 2012
	 * @throws ParseException
	 */
	public static Date StringToDate(String data) throws ParseException{		
		if(data.equals("  /  /    ")){
			data=simpleDateFormatData.format(new Date());
		}
		return simpleDateFormat.parse(data+" "+simpleDateFormatHora.format(new Date()));
	}
	
	/**
	 * Converte uma data para o seguinte formato: dd/MM/yyyy hh:mm:ss  
	 * @param data a ser formatada
	 * @return Uma String com o formato: dd/MM/yyyy hh:mm:ss
	 */
	public static String DateToStringDataHora(Date data){
		return simpleDateFormat.format(data);
	}
	
	
	/**
	 * Converte uma data para o seguinte formato: yyyy  
	 * @param data a ser formatada
	 * @return Uma String com o formato: yyyy
	 */
	public static String dateToStringDataAno(Date data){
		return dateFormatAnoSomente.format(data);
	}
	
	public static String primeirodiaDoMes(){
		simpleDateFormat = new SimpleDateFormat("MM/yyyy");
		try {
			return simpleDateFormatData.format(simpleDateFormatData.parse("01/"+simpleDateFormat.format(new Date())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	
	
	
	public static Date ultimoDiaDoMesDate(){
		simpleDateFormat = new SimpleDateFormat("MM/yyyy");
		Calendar c = new GregorianCalendar();
		try {
			return simpleDateFormatData.parse(c.getActualMaximum(Calendar.DAY_OF_MONTH)+"/"+simpleDateFormat.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date primeirodiaDoMesDate(){
		simpleDateFormat = new SimpleDateFormat("MM/yyyy");
		try {
			return simpleDateFormatData.parse("01/"+simpleDateFormat.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Converte uma data para o seguinte formato: dd/MM/yyyy  
	 * @param data a ser formatada
	 * @return Uma String com o formato: dd/MM/yyyy
	 */
	public static String DateToStringDataSomente(Date data){
		return simpleDateFormatData.format(data);
	}
	
	/**
	 * Converte uma data para o seguinte formato: dd/MM/yyyy  
	 * @param data a ser formatada
	 * @return Uma String com o formato: dd/MM/yyyy
	 */
	public static String DateToStringFormatoAmericanoDataSomente(Date data){
		simpleDateFormatData = new SimpleDateFormat("MM/dd/yyyy");
		return simpleDateFormatData.format(data);
	}
	
	
	
	/**
	 * Converte uma data para o seguinte formato: hh:mm:ss  
	 * @param data a ser formatada em horas
	 * @return Uma String com o formato: hh:mm:ss
	 */
	public static String DateToStringHoraSomente(Date data){
		return simpleDateFormatHora.format(data);
	}
	
	public static void setUsuario(Usuario novoUsuario){
		usuario = novoUsuario; 
	}
	
	public static Usuario getUsuario() {
		return usuario;
	}
	
	
	public static void lerArquivo(String arquivo) {
		File f = new File(arquivo);

		if (!f.exists()) {
		//	System.out.println("Arquivo" + arquivo + " não existe");
			return;
		}

		try {
			// fluxo de entrada a partir de um arquivo
			InputStream is = new FileInputStream(arquivo);
			// classe que converte os bytes em chars
			InputStreamReader isr = new InputStreamReader(is);
			// armazena os chars em memória
			BufferedReader br = new BufferedReader(isr);
			// inicia na primeira linha
			String s = br.readLine();
			while (s != null) {
			//	System.out.println(s);
				s = br.readLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static String md5(String senha) {
		String novaSenha = "";

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes());
			BigInteger hash = new BigInteger(1, md.digest());
			novaSenha = hash.toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return novaSenha;
	}
}
