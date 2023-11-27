## Repo
`java-calculator-tester`

## Todo
Scopo di questa esercitazione è di implementare i metodi di una semplice calcolatrice e di scrivere una classe di test per verificare che funzionino come ci aspettiamo!

Creare una classe chiamata `Calculator` avente i seguenti metodi pubblici:
- `float add(float num1, float num2)`
- `float subtract(float num1, float num2)`
- `float divide(float num1, float num2)`
- `float multiply(float num1, float num2)`

Creare in seguito una classe di test che abbia 4 metodi, ognuno per verificare il corretto funzionamento di ogni metodo presente nella classe `Calculator`.

### BONUS
Riprendere le specifiche dell’esercizio [[2023-11-09 - snacks#Snack 2 - Biglietto treno|calcolo biglietto del treno]] e implementare una classe `Ticket` che calcola il prezzo finale del biglietto.
Un’istanza di `Ticket` può essere creata passando il numero di *km* e l'*età* del passeggero (che devono essere numeri positivi altrimenti non è possibile creare un oggetto `Ticket`).
Creare una classe di test `TicketTest` nella quale testate con tutte le casistiche possibili il calcolo del prezzo finale del biglietto.