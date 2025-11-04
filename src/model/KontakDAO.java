package model;

import database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KontakDAO {
    public List<Kontak> getAllContacts() throws SQLException {
        List<Kontak> list = new ArrayList<>();
        String sql = "SELECT * FROM contacts";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Kontak(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("nomor_telepon"),
                        rs.getString("kategori")
                ));
            }
        }
        return list;
    }

    public void addContact(Kontak c) throws SQLException {
        String sql = "INSERT INTO contacts (nama, nomor_telepon, kategori) VALUES (?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNama());
            ps.setString(2, c.getNomorTelepon());
            ps.setString(3, c.getKategori());
            ps.executeUpdate();
        }
    }

    public void updateContact(Kontak c) throws SQLException {
        String sql = "UPDATE contacts SET nama=?, nomor_telepon=?, kategori=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getNama());
            ps.setString(2, c.getNomorTelepon());
            ps.setString(3, c.getKategori());
            ps.setInt(4, c.getId());
            ps.executeUpdate();
        }
    }

    public void deleteContact(int id) throws SQLException {
        String sql = "DELETE FROM contacts WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
