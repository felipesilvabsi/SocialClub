package br.com.open.socialclub.dao;

import br.com.open.socialclub.modelo.Pais;
import br.com.open.socialclub.persistencia.AbstractDao;
import br.com.open.socialclub.persistencia.DaoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PaisDAO extends AbstractDao<Pais>{

    public PaisDAO(boolean owner) {
        super(owner);
    }

    @Override
    public long save(Pais obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveAll(List<Pais> objs) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Pais obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Pais obj) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByParams(HashMap<String, Object> params) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pais> findAll() throws DaoException {
        List<Pais> lista = new ArrayList<Pais>();
        Pais pais;

        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {

            con = getConnection();

            stm = con.createStatement();
            String sql = "SELECT * FROM pais ORDER BY nome";

            rs = stm.executeQuery(sql);

            while (rs.next()) {
                pais = new Pais();
                pais.setCodigo(rs.getInt("codigo"));
                pais.setNome(rs.getString("nome"));

                lista.add(pais);
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
    public List<Pais> findByParams(HashMap<String, Object> params) throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pais findById(long id) throws DaoException {
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
