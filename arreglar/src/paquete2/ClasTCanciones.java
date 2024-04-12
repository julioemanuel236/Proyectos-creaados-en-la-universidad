package paquete2;
/**
 *
 * @author morap
 */
public abstract class ClasTCanciones {
    protected String matrisTcanciones[][] = new String [50][50];
    protected int opcion;
    protected String cancionBuscada;
    
    public ClasTCanciones(){
        //A continuacion estaran todas las canciones ordenadas por su banda
        /*
        */
        //Eutenia
        matrisTcanciones[0][0] = " They Wanna Watch Me Fall - Eutenia     [2]";
        matrisTcanciones[0][1] = " Últimas Palavras - Eutenia     [3]";
        matrisTcanciones[0][2] = " Meu Fim - Eutenia     [3]";
        matrisTcanciones[0][3] = " Carbonizar - Eutenia     [3]";
        //Hellish War
        matrisTcanciones[0][4] = " Son Of The King - Hellish War               [5]";//15 ESPACIOS
        matrisTcanciones[0][5] = " Metal Forever - Hellish War     [3]";
        matrisTcanciones[0][6] = " Destroyer - Hellish War     [5]";
        matrisTcanciones[0][7] = " Die For Glory - Hellish War     [5]";
        matrisTcanciones[0][8] = " Keep It Hellish - Hellish War     [3]";
        
        //System Of A Down
        matrisTcanciones[0][9] = "  Toxicity - System Of A Down                [3]";//16 ESPACIOS
        matrisTcanciones[0][10] = " Lonely Day - System Of A Down     [2]";
        matrisTcanciones[0][11] = " B.Y.O.B. - System Of A Down     [5]";
        matrisTcanciones[0][12] = " Chop Suey - System Of A Down     [5]";
        matrisTcanciones[0][13] = " Question! - System Of A Down     [3]";
        matrisTcanciones[0][14] = " Aerials - System Of A Down     [2]";
        matrisTcanciones[0][15] = " Hypnotize - System Of A Down     [2]";
        matrisTcanciones[0][16] = " Sugar - System Of A Down     [3]";
        matrisTcanciones[0][17] = " Spiders - System Of A Down     [3]";
        matrisTcanciones[0][18] = " Protect The Land - System Of A Down     [3]";
        matrisTcanciones[0][19] = " Genocidal Humanoidz - System Of A Down     [3]";
        matrisTcanciones[0][20] = " I-E-A-I-A-I-O - System Of A Down     [3]";
        //Royal Blood
        matrisTcanciones[0][21] = "  Figure It Out - Royal Blood                    [2]";// 20 ESPACIOS
        
        //My Chemical Romance
        matrisTcanciones[0][22] = " Famous Last Words - My C Romance   [3]";// 3 ESPACIOS
        matrisTcanciones[0][23] = " Helena - My Chemical Romance     [4]";
        matrisTcanciones[0][24] = " Na Na Na - My Chemical Romance     [3]";
        matrisTcanciones[0][25] = " Welcome To The Black Parade - My Chemical     [3]";
        matrisTcanciones[0][26] = " I'm Not Okay - My Chemical Romance     [3]";
        
        //Ramones
        matrisTcanciones[0][27] = " Pet Sematary - Ramones     [2]";
        matrisTcanciones[0][28] = " Blitzkrieg Bop - Ramones     [2]";
        matrisTcanciones[0][29] = " I Wanna Be Sedated - Ramones     [2]";
        
        //Scars On Broadway
        matrisTcanciones[0][30] = " They Say - Scars On Broadway              [2]";// 14 ESPACIOS
        matrisTcanciones[0][31] = " Lives - Scars On Broadway     [4]";
        
        
        matrisTcanciones[0][32] = " Kickstart My Heart - Motley Crue        [3]";// 8 ESPACIOS
        matrisTcanciones[0][33] = " Dr. Feelgood - Motley Crue     [3]";

        //Galneryus
        matrisTcanciones[0][34] = " Wings Of Justice - Galneryus                 [5]";// 17 ESPACIOS
        matrisTcanciones[0][35] = " Destiny - Galneryus     [6]";
        matrisTcanciones[0][36] = " Hunting For Your Dream - Galneryus     [4]";
        matrisTcanciones[0][37] = " Angel Of Salvation - Galneryus     [4]";
        matrisTcanciones[0][38] = " Raise My Sword - Galneryus     [4]";
        matrisTcanciones[0][39] = " T.F.F.B. - Galneryus     [5]";
        matrisTcanciones[0][40] = " The Followers - Galneryus     [4]";
        
        //Aerosmith
        matrisTcanciones[0][41] = " Livin On The Edge - Aerosmith             [3]";// 13 ESPACIOS
        matrisTcanciones[0][42] = " Dream On - Aerosmith     [1]";
        matrisTcanciones[0][43] = " Cryin' - Aerosmith     [2]";
        
        //Knocked Loose
        matrisTcanciones[0][44] = "  Mistakes Like Fractures - Knocked Loose   [3]";// 3 ESPACIOS

        //Velvet Revolver
        matrisTcanciones[0][45] = " Slither - Velvet Revolver                       [3]";// 23 ESPACIOS
        matrisTcanciones[0][46] = " Fall To Pieces - Velvet Revolver     [3]";
        
        //38 Special
        matrisTcanciones[0][47] = " Hold On Loosely - 38 Special     [3]";
        
        //A Day To Remember
        matrisTcanciones[0][48] = " Paranoia - A Day Remember     [3]";
        
        //A-ha
        matrisTcanciones[0][49] = " Take On Me - A-ha     [2]";
        //Hasta aqui termina la primera irela de la matris
        
        //Abrasion
        matrisTcanciones[1][0] = " Leave Your Mark - Abrasion     [4]";
        
        //AC/DC
        matrisTcanciones[1][1] = " Shoot To Thrill - AC/DC     [3]";
        matrisTcanciones[1][2] = " Back In Black - AC/DC     [2]";
        matrisTcanciones[1][3] = " Highway To Hell - AC/DC     [2]";
        matrisTcanciones[1][4] = " TNT - AC/DC     [2]";
        matrisTcanciones[1][5] = " You Shook Me All Night Long     [2]";
        matrisTcanciones[1][6] = " Thunderstruck - AC/DC     [3]";
        matrisTcanciones[1][7] = " Rock Or Bust - AC/DC     [1]";
        matrisTcanciones[1][8] = " Shot In The Dark - AC/DC     [2]";
        matrisTcanciones[1][9] = " Witch's Spell - AC/DC     [3]";
        
        //Addicted To Pain
        matrisTcanciones[1][10] = " Queen Of All Lies - Addicted To Pain     [3]";
        
        //AFI
        matrisTcanciones[1][11] = " Miss Murder - AFI     [2]";
        
        //After The Burial
        matrisTcanciones[1][12] = " Ometh - After The Burial     [5]";
        
        //Age Of Artemis
        matrisTcanciones[1][13] = " Echoes Within - Age Of Artemis     [4]";
        
        //Alice Cooper
        matrisTcanciones[1][14] = " Poison - Alice Cooper     [2]";
        matrisTcanciones[1][15] = " School's Out - Alice Cooper     [2]";
        
        //Alice In Chains 
        matrisTcanciones[1][16] = " Man In The Box - Alice In Chains     [2]";
        
        //All That Remains
        matrisTcanciones[1][17] = " Chiron - All That Remains     [3]";
        matrisTcanciones[1][18] = " Two Weeks - All That Remains     [4]";
        matrisTcanciones[1][19] = " Six - All That Remains     [5]";
        matrisTcanciones[1][20] = " The Air That I Breathe - All That Remains     [4]";
        matrisTcanciones[1][21] = " Whispers (I Hear You) - All That Remains     [4]";
        
        //Allos
        matrisTcanciones[1][22] = " Journey - Allos     [4]";
        matrisTcanciones[1][23] = " Spiritual Battle - Allos     [4]";
        
        //Alter Bridge
        matrisTcanciones[1][24] = " Isolation - Alter Bridge     [3]";
        matrisTcanciones[1][25] = " Cry Of Achilles - Alter Bridge     [4]";
        matrisTcanciones[1][26] = " Ties That Bind - Alter Bridge     [3]";
        matrisTcanciones[1][27] = " Show Me A Leader - Alter Bridge     [4]";
        matrisTcanciones[1][28] = " Addicted To Pain - Alter Bridge     [3]";
         
       //Amon Amarth    
       matrisTcanciones[1][29] = " Twilight Of The Thunder God - Amon Amarth      [3]";
       matrisTcanciones[1][30] = " Destroyer Of The Universe - Amon Amarth     [4]";
       matrisTcanciones[1][31] = " Deceiver Of The Gods - Amon Amarth     [4]";
       
       //An Endless Sporadic
       matrisTcanciones[1][32] = " Impulse - An Endless Sporadic     [3]";
       
       //Andragonia
       matrisTcanciones[1][33] = " Secrets In The Mirror - Andragonia     [4]";
       matrisTcanciones[1][34] = " Silent Screams - Andragonia     [3]";
       matrisTcanciones[1][35] = " Draining My Heart - Andragonia     [3]";
       matrisTcanciones[1][36] = " The Choice - Andragonia     [3]";
       matrisTcanciones[1][37] = " Shadowmaker - Andragonia     [4]";
       matrisTcanciones[1][38] = " Guitar Flash - Andragonia     [6]";
       matrisTcanciones[1][39] = " Catch Your Fall - Andragonia     [4]";
       
       //Angel Vivaldi
       matrisTcanciones[1][40] = " Wave Of Synergy - Angen Vivaldi     [5]";
       
       //Angels Holocaust
       matrisTcanciones[1][41] = " Crystal Night - Angels Holocaust     [3]";
       
       //Angra
       matrisTcanciones[1][42] = " Arising Thunder - Angra     [4]";
       matrisTcanciones[1][43] = " Nova Era - Angra     [4]";
       matrisTcanciones[1][44] = " Carry On - Angra     [4]";
       matrisTcanciones[1][45] = " The Temple Of Hate - Angra     [4]";
       
       //Anthrax
       matrisTcanciones[1][46] = " Madhouse - Anthrax     [3]";
       matrisTcanciones[1][47] = " Indians - Anthrax     [3]";
       
       //Arch Enemy
       matrisTcanciones[1][48] = " Nemesis - Arch Enemy     [4]";
       matrisTcanciones[1][49] = " No More Regrets - Arch Enemy     [4]";
       
       //Hasta aqui temina la segunda irela de la matris
       matrisTcanciones[2][0] = " War Eternal - Arch Enemy     [4]";
       matrisTcanciones[2][1] = " Deceiver, Deceiver - Arch Enemy     [4]";
       matrisTcanciones[2][2] = " The World Is Yours - Arch Enemy     [4]";
       
       //Architects
       matrisTcanciones[2][3] = " Doomsday - Architects     [3]";
       
       //Arctic Monkeys
       matrisTcanciones[2][4] = " R U Mine? - Arctic Monkeys     [2]";
       matrisTcanciones[2][5] = " Do I Wanna Know? - Arctic Monkeys     [1]";
       matrisTcanciones[2][6] = " Brianstorm - Arctic Monkeys     [3]";
       
       //Argos
       matrisTcanciones[2][7] = " Real Time - Argos     [2]";
       matrisTcanciones[2][8] = " Don't Be Afraid - Argos     [3]";
       matrisTcanciones[2][9] = " In The Name Of Tragedy - Argos     [2]";
       
       //As I Lay Dying
       matrisTcanciones[2][10] = " My Own Grave - As I Lay Dying     [4]";
       matrisTcanciones[2][11] = " Blinded - As I Lay Dying     [4]";
       
       //Asian Kung-Fu Generation
       matrisTcanciones[2][12] = " Haruka Kanata - Asian Kung-Fu Generation     [3]";
       
       //Asking Alexandria
       matrisTcanciones[2][13] = " The Final Episode - Asking Alexandria     [3]";
       
       //Audioslave
       matrisTcanciones[2][14] = " Doesn't Remind Me - Audioslave     [3]";
       matrisTcanciones[2][15] = " Cochise - Audioslave     [3]";
       matrisTcanciones[2][16] = " Show Me How To Live - Audioslave     [1]";
       matrisTcanciones[2][17] = " Like A Stone - Audioslave     [1]";
       matrisTcanciones[2][18] = " Revelations - Audioslave     [2]";
       
       //August Burns Red
       matrisTcanciones[2][19] = " Carol Of The Bells - August Burns Red     [3]";
       
       //Austrian Death Machine
       matrisTcanciones[2][20] = " I Need Your Clothes - Austrian Death Machine     [4]";
       
       //Avenged Sevenfold
       matrisTcanciones[2][21] = " Nightmare - Avenged Sevenfold     [3]";
       matrisTcanciones[2][22] = " Afterlife - Avenged Sevenfold     [3]";
       matrisTcanciones[2][23] = " Beast And The Harlot - Avenged Sevenfold     [3]";
       matrisTcanciones[2][24] = " Bat Country - Avenged Sevenfold     [3]";
       matrisTcanciones[2][25] = " Almost Easy - Avenged Sevenfold     [3]";
       matrisTcanciones[2][26] = " Seize The Day - Avenged Sevenfold     [3]";
       matrisTcanciones[2][27] = " Unholy Confessions - Avenged Sevenfold     [3]";
       matrisTcanciones[2][28] = " Hail To The King - Avenged Sevenfold     [3]";
       matrisTcanciones[2][29] = " Trashed And Scattered - Avenged Sevenfold     [4]";
       matrisTcanciones[2][30] = " So Far Away - Avenged Sevenfold     [1]";
       matrisTcanciones[2][31] = " The Stage - Avenged Sevenfold     [4]";
       matrisTcanciones[2][32] = " Natural Born Killer - Avenged Sevenfold      [3]";
       matrisTcanciones[2][33] = " God Damn - Avenged Sevenfold     [3]";
       
       //
       
               }
    
    public abstract  void dificultadSeled();
    
}
