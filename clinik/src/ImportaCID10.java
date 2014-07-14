import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import br.com.wofsolutions.dao.HibernateDAOImpl;
import br.com.wofsolutions.vo.CapituloCid10;
import br.com.wofsolutions.vo.CategoriaCid10;
import br.com.wofsolutions.vo.GrupoCid10;
import br.com.wofsolutions.vo.Modulo;
import br.com.wofsolutions.vo.SubCategoriaCid10;
import br.com.wofsolutions.vo.Usuario;

public class ImportaCID10 {

	static List<CategoriaCid10> categorias = new ArrayList<CategoriaCid10>();
	static List<SubCategoriaCid10> subCategorias = new ArrayList<SubCategoriaCid10>();
	static HibernateDAOImpl<CategoriaCid10, Modulo, Object> daoImpl2 = new HibernateDAOImpl<CategoriaCid10, Modulo, Object>() {
	};
	static List<CapituloCid10> capitulos = new ArrayList<CapituloCid10>();

	public static void main(String[] args) {

		// lerArquivoCategoria("C:\\Users\\Helber\\Documents\\Clinik\\CID-10-CATEGORIAS.csv");

		// lerArquivoSubCategoria("C:\\Users\\Helber\\Documents\\Clinik\\CID-10-SUBCATEGORIAS.csv");

		//lerArquivoGrupo("C:\\Users\\Helber\\Documents\\Clinik\\CID-10-GRUPOS.csv");
		
		lerArquivoCapitulo("C:\\Users\\Helber\\Documents\\Clinik\\CID-10-CAPITULOS.csv");
	}

