package org.example;

import com.google.gson.Gson;
import org.example.Serialization.model.Movie;
import org.example.Serialization.model.Session;
import org.example.Serialization.model.Theater;

import java.io.*;


public class SerializationExercises implements Serializable {
    /*
        Should define the class for the concepts Movie, Theater and Session.
        A session is a play of movie in a theater.
        Create 2 instances of each class and relate among them.
        Serialize to Json all objects and save then in different files.
     */
    public static class Exercise1 {
        public static void main(String[] args) {
            Movie firstMovie = new Movie("Star Wars", 2.30, "George Lucas");
            Movie secondMovie = new Movie("A Clockwork Orange", 2.16, "Stanley Kubrick");
            Theater firstTheater = new Theater("CC Las Arenas");
            Theater secondTheater = new Theater("CC Los Alisios");
            Session firstSession = new Session(16, firstMovie, firstTheater);
            Session secondSession = new Session(18, secondMovie, secondTheater);
            Gson gsonFilm = new Gson();
            String jsonFilm = gsonFilm.toJson(firstMovie);
            String jsonFilmTwo = gsonFilm.toJson(secondMovie);
            String jsonTheater = gsonFilm.toJson(firstTheater);
            String jsonTheaterTwo = gsonFilm.toJson(secondTheater);
            String jsonSession = gsonFilm.toJson(secondTheater);
            String jsonSessionTwo = gsonFilm.toJson(secondTheater);

            try {
                OutputStream fileOutputFilm = new FileOutputStream("firstMovie.txt");
                fileOutputFilm.write(jsonFilm.getBytes());
                fileOutputFilm.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                OutputStream fileOutputFilmTwo = new FileOutputStream("secondMovie.txt");
                fileOutputFilmTwo.write(jsonFilmTwo.getBytes());
                fileOutputFilmTwo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                OutputStream fileOutputTheater = new FileOutputStream("firstTheater.txt");
                fileOutputTheater.write(jsonTheater.getBytes());
                fileOutputTheater.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                OutputStream fileOutputTheaterTwo = new FileOutputStream("secondTheater.txt");
                fileOutputTheaterTwo.write(jsonTheaterTwo.getBytes());
                fileOutputTheaterTwo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                OutputStream fileOutputSession = new FileOutputStream("firstSession.txt");
                fileOutputSession.write(jsonSession.getBytes());
                fileOutputSession.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                OutputStream fileOutputSessionTwo = new FileOutputStream("secondSession.txt");
                fileOutputSessionTwo.write(jsonSessionTwo.getBytes());
                fileOutputSessionTwo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    /*
        Deserialize the objects created in exercise 1.
        Now serialize them using ObjectOutputStream
     */
    public static class Exercise2 {

        public static void main(String[] args) throws IOException {
            Gson gson = new Gson();
            FileInputStream fileInputStream = null;
            fileInputStream = new FileInputStream("firstMovie.txt");
            InputStreamReader reader = null;
            reader = new InputStreamReader(fileInputStream, "UTF-8");
            Movie firstMovie = gson.fromJson(reader, Movie.class);
            fileInputStream.close();
            fileInputStream = new FileInputStream("secondMovie.txt");
            reader = new InputStreamReader(fileInputStream, "UTF-8");
            Movie secondMovie = gson.fromJson(reader, Movie.class);
            fileInputStream.close();
            fileInputStream = new FileInputStream("firstTheater.txt");
            reader = new InputStreamReader(fileInputStream, "UTF-8");
            Theater firstTheater = gson.fromJson(reader, Theater.class);
            fileInputStream.close();
            fileInputStream = new FileInputStream("secondTheater.txt");
            reader = new InputStreamReader(fileInputStream, "UTF-8");
            Theater secondTheater = gson.fromJson(reader, Theater.class);
            fileInputStream.close();
            fileInputStream = new FileInputStream("firstSession.txt");
            reader = new InputStreamReader(fileInputStream, "UTF-8");
            Session firstSession = gson.fromJson(reader, Session.class);
            fileInputStream.close();
            fileInputStream = new FileInputStream("secondSession.txt");
            reader = new InputStreamReader(fileInputStream, "UTF-8");
            Session secondSession = gson.fromJson(reader, Session.class);
            fileInputStream.close();

            try {
                FileOutputStream fileOutputStream = null;
                fileOutputStream = new FileOutputStream("firstMovie2.txt");
                ObjectOutputStream objectOutputStream = null;
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(firstMovie);
                objectOutputStream.close();
                fileOutputStream.close();
                fileOutputStream = new FileOutputStream("secondtMovie2.txt");
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(secondMovie);
                objectOutputStream.close();
                fileOutputStream.close();
                fileOutputStream = new FileOutputStream("firsTheater2.txt");
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(firstTheater);
                objectOutputStream.close();
                fileOutputStream.close();
                fileOutputStream = new FileOutputStream("secondTheater2.txt");
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(secondTheater);
                objectOutputStream.close();
                fileOutputStream.close();
                fileOutputStream = new FileOutputStream("firstSession2.txt");
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(firstSession);
                objectOutputStream.close();
                fileOutputStream.close();
                fileOutputStream = new FileOutputStream("secondSession2.txt");
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(secondSession);
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
       Deserialize the objects from the binary files created in exercise 2.
    */
    public static class Exercise3 {

        public static void main(String[] args) {
            try {
                FileInputStream fileInputStream = null;
                ObjectInputStream objectInputStream = null;
                fileInputStream = new FileInputStream("firstMovie2.txt");
                objectInputStream = new ObjectInputStream(fileInputStream);
                Movie firstMovie = (Movie) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                fileInputStream = new FileInputStream("secondMovie2.txt");
                objectInputStream = new ObjectInputStream(fileInputStream);
                Movie secondMovie = (Movie) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                fileInputStream = new FileInputStream("firstTheater2.txt");
                objectInputStream = new ObjectInputStream(fileInputStream);
                Theater firstTheater = (Theater) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                fileInputStream = new FileInputStream("secondTheater2.txt");
                objectInputStream = new ObjectInputStream(fileInputStream);
                Theater secondTheater = (Theater) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                fileInputStream = new FileInputStream("firstSession2.txt");
                objectInputStream = new ObjectInputStream(fileInputStream);
                Session firstSession = (Session) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
                fileInputStream = new FileInputStream("secondSession2.txt");
                objectInputStream = new ObjectInputStream(fileInputStream);
                Session secondSession = (Session) objectInputStream.readObject();
                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}