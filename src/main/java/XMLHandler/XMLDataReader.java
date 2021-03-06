package XMLHandler;

import Character.Attributes.Gender;
import Equipment.Armor.Armor;
import Equipment.Weapon.Weapon;
import Main.CharacterClass;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLDataReader {


    public Map<Gender, List<String>> getCharacterNames() {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        File namesFile = new File("src/main/resources/character_names.xml");
        Map<Gender, List<String>> characterNames = new HashMap<>();

        try {
            SAXParser nameParser = saxParserFactory.newSAXParser();
            NameHandler nameHandler = new NameHandler();
            nameParser.parse(namesFile, nameHandler);
            characterNames = nameHandler.getNamesList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return characterNames;
    }


    public List<CharacterClass> getCharacterClasses() {

        List<CharacterClass> classes = new ArrayList<>();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser characterClassesParser = saxParserFactory.newSAXParser();
            File characterClassesFile = new File("src/main/resources/character_classes.xml");
            CharacterClassHandler characterClassHandler = new CharacterClassHandler();
            characterClassesParser.parse(characterClassesFile, characterClassHandler);
            classes = characterClassHandler.getClasses();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

    public List<Armor> getArmorEquipment() {
        List<Armor> armors = null;
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser armorParser = saxParserFactory.newSAXParser();
            File armorFile = new File("src/main/resources/equipment_armors.xml");
            ArmorHandler armorHandler = new ArmorHandler();
            armorParser.parse(armorFile, armorHandler);
            armors = armorHandler.getArmors();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return armors;
    }

    public List<Weapon> getWeaponEquipment() {
        List<Weapon> weapons = null;
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser weaponParser = saxParserFactory.newSAXParser();
            File weaponFile = new File("src/main/resources/equipment_weapons.xml");
            WeaponHandler weaponHandler = new WeaponHandler();
            weaponParser.parse(weaponFile, weaponHandler);
            weapons = weaponHandler.getWeapons();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return weapons;
    }
}
