package controller;

import model.Kontak;
import model.KontakDAO;
import java.sql.SQLException;
import java.util.List;

public class KontakController {
    private KontakDAO dao = new KontakDAO();

    public List<Kontak> getAllContacts() throws SQLException {
        return dao.getAllContacts();
    }
    public void addContact(String n, String t, String k) throws SQLException {
        dao.addContact(new Kontak(0, n, t, k));
    }
    public void updateContact(int id, String n, String t, String k) throws SQLException {
        dao.updateContact(new Kontak(id, n, t, k));
    }
    public void deleteContact(int id) throws SQLException {
        dao.deleteContact(id);
    }
}
