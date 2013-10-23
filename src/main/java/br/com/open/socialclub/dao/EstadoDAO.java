package br.com.open.socialclub.dao;

import br.com.open.socialclub.modelo.Estado;
import br.com.open.socialclub.persistencia.AbstractDao;
import br.com.open.socialclub.persistencia.DaoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EstadoDAO extends AbstractDao<Estado>{

    public EstadoDAO(boolean owner) {
        super(owner);
    }

    @Override
    public long save(Estado obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAll(List<Estado> objs) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Estado obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Estado obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByParams(HashMap<String, Object> params) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estado> findAll() throws DaoException {
        List<Estado> lista = new ArrayList<Estado>();
        Estado estado;

        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {

            con = getConnection();

            stm = con.createStatement();
            String sql = "SELECT * FROM cidade ORDER BY nome";

            rs = stm.executeQuery(sql);

            while (rs.next()) {
                estado = new Estado();
                estado.setCodigo(rs.getInt("codigo"));
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));                

                lista.add(estado);
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
    public List<Estado> findByParams(HashMap<String, Object> params) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado findById(long id) throws DaoException {
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
