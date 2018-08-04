/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constantes;

/**
 *
 * @author gbartholomeu
 */
public class Expressions {

    public enum DAO {
        SELECT_BASE_EX("Falha ao executar SELECT da base: "),
        INSERT_BASE_EX("Falha ao executar INSERT na base: "),
        UPDATE_BASE_EX("Falha ao executar UPDATE na base: "),
        DELETE_BASE_EX("Falha ao executar DELETE na base: ");

        private final String expression;

        DAO(String expression) {
            this.expression = expression;
        }

        public String getExpression() {
            return this.expression;
        }
    }

    public enum CONNECTION {
        DATABASE_CONNECTION_EX("Falha ao criar conexão com o banco de dados: "),
        DRIVER_CONNECTION_EX("Driver de conexão não encontrado: "),
        CONFIG_FILE_EX("Erro ao ler o arquivo de configuração: ");

        private final String expression;

        CONNECTION(String expression) {
            this.expression = expression;
        }

        public String getExpression() {
            return this.expression;
        }
    }

    public enum USER {
        USER_SELECT_RETURN_FAIL("Falha na obtenção das configurações do usuário: "),
        WRONG_PASSWORD("Senha incorreta."),
        MISSING_USER("Usuário não existe."),
        NO_USER("Por favor insira um usuário."),
        EXISTING_USER("Usuário já cadastrado."),
        NEW_USER_SUCESS("Usuário cadastrado com sucesso."),
        NEW_USER_FAIL("Usuário não cadastrado.");
        
        private final String expression;

        USER(String expression) {
            this.expression = expression;
        }

        public String getExpression() {
            return this.expression;
        }
    }

    public enum DAO_RETURN {
        SELECT_RETURN_FAIL("Falha ao obter registros do banco de dados."),
        INSERT_RETURN_FAIL("Falha ao inserir registro no banco de dados."),
        UPDATE_RETURN_FAIL("Falha ao atualizar objeto."),
        DELETE_RETURN_FAIL("Falha ao excluir objeto."),
        VALIDATE_RETURN_FAIL("Falha ao validar objeto"),
        VALIDATE_RETURN_OK("Objeto validado com sucesso");

        private final String expression;

        DAO_RETURN(String expression) {
            this.expression = expression;
        }

        public String getExpression() {
            return this.expression;
        }
    }

    public enum COMPONENTS {
        GRID("Grid"),
        DETAIL("Detalhe"),
        ACTIVATE("Ativar"),
        INACTIVATE("Inativar"),
        SAVE("Salvar"),
        EDIT("Editar"),
        PROCEDURE_UPPER("PROCEDURE"),
        FUNCTION_UPPER("FUNCTION"),
        TRIGGER_UPPER("TRIGGER"),
        COLUMNN_ADD_FAIL("Falha na adição das colunas ao objeto de tabela: "),
        ROW_ADD_FAIL("Falha na adição das linhas ao objeto de tabela: "),
        MISSING_FIELDS("Existem campos não informados.");

        private final String expression;

        COMPONENTS(String expression) {
            this.expression = expression;
        }

        public String getExpression() {
            return this.expression;
        }
    }

    public enum TABLE_COLUMNS {
        NR_SEQUENCE("Sequência"),
        DS_NAME("Nome objeto"),
        DS_TYPE("Tipo objeto"),
        DT_INSERTION("Data inserção"),
        DT_UPDATE("Data atualização"),
        DT_INSERTION_HISTORY("Data histórico"),
        DS_USER("Usuário criação"),
        DS_USER_UPDATE("Usuário atualização"),
        DS_USER_HIST("Usuário modificação"),
        IS_ACTIVE("Ativo"),
        NOT_A_COLUMN("NOT_A_COLUMN"),
        USERNAME("Usuário"),
        FULL_NAME("Nome Completo"),
        IS_ADMIN("Administrador");

        private final String expression;

        TABLE_COLUMNS(String expression) {
            this.expression = expression;
        }

        public String getExpression() {
            return this.expression;
        }
    }

    public enum EXCEPTIONS {
        TESTE("");

        private final String expression;

        EXCEPTIONS(String expression) {
            this.expression = expression;
        }

        public String getExpression() {
            return this.expression;
        }
    }
}
