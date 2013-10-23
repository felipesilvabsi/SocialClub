package br.com.open.socialclub.dao;

import br.com.open.socialclub.modelo.Socio;
import br.com.open.socialclub.persistencia.AbstractDao;
import br.com.open.socialclub.persistencia.DaoException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class SocioDAO extends AbstractDao<Socio> {

    public SocioDAO(boolean owner) {
        super(owner);
    }

    @Override
    public long save(Socio obj) throws DaoException {
        Connection con = null;
        PreparedStatement stm = null;

        try {

            String nome = obj.getNome();
            String logradouro = obj.getEndereco().getLogradouro();
            String numero = obj.getEndereco().getNumero();
            String complemento = obj.getEndereco().getComplemento();
            String pontoReferencia = obj.getEndereco().getPontoReferencia();
            String bairro = obj.getEndereco().getBairro();
            int cidade = obj.getEndereco().getCidade().getCodigo();
            String cep = obj.getEndereco().getCep();
            String email = obj.getEndereco().getEmail();
            
            String cpfCnpj = "";
            
            if (obj.getDadosPessoaFisica().getCpf().getDocumento() != null) {
                cpfCnpj = obj.getDadosPessoaFisica().getCpf().getDocumento();
            } else if (obj.getDadosPessoaJuridica().getCnpj().getDocumento() != null) {
                cpfCnpj = obj.getDadosPessoaJuridica().getCnpj().getDocumento();
            }
            
            String rg = obj.getDadosPessoaFisica().getRg().getNumero();
            Date dataEmissao = null;
            
            if (obj.getDadosPessoaFisica().getRg().getDataEmissao() != null) {
                dataEmissao = new java.sql.Date(obj.getDadosPessoaFisica().getRg().getDataEmissao().getTime());
            }
            
            String orgaoEmissor = obj.getDadosPessoaFisica().getRg().getOrgaoEmissor();
            
            String ufRg = obj.getDadosPessoaFisica().getRg().getUf().getSigla();
            String apelido = obj.getDadosPessoaFisica().getApelido();
            String nomeDoPai = obj.getDadosPessoaFisica().getNomeDoPai();
            String nomeDaMae = obj.getDadosPessoaFisica().getNomeDaMae();
            
            Date dataNascimento = null;
            if (obj.getDadosPessoaFisica().getDataNascimento() != null) {
                dataNascimento = new java.sql.Date(obj.getDadosPessoaFisica().getDataNascimento().getTime());
            }
            
            String nomeFantasia = obj.getDadosPessoaJuridica().getNomeFantasia();
            String sexo = "";
            
            if (obj.getDadosPessoaFisica().getSexo() != null) {
                sexo = obj.getDadosPessoaFisica().getSexo();
            }
            
            int categoria = obj.getCategoriaSocio().getCodigo();
            int tipo = obj.getTipoSocio().getCodigo();
            
            int inativo = 0;
            
            if (obj.isInativo()) {
                inativo = 1;
            }            
            
            java.util.Date dataHoje = new java.util.Date();
            Date dataCadastro = new java.sql.Date(dataHoje.getTime());
            String cadastradoPor = obj.getCadastradoPor();
            Date dataModificado = new java.sql.Date(dataHoje.getTime());
            String modificadoPor = obj.getModificadoPor();

            con = getConnection();

            this.beginTransaction();

            String sql = " INSERT INTO socio(nome, logradouro, numero, complemento, ponto_referencia, bairro,   "
                       + "                   codigo_cidade, cep, email, cpf_cnpj, rg, orgao_rg, data_rg, uf_rg, "
                       + "                   apelido, nome_pai, nome_mae, data_nascimento, nome_fantasia,       "
                       + "                   sexo, codigo_categoria, tipo_socio, inativo, data_cadastro,        "
                       + "                   cadastrado_por, data_modificado, modificado_por)                   "
                       + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,                                    "
                       + "         ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);                                      ";

            stm = con.prepareStatement(sql);
            //stm.setString(1, obj.getNome());

            stm.setString(1, nome);
            stm.setString(2, logradouro);
            stm.setString(3, numero);
            stm.setString(4, complemento);
            stm.setString(5, pontoReferencia);
            stm.setString(6, bairro);
            stm.setInt(7, cidade);
            stm.setString(8, cep);
            stm.setString(9, email);
            stm.setString(10, cpfCnpj);
            stm.setString(11, rg);
            stm.setString(12, orgaoEmissor);
            stm.setDate(13, dataEmissao);
            stm.setString(14, ufRg);
            stm.setString(15, apelido);
            stm.setString(16, nomeDoPai);
            stm.setString(17, nomeDaMae);
            stm.setDate(18, dataNascimento);
            stm.setString(19, nomeFantasia);
            stm.setString(20, sexo);            
            stm.setInt(21, categoria);
            stm.setInt(22, tipo);
            stm.setInt(23, inativo);
            stm.setDate(24, dataCadastro);
            stm.setString(25, cadastradoPor);
            stm.setDate(26, dataModificado);
            stm.setString(27, modificadoPor);
            
            stm.execute();

            this.commitTransaction();

        } catch (SQLException e) {
            try {
                this.rollbackTransaction();
                e.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        } finally {
            this.free(con, stm, null, null);
        }
        return 0;
    }

    @Override
    public void saveAll(List<Socio> objs) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Socio obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Socio obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByParams(HashMap<String, Object> params) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Socio> findAll() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Socio> findByParams(HashMap<String, Object> params) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Socio findById(long id) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clean() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCount() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
