/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import model.VideoCharacter;
import model.Movie;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Random;
import model.Movies;
import model.Rating;
import model.TVShow;
import model.TVShows;
import xml_io_manager.XML_ReadWrite;

/**
 * faker bolo potrebne implementovat pomocou maven projektu, teda funkcne generovanie je v inom projekte(nasom).
 * tato trieda je len na ukazku ako je generator udajov implementovany
 * @author adamg
 */
public class Generator {
    private static Random nahoda = new Random();
    private static Faker faker = new Faker();
    
    private static String[] nazvyFilm = {
        "Rambo", "Rocky", "John Wick", "John Wick Chapter 2", "Terminator", "Scarface", "Rambo First Blood Part II", "I, legend", "Bad Boys", "Interstellar", "Die Hard 2", "Bad Boys 2",
        "21 Jump Street", "Big Lebowski", "Batman", "Spiderman", "Man of Steel", "Batman v Superman", "Justice League", "Avengers", "Hulk", "Deadpool", "Nothing hill", "Sleepy Hollow", "Hannibal",
        "Gladiator", "The Man from U.N.C.L.E.", "Kingsman", "Commando", "Terminator 2", "Total Recall", "Godzilla", "Lethal Weapon", "Die hard", "Hudson Hawk", "Hacksaw Ridge", "Dunkirk", "Venom",
        "Ghost Dog", "Matrix", "Equalizer", "Training day", "John Wick 3", "Heat", "Django Unchained", "Inglorious Basterds", "Kill Bill", "Reservoir Dogs", "Hateful 8", "Once upon a time in Hollywood",
        "The Good, the Bad and the Ugly", "Gran Torino", "A Fistful of Dollars", "Unforgiven", "Million Dollar Baby", "Independence day", "Predator", "Alien", "Alien v Predator", "Friday the 13th",
        "Nightmare on Elm Street", "Halloween", "Blade", "Iron Man", "Dirty Harry", "The Mule", "Inception", "Sherlock Holmes", "Gentlemen", "Snatch", "Rush", "Star Wars", "Usual Suspects", "James Bond", "Green Book",
        "Memento", "Shutter Island", "Revenant", "Black Hawk Down", "Shaft", "Miami Vice", "Godfather", "Pain and Gain", "Die Hard 3", "Transformers", "The mask", "Ace Ventura", "The Mummy", "Naked Gun",
        "Rocky II", "Expendables", "Saving private Ryan", "South paw", "The Joker", "Zombieland", "Ford v Ferrari", "Knives Out", "Rocky III", "Rocky IV", "John Wick Chapter 3"
    };
    
    private static String[] nazvySerial = {
        "Peaky Blinders", "Castlevania", "Spongebob", "The Simpsons", "Family Guy", "Cobra Kai", "Sons of Anarchy", "Narcos", "Friends", "The Punisher", "Daredevil", "The Orange is the new Black",
        "The Sopranos", "House MD", "Office", "Mandalorian", "Star Trek", "The Witcher", "Two and a half Men", "The big bang theory", "True Detective", "Supernatural", "The Boys", "Top Gear", 
        "South Park", "Chernobyl", "Breaking bad", "Stranger things", "House of Cards", "Game of thrones", "Monk", "Fargo", "The Queens Gambit", "The Crown", "Dexter", "Futurama", "Suits", "The Vikings",
        "Knight Rider", "Ray Donovan", "Matlock", "Alarm fur Kobra11", "Medicopter 117", "How I met your mother", "M.A.S.H", "Walking Dead", "Band of brothers", "The Mentalist", "Prison break", "Californication"
    };
    
    private static String[] zanre = {
        "horror", "action", "romantic", "comedy", "documentary", "thriller", "animation", "anime", "musical",
        "drama", "western", "war", "historic", "real-based"
    };
    
    // nastavi pribuzne filmy k filmu movie
    public static void setRelatedMovies(ArrayList<Movie> movies, Movie movie){
        for (int i = 0; i < movies.size(); i++) {
            Movie mov = movies.get(i);
            
            // ak nazov existujuceho filmu obsahuje v nazve film ktoremu chceme pridelit pribuzne filmy ... napr Deadpool, Deadpool 2
            if(mov.getTitle().toLowerCase().contains(movie.getTitle().toLowerCase())){
                movie.addRelated(mov);
            }
        }
    }
    
