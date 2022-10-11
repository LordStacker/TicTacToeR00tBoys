package tictactoe.bll;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataStore {

    private static final DataStore instance = new DataStore();

    private final ObservableList<Player> personList;

    public static DataStore getInstance(){
        return instance;
    }
    public DataStore(){
        this.personList = FXCollections.observableArrayList();
    }
    public ObservableList<Player> getPersonList() {
        return personList ;
    }
    public void setPersonList(Player p) {
        personList.add(p);
    }
}
