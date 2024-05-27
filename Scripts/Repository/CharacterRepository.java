package Scripts.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Scripts.Database.ConnFactory;
import Scripts.ImagesConversion.Enums.ChestTypes;
import Scripts.ImagesConversion.Enums.EyeColorTypes;
import Scripts.ImagesConversion.Enums.HelmetTypes;
import Scripts.ImagesConversion.Enums.LegsTypes;
import Scripts.ImagesConversion.Enums.PhysicTypes;
import Scripts.ImagesConversion.Enums.SkinColorTypes;
import Scripts.Model.GameCharacter;

public class CharacterRepository {

    Connection conn;

    public CharacterRepository() {
        this.conn = ConnFactory.getConn();
    }

    public void addCharacter(GameCharacter character) {
        String command = "INSERT INTO tb_character(name, class, eye_color, skin_color, physic_type, helm_type, chest_type, legs_type) VALUES(?,?,?,?,?,?,?,?)";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {

            stmt = conn.prepareStatement(command);
            stmt.setString(1, character.getName());
            stmt.setString(2, character.getSkillClass());
            stmt.setInt(3, character.getEyeColor().ordinal() + 1);
            stmt.setInt(4, character.getSkinColor().ordinal() + 1);
            stmt.setInt(5, character.getPhysicType().ordinal() + 1);
            stmt.setInt(6, character.getHelmTypes().ordinal() + 1);
            stmt.setInt(7, character.getChestTypes().ordinal() + 1);
            stmt.setInt(8, character.getLegsTypes().ordinal() + 1);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao incluir os dados");
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public void deleteCharacter(GameCharacter character) {
        String command = "DELETE FROM tb_character WHERE id = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(command);
            stmt.setInt(1, character.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir os dados");
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
    }

    public GameCharacter searchCharacter(int id) {
        String command = "Select * FROM tb_character WHERE id = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;

        GameCharacter character = new GameCharacter();
        try {
            stmt = conn.prepareStatement(command);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                character = this.getValue(result);
            }
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar os dados" + e.toString());
        } finally {
            ConnFactory.closeConn(conn, stmt);
        }
        return character;
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
                character.setEyeColor(EyeColorTypes.values()[resultSet.getInt(4) - 1]);
                character.setSkinColor(SkinColorTypes.values()[resultSet.getInt(5) - 1]);
                character.setPhysicType(PhysicTypes.values()[resultSet.getInt(6) - 1]);
                character.setHelmTypes(HelmetTypes.values()[resultSet.getInt(7) - 1]);
                character.setChestTypes(ChestTypes.values()[resultSet.getInt(8) - 1]);
                character.setLegsTypes(LegsTypes.values()[resultSet.getInt(9) - 1]);

                values.add(character);
            }

        } catch (Exception e) {
            throw new RuntimeException("Deu tudo errado");
        }
        return values;
    }

    private GameCharacter getValue(ResultSet resultSet) {
        GameCharacter character = new GameCharacter();
        try {
            character.setId(resultSet.getInt(1));
            character.setName(resultSet.getString(2));
            character.setSkillClass(resultSet.getString(3));
            character.setEyeColor(EyeColorTypes.values()[resultSet.getInt(4) - 1]);
            character.setSkinColor(SkinColorTypes.values()[resultSet.getInt(5) - 1]);
            character.setPhysicType(PhysicTypes.values()[resultSet.getInt(6) - 1]);
            character.setHelmTypes(HelmetTypes.values()[resultSet.getInt(7) - 1]);
            character.setChestTypes(ChestTypes.values()[resultSet.getInt(8) - 1]);
            character.setLegsTypes(LegsTypes.values()[resultSet.getInt(9) - 1]);
        } catch (Exception e) {
            throw new RuntimeException("Deu tudo errado");
        }
        return character;

    }
}