import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {


        Scanner fileIn = null;
        try {

            fileIn = new Scanner(
                    new FileInputStream("bilgiler.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        String data;
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        while (fileIn.hasNext()) {
            data = fileIn.nextLine();
            String[] movies = data.split(",",5);
            String actors = movies[4];
            int baslangicIndex = actors.indexOf("(")+1 ;
            int bitisIndex = actors.indexOf("}")-1;
            String icerik = actors.substring(baslangicIndex, bitisIndex);
            String[] new_icerik = icerik.split("\\)\\(");

            ArrayList<Actor> actorArrayList = new ArrayList<>();
            for (String s : new_icerik) {
                String[] ozellikler = s.split(",");
                String name = ozellikler[0];
                String gender = ozellikler[1];
                String nationality = ozellikler[2];
                Actor actor = new Actor(name, gender, nationality);
                actorArrayList.add(actor);

            }

            Movie movie = new Movie(Integer.parseInt(movies[0]),movies[1],movies[2],movies[3],actorArrayList);
            doublyLinkedList.insertData(movie);

        }
        fileIn.close();

        boolean on = true;
        while(on){
            Scanner input = new Scanner(System.in);
            Scanner movie_name = new Scanner(System.in);

            String input2;
            System.out.println("Listeye film eklemek için 1");
            System.out.println("Listeden film silmek için 2");
            System.out.println("Listedeki filmlerden birini görüntülemek için 3");
            System.out.println("Liste içindeki 2000 yılından önceki filmleri görüntülemek için 4 ");
            System.out.println("Listeyi baştan sona yazdırmak için 5 ");
            System.out.println("Listeyi sondan başa yazdırmak için 6 ");
            System.out.println("Çıkmak için 0 yazınız.");
            System.out.println("----------------------------------------------------");

            switch (input.nextInt()){
                case 0:
                    on = false;
                    System.out.println("Uygulamadan çıkılıyor...");
                    break;

                case 1:
                    Scanner scanner = new Scanner(System.in);
                    Movie movie = new Movie();
                    System.out.println("Lütfen ilgili filmin adını giriniz");
                    movie.setName(scanner.nextLine());
                    System.out.println("Lütfen "+movie.getName()+" filminin yapım yılını giriniz");
                    movie.setYear(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Lütfen "+movie.getName()+" filminin türünü giriniz");
                    movie.setGenre(scanner.nextLine());
                    System.out.println("Lütfen "+movie.getName()+" filminin yönetmenini giriniz");
                    movie.setDirector(scanner.nextLine());
                    System.out.println("Lütfen "+movie.getName()+" filminin aktörlerini giriniz");
                    System.out.println("Lütfen önce kaç tane aktör girmek istediğinizi yazınız");
                    int actor_length = scanner.nextInt();
                    scanner.nextLine();
                    ArrayList<Actor> actorArrayList = new ArrayList<>();
                    for(int i=1; i< actor_length+1;i++){
                        Actor actor = new Actor();
                        System.out.println("Lütfen "+i+". aktörün ismini yazınız");
                        actor.set_name(scanner.nextLine());
                        System.out.println("Lütfen "+i+". aktörün cinsiyetini yazınız");
                        actor.setGender(scanner.nextLine());
                        System.out.println("Lütfen "+i+". aktörün milliyetini yazınız");
                        actor.setNationality(scanner.nextLine());
                        actorArrayList.add(actor);
                    }
                    movie.setActors(actorArrayList);
                    doublyLinkedList.insertData(movie);
                    System.out.println(doublyLinkedList.get_all_data());
                    break;




                case 2:
                    if(!doublyLinkedList.emptyWarning()){
                        System.out.println("Silmek istediğiniz filmin adını giriniz");
                        doublyLinkedList.delete_movie(movie_name.nextLine());
                        System.out.println("----------------------------------------------------");
                    }
                    break;

                case 3:
                    if(!doublyLinkedList.emptyWarning()){
                        System.out.println("Görüntülemek istediğiniz filmin adını giriniz");
                        doublyLinkedList.display_movie(movie_name.nextLine());
                        System.out.println("----------------------------------------------------");
                    }
                    break;

                case 4:
                    if(!doublyLinkedList.emptyWarning()){
                        doublyLinkedList.display_before_2000s();
                        System.out.println("----------------------------------------------------");
                    }
                    break;
                case 5:
                    if(!doublyLinkedList.emptyWarning()){
                        doublyLinkedList.display_from_head();
                        System.out.println("----------------------------------------------------");
                    }

                    break;
                case 6:
                    if(!doublyLinkedList.emptyWarning()){
                        doublyLinkedList.display_from_tail();
                        System.out.println("----------------------------------------------------");
                    }
                    break;

            }
        }
        try{
            FileWriter myWriter = new FileWriter("bilgiler.txt");
            myWriter.write(doublyLinkedList.get_all_data());
            myWriter.close();

        }catch (IOException e){
            System.out.println("Hata");
        }


    }
}



