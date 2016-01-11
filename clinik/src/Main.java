import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.javadude.annotation.Default;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// UsuarioDAOImpl impl = new UsuarioDAOImpl();
		//
		// HibernateDAOImpl<Usuario, Object, Object> impl = new
		// HibernateDAOImpl<Usuario, Object, Object>() {
		// };
		//
		// month agendaDay agendaWeek basicWeek basicDay
		//
		// System.out.println(impl.findAll().size());
		//

		//
		//
		// List<Usuario> usuarios = impl.findAllBy("login", "%o%",
		// HibernateDAOImpl.OP_LIKE);
		//
		// for(Usuario usuario: usuarios){
		// System.out.println(usuario.getLogin());
		// }

		// AtendimentoController controller = new AtendimentoController();
		//
		//
		//
		// //controller.init();
		// List<Atendimento> list =controller.getLista();
		//
		// for(Atendimento a: list){
		// System.out.println(a.getPaciente()+" Valor="+a.getValor());
		// }

		// MaiaUtil maiaUtil = new MaiaUtil();
		//
		// // try {
		// //
		// System.out.println(maiaUtil.StringToDate(maiaUtil.DateToStringDataSomente(new
		// Date())+" "+8+":00:00"));
		// // } catch (ParseException e) {
		// // // TODO Auto-generated catch block
		// // e.printStackTrace();
		// // }
		// GregorianCalendar gc = new GregorianCalendar();
		// gc.setTime(new Date());
		//
		// SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		// System.out.println(sdf.format(gc.getTime()));
		//
		// gc.add(Calendar.HOUR,8);
		// gc.add(Calendar.MINUTE,30);
		// System.out.println(sdf.format(gc.getTime()));

		// lerArquivo("C:\\Users\\Helber\\Documents\\not\\teste.txt");
		
	}

	
	public static void lerArquivo(String arquivo) {
		File f = new File(arquivo);
		if (!f.exists()) {
			System.out.println("Arquivo" + arquivo + " nÃ£o existe");
			return;
		}
		try {
			// fluxo de entrada a partir de um arquivo
			InputStream is = new FileInputStream(arquivo);
			// classe que converte os bytes em chars
			InputStreamReader isr = new InputStreamReader(is);
			// armazena os chars em memÃ³ria
			BufferedReader br = new BufferedReader(isr);
			// inicia na primeira linha
			br.readLine();
			String s = br.readLine();

			String script = "";

			int ant = 0;
			int total = 0;
			int totalAcumulado = 0;

			while (s != null) {

				s = br.readLine();

				if (s != null) {

					System.out.println("Ant =" + ant);
					System.out.println("Atual =" + s.substring(1, s.length()));
					total = ant + Integer.parseInt(s.substring(1, s.length()));
					totalAcumulado += total;
					System.out.println("total =" + total);
					System.out.println("total Acumulado=" + totalAcumulado);
					ant = Integer.parseInt(s.substring(1, s.length()));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}