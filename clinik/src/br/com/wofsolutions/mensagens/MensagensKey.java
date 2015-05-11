package br.com.wofsolutions.mensagens;

import java.io.Serializable;

public enum MensagensKey implements Serializable {
	WOF_LABEL_LOGIN {
		@Override
		public String toString() {
			return "wof.label.login";
		}
	},
	WOF_LABEL_SENHA {
		@Override
		public String toString() {
			return "wof.label.senha";
		}
	},
	WOF_LABEL_OUTROS {
		@Override
		public String toString() {
			return "system.label.outros";
		}
	},
	
	SYSTEM_USUARIO_OU_SENHA_INVALIDO {
		@Override
		public String toString() {
			return "system.msg.usuario.ou.senha.invalido";
		}
	},
	SYSTEM_MSG_USUARIO_INATIVO {
		@Override
		public String toString() {
			return "system.msg.usuario.inativo";
		}
	},
	WOF_MSG_USUARIO_ATIVACAO_CONCLUIDA {
		@Override
		public String toString() {
			return "wof.msg.usuario.ativacao.concluida";
		}
	},
	WOF_MSG_CADASTRO_USUARIO {
		@Override
		public String toString() {
			return "wof.msg.cadastro.usuario";
		}
	},
	WOF_MSG_USUARIO_EXISTE {
		@Override
		public String toString() {
			return "wof.msg.usuario.existe";
		}
	},
	WOF_MSG_USUARIO_EMAIL_INVALIDO {
		@Override
		public String toString() {
			return "wof.msg.usuario.email.invalido";
		}
	},
	WOF_MSG_SECAO_EXISTE {
		@Override
		public String toString() {
			return "wof.msg.secao.existe";
		}
	},
	WOF_MSG_SUCESSO {
		@Override
		public String toString() {
			return "wof.msg.sucesso";
		}
	},
	WOF_MSG_FALHA {
		@Override
		public String toString() {
			return "wof.msg.falha";
		}
	},
	WOF_MSG_CATEGORIA_EXISTE {
		@Override
		public String toString() {
			return "wof.msg.categoria.existe";
		}
	},WOF_MSG_ARTIGO_EXISTE {
		@Override
		public String toString() {
			return "wof.msg.artigo.existe";
		}
	},WOF_MSG_WORKFLOW_STATUS_EXISTE {
		@Override
		public String toString() {
			return "wof.msg.workflow.status";
		}
	},SYSTEM_MSG_EMAIL_PARA_TECNICO {
		@Override
		public String toString() {
			return "system.msg.email.para.tecnico";
		}
	},SYSTEM_MSG_AUTO_ATRIBUICAO_TECNICO_FILIZOLA {
		@Override
		public String toString() {
			return "system.msg.auto.atribuicao.tecnico.filizola";
		}
	},SYSTEM_MSG_AUTO_ATRIBUICAO_TECNICO_SEGURANCA {
		@Override
		public String toString() {
			return "system.msg.auto.atribuicao.tecnico.seguranca";
		}
	},
	
	
	SYSTEM_MSG_CHAMADO_EXISTENTE_EQUIPAMENTO {
		@Override
		public String toString() {
			return "system.msg.chamado.existente.equipamento";
		}
	},
	
	SYSTEM_MSG_NENHUM_EQUIPAMENTO_ENCONTRADO_CONTATO {
		@Override
		public String toString() {
			return "system.msg.nenhum.equipamento.encontrado.contato";
		}
	},
	SYSTEM_MSG_SELECIONE_UMA_CATEGORIA {
		@Override
		public String toString() {
			return "system.msg.selecione.uma.categoria";
		}
	},
	SYSTEM_MSG_EQUIPAMENTO_NAO_PERTENCE_A_LOJA {
		@Override
		public String toString() {
			return "system.msg.equipamento.nao.pertence.a.loja";
		}
	},	
	
	SYSTEM_MSG_CLIENTE_CADASTRADO {
		@Override
		public String toString() {
			return "system.msg.cliente.cadastrado";
		}
	},
	
	SYSTEM_MSG_CODIGO_PIN_PAD {
		@Override
		public String toString() {
			return "system.msg.codigo.pin.pad";
		}
	},SYSTEM_USUARIO_SEM_HOME {
		@Override
		public String toString() {
			return "system.msg.usuario.sem.home";
		}
	},	
	SYSTEM_MSG_EMAIL_ENVIADO_COM_SUCESSO {
		@Override
		public String toString() {
			return "system.msg.email.enviado.com.sucesso";
		}
	},
	SYSTEM_MSG_NAO_PERMITIDO_AGENDAMENTO {
		@Override
		public String toString() {
			return "system.msg.nao.permitido.agendamento";
		}
	},
	
	
}
