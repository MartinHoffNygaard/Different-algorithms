package main.java.no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length < 1) throw   // må ha minst en verdi!
                new java.util.NoSuchElementException("a.length(" + a.length + ") < 1! Arrayet må ha en verdi!");

        if (a.length == 1){
            return a[0];
        }

        for (int i = 1; i < a.length; i++)
        {
            if (a[i] < a[i-1]) {
                bytt(a,i,i-1);
            }
        }
        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        int byttcount = 0;
        if (a[0] > a[1]){
            bytt(a,0,1); // Kaller bytt i Obig1Test, bytter to verdier.
            byttcount++;
        }

        for (int i = 2; i < a.length; i++)
        {
            if (a[i] < a[i-1]) {
                bytt(a,i,i-1);
                byttcount++;
            }
        }
        return byttcount;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        if(a.length == 0) { ///Sjekker om det er en tom liste, om listen er tom så returneres 0.
            return 0;
        }
        for(int i = 0;i<a.length-1;i++) { //Går gjennom listen for å sjekke om den er sortert, kaster exception om ikke.
            if (a[i] > a[i + 1]) {
                throw new IllegalStateException("Tabellen er ikke sortert stigende.");
            }
        }
        int antallUlikeTall = 1; //Setter antallUlikeTall lik 1 siden det siste tallet i listen ikke telles i for-løkken.
        for(int i = 0;i<a.length-1;i++) {
            if(a[i] != a[i+1]) { //Sammenligner tall i listen med neste tall i listen. Om de er ulike så legges det til// i antallUlikeTall.
                antallUlikeTall++;
            }
        }
        return antallUlikeTall;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        if(a.length == 0) { ///Sjekker om det er en tom liste, om listen er tom så returneres 0.
            return 0;
        }
        int antallUlikeTall = 0; // Init antall
        for (int i =0;i<a.length;i++) { // Går igjennom alle tallene i a
            if(!iskey(a[i], a, i + 1)){ // ser om det finnes et duplikat ETTER tallet. Dette betyr at siste tall vil bli telt
                antallUlikeTall++;
            }
        }
        return antallUlikeTall;
    }
    private static boolean iskey(int key, int[] a, int fra){ // Sjekker om key finnes mellom tom fra til a.length-1.
        for(int i = fra;i<a.length;i++){
         if (key == a[i]){return true;} //kunne vært false, men isx returnerer vanligvis true hvis det finnes.
        }
        return false;
    }



    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int fra = 0; //Velger startverid
        int til = a.length-1; //Velger sluttverdi
        while(true) { //løkke som går fram til fra blir større enn til
            while(fra <= til && a[fra]%2 != 0) fra++; //Sjekker om venstrepekeren "fra" er ett oddetall og flytter pekeren om den er det
            while(fra <= til && a[til]%2 == 0) til--; //Sjekker om høyrepekeren "til" er ett partall og flytter pekeren om den er det
            if(fra < til) {
                bytt(a, fra, til); //Bytter om tallene på pekerne når venstre er partall og høyre er oddetall
            }
            else {
                break; //Går ut av løkka når fra har blitt større enn til
            }
        }
        quickSort(a,0,fra-1); //sorterer oddetallssiden av listen
        quickSort(a,fra,a.length-1); //sorterer partallssiden av listen
    }

    public static int partionering(int[] a, int fra, int til, int skilleIndeks) { //Metode for å partionere en liste i to basert på en skilleverdi
        int skilleVerdi = a[skilleIndeks]; //Finner skilleverdien
        int sisteIndeks = til; //Lagrer den siste indeksen fra listen
        bytt(a, skilleIndeks, til); //Setter skilleverdien bakerst i listen
        til--;
        while(true) { //while løkke som går fram til den venstre pekeren fra går forbi til
            while(fra <= til && a[fra] < skilleVerdi) fra++; //sjekker at venstre peker er mindre eller lik til og om venstre peker er mindre enn skilleverdien.
            while (fra <= til && a[til] >= skilleVerdi) til--; //Gjør det samme som over men at høyrepeker er mindre enn skilleverdi. Øker høyre og venstre peker til det ikke stemmer.

            if(fra < til) {
                bytt(a,fra,til); //Bytter om tallene på venstrepeker og høyrepeker når venstre peker er større enn skillverdien og høyrepeker er mindre.
                fra++; //Øker venstre og høyrepeker så de ikke blir sjekket to ganger.
                til++;
            }
            else {
                bytt(a,fra, sisteIndeks); //Om venstre peker har passert høyrepeker så settes skilleverdien inn på sin plass og indeksen til plassen blir returner.
                return fra;
            }
        }
    }

    public static void quickSort(int[] a, int fra, int til) { //quicksort algoritme som sorterer en liste.
        if(fra >= til) { //avslutter metoden når den er ferdig, når det er ett element igjen i "listene".
            return;
        }
        int skille = partionering(a,fra,til,(fra+til)/2); //bruker partioneringsmetoden med en indeks på midten og lagrer hvor skilleverdien ender.

        quickSort(a,fra,skille-1); //kjører quicksort metoden på venstre side av partioneringen
        quickSort(a,skille+1, til); //kjører quicksort metoden på høyre side av partioneringen
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) { // lagrer verdien på enden, og flytter alle verdier til høyre
        int length = a.length;
        if(1<length){
            char temp = a[length - 1];
            System.arraycopy(a, 0, a, 1, length - 1);
            a[0] = temp;// setter verdien på enden til den første
        }
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        if(a.length != 0) { //sjekker om listen er tom, om den er tom så blir ingenting gjort
                if((k %= a.length) < 0) k += a.length; //sjekker om inputverdien er negativ, om den er negativ skal den roteres motsatt vei.
                int sykluser = gcd(a.length,k); //finner den største felles divisoren mellom lengden og antall rotasjoner for å finne antall sykluser.

                for(int i = 0;i<sykluser;i++) { //antall sykluser
                    char temp = a[i]; //lagrer første veriden i syklusen

                    for(int j = i - k, h = i; j != i; j -= k) { //løkke som roterer og flytter verdier med intervallet k fram til den har gått rundt hele listen
                        if(j<0) j += a.length; //om indeksen er negativ oppdateres den til tilsvarende positive indeks for samme plass
                        a[h] = a[j]; //flytter verdien
                        h = j; //oppdaterer indeksene
                    }
                    a[i+k] = temp; //legger tilbake verdien fra starten av syklusen
                }
            }
        }

        public static int gcd(int a, int b) { //metode for å finne største felles divisor mellom to tall
        if(b==0) return a;
        return gcd(b,a%b); //bruker rekursjon fram til divisor er funnet
        }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        char[] cs= s.toCharArray(); // Gjør String om til char, vet ikke om dette er "juksing", siden dette teknisk sett er en hjelpetabell, men men.
        char[] ct = t.toCharArray();
        int length; // Definerer lengde siden den blir brukt mye.
        char[] bigword; // definerer det største ordet av de to
        if (cs.length<ct.length){ //Finner ut hvilket ord er størst, og definerer minste length som length
         length=cs.length;
         bigword=ct;
        }
        else{
            length=ct.length;
            bigword=cs;
        }
        String output = "";
        for(int i=0;i<length;i++){ // går gjennom alle char i ord, og legger dem etter hverandre.
            output += cs[i]+""+ct[i]; // "" er så de ikke legges sammen, men etter hverandre.
        }
        for (int i=length;i<bigword.length;i++){ // for alle bokstaver etter slutten av det minste ordet legges til slutt
            output+=bigword[i];
        }
        return output;
    }

    /// 7b)
    public static String flett(String... s) {
        String weave = "";
        String wj;
        for (int j=0;j>-1;j++) {
            wj = findchari(j, s); // finner j bokstav i alle s, for alle j.
            if (wj == ""){j=-2;} //Hvis alle bokstavene er utenfor alle ordene, aka, findchari returnerer ingenting, hopp ut av for løkken
            else {weave += wj;} // Hvis wj har noe, legg det til weave aka output.
        }
        return weave;
    }
    private static String findchari(int j, String... s){
        String weave = "";      // returnerer bokstav j i alle s,
        for (String value : s) {
            if (value.length() > j) { //Hvis j er utenfor ordets lengde, skriv ingenting
                weave += value.charAt(j);
            }
        }
        return weave;
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        if(a.length == 0) return a; //Sjekker om listen er tom, returnerer bare listen tilbake om den er det
        int[] tabellkopi = new int[a.length]; //Lager en kopi av listen som kan endres
        int[] resultat = new int[a.length]; //Lager en liste for å ha de riktige indeksene
        int antallStorste = 0;

        //System.arraycopy for å kopiere input listen
        System.arraycopy(a, 0, tabellkopi, 0, a.length);

        for(int i = 0;i<tabellkopi.length;i++) { //Løkke som går gjennom kopien antall ganger det er elementer i listen
            int minIndeks = minsteTallIndeks(tabellkopi); //Kaller metoden som finner indeks til minstetall
            resultat[i] = minIndeks; //Setter indeksen til minste tall på riktig plass i resultat listen
        }
        for(int i = 0;i<a.length;i++) {
            if (a[i] == 2147483647) { //For spesialtilfelle hvor listen inneholder største integer
                antallStorste++; //Teller antall største integer i listen og legger indeksene deres bakerst i listen
                resultat[a.length - antallStorste] = i;
            }
        }

        return resultat;
    }

    public static int minsteTallIndeks(int[] a) {
        int minsteTall = 2147483647; //Lager en variabel for minste tall som er satt lik største mulige integer
        int minsteTallIndeks = 0;

        for(int i = 0;i<a.length;i++) { //For-løkke for å gå igjennom hele liste
            if(a[i] <= minsteTall) { //Sammenligner tall mot nåværende minste tall
                minsteTall = a[i]; //Oppdaterer minstetall om det er ett nytt minstetall
                minsteTallIndeks = i; //Oppdaterer indeks
            }
        }
        a[minsteTallIndeks] = 2147483647; //Endrer det minste tallet i listen til størst mulige integer så det ikke blir funnet på nytt neste gang metoden brukes.
        return minsteTallIndeks;
    }

    ///// Hjelpemetode /////////////////////////////

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}  // Oblig1
