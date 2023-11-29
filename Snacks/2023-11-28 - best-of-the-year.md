## Repo
`best-of-the-year`

## Todo
### Day 1
#### Step 1 
Creare un nuovo progetto **Spring Boot MVC + Thymeleaf**. Il nome del progetto è `best-of-the-year` (stesso nome del repo). 

Nel progetto aggiungere un controller che risponde alla root dell’applicazione, con un metodo che restituisce una view fatta con *Thymeleaf* in cui viene stampato un titolo: “**Best of the year by …**” (al posto dei puntini deve apparire il vostro nome, passato come *attributo dal controller* attraverso il `Model`).

#### Step 2
Creare all'interno del controller due metodi privati:
- uno restituisce una lista di oggetti di tipo `Movie`: `getBestMovies()`
- l’altro restituisce una lista di oggetti di tipo `Song`: `getBestSongs()`

Creare le classi `Movie` e `Song` aventi almeno :
- `id`
- `titolo`

Aggiungere al controller altri due metodi, che rispondono agli URL:
- `/movies`
- `/songs`

In ognuno di questi metodi aggiungere al `Model` un attributo stringa con una lista di titoli di migliori film o canzoni (in base al metodo che stiamo implementando) separati da virgole.
Utilizzare i due metodi *getBest…* per recuperare i film e le canzoni.

Creare i rispettivi template *Thymeleaf*.

Creare due metodi:
- `/movies/{id}`
- `/songs/{id}`
che dato il parametro `id` passato tramite il `path`, mostri in pagina il titolo relativo al *film*/*canzone*.

Testare chiamando dal browser i diversi URL.

### Day 2
Includere `Bootstrap` e fare il refactoring del layout come da allegato, cercando di creare componenti riutilizzabili con i **fragments**.

Modificare i metodi che rispondono ai seguenti url:
- `/movies`
- `/songs`

Fare in modo che il `Controller` restituisca una lista di oggetti (`Movie`/`Song`) invece di una stringa. Modificare anche le rispettive view in accordo.

Ogni elemento mostrato nella lista (`Movie`/`Song`) deve essere un link che punta alla rispettiva pagina di dettaglio (e anche in questo caso restituire l'oggetto al posto della stringa col titolo).

Nella pagina `home` (quella che risponde alla root dell’applicazione) aggiungere due link che portano agli url `/movies` e `/songs`.

Nelle pagine con le liste aggiungere un link che riporta alla *home page*.

Testare navigando l’applicazione.