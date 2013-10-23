package br.com.open.socialclub.dao;

import br.com.open.socialclub.modelo.TipoTelefone;
import br.com.open.socialclub.persistencia.AbstractDao;
import br.com.open.socialclub.persistencia.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TipoTelefoneDAO extends AbstractDao<TipoTelefone>{

    public TipoTelefoneDAO(boolean owner) {
        super(owner);
    }

    @Override
    public long save(TipoTelefone obj) throws DaoException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = getConnection();

            this.beginTransaction();

            String sql = "INSERT INTO tipo_telefone (descricao) VALUES (?)";

            stm = con.prepareStatement(sql);
            stm.setString(1, obj.getDescricao());

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
    public void saveAll(List<TipoTelefone> objs) throws DaoException {
        //
    }

    @Override
    public void update(TipoTelefone obj) throws DaoException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = getConnection();

            this.beginTransaction();

            String sql = "UPDATE tipo_telefone SET descricao = ? WHERE codigo = ?";

            stm = con.prepareStatement(sql);
            stm.setString(1, obj.getDescricao());
            stm.setLong(2, obj.getCodigo());

            stm.executeUpdate();

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
    }

    @Override
    public void delete(TipoTelefone obj) throws DaoException {
        Connection con = null;
        PreparedStatement stm = null;

        try {

            con = getConnection();
            this.beginTransaction();

            String sql = "DELETE FROM tipo_telefone WHERE codigo = ?";

            stm = con.prepareStatement(sql);
            stm.setLong(1, obj.getCodigo());

            stm.executeUpdate();

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
    }

    @Override
    public void deleteByParams(HashMap<String, Object> params) throws DaoException {
        //
    }

    @Override
    public List<TipoTelefone> findAll() throws DaoException {
        List<TipoTelefone> lista = new ArrayList<TipoTelefone>();
        TipoTelefone tipo;

        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {

            con = getConnection();

            stm = con.createStatement();
            String sql = "SELECT * FROM tipo_telefone ORDER BY descricao";

            rs = stm.executeQuery(sql);

            while (rs.next()) {
                tipo = new TipoTelefone();
                tipo.setCodigo(rs.getInt("codigo"));
                tipo.setDescricao(rs.getString("descricao"));

                lista.add(tipo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e.getMessage());
        } finally {
            this.free(con, null, stm, rs);
        }
        return lista;
    }

    @Override
    public List<TipoTelefone> findByParams(HashMap<String, Object> params) throws DaoException {
        List<TipoTelefone> lista = new ArrayList<TipoTelefone>();
        TipoTelefone tipo;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {

            con = getConnection();

            String sql = "SELECT * FROM tipo_telefone";

            stm = this.getPreparedStatementByHashMap(con, sql, params);

            rs = stm.executeQuery();

            while (rs.next()) {
                tipo = new TipoTelefone();
                tipo.setCodigo(rs.getInt("codigo"));
                tipo.setDescricao(rs.getString("descricao"));

                lista.add(tipo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e.getMessage());
        } finally {
            this.free(con, null, stm, rs);
        }
        return lista;
    }

    @Override
    public TipoTelefone findById(long id) throws DaoException {
        TipoTelefone tipo = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {

            String sql = "SELECT * FROM tipo_telefone WHERE codigo = ?";

            con = getConnection();

            stm = con.prepareStatement(sql);

            stm.setLong(1, id);

            rs = stm.executeQuery();

            if (rs.next()) {

                tipo = new TipoTelefone();
                tipo.setCodigo(rs.getInt("codigo"));
                tipo.setDescricao(rs.getString("descricao"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e.getMessage());
        } finally {
            this.free(con, null, stm, rs);
        }

        return tipo;
    }

    @Override
    public void clean() throws DaoException {
        //
    }

    @Override
    public int getCount() throws DaoException {
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {

            con = getConnection();

            stm = con.createStatement();
            String sql = "SELECT * FROM tipo_telefone";

            rs = stm.executeQuery(sql);

            if (rs.next()) {

                rs.last();
                return rs.getRow();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException(e.getMessage());
        } finally {
            this.free(con, null, stm, rs);
        }

        return 0;
    }
	
}
