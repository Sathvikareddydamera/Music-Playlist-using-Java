package javaminiprojects;
import java.util.ArrayList;
import java.util.LinkedList;

public class Albums {


private String name;
private String artist;
private ArrayList<Songs> songs;

public Albums(String name, String artist) {
    this.name = name;
    this.artist = artist;
    this.songs = new ArrayList<Songs>();
}
public Albums(){

}

public Songs findSong(String title){

    for(Songs checkedSong : songs){
        if(checkedSong.getTitle().equals(title)) return checkedSong;
    }
    return null;
}

public boolean addSong(String title, double duration){
    if(findSong(title) == null){
        songs.add(new Songs(title,duration));
//        System.out.println(title + "successfully added to the list");
        return true;
    }
    else {
//        System.out.println("Song with name "+ title+ " already exist in the list");
        return false;
    }
}

public boolean addToPlayList(int trackNumber, LinkedList<Songs> PlayList){
    int index = trackNumber - 1;
    if(index > 0 && index <= this.songs.size()){
        PlayList.add(this.songs.get(index));
        return true;
    }
//    System.out.println("this album does not have song with trackNumber "+trackNumber);
    return false;
}

public boolean addToPlayList(String title, LinkedList<Songs> PlayList){
    for(Songs checkedSong : this.songs){
        if (checkedSong.getTitle().equals(title)){
            PlayList.add(checkedSong);
            return true;
        }
    }
//    System.out.println(title + "there is no such song in album");
    return false;
}}