// Music playlist using circular linked list

class Song {
    String name;
    Song next;

    // Constructor
    Song(String name) {
        this.name = name;
        this.next = null;
    }
}

class MusicPlaylist {
    Song head = null;

    // Add song
    void addSong(String name) {
        Song newSong = new Song(name);

        if (head == null) {
            head = newSong;
            newSong.next = head; // circular link
        } else {
            Song temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newSong;
            newSong.next = head;
        }
    }

    // Display playlist
    void display() {
        if (head == null) {
            System.out.println("Playlist is empty");
            return;
        }

        Song temp = head;
        do {
            System.out.println(temp.name);
            temp = temp.next;
        } while (temp != head);
    }

    // Play next song
    void playNext() {
        if (head == null) return;
        head = head.next;
        System.out.println("Now Playing: " + head.name);
    }

    // Delete a song
    void deleteSong(String name) {
        if (head == null) return;

        Song curr = head, prev = null;

        // If only one song
        if (head.name.equals(name) && head.next == head) {
            head = null;
            return;
        }

        // If head is to be deleted
        if (head.name.equals(name)) {
            Song last = head;
            while (last.next != head) {
                last = last.next;
            }
            head = head.next;
            last.next = head;
            return;
        }

        // Delete other song
        do {
            prev = curr;
            curr = curr.next;
            if (curr.name.equals(name)) {
                prev.next = curr.next;
                return;
            }
        } while (curr != head);
    }
}

public class Main {
    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist();

        playlist.addSong("Song A");
        playlist.addSong("Song B");
        playlist.addSong("Song C");

        System.out.println("Playlist:");
        playlist.display();

        playlist.playNext();

        System.out.println("\nAfter deleting Song B:");
        playlist.deleteSong("Song B");
        playlist.display();
    }
}
