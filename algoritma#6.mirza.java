import java.util.Scanner;

public class Playlist {
    private String[] stack;
    private int top;
    private int size;

    public Playlist(int size) {
        this.size = size;
        this.top = -1;
        this.stack = new String[size];
    }

    public void push(String song) {
        if (top == size - 1) {
            System.out.println("Playlist penuh!");
        } else {
            top++;
            stack[top] = song;
            System.out.println(song + " ditambahkan ke playlist");
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Playlist kosong!");
        } else {
            String song = stack[top];
            top--;
            System.out.println(song + " dihapus dari playlist");
        }
    }

    public void pop(int index) {
        if (top == -1) {
            System.out.println("Playlist kosong!");
        } else if (index > top + 1 || index < 1) {
            System.out.println("Posisi tidak valid!");
        } else {
            String song = stack[index - 1];
            for (int i = index - 1; i < top; i++) {
                stack[i] = stack[i + 1];
            }
            top--;
            System.out.println(song + " dihapus dari playlist");
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("Playlist kosong!");
        } else {
            System.out.println("Playlist:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ukuran playlist: ");
        int size = scanner.nextInt();
        Playlist playlist = new Playlist(size);
        int choice = 0;
        while (choice != 6) {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan Data Playlist");
            System.out.println("2. Tambah Data Playlist");
            System.out.println("3. Hapus Data Playlist");
            System.out.println("4. Tambah Data Playlist di Urutan Tertentu");
            System.out.println("5. Hapus Data Playlist di Urutan Tertentu");
            System.out.println("6. Hapus Semua Playlist");
            System.out.print("Masukkan pilihan: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    playlist.display();
                    break;
                case 2:
                    System.out.print("Masukkan judul lagu: ");
                    String song = scanner.next();
                    playlist.push(song);
                    break;
                case 3:
                    playlist.pop();
                    break;
                case 4:
                    System.out.print("Masukkan posisi: ");
                    int index = scanner.nextInt();
                    System.out.print("Masukkan judul lagu: ");
                    String newSong = scanner.next();
                    playlist.push(newSong);
                    playlist.pop(index);
                    break;
                case 5:
                    System.out.print("Masukkan posisi: ");
                    index = scanner.nextInt();
                    playlist.pop(index);
                    break;
                case 6:
                    System.out.println("Playlist kosong!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
}
