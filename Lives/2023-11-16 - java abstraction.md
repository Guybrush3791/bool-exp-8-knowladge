Implementare due classi che rappresentano auto:

- `SportCar` : tipologia di auto sportiva (es. Ferrari)
- `UtilityCar` : tipologia di auto utilitaria (es. Fiesta)

Definire i metodi:

- `void stampaVelocitaMassima()`: mostra a video la **velocità massima dell'auto**
- `void stampaNumeroPorte()`: mostra a video il **numero delle porte dell'auto**
- `String getNome()`: restituisce il **nome dell'auto** in modo che poi venga stampato nella classe Main
- `void accenditi()`: stampa a video una frase che indica che l**'auto si sta accendendo**
- `void frena()`: stampa a video una frase che indica che l'**auto si sta spegnendo**

`SportCar` inoltre avrà il metodo : `void attivaIlTurbo()` che dovrà mostrare a video la frase **“Ho attivato il turbo!!!”**

`UtilityCar` avrà il metodo : `void trainaAuto()` che dovrà mostrare a video la frase **"Sto trainando un'auto...”**

Creare una superclasse, astratta, che implementi i metodi condivisi tra le classi e che definisca la firma dei metodi che invece vanno implementati dalle classi figlie.

Il nome dell’auto deve essere passato come parametro del costruttore.

Implementare un metodo main che istanzi le varie tipologie di auto e utilizzi i loro metodi.