package Scripts.CharCreationManagement.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Scripts.CharCreationManagement.Database.ConnFactory;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.ChestTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.EyeColorTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.GenderTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.HelmetTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.LegsTypes;
import Scripts.CharCreationManagement.Visual.ImagesConversion.Enums.SkinColorTypes;
import Scripts.LogManager.LogSystemService;
import Scripts.LoginManagement.Screens.TelaLogin;
import Scripts.CharCreationManagement.Model.GameCharacter;

public class CharacterRepository {

    Connection conn;

    public CharacterRepository() {
        this.conn = ConnFactory.getConn();
    }

    public void addCharacter(GameCharacter character) {
        String command = "INSERT INTO tb_character(users_id,name, class, eye_color, skin_color, helm_type, chest_type, legs_type, gender) VALUES(?,?,?,?,?,?,?,?,?)";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;
        try {

            stmt = conn.prepareStatement(command);
            stmt.setInt(1, TelaLogin.userName_ID);
            stmt.setString(2, character.getName());
            stmt.setString(3, character.getSkillClass());
            stmt.setInt(4, character.getEyeColor().ordinal() + 1);
            stmt.setInt(5, character.getSkinColor().ordinal() + 1);
            stmt.setInt(6, character.getHelmTypes().ordinal() + 1);
            stmt.setInt(7, character.getChestTypes().ordinal() + 1);
            stmt.setInt(8, character.getLegsTypes().ordinal() + 1);
            stmt.setInt(9, character.getGender().ordinal() + 1);
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
        String command = "SELECT * FROM tb_character WHERE users_id = ?";
        Connection conn = ConnFactory.getConn();
        PreparedStatement stmt = null;

        ArrayList<GameCharacter> characters = new ArrayList<GameCharacter>();
        try {
            stmt = conn.prepareStatement(command);
            stmt.setInt(1, TelaLogin.userName_ID);
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
                character.setName(resultSet.getString(3));
                character.setSkillClass(resultSet.getString(4));
                character.setEyeColor(EyeColorTypes.values()[resultSet.getInt(5) - 1]);
                character.setSkinColor(SkinColorTypes.values()[resultSet.getInt(6) - 1]);
                character.setHelmTypes(HelmetTypes.values()[resultSet.getInt(7) - 1]);
                character.setChestTypes(ChestTypes.values()[resultSet.getInt(8) - 1]);
                character.setLegsTypes(LegsTypes.values()[resultSet.getInt(9) - 1]);
                character.setGender(GenderTypes.values()[resultSet.getInt(10) - 1]);

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
            character.setName(resultSet.getString(3));
            character.setSkillClass(resultSet.getString(4));
            character.setEyeColor(EyeColorTypes.values()[resultSet.getInt(5) - 1]);
            character.setSkinColor(SkinColorTypes.values()[resultSet.getInt(6) - 1]);
            character.setHelmTypes(HelmetTypes.values()[resultSet.getInt(7) - 1]);
            character.setChestTypes(ChestTypes.values()[resultSet.getInt(8) - 1]);
            character.setLegsTypes(LegsTypes.values()[resultSet.getInt(9) - 1]);
            character.setGender(GenderTypes.values()[resultSet.getInt(10) - 1]);
        } catch (Exception e) {
            throw new RuntimeException("Deu tudo errado");
        }
        return character;

    }
}