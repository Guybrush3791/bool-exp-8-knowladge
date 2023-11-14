## Repo
`java-inheritance-shop`

## Todo
Nell’esercizio di oggi riprendiamo [[2023-11-13 - java-oop-shop|Java Shop]] applicando le proprietà di incapsulamento ed ereditarietà che abbiamo visto nel frattempo.

> [!attention] Copiare la classe `Prodotto` dall'[[2023-11-13 - java-oop-shop|esercizio precedente]]

Lo shop gestisce diversi tipi di prodotto: 
- **Smarphone**: caratterizzati dal **codice IMEI** e dalla **quantità di memoria**
- **Televisori**: caratterizzati dalle **dimensioni** e dalla proprietà di essere **smart oppure no**
- **Cuffie**: caratterizzate dal **colore** e se sono **wireless o cablate**

Utilizzate l’ereditarietà per riutilizzare il codice di `Prodotto` nella stesura delle classi che gestiscono i vari sotto tipi di prodotto.

Create una classe `Carrello` con metodo `main`, in cui chiedete all'utente di valorizzare un carrello di prodotti con dati inseriti **tramite `Scanner`**. 
Durante la richiesta di valorizzazione chiedete all'utente se sta inserendo uno `Smarphone`, un `Televisore` o un paio di `Cuffie` e in base alla scelta dell’utente utilizzate il costruttore opportuno.

Al termine dell’inserimento stampate il carrello (fate l’`override` del metodo `toString` per restituire le informazioni da stampare per ogni classe).

```mermaid
graph TD
    A[PC: Nuovo elemento?] -->|Sì| B[PC: Quale?]
    A -->|No| C[Stampa Lista]
    B -->|Telefono| D[PC: Info per telefono]
    B -->|Televisore| E[PC: Info per televisore]
    B -->|Cuffie| F[PC: Info per cuffie]
    D --> A
    E --> A
    F --> A
```
### BONUS
Aggiungete alla classe `Prodotto` un metodo per il calcolo del **prezzo scontato per clienti con tessera fedeltà**, che applica al prezzo uno sconto base del **2%**:
- `Smartphone`, lo sconto è del **5%** se la quantità di memoria è **inferiore a 32GB**, altrimenti rimane del 2%
- `Televisori` lo sconto è del **10%** se la televisione **non è smart**, altrimenti rimane del 2%
- `Cuffie` lo sconto è del **7%** se sono **cablate**, altrimenti rimane del 2%

Nella classe carrello chiedere all'utente se possiede una carta fedeltà
In base alla risposta, calcolare il totale del carrello come somma dei prezzi base o dei prezzi scontati.