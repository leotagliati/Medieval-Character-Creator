package Scripts.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Scripts.Database.ConnFactory;
import Scripts.ImagesConversion.Enums.EyeColorTypes;
import Scripts.ImagesConversion.Enums.PhysicTypes;
import Scripts.ImagesConversion.Enums.SkinColorTypes;
import Scripts.Model.GameCharacter;

/**
 * CharacterRepository
 */
public class CharacterRepository {

    Connection conn;

    public CharacterRepository() {
        this.conn = ConnFactory.getConn();
    }
    public void addCharacter(GameCharacter character)
    {
        String command = "INSERT INTO tb_character(name, class, eye_color, skin_color, physic_type) VALUES(?,?,?,?,?)";
        PreparedStatement stmt = null;
        try
        {
            
            stmt = conn.prepareStatement(command);
            stmt.setString(1, character.getName());
            stmt.setString(2, character.getSkillClass());
            stmt.setInt(3, character.getEyeColor().ordinal());
            stmt.setInt(4, character.getSkinColor().ordinal());
            stmt.setInt(5, character.getPhysicType().ordinal());
            stmt.executeUpdate();
        }
        catch(SQLException e)
        {   
             System.out.println("Erro ao incluir os dados");
        }
    }

    public ArrayList<GameCharacter> GetAllCharcters() {
        String command = "SELECT * FROM tb_character";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;

        ArrayList<GameCharacter> characters = new ArrayList<GameCharacter>();
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

    private ArrayList<GameCharacter> getValues(ResultSet resultSet) {
        ArrayList<GameCharacter> values = new ArrayList<GameCharacter>();
        try {
            while (resultSet.next()) {
                GameCharacter character = new GameCharacter();
                character.setId(resultSet.getInt(1));
                character.setName(resultSet.getString(2));
                character.setSkillClass(resultSet.getString(3));
                character.setEyeColor(EyeColorTypes.values()[resultSet.getInt(4)-1]);
                character.setSkinColor(SkinColorTypes.values()[resultSet.getInt(5)-1]);
                character.setPhysicType(PhysicTypes.values()[resultSet.getInt(6)-1]);

                values.add(character);
            }

        } catch (Exception e) {
            throw new RuntimeException("Deu tudo errado");
        }
        return values;
    }
}