	public static void lerArquivoCategoria(String arquivo) {

		HibernateDAOImpl<CategoriaCid10, Modulo, Object> daoImpl = new HibernateDAOImpl<CategoriaCid10, Modulo, Object>() {
		};

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

			double valorProduto = 0;
			double valorTotalProduto = 0;

			double valorTotal = 0;

			while (s != null) {

				s = br.readLine();

				if (s != null) {
					if (!s.trim().equals("")) {

						// System.out.println("oooo "+s.split(";")[0]);
						categorias.add(new CategoriaCid10(s.split(";")[0]
								.toUpperCase(), s.split(";")[1].toUpperCase(),
								s.split(";")[2].toUpperCase(), s.split(";")[3]
										.toUpperCase(), "", ""));

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (CategoriaCid10 categoria : categorias) {

			System.out.println(categoria.getCat() + " "
					+ categoria.getClassif() + " " + categoria.getDescricao()
					+ " " + categoria.getDescAbrev());

			daoImpl.salvar(categoria);
		}
	}

	public static void lerArquivoSubCategoria(String arquivo) {

		HibernateDAOImpl<CategoriaCid10, SubCategoriaCid10, Object> daoImpl = new HibernateDAOImpl<CategoriaCid10, SubCategoriaCid10, Object>() {
		};

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

			double valorProduto = 0;
			double valorTotalProduto = 0;

			double valorTotal = 0;

			CategoriaCid10 categoriaCid10;

			while (s != null) {

				s = br.readLine();

				if (s != null) {
					if (!s.trim().equals("")) {

						categoriaCid10 = daoImpl.findBy(
								"cat",
								s.split(";")[0].length() == 3 ? s.split(";")[0]
										: s.split(";")[0].substring(0,
												s.split(";")[0].length() - 1),
								HibernateDAOImpl.OP_EQUAL);

						subCategorias
								.add(new SubCategoriaCid10(s.split(";")[0]
										.toUpperCase(), s.split(";")[1]
										.toUpperCase(), s.split(";")[2]
										.toUpperCase(), s.split(";")[3]
										.toUpperCase(), s.split(";")[4]
										.toUpperCase(), s.split(";")[5]
										.toUpperCase(), "", "", categoriaCid10));

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (SubCategoriaCid10 categoria : subCategorias) {

			daoImpl.salvarObjeto(categoria);
		}
	}

	public static void lerArquivoGrupo(String arquivo) {

		HibernateDAOImpl<GrupoCid10, CategoriaCid10, Object> daoImpl = new HibernateDAOImpl<GrupoCid10, CategoriaCid10, Object>() {
		};

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

			double valorProduto = 0;
			double valorTotalProduto = 0;

			double valorTotal = 0;

			CategoriaCid10 categoriaCid10;
			categorias = daoImpl2.findAll();
			GrupoCid10 grupo;
			while (s != null) {

				s = br.readLine();

				if (s != null) {
					if (!s.trim().equals("")) {

						// categoriaCid10=daoImpl.findBy("cat",
						// s.split(";")[0].length()==3?s.split(";")[0]:s.split(";")[0].substring(0,
						// s.split(";")[0].length()-1),
						// HibernateDAOImpl.OP_EQUAL);
						//
						// subCategorias.add(new
						// SubCategoriaCid10(s.split(";")[0].toUpperCase(),
						// s.split(";")[1].toUpperCase(),
						// s.split(";")[2].toUpperCase(),
						// s.split(";")[3].toUpperCase(),
						// s.split(";")[4].toUpperCase(),
						// s.split(";")[5].toUpperCase(), "", "",
						// categoriaCid10));

						grupo = new GrupoCid10(s.split(";")[0],
								s.split(";")[1], s.split(";")[2],
								s.split(";")[3]);

						daoImpl.salvar(grupo);

						for (int i = Integer.parseInt(grupo.getCatInic()
								.substring(1, 3)); i <= Integer.parseInt(grupo
								.getCatFim().substring(1, 3)); i++) {
							
							
							
							
							
							System.out.println("Atual = "+grupo.getCatInic().substring(0,
									1)
									+ String.format("%02d",i)+" Final = "+grupo
									.getCatFim());
							;
							if(-1!=categorias.indexOf(new CategoriaCid10(
									grupo.getCatInic().substring(0, 1)
									+ String.format("%02d",i)))){
							categoriaCid10 = categorias
									.get(categorias.indexOf(new CategoriaCid10(
											 grupo.getCatInic().substring(0, 1)
													+ String.format("%02d",i))));
							categoriaCid10.setGrupoCid10(grupo);
							daoImpl.salvarObjeto(categoriaCid10);
							}
							
						}
						grupo = null;
						System.out.println("____________");
						// daoImpl.salvar(grupo);
						// for (CategoriaCid10 categoria : categorias) {
						// if (categoria.getCat().equals(s.split(";")[1])) {
						// categoria.setGrupoCid10(grupo);
						// daoImpl.salvarObjeto(categoria);
						// break;
						// } else if
						// (categoria.getCat().contains(s.split(";")[0].substring("")))
						// {
						//
						//
						//
						// categoria.setGrupoCid10(grupo);
						// daoImpl.salvarObjeto(categoria);
						// System.out.println(categoria.getDescricao());
						// }
						// }

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// for(SubCategoriaCid10 categoria: subCategorias){
		//
		//
		// daoImpl.salvarObjeto(categoria);
		// }
	}
	
	
	public static void lerArquivoCapitulo(String arquivo) {

		HibernateDAOImpl<CapituloCid10, Modulo, Object> daoImpl = new HibernateDAOImpl<CapituloCid10, Modulo, Object>() {
		};

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

			double valorProduto = 0;
			double valorTotalProduto = 0;

			double valorTotal = 0;

			while (s != null) {

				s = br.readLine();

				if (s != null) {
					if (!s.trim().equals("")) {

						System.out.println("oooo "+s.split(";")[0]);
						capitulos.add(new CapituloCid10( s.split(";")[1].toUpperCase(),
								s.split(";")[2].toUpperCase(), s.split(";")[3]
										.toUpperCase(),s.split(";")[4]
												.toUpperCase() ));

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (CapituloCid10 capituloCid10 : capitulos) {

		
			daoImpl.salvar(capituloCid10);
		}
	}
	
	
	
	
	
}
