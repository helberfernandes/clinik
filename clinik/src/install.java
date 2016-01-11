import java.util.Date;

import br.com.wofsolutions.dao.HibernateDAOImpl;
import br.com.wofsolutions.util.MaiaUtil;
import br.com.wofsolutions.vo.Empresa;
import br.com.wofsolutions.vo.Modulo;
import br.com.wofsolutions.vo.Pagina;
import br.com.wofsolutions.vo.Permissao;
import br.com.wofsolutions.vo.PermissaoPaginaRole;
import br.com.wofsolutions.vo.PermissaoPaginaRolePk;
import br.com.wofsolutions.vo.Role;
import br.com.wofsolutions.vo.Usuario;

public class install {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		empresa.setDataCadastro(new Date());
		empresa.setNome("Root");
		empresa.setCnpj("00.000.000/0000-00");
		Role role = new Role();
		role.setNome("Super Ususario");
		role.setDescricao("Super Ususario");
		Permissao permissao = new Permissao();
		permissao.setAddUser(true);
		role.setPermissao(permissao);

		Usuario usuario = new Usuario();
		usuario.setLogin("root");
		usuario.setNome("root");
		usuario.setSenha(MaiaUtil.md5("st1215"));
		usuario.setRole(role);
		usuario.setEmpresa(empresa);
		
		
		HibernateDAOImpl<Usuario, Modulo, Object> daoImpl = new HibernateDAOImpl<Usuario, Modulo, Object>() {
		};
		daoImpl.salvar(usuario);
		
		Modulo modulo = new Modulo();//		
		modulo.setDescricao("Clinik basico");
		modulo.setNome("Clinik basico");
//		
//		
//		Pagina pagina = new Pagina();
//		pagina.setDescricao("Cadastro de Médicos");
//		pagina.setLink("/medicos/");
//		pagina.setModulo(modulo);
//		modulo.getPaginas().add(pagina);
//
//		
//		pagina = new Pagina();
//		pagina.setDescricao("Convenios");
//		pagina.setLink("/convenio/");
//		pagina.setModulo(modulo);
//		modulo.getPaginas().add(pagina);
//		
//		
//		pagina = new Pagina();
//		pagina.setDescricao("Cadastro de Exames");
//		pagina.setLink("/exames/");
//		pagina.setModulo(modulo);
//		modulo.getPaginas().add(pagina);
//		
//		
//		pagina = new Pagina();
//		pagina.setDescricao("Cadastro de Panos de Saúde");
//		pagina.setLink("/planos/");
//		pagina.setModulo(modulo);
//		modulo.getPaginas().add(pagina);
//		daoImpl.salvarObjeto(modulo);
		
//		PermissaoPaginaRole paginaRole = new PermissaoPaginaRole();
//		paginaRole.setAutorizado(true);
//		paginaRole.setPermissaoPaginaRolePk( new PermissaoPaginaRolePk(pagina, role));
		
		
	
	}
}
