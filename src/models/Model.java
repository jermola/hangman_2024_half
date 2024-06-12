package models;

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import models.datastructures.DataScore;

public class Model {
    private final String chooseCategory = "Kõik kategooriad";
    /**
     * See on vaikimisi andmebaasi fail kui käsurealt uut ei leotud. Andmebaasi tabelit nimed ja struktuurid peavad
     * samad olema, kuid andmed võivad erinevad olla.
     *  hangman_words_ee.db - Eestikeelsed sõnad, edetabel on tühi
     *  hangman_words_en.db - Inglisekeelsed sõnad, edetabel on tühi
     *  hangman_words_ee_test.db - Eestikeelsed sõnad, edetabel EI ole tühi
     */
    private String databaseFile = "hangman_words_ee_test.db";

    private String selectedCategory; // Vaikimisi valitud kategooria
    private String[] cmbCategories;
    //Kaust kus on võllapuu pildid
    private String imagesFolder = "images";
    // Siia pannakse kõik võllapuu õiges järjekorras(00-12)
    private List<String> imageFiles = new ArrayList<>();

    private DefaultTableModel dtm;
    private List<DataScore> dataScore = new ArrayList<>();

    /**
     * tabeli mugavaks kasutamiseks
     *
     */
    public Model(String dbName) {
        if(dbName != null) {
            this.databaseFile = dbName;
        }
        //System.out.println(this.databaseFile); //Testimine käsurealt andmebaasi nimi
        new Database(this); // Loome andmebaasi ühenduse
        readImageFolder();//Loeme võllapuu pildid mällu (Listi)
        selectedCategory = chooseCategory; // Vaikimisi "Kõik kategooriad"

    }



    /**
     * Rippmenüü esimene valik enne kategooriaid
     * @return teksti "Kõik kategooriad"
     */
    public String getChooseCategory() {
        return chooseCategory;
    }

    /**
     * Millise andmebaasiga on tegemist
     * @return andmebaasi failinimi
     */
    public String getDatabaseFile() {
        return databaseFile;
    }

    /**
     * Seadistab uue andmebaasi failinime, kui see saadi käsurealt
     * @param databaseFile uus andmebaasi failinimi
     */
    public void setDatabaseFile(String databaseFile) {
        this.databaseFile = databaseFile;
    }

    /**
     * Valitud kategoori
     * @return tagastab valitud kategooria
     */
    public String getSelectedCategory() {
        return selectedCategory;
    }

    /**
     * Seadistab valitud kategooria
     * @param selectedCategory uus valitud kategooria
     */
    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    /**
     * Kategooriate nimed
     * @return kategooriate nimed
     */
    public String[] getCmbCategories() {
        return cmbCategories;
    }

    /**
     * Seadistab uued kategooriate nimed
     * @param cmbCategories kategooriate massiiv
     */
    public void setCmbCategories(String[] cmbCategories) {
        this.cmbCategories = cmbCategories;
    }

    private void readImageFolder() {
        File folder = new File(imagesFolder);//Loe kausta objekt(jah, File)
        File[] files = folder.listFiles();//Loe kõik failid File objekti listi
        for(File file : Objects.requireNonNull(files)) {
            imageFiles.add(file.getAbsolutePath());//Täis kaust tee

        }
        Collections.sort(imageFiles);//Sorteerida kasvavalt kausta sisu
        System.out.println(imageFiles);

    }
    // Võllapuu pildid listina List<String>
    public List<String> getImageFiles() {
        return imageFiles;
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public void setDtm(DefaultTableModel dtm) {
        this.dtm = dtm;
    }

    /**
     * Loetud edetabeli andmed andmebaasist
     * @return dataScores ueed andmed edetabeli jaoks
     */

    public List<DataScore> getDataScore() {
        return dataScore;
    }

    /**
     * Muudab edetabeli andmeid
     * @param dataScore uued andmed
     */

    public void setDataScore(List<DataScore> dataScore) {
        this.dataScore = dataScore;
    }
}
