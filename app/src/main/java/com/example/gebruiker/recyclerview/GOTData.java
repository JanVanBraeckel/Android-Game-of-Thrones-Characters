package com.example.gebruiker.recyclerview;

import com.example.gebruiker.recyclerview.models.GOTCharacter;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by Jan on 18/12/2015.
 */
@Data
@Accessors(prefix = "m")
public class GOTData {
    private int[] mCharacterPictures = {0, 1, 2, 3, 4};
    private String[] mCharacterNames = {"Jon Snow", "Sansa Stark", "Melisandre", "Daenerys Targaryen", "Roose Bolton"};
    private String[] mCharacterDetails= {
            "Ned Stark's bastard son, Jon joined the Night's Watch. On a mission for Lord Commander Mormont, Jon infiltrated the wildlings by pretending to forsake his Night Watch brothers. In doing so, he fell in love with Ygritte, a wildling woman.",
            "The oldest Stark daughter, Sansa has since realized that King's Landing isn't the fairy tale she assumed it would be. After her engagement to King Joffrey dissolved, Sansa was married to his uncle Tyrion Lannister, who has always treated her with the utmost respect.",
            "A Red priestess from Asshai, Melisandre worships the Lord of Light. Her visions have told her that Stannis is the true king and as his advisor, she has encouraged him to pursue the throne at all costs.",
            "Princess of House Targaryen, Daenerys lives in exile in Essos with her advisors and dragons. Dany rallied the Unsullied of Astapor to her cause and continues to grow the army she needs to take back the throne.",
            "Lord of the Dreadfort and head of House Bolton, Roose takes pride in his family's sigil of a flayed man. A proven soldier who joined Robb Stark on the battlefield, Lord Bolton subsequently betrayed him to gain favor with Tywin Lannister."
    };
}
