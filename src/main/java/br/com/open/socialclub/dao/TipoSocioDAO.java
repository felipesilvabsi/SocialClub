package br.com.open.socialclub.dao;

import br.com.open.socialclub.modelo.TipoSocio;
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


public class TipoSocioDAO extends AbstractDao<TipoSocio>{

    public TipoSocioDAO(boolean owner) {
        super(owner);
    }

    @Override
    public long save(TipoSocio obj) throws DaoException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = getConnection();

            this.beginTransaction();

            String sql = "INSERT INTO tipo_socio (descricao) VALUES (?)";

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
    public void saveAll(List<TipoSocio> objs) throws DaoException {
        //
    }

    @Override
    public void update(TipoSocio obj) throws DaoException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = getConnection();

            this.beginTransaction();

            String sql = "UPDATE tipo_socio SET descricao = ? WHERE codigo = ?";

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
    public void delete(TipoSocio obj) throws DaoException {
        Connection con = null;
        PreparedStatement stm = null;

        try {

            con = getConnection();
            this.beginTransaction();

            String sql = "DELETE FROM tipo_socio WHERE codigo = ?";

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
    public List<TipoSocio> findAll() throws DaoException {
        List<TipoSocio> lista = new ArrayList<TipoSocio>();
        TipoSocio tipo;

        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {

            con = getConnection();

            stm = con.createStatement();
            String sql = "SELECT * FROM tipo_socio ORDER BY descricao";

            rs = stm.executeQuery(sql);

            while (rs.next()) {
                tipo = new TipoSocio();
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
    public List<TipoSocio> findByParams(HashMap<String, Object> params) throws DaoException {
        List<TipoSocio> lista = new ArrayList<TipoSocio>();
        TipoSocio tipo;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {

            con = getConnection();

            String sql = "SELECT * FROM tipo_socio";

            stm = this.getPreparedStatementByHashMap(con, sql, params);

            rs = stm.executeQuery();

            while (rs.next()) {
                tipo = new TipoSocio();
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
    public TipoSocio findById(long id) throws DaoException {
        TipoSocio tipo = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {

            String sql = "SELECT * FROM tipo_socio WHERE codigo = ?";

            con = getConnection();

            stm = con.prepareStatement(sql);

            stm.setLong(1, id);

            rs = stm.executeQuery();

            if (rs.next()) {

                tipo = new TipoSocio();
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
            String sql = "SELECT * FROM tipo_socio";

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
