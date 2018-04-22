package com.shubham;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
	// write your code here
       Album album = new Album("Four","One Direction");
       album.addSongtoAlbum("Steal My Girl", 5.19);
       album.addSongtoAlbum("Night Changes",4.00);
       album.addSongtoAlbum("No Control", 3.18);
       album.addSongtoAlbum("Fireproof", 2.53);
       album.addSongtoAlbum("Once in a Lifetime" , 2.18);
       album.addSongtoAlbum("Spaces",5.10);
       album.addSongtoAlbum("Clouds",3.21);
       albums.add(album);

       album = new Album("X","Ed Sheeran");
       album.addSongtoAlbum("One",4.13);
       album.addSongtoAlbum("Nina",3.46);
       album.addSongtoAlbum("Sing",3.55);
       album.addSongtoAlbum("Don't",3.79);
       album.addSongtoAlbum("BloodStream",5.00);
       album.addSongtoAlbum("Runaway", 3.25);
       album.addSongtoAlbum("Take it Back", 3.25);
       albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addSongtoPlayList("Steal My Girl", playList);
        albums.get(0).addSongtoPlayList("Night Changes", playList);
        albums.get(0).addSongtoPlayList("Fireproof", playList);
        albums.get(0).addSongtoPlayList("Spaces", playList);
        albums.get(1).addSongtoPlayList("Nina", playList);
        albums.get(1).addSongtoPlayList("Don't", playList);
        albums.get(1).addSongtoPlayList("Runaway", playList);
        play(playList);

    }

    private static void play(LinkedList<Song> playList)
    {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
if(playList.size() == 0)
{
    System.out.println("There are no songs in the playlist");
    return;
}
else
{
    System.out.println("Now playing " + listIterator.next().toString());
    printMenu();
}
while(!quit) {
    int action = scanner.nextInt();
    scanner.nextLine();

    switch (action) {
        case 0:
            quit = true;
            System.out.println("Your playlist is completed");
            break;
        case 1:
            if (!forward) {
                if (listIterator.hasNext()) {
                    listIterator.next();
                    forward = true;
                }
            }
            if (listIterator.hasNext()) {
                System.out.println("Now playing " + listIterator.next().toString());
            } else {
                System.out.println("We have reached to the end of the playlist");
                forward = false;
            }
            break;
        case 2:
            if (forward) {
                if (listIterator.hasPrevious()) {
                    listIterator.previous();

                }
                forward = false;
            }
            if (listIterator.hasPrevious()) {
                System.out.println("Now playing " + listIterator.previous().toString());
            } else {
                System.out.println("We are in the beginning of the playlist");
                forward = true;
            }
            break;
        case 3:
            if (forward) {
                if (listIterator.hasPrevious()) {
                    System.out.println("Now replaying " + listIterator.previous().toString());
                    forward = false;
                } else {
                    System.out.println("We are in the beginninng of the playlist");
                }
            }
            if (listIterator.hasNext()) {
                System.out.println("Now replaying " + listIterator.next().toString());
                forward = true;
            } else {
                System.out.println("We have reached at the end of the playlist");
            }
            break;
        case 4:
            viewLibrary(playList);
            break;
        case 5:
            printMenu();
            break;
        case 6:
            if (playList.size() > 0) {
                listIterator.remove();
                if (listIterator.hasNext()) {
                    System.out.println("Now playing " + listIterator.next());
                } else if (listIterator.hasPrevious()) {
                    System.out.println("Now playing " + listIterator.previous());
                }
            }
            break;
    }
}
}
    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");

    }
    private static void viewLibrary(LinkedList<Song> playList)
    {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("*****************************************");
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("*****************************************");
    }
}
