package Scripts.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Scripts.Database.ConnFactory;
import Scripts.Model.Character;

/**
 * CharacterRepository
 */
public class CharacterRepository {

    Connection conn;

    public CharacterRepository() {
        this.conn = ConnFactory.getConn();
    }

    public ArrayList<Scripts.Model.Character> GetAllCharcters() {
        String command = "SELECT * FROM tb_character";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;

        ArrayList<Scripts.Model.Character> characters = new ArrayList<Scripts.Model.Character>();
        try {
            stmt = conn.prepareStatement(command);
            ResultSet result = stmt.executeQuery();
            characters = this.getValues(result);
        } catch (SQLException e) {
            System.out.println("Erro ao incluir os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
        return characters;
    }

    private ArrayList<Scripts.Model.Character> getValues(ResultSet resultSet) {
        ArrayList<Scripts.Model.Character> values = new ArrayList<Scripts.Model.Character>();
        try {
            while (resultSet.next()) {
                Scripts.Model.Character character = new Character();
                character.setId(resultSet.getInt(1));
                character.setName(resultSet.getString(2));
                character.setSkillClass(resultSet.getString(3));
                character.setEyeColor(resultSet.getString(4));
                character.setSkinColor(resultSet.getString(5));
                character.setPhysicType(resultSet.getString(6));

                values.add(character);
            }

        } catch (Exception e) {
            throw new RuntimeException("Deu tudo errado");
        }
        return values;
    }
}