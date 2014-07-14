import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.wofsolutions.util.MaiaUtil;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// UsuarioDAOImpl impl = new UsuarioDAOImpl();
		//
//		 HibernateDAOImpl<Usuario, Object, Object> impl = new
//		 HibernateDAOImpl<Usuario, Object, Object>() {
//		 };
//		 
//		 month agendaDay agendaWeek basicWeek basicDay
//		 
//		 System.out.println(impl.findAll().size());
//		 
		 
		//
		//
		// List<Usuario> usuarios = impl.findAllBy("login", "%o%",
		// HibernateDAOImpl.OP_LIKE);
		//
		// for(Usuario usuario: usuarios){
		// System.out.println(usuario.getLogin());
		// }

//		AtendimentoController controller = new AtendimentoController();
//
//		
//		
//		//controller.init();
//		List<Atendimento> list =controller.getLista();
//		
//		for(Atendimento a: list){
//			System.out.println(a.getPaciente()+" Valor="+a.getValor());
//		}		
		
		
		
		MaiaUtil maiaUtil = new MaiaUtil();
		
//		try {
//			System.out.println(maiaUtil.StringToDate(maiaUtil.DateToStringDataSomente(new Date())+" "+8+":00:00"));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		GregorianCalendar gc = new GregorianCalendar();  
		gc.setTime(new Date());  
		  
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");  
		System.out.println(sdf.format(gc.getTime()));  
		
		gc.add(Calendar.HOUR,8);
		gc.add(Calendar.MINUTE,30);  
		System.out.println(sdf.format(gc.getTime()));
	}
}