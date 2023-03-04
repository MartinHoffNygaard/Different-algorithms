# Obligatorisk oppgave 1 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Kristoffer Bauer, S360530, s360530@oslomet.no
* Martin Hoff Nygaard, s362081, s362081@oslomet.no

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Kristoffer skrev kode for oddetallsoppgaver 1,3,5,7
* Martin skrev kode for partallsoppgaver 2,4,6,8
* Etter vi skrev koden gikk vi igjenom alle oppgavene og forklarte til hverandre.
* Vi er ening om løsningene som er gitt.

# Oppgavebeskrivelse

I oppgave 1 så måtte vi implementere en funksjon som bytter to tall. denne brukes til bytte to verdier. Jeg velger å sammenligne i og i-1, men kunne også sammenlignet med i+1. Hvis i-1 er større en i, bytter vi de to plassene. Dette betyr at det lokalt største tallet blir tatt med helt til høyre. Hvis vi finner et tall større enn den lokale maksverdien, bytter vi ikke. Hvis lengden er 0, kaster vi en exception. Hvis lengden er 1, er det kun en verdi som mulig kan være den største. det blir flest jo flere ganger a[i] < a[i-1], dette hender når tabellens største tall kommer først. 

Det blir færreste ombyttinger om arrayet er sortert asc, det betyr at at if(a[i] < a[i-1]) er aldri true. gjennomsnittet kan kalkuleres ved å se på n antall array, summe byttcount for vær, og dele på n For arrayer av lengde 20, er avg 16. for arrayer av lengde 1000 er avg 992. avg er veldig nær n

Jeg velger å ikke definere noen maks verdier, og i stedet skriver ut a[a.length-1] rett i return.

I oppgave 2 lagde vi først en sjekk som returnerer 0 om listen er tom. Deretter lagde vi en sjekk for om listen er sortert. Denne sjekken bruker en løkke for å gå igjennom alle elementene i listen bortsett fra det siste og sammenligner elementet med det neste i listen. Om det neste i listen er mindre så er ikke listen sortert stigende og det returneres ett IllegalStateException. Om listen er sortert så bruker vi en ny løkke for å gå igjennom listen og telle antall ulike tall. Dette gjøres ved å sammenligne ett element med det neste, om de er ulike så telles det et nytt ulikt tall. Starter telleren på 1 ulikt tall ettersom alle lister med mer enn 0 elementer har minst 1 ulikt tall og det siste ulike elementet i listen ikke blir telt i løkken siden den slutter på listen sin lengde-1.

I oppgave 3 er det to ting som hender. Det trenges telling av verdier, og det trenges verifikasjon at samme verdi kun telles en gang. dette kan løses ved å kun telle siste verdi, så det vi valgte å gjøre er å sjekke alle verdier etter i for duplikat. Dette gjøres i "iskey()". Hvis det finnes en duplikat etter verdien, telles ikke tallet.

I oppgave 4 har vi løst oppgaven ved å først sortere listen inn i to deler der den første delen er oddetall og den andre delen partall. Dette gjorde vi ved å bruke to pekere, venstre pekeren starter på begynnelsen av listen og høyre pekeren på slutten av listen. Bruker modulo regning til å finne ut om tallet pekeren står på er oddetall eller partall. Flytter pekerne helt til venstre pekeren er på et partall og høyre pekeren er på et oddetall så bytter de plass. Dette fortsetter helt fram til pekerne passerer hverandre. Etter at listen har blitt delt inn i oddetall og partall så sorterer vi hver av sidene med en sorteringsmetode som er lik quicksort.

I oppgave 5 velger vi å lagre den siste verdien i tabellen, og kopierer resten av tallene og setter dem inn en til høyre. Til slutt lagres den siste temp verdien i a[0].

I oppgave 6 lagde vi først en metode som brukte 1 for-løkke for antall rotasjoner med en for-løkke i for å flytte alle verdiene en plass om gangen. Lagde også en tilsvarende som gikk motsatt vei. Dette ga en løsning men løsningen var ikke effektiv nok. For å få en mer effektiv metode lagde vi en metode som flytter verdiene alle plassene de skal flyttes med en gang. Dette blir gjort på minst nødvendig antall sykluser som vi fant ved hjelp største felles divisor mellom lengden på listen og antall rotasjoner. Effektiviteten på denne metoden var mye bedre og passerte testen.

I oppgave 7a) er det mye rart som foregår. Hovedpoenget er at vi vil ha en løkke hvor s[0]+t[0]+s[1]+t[1]...t[n]. Det blir fort problemer med nullpointere. Hvis ordene er like langt ville en løkke "Output += s[i]+t[i]" være nok, men hvis de er forskjellige får vi problemer. Selv om dette kan løses rent i string (som i oppgave 7b) valgte vi å gjøre stringene om til charrays. for å unngå å peke utenfor arrayene, valgte vi å loope gjennom begge verdiene til det minste ordet ikke har flere bokstaver igjen. Vi definerer det største ordet som "bigword" og lengden på den minste som "length". Vi kjører gjennom løkken til et ord er ferdig, og legger til resten av bokstavene i det største ordet etter.

I oppgave 7b) bruker vi en hovedstring som verdiene skrives til. Her bruker vi funksjonen findchari, som finner bokstav med index 'i' i alle ordene, og returnerer det som en string. Hvis vi er på i = 3 og ordet er kun 3 langt, hoppes det over. Løkken stopper når findchari ikke returnerer noen bokstaver. Denne løsningen er veldig mye mer elegant enn 7a) siden den ikke trenger å gjøre om til char.

I oppgave 8 lagde vi først en metode kalt minsteTallIndeks som finner det minste tallet i en liste. Det minste tallet blir så endret til største mulige Integer slik at når metoden kjøres på nytt vil den finne indeksen til tallet som er nest minst. Denne metoden kan kalles helt til man har funnet rekkefølgen på alle tallene. I indeks sortering metoden lages det først en liste som resultatet skal lagres i med samme lengde som input listen. Det lages også en kopi av input listen ved hjelp av en for-løkke. Vi kalte så minsteTallIndeks på kopien av input listen antall ganger det er elementer i listen, resultatene fra metoden blir lagret på riktig plass i resultatlisten.