    public static String postavaMeno(){
        int volba = nahoda.nextInt(17);
        String meno = "";
     
        switch (volba) {
            case 0:
                meno = faker.backToTheFuture().character();
                break;

            case 1:
                meno = faker.buffy().characters();  // ma moznost celebrities
                break;

            case 2:
                meno = faker.dragonBall().character();
                break;

            case 3:
                meno = faker.friends().character();
                break;

            case 4:
                meno = faker.gameOfThrones().character();
                break;

            case 5:
                meno = faker.harryPotter().character();
                break;

            case 6:
                meno = faker.hitchhikersGuideToTheGalaxy().character();
                break;

            case 7:
                meno = faker.hobbit().character();
                break;

            case 8:
                meno = faker.lebowski().character();    // ma actor
                break;

            case 9:
                meno = faker.lordOfTheRings().character();
                break;

            case 10:
                meno = faker.pokemon().name();
                break;

            case 11:
                meno = faker.princessBride().character();
                break;

            case 12:
                meno = faker.rickAndMorty().character();
                break;

            case 13:
                meno = faker.starTrek().character();
                break;

            case 14:
                meno = faker.witcher().character();
                break;

            case 15:
                meno = faker.superhero().name();
                break;

            case 16:
                meno = faker.zelda().character();
                break;
                
            default:
                throw new AssertionError();
        }
        
        return meno;
    }
    
    public static String herecMeno(){   
        return faker.funnyName().name();
    }
    
    public static void main(String[] args) {
        
        int pocetFilmov = 20;
        int pocetSerialov = 20;
        
        String zaner;
        String nazov;
        
        short rok;
        short dlzka;
        
        String reziser;
        String studio;
        String zaujimavost;
        
        ArrayList<VideoCharacter> postavy;
        ArrayList<Movie> related;
        
        short pocetEpizod;
        byte pocetSezon;
        
        short pocetPostav;
        Rating hodnotenie;
        VideoCharacter postava;
                
        // filmy
        ArrayList<Movie> filmy = new ArrayList<>();
        int i = 0;
        while(filmy.size() < pocetFilmov){
            postavy = new ArrayList<>();
            related = new ArrayList<>();
            pocetPostav = (short)(nahoda.nextInt(9) + 1);
            
            zaner = zanre[nahoda.nextInt(zanre.length)];
            nazov = nazvyFilm[i++];
            
            rok = (short) (nahoda.nextInt(52) + 1970);
            dlzka = (short)(nahoda.nextInt(121) + 80);
            
            reziser = faker.artist().name();
            
            studio = faker.company().name();
            
            zaujimavost = faker.friends().quote();
            
            // postavy vo filme - id, postava, herec
            for (int j = 0; j < pocetPostav; j++) {
                postava = new VideoCharacter(j, postavaMeno(), herecMeno());
                postavy.add(postava);        
            }
            
            // hodnotenie od IMDB, CSFD
            hodnotenie = new Rating(
                (byte)(nahoda.nextInt(100)+1),
                (byte)(nahoda.nextInt(100)+1),
                (byte)(nahoda.nextInt(100)+1)
            );
                        
            Movie novyFilm = new Movie(nazov, zaner, dlzka, rok, studio, postavy, zaujimavost, hodnotenie, reziser, related);
        
            setRelatedMovies(filmy, novyFilm);
            
            filmy.add(novyFilm);
        }
        
        

        i=0;
        ArrayList<TVShow> serialy = new ArrayList<>();
        while(serialy.size() < pocetSerialov){
            pocetEpizod = (short)(nahoda.nextInt(500)+1);
            pocetSezon = (byte)(nahoda.nextInt(20)+1);
            
            pocetPostav = (short)(nahoda.nextInt(9)+1);
            postavy = new ArrayList<>();
            
            
            zaner = zanre[nahoda.nextInt(zanre.length)];
            nazov = nazvySerial[i++];
            
            rok = (short) (nahoda.nextInt(52) + 1970);  // 1970 - 2021
            dlzka = (short)(nahoda.nextInt(121) + 80);  // 80 - 200 min
            
            reziser = faker.artist().name();
            
            studio = faker.company().name();
            
            zaujimavost = faker.yoda().quote();
            
            // postavy vo filme - id, postava, herec
            for (int j = 0; j < pocetPostav; j++) {
                postava = new VideoCharacter(j, postavaMeno(), herecMeno());
                postavy.add(postava);        
            }
            
            // hodnotenie od IMDB, CSFD
            hodnotenie = new Rating(
                (byte)(nahoda.nextInt(100)+1),
                (byte)(nahoda.nextInt(100)+1),
                (byte)(nahoda.nextInt(100)+1)
            );
                        
            TVShow novySerial = new TVShow(nazov, zaner, dlzka, rok, studio, postavy, zaujimavost, hodnotenie, reziser, pocetSezon, pocetEpizod);
        
            serialy.add(novySerial);
        }
        
        
        Movies movies = new Movies(filmy);
        TVShows tvshows = new TVShows(serialy);
        
        XML_ReadWrite.getXML_RW(XML_ReadWrite.TYPMOVIES).write("C:\\Users\\adamg\\OneDrive\\Dokumenty\\NetBeansProjects\\mavenproject1\\src\\main\\java\\suboryPraca\\movies.xml", movies);
        XML_ReadWrite.getXML_RW(XML_ReadWrite.TYPTVSHOWS).write("C:\\Users\\adamg\\OneDrive\\Dokumenty\\NetBeansProjects\\mavenproject1\\src\\main\\java\\suboryPraca\\tvshows.xml", tvshows);
        
    }
    

}