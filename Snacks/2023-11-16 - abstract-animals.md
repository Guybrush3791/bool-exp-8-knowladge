## Repo
`abstract-animals`

## Todo
### Esercizio 1 : classi astratte
Dobbiamo realizzare un programma che rappresenti il regno animale.

Creiamo quindi una classe astratta `Animale` e delle classi che la estendono : `Cane`, `Passerotto`, `Aquila`, `Delfino`

Vogliamo che gli animali abbiano i seguenti metodi:
- `void dormi()` mostra a video **“Zzz”**
- `void verso()` mostra a video il verso fatto dall'animale specifico
- `void mangia()` mostra a video quello che mangia : erba, carne, ...?

Quali di questi metodi devono essere implementati nella classe astratta e quali devono essere lasciati astratti e implementati dalle classi che la estendono?

Una volta create le classi, nel programma istanziare alcuni animali e utilizzare i metodi implementati.

### Esercizio 2 : interfacce
#### New Version
Definire 2 interfacce chiamate `IVolante` e `INuovante`:
##### `IVolante`
Definisce firma del metodo:
`void vola();`

##### `INuotante`
Definisce firma del metodo:
`void nuota();`

Ogni animale dovrà implementare una o più di queste due interfacce.

Definire inoltre nella classe che contiene il `main` due metodi definiti come segue:
- `public static void faiVolare(IVolante)`: prende in ingresso un oggetto volante e lo fa volare
- `public static void faiNuotare(INuotante)`: prende in ingresso un oggetto nuotante e lo fa nuotare

Richiamare opportunamente questi metodi all'interno del `main`.

#### Old Version
Alcuni degli animali che abbiamo creato volano, altri nuotano.

Gli animali che volano hanno il seguente metodo:
- `void vola()` mostra a video **“Sto volando!!!”**

Gli animali che nuotano hanno il seguente metodo:
- `void nuota()` mostra a video **“Sto nuotando!!!”**

Scrivere due interfacce:
- `IVolante` con metodo `void faiVolare`
- `INuotante` con metodo `void faiNuotare`

Questi metodi prendono come parametro un animale che può o *volare*/*nuotare* e richiamano il corrispondente metodo `vola()`/`nuota()`.

Scrivere un programma che istanzi animali che volano o nuotano e richiamare i metodi `faiVolare`/`faiNuotare` passandoglieli come parametro.