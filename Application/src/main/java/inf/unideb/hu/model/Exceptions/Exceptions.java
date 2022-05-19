package inf.unideb.hu.model.Exceptions;

public class Exceptions {
    public static class UserDoesNotExist extends Exception {
        public UserDoesNotExist() {
            super("User doesn't exist!");
            
        }
    }

    public static class ArlistaExists extends Exception{
        public ArlistaExists(){
            super("Erre a termékre már létezik egy ár!");
        }
    }

    public static class ArlistaDoesntExists extends Exception{
        public ArlistaDoesntExists(){
            super("Nem létezik ez az árlista!");
        }
    }

    public static class KocsmaDoesNotExists extends Exception{
        public KocsmaDoesNotExists(){
            super("Nem létezik ssssssez a kocsma!");
        }
    }


}
