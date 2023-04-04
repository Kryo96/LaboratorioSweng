# CORSO INGEGNERIA DEL SOFTWARE A.A. 2022/23


## TRACCIA

Completare, in modo da realizzare un'organizzazione del sistema di tipo
*Model-View-Presenter*, le classi già presenti e aggiungere le
classi necessarie in modo che:

- nel riquadro a sinistra vengano presentati (in ordine di orario stimato di partenza effettiva, cioè orario programmato + ritardo previsto) 
i primi 8 treni in partenza, mentre nel riquadro a destra i successivi 8 (il numero 8 è fissato dalla costante `MAX_ITEMS` del `Main`);

- quando un treno è partito (segnalato dalla pressione del bottone `Departed`) sparisca dall'elenco e i 
treni scorrano nell'elenco in maniera opportuna.

Si noti che pur essendo ordinati secondo l'orario stimato di partenza, è possibile che parta anche un treno non in prima 
posizione (per questo i bottoni `Departed` sono presenti per tutti i treni).


Nel tabellone devono essere presentate nell'ordine per ogni treno mostrato le seguenti informazioni:
- codice treno
- destinazione finale
- orario programmato di partenza (non comprensivo del ritardo)
- ritardo stimato


Nella vista in alto è possibile dato un codice del treno inserire una nuova stima del ritardo del treno stesso.


### Suggerimenti

Oltre all'uso del pattern _Model-View-Presenter_, vi consigliamo di considerare
lo sfruttamento
al fine di scrivere un codice migliore anche di altri pattern (ad es. il pattern
_Strategy_, o il pattern _Template_) e in
ogni caso di prestare grande attenzione al rispetto dei principi **SOLID** di
buona progettazione Object Oriented.

Prestare estrema attenzione anche a garantire una corretta encapsulation dello
stato da parte delle arie classi (ad
esempio del Model) n modo da garantire l'assenza di escaping references di anche
solo parte dello stato.


